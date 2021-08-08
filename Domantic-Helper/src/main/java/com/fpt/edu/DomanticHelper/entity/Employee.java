package com.fpt.edu.DomanticHelper.entity;




import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_emp")
    private int id;
    @Column(name = "accommodation", length = 150)
    private String accommodation;
    @Column(name = "care", length = 100)
    private String care;
    @Column(name = "cooking", length = 100)
    private String cooking;
    @Column(name = "houseKeeping", length = 100)
    private String houseKeeping;
    @Column(name = "house_size")
    private int houseSize;
    @Column(name = "living_arrangement", length = 100)
    private String livingArrangement;
    @Column(name = "note", length = 255)
    private String note;  
    @Column(name = "number_child", length = 50)
    private int numberChild;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_entity_emp", referencedColumnName = "id")
    private User user_emp;
    // mappedBy trỏ tới tên biến helperJobs ở trong rate.
  

    public Employee() {
        super();
    }
	public Employee(int id, String accommodation, String care, String cooking, String houseKeeping, int houseSize,
			String livingArrangement, String note, int numberChild, User user_emp) {
		super();
		this.id = id;
		this.accommodation = accommodation;
		this.care = care;
		this.cooking = cooking;
		this.houseKeeping = houseKeeping;
		this.houseSize = houseSize;
		this.livingArrangement = livingArrangement;
		this.note = note;
		this.numberChild = numberChild;
		this.user_emp = user_emp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccommodation() {
		return accommodation;
	}
	public void setAccommodation(String accommodation) {
		this.accommodation = accommodation;
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
	public int getHouseSize() {
		return houseSize;
	}
	public void setHouseSize(int houseSize) {
		this.houseSize = houseSize;
	}
	public String getLivingArrangement() {
		return livingArrangement;
	}
	public void setLivingArrangement(String livingArrangement) {
		this.livingArrangement = livingArrangement;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getNumberChild() {
		return numberChild;
	}
	public void setNumberChild(int numberChild) {
		this.numberChild = numberChild;
	}
	public User getUser_emp() {
		return user_emp;
	}
	public void setUser_emp(User user_emp) {
		this.user_emp = user_emp;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", accommodation=" + accommodation + ", care=" + care + ", cooking=" + cooking
				+ ", houseKeeping=" + houseKeeping + ", houseSize=" + houseSize + ", livingArrangement="
				+ livingArrangement + ", note=" + note + ", numberChild=" + numberChild + ", user_emp=" + user_emp
				+ "]";
	}



}
