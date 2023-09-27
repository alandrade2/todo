package com.trablabweb.todo.model.entity;

import java.time.LocalDate;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.trablabweb.todo.model.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table (name= "tarefa", schema= "task")
@Data
@Builder
public class Tarefa {
	@Id
	@Column(name="id")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Column(name="nome")
	private String nome;

	@Column(name = "status")
	@Enumerated(value = EnumType.STRING)
	private Status tipo;	

	@Column(name="observ")
	private String observ;
	
	@Column(name = "data_criacao")
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate datacriacao;

	@Column(name = "data_atualiza")
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate dataatualiza;			
}
