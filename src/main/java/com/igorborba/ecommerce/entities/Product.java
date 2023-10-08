package com.igorborba.ecommerce.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Double price;
	
	@ManyToMany							  // JoinTable: cria tabela intermediário quano tem relacionamento muitos para muitos
	@JoinTable(name = "PRODUCT_CATEGORY", // name: nome da tabela
			   joinColumns = @JoinColumn(name = "PRODUCT_ID"), // chave estrangeira desta classe
			   inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID")) // chave estrangeira da outra classe
	private List<Category> category = new ArrayList<>();

	public Product() {}
	
	public Product(Integer id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public List<Category> getCategory() {
		return category;
	}

	public void addCategory(Category category) {
		this.category.add(category);
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
