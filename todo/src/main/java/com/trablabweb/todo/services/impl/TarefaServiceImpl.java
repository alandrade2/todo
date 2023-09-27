package com.trablabweb.todo.services.impl;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trablabweb.todo.exception.RegraNegocioException;
import com.trablabweb.todo.model.entity.Tarefa;
import com.trablabweb.todo.model.repository.Tarefarepository;
import com.trablabweb.todo.services.TarefaService;

@Service
public class TarefaServiceImpl implements TarefaService {

	private Tarefarepository repository;
	
	@Autowired
	public TarefaServiceImpl(Tarefarepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	@Transactional	
	public Tarefa SalvarTarefa(Tarefa tarefa) {
		return repository.save(tarefa);
	}

	@Override
	@Transactional
	public Tarefa AlterarTarefa(long id, Tarefa newtarefa) {

		newtarefa = repository.findById(id)
				.orElseThrow(() -> new RegraNegocioException("Tarefa Não Encontrada."));
		return repository.save(newtarefa);
	}

	@Transactional
    public void excluirTarefa(long id) {

		Tarefa newtarefa = repository.findById(id)
				.orElseThrow(() -> new RegraNegocioException("Tarefa Não Encontrada."));

        repository.delete(newtarefa);
    }	
	
		
}
