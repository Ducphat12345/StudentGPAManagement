package com.itsol.model;

import com.itsol.error.MyException;

import java.io.Serializable;
import java.util.Scanner;
public class Student extends Person implements Serializable {
    public  static int AutoID = 00001;
    private String id;
    private String classroom;
    private int[] gpa;
    private float avgMark;
    public Student(){

    }

    public Student(String name, String address, String phone, String classroom, int[] gpa, float avgMark){
        super(name, address, phone);
        this.id = String.format("%05d", AutoID++);
        this.classroom = classroom;
        this.gpa = gpa;
        this.avgMark = avgMark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public int[] getGpa() {
        return gpa;
    }
    public void setGpa(int[] gpa) {
        this.gpa = gpa;
    }
    public float getAvgMark() {
        return avgMark;
    }
    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }
    @Override
    public void nhapTT() throws MyException{
        boolean check = true;
        String pattern = "^[0-9]";
        String mobile = "0[0-9]{10,11}";
        String pattern1 = "[a-zA-Z_0-9]";

        this.id = String.format("%05d",AutoID++);

        while (check){
                super.nhapTT();
                System.out.println("Nhập lớp học: ");
                this.classroom = new Scanner(System.in).nextLine();

                if (super.getName().equals("") && !super.getName().matches(pattern)){
                    throw new MyException("Dữ liệu không hợp lệ! Nhập lại");
                }

                if (super.getAddress().equals("") && !super.getAddress().matches(pattern1)){
                    throw new MyException("Dữ liệu không hợp lệ! Nhập lại");
                }

                if (super.getPhone().equals("") && !super.getPhone().matches(mobile)){
                    throw new MyException("Dữ liệu không hợp lệ! Nhập lại");
                }

                if (this.classroom.equals("") && !this.classroom.matches(pattern1)){
                    throw new MyException("Dữ liệu không hợp lệ! Nhập lại");
                }
                check = false;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + getName() + '\'' +
                ", address='" + getAddress() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", classroom='" + classroom + '\'' +
                '}';
    }
}
