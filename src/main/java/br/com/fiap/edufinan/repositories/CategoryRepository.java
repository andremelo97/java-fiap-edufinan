package br.com.fiap.edufinan.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.edufinan.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
