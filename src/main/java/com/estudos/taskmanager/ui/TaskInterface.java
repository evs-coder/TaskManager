package com.estudos.taskmanager.ui;

import com.estudos.taskmanager.model.Task;
import com.estudos.taskmanager.service.TaskService;
import java.util.Scanner;

public class TaskInterface{
    //1.injeção de dependência
    private final TaskService service;
    private final Scanner scanner;

    //2.Construtor do operador que utilizaráos recursos de TaskService e do Scanner
    public TaskInterface(TaskService service){
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar(){
        int opcao = -1;

        while(opcao != 4){
            menuListar();
            exibirMenu();

            try{
                opcao = Integer.parseInt(scanner.nextLine());
                processarOpcao(opcao);
            } catch(NumberFormatException e){
                System.out.println("\n ERRO: Digite um digito válido.");
            } catch(IllegalArgumentException e){
                System.out.println("\n " + e.getMessage());
            }
        }
    }

    private void exibirMenu(){
        System.out.println("\n =================== MENU ===================");
        System.out.println("1. Adicionar nova tarefa | 2. Finalizar tarefa");
        System.out.println("3. Remover Tarefa        | 4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private void processarOpcao(int opcao){
        switch(opcao){
            case 1:
                menuAdicionar();
                break;
            case 2:
                menuConcluir();
                break;
            case 3:
                menuRemover();
                break;
            case 4:
                System.out.println("Encerrando o sistema. Até logo!");
                break;
            default:
                System.out.println("ERRO: Opção inválida. Tente novamente.");
                break;
        }
    }

    private void menuAdicionar(){
        System.out.print("Digite a descricao da tarefa: ");
        String descricao = scanner.nextLine();

        service.registrarTarefa(descricao);
        System.out.println("Tarefa adicionada com sucesso!");
    }

    private void menuListar(){
        System.out.println("\n -------------- Minhas Tarefas --------------");
        var tarefas = service.listarTodas();

        for(Task t:tarefas){
            System.out.println(t);
        }
    }

    private void menuConcluir(){
        System.out.print("Qual tarefa deseja concluir? ");
        String descricao = scanner.nextLine();

        service.concluirTarefa(descricao);
        System.out.println("Tarefa concluida com sucesso!");
    }

    private void menuRemover(){
        System.out.print("Qual tarefa deseja remover? ");
        String descricao = scanner.nextLine();

        service.removerTarefa(descricao);
        System.out.println("Tarefa removida com sucesso!");
    }

}
