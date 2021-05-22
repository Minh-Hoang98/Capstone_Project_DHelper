
package com.fpt.edu.DomanticHelper.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "location")
public class LocationEntity {
	@Id
	@GenericGenerator(name = "idLocation", strategy = "com.fpt.edu.DomanticHelper.generator.IdLocationGenerator")
	@Column(name = "idLocation")
	private String idLocation;
	
	@Column(name ="country")
	private String country;
	
	@Column(name ="province")
	private String province;
	@Column(name ="district")
	private String district;
	@Column(name ="subDistrict")
	private String subDistrict;
	@Column(name ="group")
	private String group;
	@Column(name ="numberHome")
	private String numberHome;
	
	@OneToMany(mappedBy="locationHome",
			   cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	private List<IdentityEntity> identities;
	
	public LocationEntity() {
		super();
	}
	public LocationEntity(String idLocation, String country, String province, String district, String subDistrict,
			String group, String numberHome) {
		super();
		this.idLocation = idLocation;
		this.country = country;
		this.province = province;
		this.district = district;
		this.subDistrict = subDistrict;
		this.group = group;
		this.numberHome = numberHome;
	}
	public String getIdLocation() {
		return idLocation;
	}
	public void setIdLocation(String idLocation) {
		this.idLocation = idLocation;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getSubDistrict() {
		return subDistrict;
	}
	public void setSubDistrict(String subDistrict) {
		this.subDistrict = subDistrict;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getNumberHome() {
		return numberHome;
	}
	public void setNumberHome(String numberHome) {
		this.numberHome = numberHome;
	}
	@Override
	public String toString() {
		return "LocationEntity [idLocation=" + idLocation + ", country=" + country + ", province=" + province
				+ ", district=" + district + ", subDistrict=" + subDistrict + ", group=" + group + ", numberHome="
				+ numberHome + "]";
	}
	
	
}
