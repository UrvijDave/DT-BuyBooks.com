package com.urvij.buybooks.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

// map to specific database entity (Table)
// Which table you have map
// Create Singleton instance / object

@Entity
@Table 		// If table name and domain object name is same 
@Component	// user instance		// do not use User u = new User()


public class User{

	
	// what are the properties same as db table field
	@Id
	private String id;
	
	private String name;
	
	private String password;
	
	private String mobile;
	
	private String role;
	
}
