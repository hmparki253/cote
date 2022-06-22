package com.phm.cote;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class CompTest {
    public static void main(String[] args) {
        Student s1 = new Student(27, 5);
        Student s2 = new Student(33, 1);

        Queue<Student> studentQueue = new LinkedList<>();
        studentQueue.add(s1);
        studentQueue.add(s2);

        Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }
        };

        System.out.println(comparator.compare(s1, s2));
    }
}

class Student {
    int age;
    int classNumber;

    public Student(int age, int classNumber) {
        this.age = age;
        this.classNumber = classNumber;
    }
}