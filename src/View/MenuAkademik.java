/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.sql.Connection;

/**
 *
 * @author Agung Ma'ruf
 */
public class MenuAkademik extends javax.swing.JFrame {
    Connection conn;
    
    public MenuAkademik() {
        initComponents();
        setSize(1000, 600);
        setLocationRelativeTo(this);
        Koneksi.Database.KoneksiDB();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mnuMahasiswa = new javax.swing.JMenuItem();
        mnuMatakuliah = new javax.swing.JMenuItem();
        mnuPeriode = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuExit = new javax.swing.JMenuItem();
        mnuTransaksi = new javax.swing.JMenu();
        mnuKRSS = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        mnuFile.setText("File");

        mnuMahasiswa.setText("Mahasiswa");
        mnuMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMahasiswaActionPerformed(evt);
            }
        });
        mnuFile.add(mnuMahasiswa);

        mnuMatakuliah.setText("Matakuliah");
        mnuMatakuliah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMatakuliahActionPerformed(evt);
            }
        });
        mnuFile.add(mnuMatakuliah);

        mnuPeriode.setText("Periode");
        mnuPeriode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPeriodeActionPerformed(evt);
            }
        });
        mnuFile.add(mnuPeriode);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        mnuFile.add(jSeparator1);

        mnuExit.setText("Exit");
        mnuExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuExitMouseClicked(evt);
            }
        });
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        mnuFile.add(mnuExit);

        jMenuBar1.add(mnuFile);

        mnuTransaksi.setText("Transaksi");

        mnuKRSS.setText("KRSS");
        mnuKRSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuKRSSActionPerformed(evt);
            }
        });
        mnuTransaksi.add(mnuKRSS);

        jMenuBar1.add(mnuTransaksi);

        jMenu1.setText("Cetak");

        jMenuItem1.setText("Matakuliah");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMahasiswaActionPerformed
        View.FrmMahasiswa objMhs = new View.FrmMahasiswa();
        objMhs.setLocationRelativeTo(this);
        objMhs.setVisible(true);
    }//GEN-LAST:event_mnuMahasiswaActionPerformed

    private void mnuMatakuliahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMatakuliahActionPerformed
        View.FrmMatakuliah objMtk = new View.FrmMatakuliah();
        objMtk.setLocationRelativeTo(this);
        objMtk.setVisible(true);
    }//GEN-LAST:event_mnuMatakuliahActionPerformed

    private void mnuPeriodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPeriodeActionPerformed
        View.FrmPeriode objPrd = new View.FrmPeriode();
        objPrd.setLocationRelativeTo(this);
        objPrd.setVisible(true);
    }//GEN-LAST:event_mnuPeriodeActionPerformed

    private void mnuExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuExitMouseClicked
        
    }//GEN-LAST:event_mnuExitMouseClicked

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mnuExitActionPerformed

    private void mnuKRSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuKRSSActionPerformed
        View.FrmKRSS k = new View.FrmKRSS();
        k.setLocationRelativeTo(this);
        k.setVisible(true);
    }//GEN-LAST:event_mnuKRSSActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        View.FrmCetakMatakuliah k = new View.FrmCetakMatakuliah();
        k.setLocationRelativeTo(this);
        k.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAkademik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAkademik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAkademik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAkademik.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAkademik().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JMenuItem mnuKRSS;
    private javax.swing.JMenuItem mnuMahasiswa;
    private javax.swing.JMenuItem mnuMatakuliah;
    private javax.swing.JMenuItem mnuPeriode;
    private javax.swing.JMenu mnuTransaksi;
    // End of variables declaration//GEN-END:variables
}