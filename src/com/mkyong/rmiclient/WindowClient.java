/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkyong.rmiclient;

import com.mkyong.rmiinterface.Task;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author computer
 */
public class WindowClient extends javax.swing.JFrame {
    private static JobClient client;
    private DefaultTableModel tableModel;
    
    /**
     * Creates new form WindowClient
     */
    public WindowClient() {
        initComponents();
        this._btn_disconnect.setEnabled(false);
        tableModel = (DefaultTableModel)this._tbl_task.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        _txt_client_status = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        _txt_connect_status = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        _tbl_task = new javax.swing.JTable();
        _btn_disconnect = new javax.swing.JButton();
        _btn_connect = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        _txt_total_task = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        _txt_client_id = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Mergesort");

        jLabel2.setText("Client Status :");

        _txt_client_status.setText("non-working");

        jLabel4.setText("Connect Status:");

        _txt_connect_status.setText("not connect");

        _tbl_task.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Task ID", "Number of Words", "Status", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(_tbl_task);

        _btn_disconnect.setText("Pause");
        _btn_disconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btn_disconnectActionPerformed(evt);
            }
        });

        _btn_connect.setText("Connect");
        _btn_connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btn_connectActionPerformed(evt);
            }
        });

        jLabel7.setText("Total:");

        _txt_total_task.setText("0");

        jLabel9.setText("Task(s)");

        jLabel10.setText("Client ID:");

        _txt_client_id.setText("01");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(_txt_client_status))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(_txt_connect_status)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(_btn_connect)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(_btn_disconnect))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(_txt_total_task, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(132, 132, 132)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(_txt_client_id)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(_txt_client_id)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(_txt_client_status))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(_txt_connect_status))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(_txt_total_task)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_btn_disconnect, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_btn_connect, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void _btn_disconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btn_disconnectActionPerformed
        this._btn_disconnect.setEnabled(!this._btn_disconnect.isEnabled());
        this._btn_connect.setEnabled(!this._btn_connect.isEnabled());
        client.pauseClient();
    }//GEN-LAST:event__btn_disconnectActionPerformed

    private void _btn_connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btn_connectActionPerformed
        this._btn_connect.setEnabled(!this._btn_connect.isEnabled());
        this._btn_disconnect.setEnabled(!this._btn_disconnect.isEnabled());
        client.startClient();
    }//GEN-LAST:event__btn_connectActionPerformed

    public void setText_txtConnectStatus(String txt){
        this._txt_connect_status.setText(txt);
    }
    
    public void setText_txtClientStatus(String txt){
        this._txt_client_status.setText(txt);
    }
    
    public void setText_txtTotalTask(String txt){
        this._txt_total_task.setText(txt);
    }
    
    public void setText_TxtTotalTask(String txt){
        this._txt_total_task.setText(txt);
    }
    
    public void addInforTask(Task task){
        int num = task.getData1().size();
        String status = "In process";
        if((task.getData2())!=null){num += task.getData2().size();}
        Object[] infor = new Object[4];
        infor[0]= task.getId();
        infor[1]= num;
        infor[2]= status;
        infor[3]=task.getTimeStamp().toString();
        tableModel.addRow(infor);
    }
    
    public void UpdateStatusInforLastTask(String s){
        int row = tableModel.getRowCount()-1;
        int column = tableModel.getColumnCount()-1;
        tableModel.setValueAt(s, row, 2);
    }
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
            java.util.logging.Logger.getLogger(WindowClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WindowClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WindowClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WindowClient ui =  new WindowClient();
                ui.setVisible(true);
                client = new JobClient(ui);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton _btn_connect;
    private javax.swing.JButton _btn_disconnect;
    private javax.swing.JTable _tbl_task;
    private javax.swing.JLabel _txt_client_id;
    private javax.swing.JLabel _txt_client_status;
    private javax.swing.JLabel _txt_connect_status;
    private javax.swing.JLabel _txt_total_task;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
