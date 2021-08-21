package com.fpt.edu.DomanticHelper.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "post")
public class Post {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tile", length = 150)
    private String tile;

    @Column(name = "content", length = 255)
    private String content;

    @Lob
    @Column(name = "avatar", columnDefinition = "MEDIUMBLOB")
    private String image;

    @Column(name = "salary")
    private float salary;

    @Column(name = "date_start")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateStart;

    @Column(name = "day_off")
    private String dayOff;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "location_work")
    private Location workLocation;

    @ManyToOne
    @JoinColumn(name = "user_post")
    private User userPost;

    @Column(name="type")
    private int type;
    
    @OneToMany(mappedBy = "postApply", cascade = CascadeType.ALL)
    private List<PostApply> postApply;
    
    @OneToMany(mappedBy = "postComment", cascade = CascadeType.ALL)
    private List<PostComment> cmtPost;
    
    public Post() {
        super();
    }

    public Post(Long id, String tile, String content, String image, float salary, Date dateStart, String dayOff,
                String status, Location workLocation) {
        super();
        this.id = id;
        this.tile = tile;
        this.content = content;
        this.image = image;
        this.salary = salary;
        this.dateStart = dateStart;
        this.dayOff = dayOff;
        this.status = status;
        this.workLocation = workLocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTile() {
        return tile;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public String getDayOff() {
        return dayOff;
    }

    public void setDayOff(String dayOff) {
        this.dayOff = dayOff;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Location getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(Location workLocation) {
        this.workLocation = workLocation;
    }

    @Override
    public String toString() {
        return "PostEntity [id=" + id + ", tile=" + tile + ", content=" + content + ", image=" + image + ", salary="
                + salary + ", dateStart=" + dateStart + ", dayOff=" + dayOff + ", status=" + status + ", workLocation="
                + workLocation + "]";
    }

}
