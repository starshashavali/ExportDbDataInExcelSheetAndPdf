package com.tcs.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.entity.Emp;
@Repository
/*
 * represent dao class 
 */
public interface EmpRepo  extends JpaRepository<Emp,Integer>{

}
