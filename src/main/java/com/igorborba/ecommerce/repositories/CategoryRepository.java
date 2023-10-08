package com.igorborba.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igorborba.ecommerce.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
