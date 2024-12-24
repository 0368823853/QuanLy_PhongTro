/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.DAOhd;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;
import javax.swing.JTable;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class frmThongKe extends javax.swing.JFrame {
    public static PreparedStatement ps = null;
    public static String sqlDg = "SELECT * FROM tblThongKe order by MaHD asc";
    private List<HoaDon> hoadon;
    private DefaultTableModel model;
    public frmThongKe() {
        initComponents();
        setLocationRelativeTo(null);
        model = (DefaultTableModel)TableResult.getModel();
        showTable();
        UpdateTable.LoadData(sqlDg, TableResult);
        Tong();
//        DAOhd controller = new DAOhd(btnReset, btnThoat, btnTimKiem, btnXuatHoaDon, TableResult, jButton1);
//        controller.setEvent();
        
    }
    private void exportToExcel() {
    try {
        // Create a new workbook
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Thống Kê");
        

        // Get the table model
        DefaultTableModel model = (DefaultTableModel) TableResult.getModel();

        // Create the header row
        Row headerRow = sheet.createRow(3);
        
        for (int col = 0; col < model.getColumnCount(); col++) {
            Cell cell = headerRow.createCell(col);
            cell.setCellValue(model.getColumnName(col));
           
        }

        // Create the data rows
        for (int row = 0; row < model.getRowCount(); row++) {
            Row dataRow = sheet.createRow(row + 1);
            for (int col = 0; col < model.getColumnCount(); col++) {
                
                Cell cell = dataRow.createCell(col);
                cell.setCellValue(model.getValueAt(row, col).toString());  
            }
        }

        // Calculate and add the total amount label and value
        Row totalRow = sheet.createRow(model.getRowCount() + 1);
        Cell totalAmountCell = totalRow.createCell(1);
        totalAmountCell.setCellValue(labelDoanhThu.getText());

        // Save the workbook to a file
        FileOutputStream fileOut = new FileOutputStream("D:/New folder/xuat.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        JOptionPane.showMessageDialog(this, "Xuất hoá đơn Excel thành công", "Export Success", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Lỗi xuất file Excel!!! " + e.getMessage(), "Export Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableResult = new javax.swing.JTable();
        labelDoanhThu = new javax.swing.JLabel();
        btnTimKiem = new javax.swing.JButton();
        txtDate = new javax.swing.JTextField();
        btnThoat = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        btnXuatHoaDon = new javax.swing.JButton();
        btnfile = new javax.swing.JButton();
        txttenfile = new javax.swing.JTextField();
        txtdinhdang = new javax.swing.JTextField();
        txtlinkfile = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        txtMaHD = new javax.swing.JTextField();
        txtNgayThanhToan = new javax.swing.JTextField();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/one piece/thống kê.png"))); // NOI18N
        jLabel1.setText("Thống Kê Doanh Thu");

        TableResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Hoá Đơn", "Ngày Thanh Toán", "Thành Tiền"
            }
        ));
        TableResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableResultMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableResult);

        labelDoanhThu.setBackground(new java.awt.Color(255, 0, 153));
        labelDoanhThu.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelDoanhThu.setForeground(new java.awt.Color(255, 51, 51));
        labelDoanhThu.setText("Tổng doanh thu:");

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/one piece/tìm kiếm.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/one piece/exit.png"))); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/one piece/reset.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/one piece/print.png"))); // NOI18N
        jButton1.setText("Xuất hoá đơn PDF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnXuatHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnXuatHoaDon.setForeground(new java.awt.Color(255, 0, 0));
        btnXuatHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/one piece/print.png"))); // NOI18N
        btnXuatHoaDon.setText("Xuất hoá đơn Excel");
        btnXuatHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatHoaDonActionPerformed(evt);
            }
        });

        btnfile.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/one piece/thêm.png"))); // NOI18N
        btnfile.setText("Browser");
        btnfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfileActionPerformed(evt);
            }
        });

        txttenfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenfileActionPerformed(evt);
            }
        });

        txtdinhdang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdinhdangActionPerformed(evt);
            }
        });

        txtlinkfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtlinkfileActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Tên file:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Định dạng:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Link file:");

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/one piece/thêm.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Mã hoá đơn:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Ngày thanh toán:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel8.setText("Thành tiền:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(labelDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem)
                        .addGap(33, 33, 33)
                        .addComponent(btnReset)
                        .addGap(27, 27, 27)
                        .addComponent(btnThoat))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSeparator1)
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMaHD))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNgayThanhToan)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnTimKiem)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDate)))
                                .addGap(48, 48, 48))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addComponent(btnXuatHoaDon))
                        .addGap(10, 10, 10)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttenfile, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdinhdang, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtlinkfile, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnfile)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnXuatHoaDon)
                        .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTimKiem)
                        .addComponent(jLabel7)
                        .addComponent(txtNgayThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttenfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdinhdang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtlinkfile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfile))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThoat)
                    .addComponent(labelDoanhThu)
                    .addComponent(btnReset)
                    .addComponent(btnThem))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Quay lại trang chủ!");
       frmHome thoat = new frmHome();
       thoat.setVisible(true);
       dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        if(this.txtDate.getText().length() == 0) {
            String sql = "SELECT * from tblThongKe ";
            UpdateTable.LoadData(sql, TableResult);
        }
        else {
            String sql = "SELECT * from tblThongKe WHERE MaHD like N'%"+this.txtDate.getText()+"%' "
            + "or Date like N'%"+this.txtDate.getText()+"%'"
            + "or ThanhTien like N'%"+this.txtDate.getText()+"%'";
            UpdateTable.LoadData(sql, TableResult);
        } 
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

        btnReset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:try
        try
        {
            TableResult.print(JTable.PrintMode.NORMAL);
        }
        catch(Exception e)
        {}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    
    
    ArrayList<HoaDon> arr = new ArrayList<HoaDon>();
    private void btnXuatHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatHoaDonActionPerformed

        exportToExcel();
//        try {
//            XSSFWorkbook workbook = new XSSFWorkbook();
//            XSSFSheet sheet = workbook.createSheet("Thống kê");
//            XSSFRow row = null;
//            Cell cell = null;
//            String linkfile=txtlinkfile.getText();
//            row = sheet.createRow(3);
//            cell=row.createCell(0, CellType.STRING);
//            cell.setCellValue("STT");
//            
//            cell=row.createCell(1, CellType.STRING);
//            cell.setCellValue("Mã Hoá Đơn");
//            
//            cell=row.createCell(2, CellType.STRING);
//            cell.setCellValue("Ngày Thanh Toán");
//            
//            cell=row.createCell(3, CellType.STRING);
//                cell.setCellValue("Thành Tiền");
//            
//            for(int i=0; i< arr.size(); i++){
//                HoaDon book = arr.get(i);
//                row = sheet.createRow(4 +i);
//                
//                cell = row.createCell(0, CellType.NUMERIC);
//                cell.setCellValue(i + 1);
//                
//                cell = row.createCell(1, CellType.STRING);
//                cell.setCellValue(arr.get(i).getMaHD());
//                
//                cell = row.createCell(2, CellType.STRING);
//                cell.setCellValue(arr.get(i).getDateOrder());
//                
//                cell = row.createCell(3, CellType.STRING);
//                cell.setCellValue(arr.get(i).getThanhtien());
//               
//            }
//            
//
//            try {
//                File excelFile = new File("D:/New folder/xuat.xlsx");
//                FileOutputStream fis = new FileOutputStream(excelFile);
//                JOptionPane.showMessageDialog(this, "Xuất hoá đơn Excel thành công");
//                workbook.write(fis);
//                fis.close();
//            } catch (FileNotFoundException ex) {
//                ex.printStackTrace();
//                
//            }
//            
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(this, "loi mo file");
//            
//        }catch(Exception ex){
//            ex.printStackTrace();
//            
//        
//        }


        
        
    }//GEN-LAST:event_btnXuatHoaDonActionPerformed

    private void btnfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfileActionPerformed

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Choose a directory to save your file: ");
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                String tenfile=txttenfile.getText();
                String dinhdang=txtdinhdang.getText();
		int returnValue = jfc.showSaveDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			if (jfc.getSelectedFile().isDirectory()) {
				txtlinkfile.setText(jfc.getSelectedFile()+"/"+tenfile+"."+dinhdang);
			}
		}
    }//GEN-LAST:event_btnfileActionPerformed

    private void txttenfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenfileActionPerformed

    private void txtdinhdangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdinhdangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdinhdangActionPerformed

    private void txtlinkfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtlinkfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtlinkfileActionPerformed

    private void TableResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableResultMouseClicked

        try{
            int row = this.TableResult.getSelectedRow();
            String IDrow = (this.TableResult.getModel().getValueAt(row, 0)).toString();
            String sql = "SELECT * FROM tblThongKe where MaHD='"+IDrow+"'";
            ResultSet rs = UpdateTable.ShowTextField(sql);
            if(rs.next()) {
                this.txtMaHD.setText(rs.getString("MaHD"));
                this.txtNgayThanhToan.setText(rs.getString("Date"));
                this.txtThanhTien.setText(rs.getString("ThanhTien"));
            }
        }catch(SQLException e) {
        } 
    }//GEN-LAST:event_TableResultMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        if (this.txtMaHD.getText().length()==0 ) JOptionPane.showMessageDialog(null, "Mã hoá đơn không thể bỏ trống", "thông báo", 2);
            else {
            HoaDon p = new HoaDon(
                    Integer.parseInt(this.txtMaHD.getText()), 
                    this.txtNgayThanhToan.getText(),
                    Integer.parseInt(this.txtThanhTien.getText()));
            try {
                DAOhd.InsertThongKe(p);
            } catch (SQLException ex) {
                Logger.getLogger(frmDichVu.class.getName()).log(Level.SEVERE, null, ex);
            }
            btnReset();
        UpdateTable.LoadData(sqlDg, TableResult);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    public JTable GetTbkh(){
       return TableResult;}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmThongKe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmThongKe().setVisible(true);
            }
        });
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableResult;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXuatHoaDon;
    private javax.swing.JButton btnfile;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelDoanhThu;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayThanhToan;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtdinhdang;
    private javax.swing.JTextField txtlinkfile;
    private javax.swing.JTextField txttenfile;
    // End of variables declaration//GEN-END:variables

    private void showTable() {
        hoadon = new DAOhd().getListHD();
        model.setRowCount(0);
        for(HoaDon hd:hoadon){
            model.addRow(new Object[]{
            TableResult.getRowCount()+1, hd.getDateOrder(), hd.getThanhtien()
            });
        }
    }


    private void Tong(){
        DecimalFormat x = new DecimalFormat("###,###,###");
        int Tong = 0;
        for(int i=0; i< TableResult.getRowCount(); i++){
            Tong+=Integer.parseInt(TableResult.getValueAt(i, 2).toString());
        }
        labelDoanhThu.setText("Tổng Doang Thu Là:"+" "+x.format(Tong)+" "+"VNĐ");
        UpdateTable.LoadData(sqlDg, TableResult);
    }

    private void btnReset() {

        txtDate.setText("");
        txtMaHD.setText("");
        txtNgayThanhToan.setText("");
        txtThanhTien.setText("");
        showTable();
    }

}
