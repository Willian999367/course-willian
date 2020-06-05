package com.williansiedschlag.course.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.williansiedschlag.course.entities.Order;
import com.williansiedschlag.course.entities.Product;

// Essa classe e uma referencia para o produto e pedido. Seria uma associação entre 
// eles 

// Foi importado por que essa classe e diferente das outras
@Embeddable
public class OrdemItemPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	// Nessa classe em especial não tem construtores
	
	// O relaciomaneto dos dois abaixo, vão ser muitos para 1 (pedido e porduto)
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		OrdemItemPK other = (OrdemItemPK) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	} 
	
	
	
}
