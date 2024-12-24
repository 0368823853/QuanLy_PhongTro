/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.HoaDon;
import static view.UpdateTable.conn;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.HeadlessException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class DAOhd {
    
    

    private JLabel labelDoanhThu;
    private JTable TableResult;
    
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
    public DAOhd(){}

    public DAOhd(JButton btnReset, JButton btnThoat, JButton btnTimKiem, JButton btnXuatHoaDon, JTable TableResult, JButton jButton1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public ArrayList<HoaDon> getListHD(){
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql= "SELECT * FROM tblThongKe";
        try {
            PreparedStatement pss = conn.prepareStatement(sql);
            ResultSet rs= pss.executeQuery();
            while(rs.next()){
                HoaDon s= new HoaDon();
                s.setMaHD(rs.getInt("MaHD"));
                s.setDateOrder(rs.getString("Date"));
                s.setThanhtien(rs.getInt("ThanhTien"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public ArrayList<HoaDon> findbyDate(String Date){
        ArrayList<HoaDon> list = new ArrayList<>();
        String sql= "SELECT * FROM tblThongKe WHERE Date like?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%"+Date+"%");
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                HoaDon s= new HoaDon();
                s.setMaHD(rs.getInt("MaHD"));
                s.setDateOrder(rs.getString("Date"));
                s.setThanhtien(rs.getInt("ThanhTien"));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
   public static void InsertThongKe (HoaDon dg) throws SQLException{
        String sql="insert into tblThongKe(MaHD, Date, ThanhTien) values(?,?,?)";
        try {
            ps=SQLPhongTro.getSQLPhongTro().prepareStatement(sql);
            ps.setInt(1, dg.getMaHD());
            ps.setString(2,dg.getDateOrder());
            ps.setInt(3, dg.getThanhtien());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Đã thống kê  thành công!" , "Thông báo", 1);
        }catch(HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Thống kê không được thêm" , "Thông báo", 1);
        }   
    }
   
//    public void exportToExcel() {
//    try {
//        // Create a new workbook
//        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet("Thống Kê");
//
//        // Get the table model
//        DefaultTableModel model = (DefaultTableModel) TableResult.getModel();
//
//        // Create the header row
//        Row headerRow = sheet.createRow(3);
//        for (int col = 0; col < model.getColumnCount(); col++) {
//            Cell cell = headerRow.createCell(col);
//            cell.setCellValue(model.getColumnName(col));
//        }
//
//        // Create the data rows
//        for (int row = 0; row < model.getRowCount(); row++) {
//            Row dataRow = sheet.createRow(row + 1);
//            for (int col = 0; col < model.getColumnCount(); col++) {
//                Cell cell = dataRow.createCell(col);
//                cell.setCellValue(model.getValueAt(row, col).toString());
//            }
//        }
//
//        // Calculate and add the total amount label and value
//        Row totalRow = sheet.createRow(model.getRowCount() + 1);
//        Cell totalAmountCell = totalRow.createCell(1);
//        totalAmountCell.setCellValue(labelDoanhThu.getText());
//
//        // Save the workbook to a file
//        FileOutputStream fileOut = new FileOutputStream("D:/New folder/xuat.xlsx");
//        workbook.write(fileOut);
//        fileOut.close();
//
//        JOptionPane.showMessageDialog(null, "Xuất hoá đơn Excel thành công", "Export Success", JOptionPane.INFORMATION_MESSAGE);
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, "Lỗi xuất file Excel!!! " + e.getMessage(), "Export Error", JOptionPane.ERROR_MESSAGE);
//    }
//}
   
}