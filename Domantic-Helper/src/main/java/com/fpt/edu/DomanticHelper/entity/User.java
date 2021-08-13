package com.fpt.edu.DomanticHelper.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;



@Entity
@Table(	name = "user")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
        @Lob
    @Column(name = "avatar", columnDefinition = "MEDIUMBLOB")
    private String avatar;

    @Column(name = "username", length = 125, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "email", nullable = false, length = 125)
    private String email;

    @Column(name = "status", length = 255)
    private String status;

    @Column(name = "reset_password_token")
    private String resetPasswordToken;

    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles",
				joinColumns = @JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> role = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "location_current")
    private Location currentLocation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "identity_entity_id")
    private Identity identityEntity;

    @OneToOne(mappedBy = "user_emp")
    private Employee employee;

//    @OneToOne(mappedBy = "users_helper")
//    private HelperJob helperJob;

    public User() {
        super();
    }


    public User(String userName,String phone, String password, String email) {
		super();
		this.username = userName;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}
    public User(String userName,String phone, String password, String email, String avatar) {
		super();
		this.username = userName;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.avatar = avatar;
	}

	public User(int id, String avatar, String userName, String password, String phone, String email, String status,
			Set<Role> role, Location currentLocation, Identity identityEntity,
			Employee employee, HelperJob helperJob) {
		super();
		this.id = id;
		this.avatar = avatar;
		this.username = userName;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.status = status;
		this.role = role;
		this.currentLocation = currentLocation;
		this.identityEntity = identityEntity;
		this.employee = employee;

	}


	

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}


	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}


	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public Set<Role> getRole() {
		return role;
	}



	public void setRole(Set<Role> role) {
		this.role = role;
	}



	public Employee getEmployee() {
		return employee;
	}



	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Identity getIdentityEntity() {
        return identityEntity;
    }

    public void setIdentityEntity(Identity identityEntity) {
        this.identityEntity = identityEntity;
    }

}
