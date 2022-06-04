package com.itsol.service;

import com.itsol.error.MyException;
import com.itsol.fileData.Data;
import com.itsol.model.GPAManagement;
import com.itsol.model.Student;
import com.itsol.model.Subject;

import java.io.Serializable;
import java.util.Scanner;
public class GPA_Service implements Serializable {
    int countStudent;
    int countSubject;
    Student[] students;
    Subject[] subjects;
    GPAManagement[] gpaManagements;
    String id;
    Data data = null;
    public void createNewStudent() throws MyException{
        System.out.println("Nhập số lượng sinh viên muốn thêm: ");
        countStudent = new Scanner(System.in).nextInt();
        students = new Student[countStudent];
        for (int i = 0; i < students.length; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");
            Student student = new Student();
            student.nhapTT();
            students[i] = student;
        }
        data = new Data();
        data.write_file(students, "Student.txt");
        data.read_file("Student.txt");
    }
    public void displayStudent(){
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i].toString());
        }
    }
    public void createNewSubject() throws MyException {
        System.out.println("Nhập số lượng môn học muốn thêm: ");
        countSubject = new Scanner(System.in).nextInt();
        subjects = new Subject[countSubject];
        for (int i = 0; i < subjects.length; i++) {
            System.out.println("Nhập thông tin môn học thứ " + (i + 1) + ":");
            Subject subject = new Subject();
            subject.nhapTT();
            subjects[i] = subject;
        }
        data = new Data();
        data.write_file(subjects, "Subject.txt");
        data.read_file("Subject.txt");
    }
    public void displaySubject(){
        for (int i = 0; i < subjects.length; i++) {
            System.out.println(subjects[i].toString());
        }
    }
    public void studentGPA() throws MyException{
        if (students == null || subjects == null){
            System.out.println("Sinh viên hoặc môn học chưa tồn tại! Bạn cần nhập sinh viên và môn học trước");
            return;
        }

        gpaManagements = new GPAManagement[countStudent];

            for (int i = 0; i < students.length; i++) {
                System.out.println("Nhập số lượng môn học mà sinh viên " + students[i].getName() + " đã học: ");
                int subjectNumber = new Scanner(System.in).nextInt();
                Subject[] subjectList = new Subject[subjectNumber];
                int[] mark = new int[subjectNumber];

                for (int j = 0; j < subjectNumber; j++) {
                    System.out.println("Nhập id môn học thứ " + (j + 1) + " mà sinh viên " + students[i].getName() + " học: ");
                    id = new Scanner(System.in).nextLine();
                    Subject subject = searchSubject(id);

                    int gpa = 0;

                    if (subject != null){
                        boolean check = true;
                        while (check){
                            System.out.println("Nhập điểm của môn học thứ " + (j + 1) + " mà sinh viên " + students[i].getName() + " học: ");
                            gpa = new Scanner(System.in).nextInt();

                            if (gpa < 0 || gpa > 10){
                                throw new MyException("Điểm phải lớn hơn hoặc bằng 0 và nhỏ hơn hoặc bằng 10! Nhập lại");
                            }
                            else{
                                mark[j] = gpa;
                                students[j].setGpa(mark);
                                float markAvg = (float) (gpa / subject.getUnits_study());
                                students[j].setAvgMark(markAvg);
                                subjectList[j] = subject;
                            }
                            check = false;
                        }
                    }
                }

                GPAManagement gpaManagement = new GPAManagement(students[i], subjectList, mark);
                gpaManagements[i] = gpaManagement;
            }

        for (int i = 0; i < gpaManagements.length; i++) {
            System.out.println(gpaManagements[i].toString());
        }
    }
    public void sortBorrowListByStudentName(){
        for (int i = 0; i < gpaManagements.length - 1; i++) {
            for (int j = 0; j < gpaManagements.length; j++) {
                if (gpaManagements[i].getStudent().getName().compareTo(gpaManagements[j].getStudent().getName()) > 0){
                    GPAManagement temp = gpaManagements[i];
                    gpaManagements[i] = gpaManagements[j];
                    gpaManagements[j] = temp;
                }
            }
        }

        for (int i = 0; i < gpaManagements.length; i++) {
            System.out.println(gpaManagements[i].toString());
        }
    }
    public void sortBorrowListBySubjectName(){
        for (int i = 0; i < gpaManagements.length - 1; i++) {
            for (int j = 0; j < gpaManagements.length; j++) {

            }
        }
    }
    public void markAvgStudent(){
        for (int i = 0; i < gpaManagements.length; i++) {
            System.out.println("Điểm trung bình của sinh viên " + gpaManagements[i].getStudent().getName() + " là: " + gpaManagements[i].getStudent().getAvgMark());
        }
    }
    public Subject searchSubject(String id){
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i].getId().equals(id)){
                return subjects[i];
            }
        }
        return null;
    }
}
