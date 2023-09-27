package com.trablabweb.todo.services;

import com.trablabweb.todo.model.entity.Tarefa;

public interface TarefaService {

	Tarefa SalvarTarefa(Tarefa tarefa);

	Tarefa AlterarTarefa(long id, Tarefa newtarefa);

	void excluirTarefa(long id);
	
}
