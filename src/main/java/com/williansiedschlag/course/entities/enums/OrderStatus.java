package com.williansiedschlag.course.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	
	// codigo do tipo enumerado
	private int code;
	
	// Nesse caso precisa ser private
	private OrderStatus(int code) {
		this.code = code; 
	}
	
	
	// Metodo publico para acessar o código acima 
	public int getCode() {
		return code; 
	}
	
	// Metodo estatico para converter um valor númerico para tipo enumerado
	// esatico (não precisa instanciar)
	// OrderStatus e um tipo de retorno 
	// passando um código como argumento
	public static OrderStatus valueOF (int code) {
		// Vou percorrer todos os possíveis valores do OrderStatus
	    // 	WAITING_PAYMENT, PAID etc.....
		for(OrderStatus value: OrderStatus.values()) {
			if(value.getCode() == code) {
				return value; 
			}
		}
		// Caso não encontre o código na lista acima 
		// Vou lançar uma execeção
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
