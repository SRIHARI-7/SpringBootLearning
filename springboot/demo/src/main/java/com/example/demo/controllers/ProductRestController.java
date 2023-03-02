package com.example.demo.controllers;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Product;
import com.example.demo.repository.ProductRepository;

@RestController
public class ProductRestController {

    @Autowired
    ProductRepository repository;

    private static final Logger LOGGER=LoggerFactory.getLogger(ProductRestController.class);
    
    // To list all products
    @RequestMapping(value = "/products/", method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    // To list a product
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") int id){
        LOGGER.info("Finding by id: "+id);
        return repository.findById(id).get();
    }

    // To create a product
    @RequestMapping(value = "/products/", method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product){
        return repository.save(product);
    }

    // To update a product
    @RequestMapping(value = "/products/", method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product){
        return repository.save(product);
    }

    // To delete a product
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") int id){
        repository.deleteById(id);
    }
    

}
