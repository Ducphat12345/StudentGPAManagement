package com.itsol.model;

import java.util.Arrays;
public class GPAManagement {
    private Student student;
    private Subject[] subjects;
    private int[] gpa;

    public GPAManagement(){

    }
    public GPAManagement(Student student, Subject[] subjects, int[] gpa){
        this.student = student;
        this.subjects = subjects;
        this.gpa = gpa;
    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public int[] getGpa() {
        return gpa;
    }

    public void setGpa(int[] gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "GPAManagement{" +
                "student=" + student +
                ", subjects=" + Arrays.toString(subjects) +
                ", gpa=" + Arrays.toString(gpa) +
                '}';
    }
}
