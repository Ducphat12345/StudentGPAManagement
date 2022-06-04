package com.itsol.model;

import com.itsol.error.MyException;

import java.util.Scanner;
public abstract class Person implements Input{
    private String name;
    private String address;
    private String phone;
    public Person() {
    }
    public Person(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public void nhapTT() throws MyException {
        System.out.println("Nhập tên sinh viên: ");
        this.name = new Scanner(System.in).nextLine();
        System.out.println("Nhập địa chỉ sinh viên: ");
        this.address = new Scanner(System.in).nextLine();
        System.out.println("Nhập sđt sinh viên: ");
        this.phone = new Scanner(System.in).nextLine();
    }
}
