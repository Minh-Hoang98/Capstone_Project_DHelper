package com.fpt.edu.DomanticHelper.entity;

import javax.persistence.*;

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
    private double image;
    
	public PostEntity() {
		super();
	}

	public PostEntity(Long id, String iduser, double tile, double content, double image) {
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

	public double getImage() {
		return image;
	}

	public void setImage(double image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", iduser=" + iduser + ", tile=" + tile + ", content=" + content + ", image=" + image
				+ "]";
	}
	
}
