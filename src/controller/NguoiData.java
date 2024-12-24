package controller;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Nguoi;

public class NguoiData {
    
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
    
   public static void InsertNguoi (Nguoi dg) throws SQLException{
        String sql="insert into tblKhachHang(ID, HoTen, GioiTinh, QueQuan, DienThoai, CMND) values(?,?,?,?,?,?)";
        try {
            ps=SQLPhongTro.getSQLPhongTro().prepareStatement(sql);
            ps.setInt(1, dg.getID());
            ps.setString(2,dg.getHoTen());
            ps.setString(3, dg.getGioiTinh());
            ps.setString(4,dg.getQueQuan()); 
            ps.setString(5,dg.getDienThoai());
            ps.setString(6, dg.getCMND());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm khách hàng thành công!" , "Thông báo", 1);
        }catch(HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Khách hàng không được thêm" , "Thông báo", 1);
        }   
    }
    public boolean XoaNguoi (int MaKH) {
        try {
            ps = SQLPhongTro.getSQLPhongTro().prepareStatement("DELETE FROM tblKhachHang WHERE ID  = ?");
            ps.setInt(1, MaKH);
            return ps.executeUpdate() >0;
        } catch(SQLException e) {
            return false;
        }
    }
        public static void UpdateNguoi(Nguoi dg) throws SQLException{
        try {
            ps = SQLPhongTro.getSQLPhongTro().prepareStatement("UPDATE tblKhachHang SET HoTen = ?, GioiTinh = ?,"
                    + "QueQuan = ?, DienThoai = ?,CMND = ?  where ID = ?");
            ps.setInt(6, dg.getID());
            ps.setString(1, dg.getHoTen());
            ps.setString(2, dg.getGioiTinh());
            ps.setString(3, dg.getQueQuan());
            ps.setString(4, dg.getDienThoai());
            ps.setString(5, dg.getCMND());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã Sửa khách hàng thành công!" , "Thông báo", 1);
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Khách hàng không được sửa" , "Thông báo", 1);

        }
        
    }
    


}
