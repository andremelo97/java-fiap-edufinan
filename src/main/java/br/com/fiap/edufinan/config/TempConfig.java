/* 
 * Classe criada para que sejam instanciados alguns objetos no momento que a aplicação é iniciada,
 * desta forma facilitando o teste.
 * É apenas temporária, o projeto final não irá conter ela.
 * */

package br.com.fiap.edufinan.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.edufinan.entities.Category;
import br.com.fiap.edufinan.entities.Course;
import br.com.fiap.edufinan.entities.Order;
import br.com.fiap.edufinan.entities.OrderItem;
import br.com.fiap.edufinan.entities.Payment;
import br.com.fiap.edufinan.entities.User;
import br.com.fiap.edufinan.entities.enums.OrderStatus;
import br.com.fiap.edufinan.repositories.CategoryRepository;
import br.com.fiap.edufinan.repositories.CourseRepository;
import br.com.fiap.edufinan.repositories.OrderItemRepository;
import br.com.fiap.edufinan.repositories.OrderRepository;
import br.com.fiap.edufinan.repositories.UserRepository;

@Configuration
public class TempConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		User u1 = new User(null, "Aline Silva", "alive@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Andre Melo", "andre@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Marcos Paulo", "marcos@hotmail.com", "99999999", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		
		Category cat1 = new Category(null, "Renda Fixa");
		Category cat2 = new Category(null, "Renda Variável");
		Category cat3 = new Category(null, "Criptoativos");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Course course1 = new Course(null, "Tesouro Direto", "Aprenda o essencial sobre a classe de investimentos mais segura do mercado", 24.90);
		Course course2 = new Course(null, "Mercado de Ações", "Aprenda o essencial sobre a classe de investimentos que mais rende no mercado", 24.90);
		Course course3 = new Course(null, "Bitcoin", "Aprenda o essencial sobre a mais inovadora moeda digital do mercado", 29.90);
		Course course4 = new Course(null, "Liberdade Financeira", "Entenda os principais conceitos e estratégias para se tornar independente financeiramente", 00.00);
		
		courseRepository.saveAll(Arrays.asList(course1, course2, course3, course4));
		
		course1.getCategories().add(cat1);
		course2.getCategories().add(cat2);
		course3.getCategories().add(cat3);
		course4.getCategories().add(cat1);
		course4.getCategories().add(cat2);
		course4.getCategories().add(cat3);
		
		courseRepository.saveAll(Arrays.asList(course1, course2, course3, course4));
		
		Order o1 = new Order(null, Instant.parse("2023-03-20T19:53:07Z"), OrderStatus.ENTREGUE, u1);
		Order o2 = new Order(null, Instant.parse("2023-03-21T03:42:10Z"), OrderStatus.AGUARDANDO_PAGAMENTO, u2);
		Order o3 = new Order(null, Instant.parse("2023-03-22T15:21:22Z"), OrderStatus.PAGO,u1); 
		Order o4 = new Order(null, Instant.parse("2023-03-27T15:25:22Z"), OrderStatus.PAGO,u3);
		
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4));
		
		OrderItem oi1 = new OrderItem(o1, course1, course1.getPrice());
		OrderItem oi2 = new OrderItem(o2, course1, course1.getPrice());
		OrderItem oi3 = new OrderItem(o2, course2, course2.getPrice());
		OrderItem oi4 = new OrderItem(o3, course4, course4.getPrice());
		OrderItem oi5 = new OrderItem(o4, course2, course2.getPrice());
		OrderItem oi6 = new OrderItem(o4, course3, course3.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4, oi5, oi6));
		
		Payment payO1 = new Payment(null, Instant.parse("2023-03-20T19:58:07Z"), o1);
		Payment payO2 = new Payment(null, Instant.parse("2023-03-22T16:21:22Z"), o3);
		Payment payO3 = new Payment(null, Instant.parse("2023-03-27T15:30:22Z"), o4);
		
		o1.setPayment(payO1);
		orderRepository.save(o1);
		o3.setPayment(payO2);
		orderRepository.save(o3);
		o4.setPayment(payO3);
		orderRepository.save(o4);
	} 

}
