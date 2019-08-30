package org.sid.dao;


import org.sid.entities.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServiceRepository extends JpaRepository<Service, Long> {
	

	public Page<Service>findByNomSerContains(String mc ,Pageable pageable);
	
	
	
	
	
}
