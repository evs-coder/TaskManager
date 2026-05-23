package com.estudos.taskmanager.service;

import com.estudos.taskmanager.model.Task;
import com.estudos.taskmanager.repository.TaskRepository;
import java.util.List;

public class TaskService{
    //1.Criação de uma variável que faz referência a classe TaskRepository para podermos criar o objeto que executará as ações.
    private final TaskRepository repository; 

    //2.Construtor do operador TaskService que utilizará os recursos de TaskRepository
    public TaskService(TaskRepository repository){
        this.repository = repository;
    }

    public void registrarTarefa(String descricao){
        boolean jaExiste = repository.buscarTodas().stream().anyMatch(t -> t.getDescricao().trim().equalsIgnoreCase(descricao.trim()));

        if(jaExiste){
            throw new IllegalArgumentException("ERRO: Já existe uma tarefa com essa descricao!");
        }

        Task novaTarefa = new Task(descricao);

        repository.salvar(novaTarefa);
    }

    public List<Task> listarTodas(){
        return repository.buscarTodas();
    }

    public void removerTarefa(String descricao){
        Task tarefa = repository.buscarTodas().stream().filter(t -> t.getDescricao().trim().equalsIgnoreCase(descricao.trim())).findFirst().orElse(null);

        if(tarefa != null){
            repository.remover(tarefa);
        } else{
            throw new IllegalArgumentException("ERRO: A tarefa descrita não existe.");
        }
    }

    public void concluirTarefa(String descricao){
        Task tarefa = repository.buscarTodas().stream().filter(t -> t.getDescricao().trim().equalsIgnoreCase(descricao.trim())).findFirst().orElse(null);

        if(tarefa != null){
            tarefa.setConcluida(true);
            repository.salvarCSV();
        } else{
            throw new IllegalArgumentException("ERRO: A tarefa descrita não existe.");
        }
    }
}