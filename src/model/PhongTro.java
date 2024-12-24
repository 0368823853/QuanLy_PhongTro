/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author DELL
 */
public class PhongTro implements Serializable{

    private int maPhong;
    private int giaPhong;
    private String loaiPhong;
    private Date ngayThue;
    private String khachHang;
    
    public PhongTro(){
        
    }

    public PhongTro(int maPhong, int giaPhong, String loaiPhong, Date ngayThue, String khachHang) {
        this.maPhong = maPhong;
        this.giaPhong = giaPhong;
        this.loaiPhong = loaiPhong;
        this.ngayThue = ngayThue;
        this.khachHang = khachHang;
    }

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public int getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(int giaPhong) {
        this.giaPhong = giaPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public Date getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(Date ngayThue) {
        this.ngayThue = ngayThue;
    }

    public String getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(String khachHang) {
        this.khachHang = khachHang;
    }

    @Override
    public String toString() {
        return "PhongTro{" + "maPhong=" + maPhong + ", giaPhong=" + giaPhong + ", loaiPhong=" + loaiPhong + ", ngayThue=" + ngayThue + ", khachHang=" + khachHang + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.maPhong;
        hash = 43 * hash + this.giaPhong;
        hash = 43 * hash + Objects.hashCode(this.loaiPhong);
        hash = 43 * hash + Objects.hashCode(this.ngayThue);
        hash = 43 * hash + Objects.hashCode(this.khachHang);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PhongTro other = (PhongTro) obj;
        return true;
    }
    
}
