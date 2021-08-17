package common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import javax.swing.*;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class},
        scanBasePackages = {"common", "diceRollSimulator", "diceRollSimulator.controllers", "rosterBuilder", "scenarioGenerator", "config"})
public class Main {
    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }
}