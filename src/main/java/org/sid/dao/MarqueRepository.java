package org.sid.dao;

import java.util.List;

import org.sid.entities.Marque;
import org.sid.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MarqueRepository extends JpaRepository<Marque, Long> {
	
	public Page<Marque> findByNomMarqContains(String mc ,Pageable pageable);
	
	
	
	
	
}
