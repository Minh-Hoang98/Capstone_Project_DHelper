package com.fpt.edu.DomanticHelper.controller;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpt.edu.DomanticHelper.entity.ERole;
import com.fpt.edu.DomanticHelper.entity.Role;
import com.fpt.edu.DomanticHelper.entity.User;
import com.fpt.edu.DomanticHelper.jpa.RoleRepository;
import com.fpt.edu.DomanticHelper.jpa.UserRepository;
import com.fpt.edu.DomanticHelper.payload.request.LoginRequest;
import com.fpt.edu.DomanticHelper.payload.request.SignupRequest;
import com.fpt.edu.DomanticHelper.payload.response.JwtResponse;
import com.fpt.edu.DomanticHelper.payload.response.MessageResponse;
import com.fpt.edu.DomanticHelper.security.jwt.JwtUtils;
import com.fpt.edu.DomanticHelper.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;


	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		loginRequest.setUsername(loginRequest.getUsername().trim()) ;
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwtToken = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwtToken,
												 userDetails.getId(),
												 userDetails.getUsername(),
												 userDetails.getPhone(),
												 userDetails.getEmail(),
												 userDetails.getAvatar(),									
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) throws IOException {
		
		signUpRequest.setUsername(signUpRequest.getUsername().trim()) ;
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Tên đăng nhập đã được sử dụng!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Email đã được sử dụng!"));
		}
		
		if (userRepository.existsByPhone(signUpRequest.getPhone())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Số điện thoại đã được sử dụng!"));
		}
		
		String filePath = "src/main/resources/cmnd_mattruoc.jpg";
		
		byte[] fileContent = FileUtils.readFileToByteArray(new File(filePath));
		String encodedString = Base64.getEncoder().encodeToString(fileContent);
		// Create new user's account
		User user = new User(signUpRequest.getUsername(),signUpRequest.getPhone(),
							 encoder.encode(signUpRequest.getPassword()),signUpRequest.getEmail(), encodedString);

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Không có quyền truy cập"));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Không có quyền truy cập"));
					roles.add(adminRole);

					break;
				case "helper":
					Role modRole = roleRepository.findByName(ERole.ROLE_HELPER)
							.orElseThrow(() -> new RuntimeException("Không có quyền truy cập"));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Không có quyền truy cập"));
					roles.add(userRole);
				}
			});
		}

		user.setRole(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("Đăng kí thành công"));
	}
}
