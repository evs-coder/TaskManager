package com.estudos.taskmanager.repository; 

import com.estudos.taskmanager.model.Task;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class TaskRepository{
    //1.Criando lista
    private final List<Task> tarefas = new ArrayList<>(); 
    
    //2.Salvar
    public void salvar(Task tarefa){
        tarefas.add(tarefa);
        salvarCSV();
    }

    //3.Remover
    public void remover(Task tarefa){
        tarefas.remove(tarefa);
        salvarCSV();
    }

    //4.Buscar todas as tarefas
    public List<Task> buscarTodas(){
        carregarCSV();
        return new ArrayList<>(tarefas);
    }

    //5.Persistência de dados em CSV
    private final String ARQUIVO_CSV = "tarefas.csv";

    public void salvarCSV(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO_CSV))){
            for(Task t: tarefas){
                bw.write(t.getDescricao() + ";" + t.isConcluida());
                bw.newLine();
            } 
        } catch(IOException e){
                System.out.println("ERRO: Não foi possível salvar no arquivo CSV.");
        }
    }

    public void carregarCSV(){
        tarefas.clear();
        
        try(BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_CSV))){
            String linha;
            
            while((linha = br.readLine()) != null){
                String[] partes = linha.split(";");

                if(partes.length == 2){
                    String descricao = partes[0].trim();
                    boolean concluida = Boolean.parseBoolean(partes[1].trim());
                    tarefas.add(new Task(descricao, concluida));
                }
            }
        } catch(IOException e){
            System.out.println("ERRO: Não foi possível carregar arquivo CSV.");
        }
    }

}