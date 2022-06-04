package com.itsol.model;

import com.itsol.error.MyException;

import java.io.Serializable;
import java.util.Scanner;
public class Subject implements Input, Serializable {
    private static int AutoID = 001;
    private String id;
    private String name_subject;
    private int units_study;
    private String type_Subject;
    public Subject(){

    }

    public Subject(String name_subject, int units_study, String type_Subject){
        this.id = String.format("%03d", AutoID++);
        this.name_subject = name_subject;
        this.units_study = units_study;
        this.type_Subject = type_Subject;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName_subject() {
        return name_subject;
    }

    public void setName_subject(String name_subject) {
        this.name_subject = name_subject;
    }

    public int getUnits_study() {
        return units_study;
    }

    public void setUnits_study(int units_study) {
        this.units_study = units_study;
    }

    public String getType_Subject() {
        return type_Subject;
    }

    public void setType_Subject(String type_Subject) {
        this.type_Subject = type_Subject;
    }
    @Override
    public void nhapTT() throws MyException {
        boolean check = true;
        String pattern = "[0-9]";

        while (check){
            this.id = String.format("%03d", AutoID++);
            System.out.println("Nhập tên môn học: ");
            this.name_subject = new Scanner(System.in).nextLine();
            System.out.println("Nhập số đơn vị học trình môn học: ");
            this.units_study = new Scanner(System.in).nextInt();
            System.out.println("Nhập loại môn học: ");
            System.out.println("1.Đại cương");
            System.out.println("2.Cơ sở ngành");
            System.out.println("3.Chuyên ngành");
            String choose = new Scanner(System.in).nextLine();
            switch (choose){
                case "1":
                    this.type_Subject = Type_Subject.outline_Subject.getType_Subject();
                    break;
                case "2":
                    this.type_Subject = Type_Subject.base_Building.getType_Subject();
                    break;
                case "3":
                    this.type_Subject = Type_Subject.specialized.getType_Subject();
                    break;
            }

            if (this.name_subject.equals("")){
                throw new MyException("Dữ liệu không hợp lệ! Nhập lại");
            }

            if (this.units_study <= 0){
                throw new MyException("Dữ liệu không hợp lệ! Nhập lại");
            }

            if (this.type_Subject.equals("") && !this.type_Subject.matches(pattern)){
                throw new MyException("Dữ liệu không hợp lệ! Nhập lại");
            }
            check = false;
        }
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id='" + id + '\'' +
                ", name_subject='" + name_subject + '\'' +
                ", units_study=" + units_study +
                ", type_Subject='" + type_Subject + '\'' +
                '}';
    }
}
