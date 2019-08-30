package org.sid.dao;

import org.sid.entities.Employe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeRepository extends JpaRepository<Employe, Long> {
	

	public Page<Employe> findByNomContains(String mc ,Pageable pageable);	
	
	
	
	
	
}
