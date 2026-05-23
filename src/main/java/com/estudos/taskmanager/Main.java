package com.estudos.taskmanager;

import com.estudos.taskmanager.repository.TaskRepository;
import com.estudos.taskmanager.service.TaskService;
import com.estudos.taskmanager.ui.TaskInterface;

public class Main{
    public static void main(String[] Args){
        //1.Instancia o banco de dados temporário
        TaskRepository repository = new TaskRepository();

        //2.Instancia o service
        TaskService service = new TaskService(repository);

        //3.Instancia a interface
        TaskInterface ui = new TaskInterface(service);

        //4.Liga o motor
        ui.iniciar();
    }
}