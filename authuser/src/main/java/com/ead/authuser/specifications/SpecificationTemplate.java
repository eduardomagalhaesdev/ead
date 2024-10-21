package com.ead.authuser.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.ead.authuser.models.UserModel;

import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

public class SpecificationTemplate {

	// ao inves da anotação @And, tmb é possível usar a anotação @Or caso queira optar por alguma das Specs em vez de uma combinação.
	@And({	
			@Spec(path = "userType", spec = Equal.class),
			@Spec(path = "userStatus", spec = Equal.class),
			@Spec(path = "email", spec = Like.class),
	})
	public interface UserSpec extends Specification<UserModel>{}
}
