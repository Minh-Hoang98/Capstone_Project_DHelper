package com.fpt.edu.DomanticHelper.payload.request;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class UpdateProfileRequest {

	private String name;

	private String avatar;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;

	private String gender;

	private String hocvan;

	private String chuyenNganh;

	private String queQuan;

	private String noiO;

	@NotBlank
	@Size(max = 9)
	private String soCmnd;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngayCap;

	private String noiCap;

	private String image1;

	private String image2;

	public UpdateProfileRequest() {
		super();
	}

	public UpdateProfileRequest(String name, String avatar, Date dob, String gender, String hocvan,
			String chuyenNganh, String queQuan, String noiO, @NotBlank @Size(max = 9) String soCmnd, Date ngayCap,
			String noiCap, String image1, String image2) {
		super();
		this.name = name;
		this.avatar = avatar;
		this.dob = dob;
		this.gender = gender;
		this.hocvan = hocvan;
		this.chuyenNganh = chuyenNganh;
		this.queQuan = queQuan;
		this.noiO = noiO;
		this.soCmnd = soCmnd;
		this.ngayCap = ngayCap;
		this.noiCap = noiCap;
		this.image1 = image1;
		this.image2 = image2;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHocvan() {
		return hocvan;
	}

	public void setHocvan(String hocvan) {
		this.hocvan = hocvan;
	}

	public String getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public String getNoiO() {
		return noiO;
	}

	public void setNoiO(String noiO) {
		this.noiO = noiO;
	}

	public String getSoCmnd() {
		return soCmnd;
	}

	public void setSoCmnd(String soCmnd) {
		this.soCmnd = soCmnd;
	}

	public Date getNgayCap() {
		return ngayCap;
	}

	public void setNgayCap(Date ngayCap) {
		this.ngayCap = ngayCap;
	}

	public String getNoiCap() {
		return noiCap;
	}

	public void setNoiCap(String noiCap) {
		this.noiCap = noiCap;
	}

}
