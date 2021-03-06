
package com.fpt.edu.DomanticHelper.entity;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "country", length = 100, nullable = false)
    private String country;

    @Column(name = "province", length = 100, nullable = false)
    private String province;

    @Column(name = "district", length = 100, nullable = false)
    private String district;

    @Column(name = "sub_district", length = 100, nullable = false)
    private String subDistrict;

    @Column(name = "group_location", length = 100, nullable = false)
    private String groupLocation;

    @Column(name = "number_home", nullable = false)
    private int numberHome;


    @OneToMany(mappedBy = "currentLocation", cascade = CascadeType.ALL)
    private List<User> users;


    @OneToMany(mappedBy = "locationHome", cascade = CascadeType.ALL)
    private List<Identity> identities;

    public Location() {
        super();
    }

    public Location(Long idLocation, String country, String province, String district, String subDistrict,
                          String group, int numberHome) {
        super();
        this.id = idLocation;
        this.country = country;
        this.province = province;
        this.district = district;
        this.subDistrict = subDistrict;
        this.groupLocation = group;
        this.numberHome = numberHome;
    }

    public Long getIdLocation() {
        return id;
    }

    public void setIdLocation(Long idLocation) {
        this.id = idLocation;
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
        return groupLocation;
    }

    public void setGroup(String group) {
        this.groupLocation = group;
    }

    public int getNumberHome() {
        return numberHome;
    }

    public void setNumberHome(int numberHome) {
        this.numberHome = numberHome;
    }

    @Override
    public String toString() {
        return "LocationEntity [id=" + id + ", country=" + country + ", province=" + province + ", district=" + district
                + ", subDistrict=" + subDistrict + ", groupLocation=" + groupLocation + ", numberHome=" + numberHome
                + "]";
    }

}
