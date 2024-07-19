package org.example.controller;

import org.example.dto.StudentDto;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Student {
    public static void main(String[] args) {
        StudentDto studentDto = new StudentDto();

        studentDto.setName("Kamal");
        studentDto.setAge("20");
        studentDto.setAddress("Panadura");

        try {
            //A text file called Student Object created with FileOutputStream
            FileOutputStream fileOutputStream = new FileOutputStream("studentObject.txt");

            //Serializing the Student Object
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(studentDto);

            //Close the output stream
            objectOutputStream.close();

            //Close the file
            fileOutputStream.close();

            System.out.println("Student Object Serialized");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
