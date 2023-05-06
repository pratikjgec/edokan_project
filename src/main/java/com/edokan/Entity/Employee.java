package com.edokan.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	private int id;
	private String name;
	private String email;
	private String access;
	
	  @OneToMany(cascade = CascadeType.ALL)
	  @JoinColumn(name = "fk_emp_id", referencedColumnName = "id")
	  private List<Department> department;
	  
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
//    private Department department;




	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAccess() {
		return access;
	}



	public void setAccess(String access) {
		this.access = access;
	}



	public List<Department> getDepartment() {
		return department;
	}



	public void setDepartment(List<Department> department) {
		this.department = department;
	}
	

	
}
