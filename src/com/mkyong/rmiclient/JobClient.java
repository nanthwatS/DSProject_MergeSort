/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkyong.rmiclient;

import com.mkyong.rmiinterface.Const;
import com.mkyong.rmiinterface.MergeSort;
import com.mkyong.rmiinterface.RMIJobService;
import com.mkyong.rmiinterface.Task;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Micky
 */
public class JobClient extends Thread{
    private Task task;
    private Worker[] worker = new Worker[2];
    private static RMIJobService look_up;
    private boolean stop = true, exit = false;
    private WindowClient ui;
    private static int jobDone=0;
    
    @Override
    public void run(){
        while(!exit){
            while(!stop){
                task = reqJob();
                if(task==null){
                    waitForJob(1000);
                    continue;
                }
                clientStartJob(task);
                sendResult(task);   
            }
            waitForJob(2000);
        }
    }
    
    
    public JobClient(WindowClient ui){
        worker[0] = new Worker();
        worker[1] = new Worker();
        this.ui = ui;
    }
    
    public void clientStartJob(Task task){
        ui.setText_txtClientStatus(Const._TXT_IN_PROCESS_MS);
        ui.addInforTask(task);
        ArrayList<String> data_1 = task.getData1();
        ArrayList<String> data_2 = task.getData2();
        if(data_1.size()<2 && data_2==null){
            task.setStatus(true);
            return;
        }
        if(task.isSort()){
            task.setData1(MergeSort.DoMerge(data_1, data_2));
            task.removeData(2);
            return;
        }
        else{
            int end = data_1.size()-1;
            int middle = (end/2);
            ArrayList<String> left = new ArrayList(data_1.subList(0, middle+1));
            ArrayList<String> right = new ArrayList(data_1.subList(middle+1, end+1));
            worker[0] = new Worker();
            worker[1] = new Worker();
            int a = 3/2;
            worker[0].startJob(left, 0, left.size()-1);
            worker[1].startJob(right, 0, right.size()-1);
            try {
                worker[0].join();
                worker[1].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(JobClient.class.getName()).log(Level.SEVERE, null, ex);
            }
            task.setData1(MergeSort.DoMerge(left, right));
            task.setStatus(true);
        }
    }
    
    public void waitForJob(long time){
        ui.setText_txtClientStatus(Const._TXT_WaitForJob);
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(JobClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Task reqJob() {
        try {
            ui.setText_txtClientStatus(Const._TXT_REQUEST_JOB);
            ui.setText_txtConnectStatus(Const._TXT_Connected);
            return getService().getTask(Const._MY_ID);
        } catch (RemoteException ex) {
           // Logger.getLogger(JobClient.class.getName()).log(Level.SEVERE, null, ex);
           System.out.println("Cannot connect server");
           ui.setText_txtConnectStatus(Const._TXT_CanNotConnect);
           look_up =null;
            
        } catch(NullPointerException ex){
            ui.setText_txtConnectStatus(Const._TXT_CanNotConnect);
        }
        return null;
    }
    
    private void sendResult(Task task){
        ui.setText_txtClientStatus(Const._TXT_SEND_RESULT);
        try {
            getService().sendResult(task);
            jobDone++;
            ui.setText_txtTotalTask(String.valueOf(jobDone));
            ui.UpdateStatusInforLastTask(Const._TXT_Finsih);
        } catch (RemoteException ex) {
            Logger.getLogger(JobClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private RMIJobService getService(){
        if(look_up ==null){
            try {
                ui.setText_txtConnectStatus(Const._TXT_Connecting);
                look_up = (RMIJobService) Naming.lookup("//"+Const._IP_Server+"/"+Const._RMI_Name_Service1);
            } catch (NotBoundException ex) {
                Logger.getLogger(JobClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(JobClient.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(JobClient.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        return look_up;
    }
    
    public void startClient(){
        if(!this.isAlive()){
            this.start();
        }
        stop = false;
    }
    
    
   
    
    public void pauseClient(){
        ui.setText_txtConnectStatus(Const._TXT_NotConnect);
        stop = true;
    }
    
}
