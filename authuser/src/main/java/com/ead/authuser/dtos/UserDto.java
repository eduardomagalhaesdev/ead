package com.ead.authuser.dtos;

import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.ead.authuser.validations.UsernameConstraint;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
	
	
	public interface UserView{
		public static interface RegistrationPost {}
		public static interface UserPut {}
		public static interface PasswordPut {}
		public static interface ImagePut {}
	}

	private UUID userId;
	
	@Size(min = 4, max = 50, groups = UserView.RegistrationPost.class)
	@UsernameConstraint(groups = UserView.RegistrationPost.class)
	@NotBlank(groups = UserView.RegistrationPost.class)
	@JsonView(UserView.RegistrationPost.class)	//JsonView -> uso de múltiplas visões, utilizando-se de apenas um único DTO.
	private String username;
	
	@Size(min = 6, max = 20, groups = UserView.RegistrationPost.class)
	@NotBlank(groups = UserView.RegistrationPost.class)
	@Email(groups = UserView.RegistrationPost.class)
	@JsonView(UserView.RegistrationPost.class)
	private String email;
	
	@Size(min = 6, max = 20, groups = {UserView.PasswordPut.class, UserView.RegistrationPost.class})
	@NotBlank(groups = {UserView.RegistrationPost.class, UserView.PasswordPut.class})
	@JsonView({UserView.RegistrationPost.class, UserView.PasswordPut.class})
	private String password;
	
	@Size(min = 6, max = 20, groups = UserView.PasswordPut.class)
	@NotBlank(groups = UserView.PasswordPut.class)
	@JsonView(UserView.PasswordPut.class)
	private String oldPassword;
	
	@JsonView({UserView.RegistrationPost.class, UserView.UserPut.class})
	private String fullName;
	
	@JsonView({UserView.RegistrationPost.class, UserView.UserPut.class})
	private String phoneNumber;
	
	@JsonView({UserView.RegistrationPost.class, UserView.UserPut.class})
	private String cpf;
	
	@NotBlank(groups = UserView.ImagePut.class)
	@JsonView(UserView.ImagePut.class)
	private String imageUrl;
}
