package com.ead.course.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ead.course.models.CourseModel;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel, UUID>{

}
