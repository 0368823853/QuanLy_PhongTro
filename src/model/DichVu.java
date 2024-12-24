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
public class DichVu implements Serializable{
    private int maDV;
    private int tienDien;
    private int tienNuoc;
    private Date tuNgay;
    private Date denNgay;
    private int tongTien;
    
    public DichVu(){
        
    }

    public DichVu(int maDV, int tienDien, int tienNuoc, Date tuNgay, Date denNgay, int tongTien) {
        this.maDV = maDV;
        this.tienDien = tienDien;
        this.tienNuoc = tienNuoc;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
        this.tongTien = tongTien;
    }

    public int getMaDV() {
        return maDV;
    }

    public void setMaDV(int maDV) {
        this.maDV = maDV;
    }

    public int getTienDien() {
        return tienDien;
    }

    public void setTienDien(int tienDien) {
        this.tienDien = tienDien;
    }

    public int getTienNuoc() {
        return tienNuoc;
    }

    public void setTienNuoc(int tienNuoc) {
        this.tienNuoc = tienNuoc;
    }

    public Date getTuNgay() {
        return tuNgay;
    }

    public void setTuNgay(Date tuNgay) {
        this.tuNgay = tuNgay;
    }

    public Date getDenNgay() {
        return denNgay;
    }

    public void setDenNgay(Date denNgay) {
        this.denNgay = denNgay;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }
    
}
