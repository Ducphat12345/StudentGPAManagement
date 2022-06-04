package com.itsol.main;

import com.itsol.error.MyException;
import com.itsol.service.GPA_Service;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        GPA_Service gpa_service = new GPA_Service();

        while (true){
            System.out.println("Mời bạn chọn chương trình:");
            System.out.println("1. Nhập, xuất danh sách các sinh viên");
            System.out.println("2. Nhập, xuất danh sách các môn học");
            System.out.println("3. Quản lý điểm sinh viên");
            System.out.println("4. Sắp xếp sinh viên theo tên");
            System.out.println("5. Sắp xếp sinh viên theo môn học");
            System.out.println("6. Tính điểm TB cho mỗi sinh viên");
            System.out.println("7. Thoát");

            int choose = new Scanner(System.in).nextInt();

            switch (choose){
                case 1:
                    try {
                        gpa_service.createNewStudent();
                    } catch (MyException e) {
                        System.out.println(e.getError());
                        break;
                    }
                    gpa_service.displayStudent();
                    break;
                case 2:
                    try {
                        gpa_service.createNewSubject();
                    } catch (MyException e) {
                        System.out.println(e.getError());
                        break;
                    }
                    gpa_service.displaySubject();
                    break;
                case 3:
                    try {
                        gpa_service.studentGPA();
                    } catch (MyException e) {
                        System.out.println(e.getError());
                    }
                    break;
                case 4:
                    gpa_service.sortBorrowListByReaderName();
                    break;
                case 5:
                    gpa_service.sortBorrowListBySubjectName();
                    break;
                case 6:
                    gpa_service.markAvgStudent();
                    break;
                case 7:
                    System.out.println("Kết thúc chương trình!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có chương trình bạn chọn! Mời chọn lại:");
                    break;
            }
        }
    }
}
