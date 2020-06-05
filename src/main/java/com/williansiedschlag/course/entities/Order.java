package  com.williansiedschlag.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.williansiedschlag.course.entities.enums.OrderStatus;


// 7 - Impelmentar o Serializable. Gerar o serial id padrão. Click em orderm para fazer isso

// 9 - Declarar anotação, não esquecer de importar por persistence
@Entity 
@Table(name = "tb_order")
public class Order implements Serializable{

	// Isso por causa do Serializable
	private static final long serialVersionUID = 1L;

	
	// 1 - Declaração das variaveis 
	// 8 - Declarar anotação, para classe conversasr com banco de dados
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id; 
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",timezone="GMT")
	private Instant moment;
	
	// Tiro o tipo OrderStatus e coloco Interger para dizer para o banco 
	// que estou gravando um numero inteiro
	private Integer orderStatus; 
	
	// 2 - Associação com as outras classes. Exemplo User
	// Nome no diagrama esta o nome correto
	// Um usuario pode ter varios pedidos 
	// Mas um pedido que esse caso, pode ter apenas um usuario
	
	
	// Vou falar o nome da chave estrangeira que tem no banco de dados
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client; 
	// Acima preciso fazer associação do banco
	// Com anotação @ManyToOne 
	
	
	// No OrdemItem(classe) tenho id.order
	@OneToMany(mappedBy= "id.order")
	private Set<OrderItem> items =  new HashSet<>();
	
	
	// Mais abaixo um get para items 
	
	
	// 3 - Sempre criar um construtor vazio
	public Order() {
	}
	
	// 4 - Criar construtor com argumentos
	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}
	
	// 5 - Criar os GET e SETs

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
	

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOF(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
		this.orderStatus = orderStatus.getCode();
		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	public Set<OrderItem> getItems(){
		return items; 
	}

	// Fim do GET e SETs 
	// 6 - Criar os HashCode e Equals 
	
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
