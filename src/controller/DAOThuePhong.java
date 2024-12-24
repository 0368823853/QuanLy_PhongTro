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
import model.PhongTro;

/**
 *
 * @author DELL
 */
public class DAOThuePhong {
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
    public static void InsertPhongTro (PhongTro dg) throws SQLException{
        String sql="insert into tblThuePhong(MaPhong, GiaPhong, LoaiPhong, NgayThue, KhachHang) values(?,?,?,?,?)";
        try {
            ps=SQLPhongTro.getSQLPhongTro().prepareStatement(sql);
            ps.setInt(1, dg.getMaPhong());
            ps.setInt(2,dg.getGiaPhong()); 
            ps.setString(3, dg.getLoaiPhong());
            ps.setDate(4,new Date(dg.getNgayThue().getTime()));
            ps.setString(5,dg.getKhachHang());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm phòng trọ thành công!" , "Thông báo", 1);
        }catch(HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Phòng trọ không được thêm" , "Thông báo", 1);
        }   
    }

    public static void UpdatePhongTro(DichVu d) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public boolean XoaPhongTro (int MaPhong) {
        try {
            ps = SQLPhongTro.getSQLPhongTro().prepareStatement("DELETE FROM tblThuePhong WHERE MaPhong  = ?");
            ps.setInt(1, MaPhong);
            return ps.executeUpdate() >0;
        } catch(SQLException e) {
            return false;
        }
    }
    public static void UpdatePhongTro(PhongTro dg) throws SQLException {
        try {
            ps = SQLPhongTro.getSQLPhongTro().prepareStatement("UPDATE tblThuePhong SET GiaPhong = ?, LoaiPhong = ?,"
                    + "NgayThue = ?, KhachHang = ?  where MaPhong = ?");
            ps.setInt(5, dg.getMaPhong());
            ps.setInt(1,dg.getGiaPhong()); 
            ps.setString(2, dg.getLoaiPhong());
            ps.setDate(3,new Date(dg.getNgayThue().getTime()));
            ps.setString(4,dg.getKhachHang());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã Sửa phòng trọ thành công!" , "Thông báo", 1);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Phòng trọ không được sửa" , "Thông báo", 1);

        }
  
    }
}
