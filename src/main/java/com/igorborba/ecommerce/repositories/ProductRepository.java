package com.igorborba.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igorborba.ecommerce.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
