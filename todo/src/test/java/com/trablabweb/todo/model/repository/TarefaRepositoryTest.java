package com.trablabweb.todo.model.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.trablabweb.todo.exception.RegraNegocioException;
import com.trablabweb.todo.model.entity.Tarefa;

@ExtendWith( SpringExtension.class )
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class TarefaRepositoryTest {
	
	@Autowired
	Tarefarepository repository;
	
	@Autowired
	TestEntityManager entityManager;
	
	
	
	@Test
	public void deveIncluirUmaTarefaNoBancoDeDados() {
		// Cenário		
		Tarefa tarefa = criarTarefa();
		
		// ação
		Tarefa newTarefa = repository.save(tarefa);

		// Verificação
		Assertions.assertThat(newTarefa.getId()).isNotNull();
	}

	@Test
	public void deveAlterarUmaTarefaNoBancoDeDados() {
		// Cenário		
		Tarefa tarefa = criarTarefa();
		entityManager.persist(tarefa);

		// Ação
		long newId = tarefa.getId();
		Tarefa newTarefa; 
		newTarefa = repository.findById(newId)
				.orElseThrow(() -> new RegraNegocioException("Tarefa Não Encontrada."));
		newTarefa.setNome("Tarefa 02");
		newTarefa.setObserv("Tarefa Alterada");		
		repository.save(newTarefa);

		// Verificação
		Tarefa tarefaAlterada = repository.findById(newTarefa.getId()).orElse(null);
		assertEquals("Tarefa 02", tarefaAlterada.getNome());
		assertEquals("Tarefa Alterada", tarefaAlterada.getObserv());		
	}

	@Test
	public void deveExcluirUmaTarefaNoBancoDeDados() {
		// Cenário		
		Tarefa tarefa = criarTarefa();
		entityManager.persist(tarefa);

		// Ação
		Tarefa tarefaExcluir = repository.findById(tarefa.getId()).orElse(null);
		repository.delete(tarefaExcluir);
		
		// Verificação
		Tarefa tarefaExcluida = repository.findById(tarefaExcluir.getId()).orElse(null);
		assertNull(tarefaExcluida);
	}
	
	
	
	public static Tarefa criarTarefa() {
		return Tarefa.builder()
				.nome("Tarefa 01")
				.observ("Observação teste")
				.dataatualiza(null)
				.build();
	}
	

}
