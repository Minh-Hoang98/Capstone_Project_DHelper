package com.fpt.edu.DomanticHelper.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="user")
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="status")
	private String status;
	
	@Column(name = "number_child")
	private int numberChild;
	
	@Column(name = "type_of_emp")
	private String typeOfEmp;
	
	@Column(name="date_start")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateStart;
	
	@Column(name="date_off")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateOff;
	
	@Column(name="acommodation")
	private String acommodation;
	
    @Column(name="living_arr")
	private String livingArr;
	
    @Column(name="house_size")
	private float houseSize;
	
    @Column(name="note")
	private String note;
	
    @Column(name="care")
	private String care;
	
    @Column(name="cooking")
	private String cooking;

    @Column(name="houseKeeping")
	private String houseKeeping;
	
    @Column(name = "salary")
	private int salary;
    
    @OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="identity_entity_id")
	private IdentityEntity IdentityEntity;

	public UserEntity() {
		super();
	}

	public UserEntity(int id, String userName, String password, String phone, String email, String status,
			int numberChild, String typeOfEmp, Date dateStart, Date dateOff, String acommodation, String livingArr,
			float houseSize, String note, String care, String cooking, String houseKeeping, int salary) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.status = status;
		this.numberChild = numberChild;
		this.typeOfEmp = typeOfEmp;
		this.dateStart = dateStart;
		this.dateOff = dateOff;
		this.acommodation = acommodation;
		this.livingArr = livingArr;
		this.houseSize = houseSize;
		this.note = note;
		this.care = care;
		this.cooking = cooking;
		this.houseKeeping = houseKeeping;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int theid) {
		this.id = theid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
	
	public int getNumberChild() {
		return numberChild;
	}

	public void setNumberChild(int numberChild) {
		this.numberChild = numberChild;
	}

	public String getTypeOfEmp() {
		return typeOfEmp;
	}

	public void setTypeOfEmp(String typeOfEmp) {
		this.typeOfEmp = typeOfEmp;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateOff() {
		return dateOff;
	}

	public void setDateOff(Date dateOff) {
		this.dateOff = dateOff;
	}

	public String getAcommodation() {
		return acommodation;
	}

	public void setAcommodation(String acommodation) {
		this.acommodation = acommodation;
	}

	public String getLivingArr() {
		return livingArr;
	}

	public void setLivingArr(String livingArr) {
		this.livingArr = livingArr;
	}

	public float getHouseSize() {
		return houseSize;
	}

	public void setHouseSize(float houseSize) {
		this.houseSize = houseSize;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCare() {
		return care;
	}

	public void setCare(String care) {
		this.care = care;
	}

	public String getCooking() {
		return cooking;
	}

	public void setCooking(String cooking) {
		this.cooking = cooking;
	}

	public String getHouseKeeping() {
		return houseKeeping;
	}

	public void setHouseKeeping(String houseKeeping) {
		this.houseKeeping = houseKeeping;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", userName=" + userName + ", password=" + password + ", phone=" + phone
				+ ", email=" + email + ", status=" + status + ", numberChild=" + numberChild + ", typeOfEmp="
				+ typeOfEmp + ", dateStart=" + dateStart + ", dateOff=" + dateOff + ", acommodation=" + acommodation
				+ ", livingArr=" + livingArr + ", houseSize=" + houseSize + ", note=" + note + ", care=" + care
				+ ", cooking=" + cooking + ", houseKeeping=" + houseKeeping + ", salary=" + salary + "]";
	}

	
}
