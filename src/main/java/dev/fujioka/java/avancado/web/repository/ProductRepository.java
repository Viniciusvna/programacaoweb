package dev.fujioka.java.avancado.web.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.fujioka.java.avancado.web.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public List<Product> findProductByName(@Param("name") String name);
	public List<Product> findProductById(@Param("id") Long id);
	public List<Product> findProductByDtCreation(@Param("dtCreation") Date dtCreation);
	public List<Product> findProductByDtUpdate(@Param("dtUpdate") Date dtUpdate);
	public List<Product> findProductByDescription(@Param("description") String description);
}
