package com.ead.authuser.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.ead.authuser.models.UserModel;
import com.ead.authuser.specifications.SpecificationTemplate.UserSpec;


public interface UserService {

	List<UserModel> findAll();

	Optional<UserModel> findById(UUID userId);

	void delete(UserModel userModel);

	void save(UserModel userModel);

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);

	Page<UserModel> findAll(Specification<UserModel> spec, Pageable pageable);

}
