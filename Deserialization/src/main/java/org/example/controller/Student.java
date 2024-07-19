package org.example.controller;

import org.example.dto.StudentDto;

import java.io.*;

public class Student {
    public static void main(String[] args) {
        StudentDto studentDto = new StudentDto();
        studentDto.setName("Kamal");
        studentDto.setAge("24");
        studentDto.setAddress("Panadura");

        //Declare a StudentDto type variable to hole the deserialized byte-stream
        StudentDto deserializedStudent;

        try {
            // Serializing the Student Object into a studentObject.txt file
            FileOutputStream fileOutputStream = new FileOutputStream("studentObject.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(studentDto);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Student Object Serialized");

            //Deserialization Process
            // Get the FileInputStream to read data from a file
            FileInputStream fileInputStream = new FileInputStream("studentObject.txt");
            //Retrieve and converts the student object from the byte-stream with the help of ObjectInputStream
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            //Use readObject method to deserialize objects
            deserializedStudent = (StudentDto) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

            System.out.println("Deserialized Student");
            System.out.println("Student Name: " + deserializedStudent.getName());
            System.out.println("Student Age: " + deserializedStudent.getAge());
            System.out.println("Student Address: " + deserializedStudent.getAddress());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
