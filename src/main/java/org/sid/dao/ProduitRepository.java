package org.sid.dao;

import java.util.List;


import org.sid.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	@Query("select p from Produit p where p.categorie.idCat=:x")
	public List <Produit> listProduits(@Param("x") Long id);
	@Query("select p from Produit p where p.marque.idMarq=:x")
	public List <Produit> listProduitsM(@Param("x") Long id);
	public Page<Produit> findByNumSerieContains(String mc ,Pageable pageable);
	

		
	
	
	
	
	
}
