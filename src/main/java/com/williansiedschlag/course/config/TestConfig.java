package com.williansiedschlag.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.williansiedschlag.course.entities.Category;
import com.williansiedschlag.course.entities.Order;
import com.williansiedschlag.course.entities.OrderItem;
import com.williansiedschlag.course.entities.Payment;
import com.williansiedschlag.course.entities.Product;
import com.williansiedschlag.course.entities.User;
import com.williansiedschlag.course.entities.enums.OrderStatus;
import com.williansiedschlag.course.respositories.CategoryRepository;
import com.williansiedschlag.course.respositories.OrderItemRepository;
import com.williansiedschlag.course.respositories.OrderRepository;
import com.williansiedschlag.course.respositories.ProductRepository;
import com.williansiedschlag.course.respositories.UserRepository;

@Configuration
@Profile("test")

public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRespository;
	
	@Autowired
	private OrderItemRepository orderItemRepository; 

	@Override
	public void run(String... args) throws Exception {
		
		
		Category cat1 = new Category(null, "Electronics"); 
		Category cat2 = new Category(null, "Books"); 
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		productRespository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3); 
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2); 
		
		productRespository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		
		// Abaixo criando o banco tb_order. Nele tinha uma chave estrangeira 
		// da table tb_user. Que nesse caso são o u1,u2 
		// Na classe Order declarei um tipo User (client)
		
		// Instant e um tipo de data
		// Agora preciso passar o status do pedido
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u1); 
	
	
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3)); 
	
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
		
		
		Payment pay1  = new Payment(null,Instant.parse("2019-06-20T21:53:07Z"),o1); 
		// Quando e 1 para 1 e forma diferente. faço a associação para pedido(order)
		o1.setPayment(pay1);
		// Depois salvo o pedido novamente. O jpa cuida de salvar o pagamento
	
		orderRepository.save(o1); 
	}
	
}
