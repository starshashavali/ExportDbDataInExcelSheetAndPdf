package com.tcs.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
//represent entity class
@Table(name = "emp_tbl")
//map table name
@Data
//provide setter+Getter+O-param Construct+ToString+equal

public class Emp {
	@Id
	/*
	 * represent primary key
	 * @Column is optional so variable name as  same column name 
	 */
	private Integer empId;
	private String name;
	private String designation;

}
