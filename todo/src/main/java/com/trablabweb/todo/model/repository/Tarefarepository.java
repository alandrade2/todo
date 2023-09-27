package com.trablabweb.todo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trablabweb.todo.model.entity.Tarefa;

public interface Tarefarepository extends JpaRepository<Tarefa, Long> {

	
	
}
