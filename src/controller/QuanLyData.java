/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.DichVu;
import model.HoaDon;
import model.QuanLy;

/**
 *
 * @author DELL
 */
public class QuanLyData {
    
    public static PreparedStatement ps;
    public static ResultSet rs;
    public static ResultSet showTextfield(String sql) {
        try {
            ps = SQLPhongTro.getSQLPhongTro().prepareStatement(sql);
            return ps.executeQuery();
        } catch (SQLException e) {
            return null;
        }
    }
    
   public static void InsertQuanLy (QuanLy dg) throws SQLException{
        String sql="insert into tblQuanLy(KhachHang, Phong, DichVu, NgayThue, TienCoc, TinhTrang) values(?,?,?,?,?,?)";
        try {
            ps=SQLPhongTro.getSQLPhongTro().prepareStatement(sql);
            ps.setString(1,dg.getKhachHang());
            ps.setString(2,dg.getThuePhong());
            ps.setString(3,dg.getDichVu());
            ps.setDate(4,new Date(dg.getNgayThue().getTime()));
            ps.setInt(5, dg.getTienCoc());
            ps.setString(6,dg.getTingTrang());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm thông tin thành công!" , "Thông báo", 1);
        }catch(HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, " Không được thêm" , "Thông báo", 1);
        }   
    }
       

   
    public boolean XoaQuanLy (String KhachHang) {
        try {
            ps = SQLPhongTro.getSQLPhongTro().prepareStatement("DELETE FROM tblQuanLy WHERE KhachHang  = ?");
            ps.setString(1, KhachHang);
            return ps.executeUpdate() >0;
        } catch(SQLException e) {
            return false;
        }
    }
    
    
    public static void UpdateQuanLy(QuanLy dg) throws SQLException {
        try {
            ps = SQLPhongTro.getSQLPhongTro().prepareStatement("UPDATE tblQuanLy SET Phong = ?, DichVu = ?,"
                    + "NgayThue = ?, TienCoc = ?,TinhTrang = ?  where KhachHang = ?");
            ps.setString(6, dg.getKhachHang());
            ps.setString(1, dg.getThuePhong());
            ps.setString(2, dg.getDichVu());
            ps.setDate(3, new Date(dg.getNgayThue().getTime())); 
            ps.setInt(4, dg.getTienCoc());
            ps.setString(5, dg.getTingTrang());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã Sửa thông tin thành công!" , "Thông báo", 1);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Không được sửa" , "Thông báo", 1);

        }
  
    }
    
}
