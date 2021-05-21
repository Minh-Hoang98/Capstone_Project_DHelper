package com.fpt.edu.DomanticHelper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="post")
public class Post {
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
