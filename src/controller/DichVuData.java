/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JOptionPane;
import model.DichVu;
import model.HoaDon;

/**
 *
 * @author DELL
 */
public class DichVuData {  
    
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
    
   public static void InsertDichVu (DichVu dg) throws SQLException{
        String sql="insert into tblDichVu(MaDV, TienDien, TienNuoc, TuNgay, DenNgay, TongTien) values(?,?,?,?,?,?)";
        try {
            ps=SQLPhongTro.getSQLPhongTro().prepareStatement(sql);
            ps.setInt(1, dg.getMaDV());
            ps.setInt(2,dg.getTienDien());
            ps.setInt(3, dg.getTienNuoc());
            ps.setDate(4, new Date(dg.getTuNgay().getTime())); 
            ps.setDate(5,new Date(dg.getDenNgay().getTime()));
            ps.setInt(6, dg.getTongTien());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm Dich vụ thành công!" , "Thông báo", 1);
        }catch(HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Dịch vụ không được thêm" , "Thông báo", 1);
        }   
    }
       

   
    public boolean XoaDichVu (int MaDV) {
        try {
            ps = SQLPhongTro.getSQLPhongTro().prepareStatement("DELETE FROM tblDichVu WHERE MaDV  = ?");
            ps.setInt(1, MaDV);
            return ps.executeUpdate() >0;
        } catch(SQLException e) {
            return false;
        }
    }
    public static void UpdateDichVu(DichVu dg) throws SQLException {
        try {
            ps = SQLPhongTro.getSQLPhongTro().prepareStatement("UPDATE tblDichVu SET TienDien = ?, TienNuoc = ?,"
                    + "TuNgay = ?, DenNgay = ?,TongTien = ?  where MaDV = ?");
            ps.setInt(6, dg.getMaDV());
            ps.setInt(1, dg.getTienDien());
            ps.setInt(2, dg.getTienNuoc());
            ps.setDate(3, new Date(dg.getTuNgay().getTime())); 
            ps.setDate(4,new Date(dg.getDenNgay().getTime()));
            ps.setInt(5, dg.getTongTien());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã Sửa dịch vụ thành công!" , "Thông báo", 1);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Dịch vụ không được sửa" , "Thông báo", 1);

        }
  
    }
}
