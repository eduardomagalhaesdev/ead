package com.ead.course.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.ead.course.models.ModuleModel;

@Repository
public interface ModuleRepository extends JpaRepository<ModuleModel, UUID>{

}
