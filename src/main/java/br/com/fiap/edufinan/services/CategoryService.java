package br.com.fiap.edufinan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.edufinan.entities.Category;
import br.com.fiap.edufinan.repositories.CategoryRepository;

import br.com.fiap.edufinan.services.exceptions.ResourceNotFoundException;


@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = categoryRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
