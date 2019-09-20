package dev.fujioka.java.avancado.web.web.rest;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.fujioka.java.avancado.web.domain.Product;
import dev.fujioka.java.avancado.web.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<Product> getProductList() {
        return productService.findAll();
    }
    
    @GetMapping("/product/id/{id}")
    public List<Product> getProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }

    @GetMapping("/product/name/{name}")
    public List<Product> getProductByName(@PathVariable String name) {
        return productService.findProductByName(name);
    }
    
    @GetMapping("/product/description/{description}")
    public List<Product> getProductByDescription(@PathVariable String description) {
        return productService.findProductByDescription(description);
    }
    
    @GetMapping("/product/dtCreation/{dtCreation}")
    public List<Product> getProductByDtCreation(@PathVariable @DateTimeFormat(pattern = "ddMMyyyy") Date dtCreation) {
        return productService.findProductByDtCreation(dtCreation);
    }
    
    @GetMapping("/product/dtUpdate/{dtUpdate}")
    public List<Product> getProductByDtUpdate(@PathVariable Date dtUpdate) {
        return productService.findProductByDtUpdate(dtUpdate);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> save(
            @RequestBody Product product) {

        product = productService.save(product).get();

        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/product")
    public ResponseEntity<Product> update(
            @RequestBody Product product) {

        product = productService.save(product).get();

        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/product")
    public ResponseEntity<String> delete(
            @RequestBody Product product) {

        productService.delete(product);
        return ResponseEntity.ok().body("Product excluded " + product.getId());
    }


}
