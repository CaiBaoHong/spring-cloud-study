package com.abc.cloud;

import com.abc.cloud.mq.MsgSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RabbitmqHelloApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqHelloApplication.class,args);
    }

    /*
    @Override
    public void run(String... args) throws Exception {
        System.in.read();
    }
    */


    @Autowired
    private MsgSender msgSender;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MsgSender : "+msgSender);
        msgSender.send();
        //等待用户输入
        System.in.read();
    }

}
