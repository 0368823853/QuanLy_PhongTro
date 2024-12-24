/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class QuanLy implements Serializable{
    private String khachHang;
    private String thuePhong;
    private String dichVu;
    private Date ngayThue;
    private int tienCoc;
    private String tingTrang;

    public QuanLy() {
    }

    public QuanLy(String khachHang, String thuePhong, String dichVu, Date ngayThue, int tienCoc, String tingTrang) {
        this.khachHang = khachHang;
        this.thuePhong = thuePhong;
        this.dichVu = dichVu;
        this.ngayThue = ngayThue;
        this.tienCoc = tienCoc;
        this.tingTrang = tingTrang;
    }

    public String getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(String khachHang) {
        this.khachHang = khachHang;
    }

    public String getThuePhong() {
        return thuePhong;
    }

    public void setThuePhong(String thuePhong) {
        this.thuePhong = thuePhong;
    }

    public String getDichVu() {
        return dichVu;
    }

    public void setDichVu(String dichVu) {
        this.dichVu = dichVu;
    }

    public Date getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(Date ngayThue) {
        this.ngayThue = ngayThue;
    }

    public int getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(int tienCoc) {
        this.tienCoc = tienCoc;
    }

    public String getTingTrang() {
        return tingTrang;
    }

    public void setTingTrang(String tingTrang) {
        this.tingTrang = tingTrang;
    }
    
}
