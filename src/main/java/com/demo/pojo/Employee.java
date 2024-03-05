package com.demo.pojo;

import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "set")
@Getter
public class Employee {
	
	int id;
	String firstName;
	String lastName;
	String email;
	String profession;
}
