package org.example.controller;

import org.example.dto.StudentDto;

import java.io.*;
import java.sql.SQLOutput;

public class Student {
    public static void main(String[] args) {
        StudentDto studentDto = new StudentDto();
        studentDto.setName("Kamal");
        studentDto.setAge("24");
        studentDto.setAddress("Panadura");

        Student deserializedStudent;

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("studentObject.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(studentDto);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Student Object Serialized");

            FileInputStream fileInputStream = new FileInputStream("studentObject.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            deserializedStudent = (Student) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

            System.out.println("Deserialized Student");
            System.out.println("Name :" + deserializedStudent.name);
            System.out.println("Age: " + deserializedStudent.age);
            System.out.println("Address: " + deserializedStudent.address);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
