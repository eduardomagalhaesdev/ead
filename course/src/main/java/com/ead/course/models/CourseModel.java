package com.ead.course.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ead.course.enums.CourseLevel;
import com.ead.course.enums.CourseStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) //oculta os campos nulos no retorno
@Entity
@Table(name = "TB_COURSES")
public class CourseModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID courseId;
	
	@Column(nullable = false, length = 150)
	private String name;
	
	@Column(nullable = false, length = 250)
	private String description;
	
	@Column
	private String imageUrl;
	
	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime creationDate;
	
	@Column(nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
	private LocalDateTime lastUpdateDate;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CourseStatus courseStatus;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CourseLevel courseLevel;
	
	@Column(nullable = false)
	private UUID userInstructor;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // No método get esse atributo é ignorado, sendo exibido na requisição apenas em caso de atualização.
	@OneToMany(mappedBy = "course") // Relacionamento bidirecional(evita geração de tabelas e querys extras pelo hibernate).
	private Set<ModuleModel> modules; //Set -> sem ordenação e sem duplicidade.
}
