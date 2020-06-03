package com.williansiedschlag.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tb_user")
public class User implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email; 
	private String phone;
	private String password;
	
	// Essa seria associação, um usuario pode fazer vários pedidos
	// Um pedido pode ter apenas um usuario
	// Criar o método. Nesse caso clik e framework já faz o procedimento
	// Metodo esta lá embaixo
	// Essa classe ordem e referente associação entre User e Order 
	
	// Esse abaixo é muitos para 1 
	// Dentro do parentes coloco o que tem lá do outra lado (classe Order)
	// Esta mapeado pelo atraibuto client que esta na classe Order 
	@JsonIgnore // Para não entrar loop infinito entre User e Order
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
	
	
	
	public User() {
		
	}
	

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public List<Order> getOrders() {
		return orders;
	}
	
	
	
	
}
