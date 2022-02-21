package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;



@Repository
public class StudentDao {
	
	@Autowired
	private EntityManager enmanager;
	
	// Non-Parameter 
	@SuppressWarnings("unchecked")
	public List<Student> displayStudent(){
		return enmanager.createNamedStoredProcedureQuery("AllStudentDetails").getResultList();
	}
	
	
	//parameter
	@SuppressWarnings("unchecked")
	public List<Student> parameterStored(String input){
		return enmanager.createNamedStoredProcedureQuery("getAddress").setParameter("caddress",input).getResultList();
	}
	
	
	
	
}
