package com.numetry.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numetry.entity.Course;
import com.numetry.repository.CourseRepo;

@Service
public class CourseService {
	@Autowired
	private CourseRepo courseRepository;

	public Course saveCourse(Course course) {

		return courseRepository.save(course);

	}

	public List<Course> getAllCourse() {

		return courseRepository.findAll();

	}

	public Course updateCourse(Integer id, Course course) {
		Optional<Course> findById = courseRepository.findById(id);
		if (findById.isPresent()) {
			Course savedCourse = findById.get();
			savedCourse.setCourseName(course.getCourseName());
			savedCourse.setCreditHours(course.getCreditHours());
			return courseRepository.save(savedCourse);
		}
		return null;

	}

	public void deleteCourseById(Integer id) {
		courseRepository.deleteById(id);
	}

}
