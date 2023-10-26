package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChuyenDe;
import repository.ChuyenDeRepository;

public class ChuyenDeView extends javax.swing.JFrame {

    ChuyenDeRepository service = new ChuyenDeRepository();
    List<ChuyenDe> listChuyenDe = new ArrayList<>();
    DefaultTableModel dtm;

    public ChuyenDeView() {
        initComponents();
        loadCombobox();
        dtm = (DefaultTableModel) tblChuyenDe.getModel();
        listChuyenDe = service.getAll();
        loadTable(listChuyenDe);
    }

    public void loadCombobox() {
        DefaultComboBoxModel dcb = (DefaultComboBoxModel) cbbThoiLuong.getModel();
        dcb.removeAllElements();
        for (int i = 1; i < 101; i++) {
            dcb.addElement(i);
        }
    }

    public void loadTable(List<ChuyenDe> list) {
        dtm.setRowCount(0);
        for (ChuyenDe chuyenDe : list) {
            Object[] rowData = {
                chuyenDe.getMa(),
                chuyenDe.getTen(),
                chuyenDe.getHocPhi(),
                chuyenDe.getThoiLuong(),
                chuyenDe.getMoTa()
            };
            dtm.addRow(rowData);
        }
    }

    public void show(int index) {
        ChuyenDe chuyenDe = service.getAll().get(index);
        txtMa.setText(String.valueOf(chuyenDe.getMa()));
        txtTen.setText(chuyenDe.getTen());
        txtHocPhi.setText(String.valueOf(chuyenDe.getHocPhi()));
        cbbThoiLuong.setSelectedItem(chuyenDe.getThoiLuong());
        txtMoTa.setText(chuyenDe.getMoTa());
    }

    public void clear() {
        txtMa.setText("");
        txtTen.setText("");
        txtHocPhi.setText("");
        txtMoTa.setText("");
        cbbThoiLuong.setSelectedIndex(0);
    }

    public ChuyenDe getForm() {
        String ma = txtMa.getText().trim();
        String ten = txtTen.getText().trim();
        String hocPhi = txtHocPhi.getText().trim();
        int thoiLuong = Integer.valueOf(cbbThoiLuong.getSelectedItem().toString());
        String moTa = txtMoTa.getText().trim();
        if (ma.length() == 0 || ten.length() == 0 || hocPhi.length() == 0 || moTa.length() == 0) {
            JOptionPane.showMessageDialog(this, "Không được để trống!!!");
            return null;
        }
        try {
            if (Integer.valueOf(ma) < 0) {
                JOptionPane.showMessageDialog(this, "Ma phai lon hon 0");
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ma phai la so");
            return null;
        }
        ChuyenDe chuyenDe = new ChuyenDe(Integer.valueOf(ma), ten, Double.valueOf(hocPhi), thoiLuong, moTa);
        return chuyenDe;
    }

    public boolean checkTrung() {
        String ma = txtMa.getText().trim();
        for (int i = 0; i < dtm.getRowCount(); i++) {
            if (tblChuyenDe.getValueAt(i, 0).toString().equals(ma)) {
                JOptionPane.showMessageDialog(this, "Trung maNV!");
                return false;
            }
        }
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHocPhi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbbThoiLuong = new javax.swing.JComboBox<>();
        txtMoTa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChuyenDe = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSort = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("chuyen-de");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("QUAN LY CHUYEN DE");

        jLabel2.setText("Ma");

        jLabel3.setText("Ten");

        jLabel4.setText("Hoc Phi");

        jLabel5.setText("Thoi Luong");

        cbbThoiLuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Mo Ta");

        tblChuyenDe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma", "Ten", "Hoc Phi", "Thoi Luong", "Mo Ta"
            }
        ));
        tblChuyenDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChuyenDeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblChuyenDe);

        btnThem.setText("Them");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sua");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSort.setText("Sort");
        btnSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSortActionPerformed(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(148, 148, 148)
                                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbbThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSort))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblChuyenDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChuyenDeMouseClicked
        int row = tblChuyenDe.getSelectedRow();
        show(row);
    }//GEN-LAST:event_tblChuyenDeMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int tb = JOptionPane.showConfirmDialog(this, "Xác nhận", "Thông báo", JOptionPane.YES_OPTION);
        if (tb == JOptionPane.YES_OPTION) {
            int row = tblChuyenDe.getSelectedRow();
            if (row > -1) {
                try {
                    int ma = Integer.valueOf(tblChuyenDe.getValueAt(row, 0).toString());
                    service.xoa(ma);
                    loadTable(service.getAll());
                    clear();
                    JOptionPane.showMessageDialog(this, "Xóa thành công ^^");
                    show(0);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại!!!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        int tb = JOptionPane.showConfirmDialog(this, "Xác nhận", "Thông báo", JOptionPane.YES_OPTION);
        if (tb == JOptionPane.YES_OPTION) {
            ChuyenDe chuyenDe = getForm();
            if (chuyenDe != null && checkTrung()) {
                try {
                    service.them(chuyenDe);
                    loadTable(service.getAll());
                    JOptionPane.showMessageDialog(this, "Thêm thành công ^^");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại!!!");
                }
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int tb = JOptionPane.showConfirmDialog(this, "Xác nhận", "Thông báo", JOptionPane.YES_OPTION);
        if (tb == JOptionPane.YES_OPTION) {
            int row = tblChuyenDe.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
                return;
            }
            ChuyenDe chuyenDe = getForm();
            if (chuyenDe != null) {
                try {
                    service.sua(chuyenDe);
                    loadTable(service.getAll());
                    JOptionPane.showMessageDialog(this, "Sửa thành công ^^");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại!!!");
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        ChuyenDe chuyenDe = new ChuyenDe();
        chuyenDe.setTen(txtSearch.getText());
        loadTable(service.search(chuyenDe));
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSortActionPerformed
        int tb = JOptionPane.showConfirmDialog(this, "Xác nhận", "Thông báo", JOptionPane.YES_OPTION);
        if (tb == JOptionPane.YES_OPTION) {
            loadTable(service.sortGiamDan());
        }
    }//GEN-LAST:event_btnSortActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChuyenDeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSort;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbThoiLuong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblChuyenDe;
    private javax.swing.JTextField txtHocPhi;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
