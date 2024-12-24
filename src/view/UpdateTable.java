/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controller.SQLPhongTro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author DELL
 */
public class UpdateTable {
    public static PreparedStatement ps = null;
    public static ResultSet rs = null;
    public static Connection conn = SQLPhongTro.getSQLPhongTro();
    
    public static void LoadData(String sql, JTable tb) {
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            tb.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", 1);
        }
    }
    
    public static ResultSet ShowTextField(String sql) {
        try{
            ps = conn.prepareStatement(sql);
            return ps.executeQuery(); 
        }
        catch(SQLException e) {
            return null;
            //JOptionPane.showMessageDialog(null, e, "Thông báo lỗi", 1);
        }
    }
    
}