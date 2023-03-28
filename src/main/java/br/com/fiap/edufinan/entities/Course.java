package br.com.fiap.edufinan.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_course")
@SequenceGenerator(name="course", sequenceName="SQ_COURSE", allocationSize=1)
public class Course implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course")
	private Long id;
	private String name;
	private String description;
	private Double price;
	
	@ManyToMany
	@JoinTable(name="tb_course_category",
	joinColumns=@JoinColumn(name="course_id"),inverseJoinColumns=@JoinColumn(name="category_id"))
	private Set<Category> categories = new HashSet<>();
	
	@OneToMany(mappedBy="id.course")
	private Set<OrderItem> items = new HashSet<>();
	
	public Course() { }

	public Course(Long id, String name, String description, Double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Set<Category> getCategories() {
		return categories;
	}
	
	@JsonIgnore
	public Set<Order> getOrders() {
		Set<Order> o = new HashSet<>();
		for (OrderItem oi : items) {
			o.add(oi.getOrder());
		}
		return o;
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
		Course other = (Course) obj;
		return Objects.equals(id, other.id);
	}
	
}
