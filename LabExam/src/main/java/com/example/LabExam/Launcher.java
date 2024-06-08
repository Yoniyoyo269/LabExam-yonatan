package com.example.LabExam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
    public class Launcher {
        public static void main(String[] args) {
            ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
            StudentRepo studentRepo = context.getBean(StudentRepo.class);
            studentRepo.createDBAndTable();
            Student student = new Student(1, "John Doe", "john.doe@example.com");
            studentRepo.insertIntoTable(student);
            System.out.println("Student inserted successfully!");
        }
    }

