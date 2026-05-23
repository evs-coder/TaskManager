package com.estudos.taskmanager.model;

public class Task{
    //1.Atributos
    private String descricao;
    private boolean concluida;

    //2.Construtor
    public Task(String descricao){
        setDescricao(descricao);
        this.concluida = false;
    }

    //2.Construtor
    public Task(String descricao, boolean concluida){
        setDescricao(descricao);
        setConcluida(concluida);
    }

    //3.Setters e getters
    public void setDescricao(String descricao){
        if(descricao == null || descricao.trim().isEmpty()){
            throw new IllegalArgumentException("Erro: Insira uma descrição válida.");
        } else{
            this.descricao = descricao;
        }
    }

    public String getDescricao(){
        return descricao;
    }

    public void setConcluida(boolean concluida){
        this.concluida = concluida;
    }

    public boolean isConcluida(){
        return concluida;
    }

    //4.Sobrescrita do método toString()
    @Override
    public String toString(){
        String status = concluida ? "[X]" : "[ ]";
        return status + " " + descricao;
    }
}