/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkyong.rmiserver;

import com.mkyong.rmiclient.JobClient;
import com.mkyong.rmiclient.WindowClient;
import com.mkyong.rmiinterface.Const;
import com.mkyong.rmiinterface.Task;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author naki_
 */
public class GUIServer extends javax.swing.JFrame {
    
    private static JobSchedule jobSchedule;
    private static DefaultTableModel tableModel;
    /**
     * Creates new form GUIServer
     */
    public GUIServer() {
        initComponents();
        this._btn_start.setEnabled(false);
        this._btn_stop.setEnabled(false);
    }
    
    public void init(JobSchedule jobSchedule){
        this.jobSchedule = jobSchedule;
        this._btn_start.setEnabled(true);
        tableModel = (DefaultTableModel) this._tblClientTask.getModel();
    }
    
    public void addInforTask(Task task){
        Object[] infor = new Object[3];
        infor[0] = task.getIDClient();
        infor[1] = task.getId();
        infor[2] = Const._TXT_SENDED;
        tableModel.addRow(infor);
    }
    
    public int removeInforTask(int idTask){
        for(int i=0;i<tableModel.getRowCount();i++){
            if((int)tableModel.getValueAt(i, 1) == idTask){
                tableModel.removeRow(i);
                return i;
            }
        }
        return -1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        _tblClientTask = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        _lblRemainWork = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        _lblWorkStatus = new javax.swing.JLabel();
        _btn_start = new javax.swing.JButton();
        _btnEndTask = new javax.swing.JButton();
        _btn_stop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        _tblClientTask.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Client ID", "Task ID", "status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(_tblClientTask);
        if (_tblClientTask.getColumnModel().getColumnCount() > 0) {
            _tblClientTask.getColumnModel().getColumn(0).setResizable(false);
            _tblClientTask.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Total Remaining Work");

        _lblRemainWork.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        String remainWork = "";
        //if(JobSchedule.unSortTask.size()!=0){
            //    remainWork = String.valueOf(JobSchedule.unSortTask.size());
            //}
        _lblRemainWork.setText(remainWork);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Work Status");

        _lblWorkStatus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        _lblWorkStatus.setText("Idle");

        _btn_start.setText("Start");
        _btn_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btn_startActionPerformed(evt);
            }
        });

        _btnEndTask.setText("End Task");

        _btn_stop.setText("Stop ");
        _btn_stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _btn_stopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(_btn_start)
                        .addGap(41, 41, 41)
                        .addComponent(_btn_stop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(_btnEndTask))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(117, 117, 117)
                            .addComponent(_lblRemainWork)
                            .addGap(132, 132, 132))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(_lblWorkStatus)
                            .addGap(121, 121, 121))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(_lblRemainWork))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(_lblWorkStatus))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_btnEndTask)
                    .addComponent(_btn_start)
                    .addComponent(_btn_stop))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void _btn_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btn_startActionPerformed
       this._btn_start.setEnabled(false);
       Server.regisService();
       this._btn_stop.setEnabled(true);
    }//GEN-LAST:event__btn_startActionPerformed

    private void _btn_stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__btn_stopActionPerformed
        this._btn_stop.setEnabled(false);
        Server.unRegisService();
        this._btn_start.setEnabled(true);
    }//GEN-LAST:event__btn_stopActionPerformed

    public JButton getBtnEndTask(){
        return this._btnEndTask;
    }
    
    public JTable getTaskTable(){
        return this._tblClientTask;
    }
    
    public void setText_lblWorkStatus(String text){
        _lblWorkStatus.setText(text);
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
            java.util.logging.Logger.getLogger(GUIServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
//        JobSchedule jobS = new JobSchedule();
        /* Create and display the form */
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton _btnEndTask;
    private javax.swing.JButton _btn_start;
    private javax.swing.JButton _btn_stop;
    private javax.swing.JLabel _lblRemainWork;
    private javax.swing.JLabel _lblWorkStatus;
    private javax.swing.JTable _tblClientTask;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
