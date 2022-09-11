package com.example.messagequeuetuan02.model;

import java.util.Date;

public  class Person {
    private long mssv;
    private String hoten;
    private Date ngaysinh;

    public Person(long mssv, String hoten, Date ngaysinh) {
        this.mssv = mssv;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
    }

    public Person() {
    }

    public long getMssv() {
        return mssv;
    }

    public void setMssv(long mssv) {
        this.mssv = mssv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;

    }

    @Override
    public String toString() {
        return mssv + "\t" + hoten + "\t" + ngaysinh;
    }
}