package com.fpt.edu.DomanticHelper.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="post")
public class PostEntity {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	
    @Column(name = "iduser")
    private String iduser;
 
    @Column(name = "tile")
    private double tile;
    
    @Column(name = "content")
    private double content;
    
    @Column(name = "image")
    private String image;
    
    @Column(name = "salary")
    private float salary;
    
    @Column(name="date_start")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateStart;
	
	@Column(name="date_off")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateOff;
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "location_work")
	private LocationEntity workLocation;
    
	public PostEntity() {
		super();
	}

	public PostEntity(Long id, String iduser, double tile, double content, String image) {
		super();
		this.id = id;
		this.iduser = iduser;
		this.tile = tile;
		this.content = content;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIduser() {
		return iduser;
	}

	public void setIduser(String iduser) {
		this.iduser = iduser;
	}

	public double getTile() {
		return tile;
	}

	public void setTile(double tile) {
		this.tile = tile;
	}

	public double getContent() {
		return content;
	}

	public void setContent(double content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", iduser=" + iduser + ", tile=" + tile + ", content=" + content + ", image=" + image
				+ "]";
	}
	
}
