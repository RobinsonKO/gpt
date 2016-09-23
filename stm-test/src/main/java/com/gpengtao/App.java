package com.gpengtao;

import com.gpengtao.enums.Events;
import com.gpengtao.enums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

/**
 * Hello world!
 */
@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private StateMachine<States, Events> stateMachine;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("准备发送事件");

        stateMachine.sendEvent(Events.E1);

        System.out.println("发送事件完成");

        stateMachine.sendEvent(Events.E1);

        System.out.println("发送事件完成");
    }
}
