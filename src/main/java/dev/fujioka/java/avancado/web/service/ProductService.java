package dev.fujioka.java.avancado.web.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fujioka.java.avancado.web.domain.Product;
import dev.fujioka.java.avancado.web.repository.ProductRepository;

@Service
public class ProductService
        implements CrudInterface<Product> {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> save(Product entity) {
        return Optional.of(productRepository.save(entity));
    }

    @Override
    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    @Override
    public void delete(Product entity) {
        productRepository.delete(entity);
    }

    @Override
    public void deleteById(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public long count() {
        return productRepository.count();
    }
    
    public List<Product> findProductByName(String name){
    	return productRepository.findProductByName(name);
    }
    
    public List<Product> findProductById(Long id){
    	return productRepository.findProductById(id);
    }
    
    public List<Product> findProductByDtCreation(Date dtCreation){
    	return productRepository.findProductByDtCreation(dtCreation);
    }
    
    public List<Product> findProductByDtUpdate(Date dtUpdate){
    	return productRepository.findProductByDtUpdate(dtUpdate);
    }
    
    public List<Product> findProductByDescription(String description){
    	return productRepository.findProductByDescription(description);
    }
}
