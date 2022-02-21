package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

@Entity
@Table(name = "student1")
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name = "AllStudentDetails", procedureName = "displayStudent"),
@NamedStoredProcedureQuery(name = "getAddress", procedureName = "parameterStored",parameters = {@StoredProcedureParameter(mode=ParameterMode.IN,name="caddress",type = String.class)})
})




public class Student {
	
	private int id;
	private String Name;
	private String Email;
	private String Address;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, String email, String address) {
		super();
		this.id = id;
		Name = name;
		Email = email;
		Address = address;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	 @Column(name = "name", nullable = false)
	 public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
	
		 @Column(name = "email", nullable = false)
		 public String getEmail() {
				return Email;
			}
			public void setEmail(String email) {
				Email = email;
			}
			
	
			 @Column(name = "address", nullable = false)
			public String getAddress() {
				return Address;
			}
			public void setAddress(String address) {
				Address = address;
			}
			@Override
			public String toString() {
				return "Student [id=" + id + ", Name=" + Name + ", Email=" + Email + ", Address=" + Address + "]";
			}
	
			
			

}
