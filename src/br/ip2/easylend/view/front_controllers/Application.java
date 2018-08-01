package br.ip2.easylend.view.front_controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void Main(String args[]){
        SpringApplication.run(Application.class,args);
    }

    public static void close(){
      //  SpringApplication.exit();
    }
}
