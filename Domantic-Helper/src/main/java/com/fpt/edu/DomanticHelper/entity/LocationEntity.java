
package com.fpt.edu.DomanticHelper.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "location")
public class LocationEntity {
	@Id
	@GenericGenerator(name = "idLocation", strategy = "com.supportmycode.model.IdLocationGenerator")
	@Column(name = "idLocation",unique=true)
	private String idLocation;
	
	
}
