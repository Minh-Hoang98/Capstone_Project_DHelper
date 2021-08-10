
package com.fpt.edu.DomanticHelper.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpt.edu.DomanticHelper.entity.User;
import com.fpt.edu.DomanticHelper.exception.UserNotFoundException;
import com.fpt.edu.DomanticHelper.payload.request.ForgotRequest;
import com.fpt.edu.DomanticHelper.payload.request.ResetRequest;

import com.fpt.edu.DomanticHelper.payload.response.MessageResponse;
import com.fpt.edu.DomanticHelper.security.services.UserEntityServiceImpl;

import net.bytebuddy.utility.RandomString;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class ForgotPasswordController {
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private UserEntityServiceImpl userService;

//    @GetMapping("/forgot_password")
//    public String showForgotPasswordForm() {
//         return "forgot_password_form";
//    }

//    @PostMapping("/forgot_password")
//    public String processForgotPassword(HttpServletRequest request, Model model) {
//    String email = request.getParameter("email");
//    String token = RandomString.make(30);
//     
//    try {
//        userService.updateResetPasswordToken(token, email);
//        String resetPasswordLink = Utility.getSiteURL(request) + "/api/auth/reset_password?token=" + token;
//        sendEmail(email, resetPasswordLink);
//        model.addAttribute("message", "We have sent a reset password link to your email. Please check.");
//        System.out.println("aa");
//         
//    } catch (UserNotFoundException ex) {
//        model.addAttribute("error", ex.getMessage());
//        System.out.println("bb");
//    } catch (UnsupportedEncodingException | MessagingException e) {
//        model.addAttribute("error", "Error while sending email");
//        System.out.println("cc");
//    }
//         
//    return "forgot_password_form";
//}

	@PostMapping("/forgot_password")
	public ResponseEntity<?> processForgotPassword(HttpServletRequest request,
			@Valid @RequestBody ForgotRequest forgotRequest) {
		String email = forgotRequest.getEmail();
		String token = RandomString.make(30);

		try {
			userService.updateResetPasswordToken(token, email);
			// String resetPasswordLink = Utility.getSiteURL(request) +
			// "/api/auth/reset_password?token=" + token;
			String resetPasswordLink = "http://localhost:3000/resetpass?token=" + token;
			sendEmail(email, resetPasswordLink);
			return ResponseEntity.ok().body(new MessageResponse("Sent Email"));

		} catch (UserNotFoundException ex) {
			return ResponseEntity.badRequest().body(new MessageResponse("Not Found"));
		} catch (UnsupportedEncodingException | MessagingException e) {

			return ResponseEntity.badRequest().body(new MessageResponse("Error while sending email"));

		}

	}

	public void sendEmail(String recipientEmail, String link) throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom("HelperJob", "Support");
		helper.setTo(recipientEmail);

		String subject = "Here's the link to reset your password";

		String content = "<p>Hello,</p>" + "<p>You have requested to reset your password.</p>"
				+ "<p>Click the link below to change your password:</p>" + "<p><a href=\"" + link
				+ "\">Change my password</a></p>" + "<br>" + "<p>Ignore this email if you do remember your password, "
				+ "or you have not made the request.</p>";

		helper.setSubject(subject);

		helper.setText(content, true);

		mailSender.send(message);
	}

//    @GetMapping("/reset_password")
//    public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
//        User customer = userService.getByResetPasswordToken(token);
//        model.addAttribute("token", token);
//         
//        if (customer == null) {
//            model.addAttribute("message", "Invalid Token");
//            return "message";
//        }
//         
//        return "reset_password_form";
//    }

//    @PostMapping("/reset_password")
//    public String processResetPassword(HttpServletRequest request, Model model) {
//        String token = request.getParameter("token");
//        String password = request.getParameter("password");
//         
//        User customer = userService.getByResetPasswordToken(token);
//        model.addAttribute("title", "Reset your password");
//         
//        if (customer == null) {
//            model.addAttribute("message", "Invalid Token");
//            return "message";
//        } else {           
//        	userService.updatePassword(customer, password);
//             
//            model.addAttribute("message", "You have successfully changed your password.");
//        }
//         
//        return "message";
//    }

	@PostMapping("/reset_password")
	public ResponseEntity<?> processForgotPassword(@Valid @RequestBody ResetRequest requestRequest,
			HttpServletRequest request) {
		// String token = request.getParameter("token");
		String password = requestRequest.getPassword();
		String token = requestRequest.getToken();

		User customer = userService.getByResetPasswordToken(token);

		if (customer == null) {
			return ResponseEntity.badRequest().body(new MessageResponse("Invalid token"));
		} else {
			userService.updatePassword(customer, password);
			return ResponseEntity.ok().body(new MessageResponse("You have successfully changed your password."));

		}

	}
}