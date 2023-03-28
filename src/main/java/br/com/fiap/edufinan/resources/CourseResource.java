package br.com.fiap.edufinan.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.edufinan.entities.Course;
import br.com.fiap.edufinan.services.CourseService;

@RestController
@RequestMapping(value="/courses")
public class CourseResource {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public ResponseEntity<List<Course>> findAll() {

		List<Course> list = courseService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Course> findById(@PathVariable Long id) {
		Course obj = courseService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
