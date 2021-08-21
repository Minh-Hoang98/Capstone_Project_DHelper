package com.fpt.edu.DomanticHelper.entity;


import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_emp")
    private int id;

    @Column(name = "number_child", length = 50)
    private int numberChild;

    @Column(name = "accommodation", length = 150)
    private String accommodation;

    @Column(name = "living_arrangement", length = 100)
    private String livingArrangement;

    @Column(name = "house_size")
    private float houseSize;

    @Column(name = "note", length = 255)
    private String note;

    @Column(name = "care", length = 100)
    private String care;

    @Column(name = "cooking", length = 100)
    private String cooking;

    @Column(name = "houseKeeping", length = 100)
    private String houseKeeping;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_entity_emp", referencedColumnName = "id")
    private User user_emp;

    // mappedBy trỏ tới tên biến helperJobs ở trong rate.
    @ManyToMany(mappedBy = "employees")
    // LAZY để tránh việc truy xuất dữ liệu không cần thiết. Lúc nào cần thì mới query
    private Collection<Rate> rates_emp;

    public Employee() {
        super();
    }

    public Employee(int id, int numberChild, String accommodation, String livingArrangement,
                    float houseSize, String note, String care, String cooking, String houseKeeping) {
        super();
        this.id = id;
        this.numberChild = numberChild;
        this.accommodation = accommodation;
        this.livingArrangement = livingArrangement;
        this.houseSize = houseSize;
        this.note = note;
        this.care = care;
        this.cooking = cooking;
        this.houseKeeping = houseKeeping;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberChild() {
        return numberChild;
    }

    public void setNumberChild(int numberChild) {
        this.numberChild = numberChild;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    public String getLivingArrangement() {
        return livingArrangement;
    }

    public void setLivingArrangement(String livingArrangement) {
        this.livingArrangement = livingArrangement;
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

    public User getUser_emp() {
        return user_emp;
    }

    public void setUser_emp(User user_emp) {
        this.user_emp = user_emp;
    }

    public Collection<Rate> getRates_emp() {
        return rates_emp;
    }

    public void setRates_emp(Collection<Rate> rates_emp) {
        this.rates_emp = rates_emp;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", numberChild=" + numberChild + ", accommodation="
                + accommodation + ", livingArrangement=" + livingArrangement + ", houseSize=" + houseSize + ", note="
                + note + ", care=" + care + ", cooking=" + cooking + ", houseKeeping=" + houseKeeping + ", user_emp="
                + user_emp + ", rates_emp=" + rates_emp + "]";
    }

}
