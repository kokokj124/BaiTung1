package com.example.baitung;

public class Restaurant {
    private String Ma,Ten,Dc;
    private double Diem;

    public Restaurant(String ma, String ten, String dc, double diem) {
        Ma = ma;
        Ten = ten;
        Dc = dc;
        Diem = diem;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String ma) {
        Ma = ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getDc() {
        return Dc;
    }

    public void setDc(String dc) {
        Dc = dc;
    }

    public double getDiem() {
        return Diem;
    }

    public void setDiem(double diem) {
        Diem = diem;
    }
}
