package br.com.fiap.edufinan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.edufinan.entities.Course;
import br.com.fiap.edufinan.repositories.CourseRepository;
import br.com.fiap.edufinan.services.exceptions.ResourceNotFoundException;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> findAll() {
		return courseRepository.findAll();
	}
	
	public Course findById(Long id) {
		Optional<Course> obj = courseRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
}
