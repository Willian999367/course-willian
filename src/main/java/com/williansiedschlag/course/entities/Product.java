package com.williansiedschlag.course.entities;


import java.io.Serializable;
import java.util.HashSet; // Set é uma interface não pode ser instanciado
// Então usamos HashSet	
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String name; 
	private String drescription; 
	private Double price;
	private String imgUrl; 
	
	// Set representa um conjunto 
	// Isso para evitrar que um produto tenha mais de uma ocorencia com a 
	// mesma categoria
	// Tipo Category
	// categories conforme o diagrama
	// HashSet para instanciar
	// Por que estanciamos? Para garantir que minha isntancia começe valendo nullo 
	// Ela tem começar vazia porém instanciada
	
	
	// Abaixo e criado uma tabela de associação entre produto e categoria
	// Aqui vou dizer qual o nome da tabela e quais chaves estrangeiras vão 
	// associar entre tabela tb_product e tb_category
	// Depois colocar o nome da chave estrangeira do produto
	
	//@JoinTable(name = "tb_product_category", 
	//joinColumns= @JoinColumn(name="product_id"),
	// Como estou na classe Products a chave inversa e categoria
	//inverseJoinColumns = @JoinColumn(name="category_id"))
	
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();
	
	// Estou usando set em vez de listen para dizer para meu JPA que não foi admitir repetição 
	// do mesmo item 
	
	
	@OneToMany(mappedBy = "id.product")
	private Set<OrderItem> items = new HashSet<>();
	
	public Product() {
		
	}
	

	public Product(Long id, String name, String drescription, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.drescription = drescription;
		this.price = price;
		this.imgUrl = imgUrl;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDrescription() {
		return drescription;
	}


	public void setDrescription(String drescription) {
		this.drescription = drescription;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


	public Set<Category> getCategories() {
		return categories;
	}

	@JsonIgnore
	public Set<Order> getOrdes(){
		Set<Order> set = new HashSet<>();
		for(OrderItem x : items) { 
			set.add(x.getOrder());
		}
		return set;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
