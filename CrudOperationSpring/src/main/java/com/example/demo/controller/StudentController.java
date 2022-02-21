package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentDao;
import com.example.demo.entity.Student;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("api/v1")


public class StudentController {
	
	@Autowired
	private StudentRepository studRepo;
	 
	@Autowired
	private StudentDao studentDao;
	
	// Non-Parameter 
	 @GetMapping("/studentDetail")
	    public List<Student>  displayStudent(){
			return studentDao. displayStudent(); 	
	    }
	 
	//parameter
	 @GetMapping("/studentDetail/{address}")
	    public List<Student>  parameterStored(@PathVariable String  address){
			return studentDao.parameterStored(address);
	    	
	    }
	 
   @GetMapping("/student")
   public List<Student> getAllStudent(){
	   return studRepo.findAll();
   }
   
   
   
   
   @GetMapping("/student/{id}")
   public ResponseEntity<Student> getStudentId(@PathVariable (value = "id") int id) 
      throws ResourceNotFoundException
   {
	  Student stud = studRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
		        return ResponseEntity.ok().body(stud);
   }
 
   @PostMapping("/student")
   public Student createEmployee(@Validated @RequestBody Student stud1) {
       return studRepo.save(stud1);
   }
   
   @PutMapping("/student/{id}")
   public ResponseEntity<Student> updateEmployee(@PathVariable(value = "id") int id ,
        @Validated @RequestBody Student studentDetails) throws ResourceNotFoundException {
     Student std = studRepo.findById(id)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

      std.setId(studentDetails.getId());
      std.setName(studentDetails.getName());
      std.setEmail(studentDetails.getEmail());
      std.setAddress(studentDetails.getAddress());
       final Student updatedStudent = studRepo.save(std);
       return ResponseEntity.ok(updatedStudent);
   }
   
   
   @DeleteMapping("/student/{id}")
   public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") int id)
        throws ResourceNotFoundException {
	   Student std = studRepo.findById(id)
      .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

       studRepo.delete(std);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
   }
}
