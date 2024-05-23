package org.example;
import java.util.Random;


public class MyHashTableTest {
    public static void main(String[] args) {
        MyHashTable<Subjects, Student> hashTable = new MyHashTable<>(11);

        Random random = new Random();

        for (int i = 0; i < 10000; i++) {
            String subjectId = "Subject number is " + random.nextInt(10000);
            Subjects subjects = new Subjects(subjectId);

            int studentId = random.nextInt(10000);
            String firstName = "Firstname " + random.nextInt(10000) + ",";
            String surname = "Surname " + (random.nextInt(10000))+ ".";

            Student student = new Student(studentId, firstName, surname);
            hashTable.put(subjects, student);

            System.out.println(subjects + " - student id is " + student);

        }


    }

    }




