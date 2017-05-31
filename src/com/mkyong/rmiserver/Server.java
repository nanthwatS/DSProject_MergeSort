package com.mkyong.rmiserver;

import com.mkyong.rmiclient.JobClient;
import com.mkyong.rmiclient.WindowClient;
import java.rmi.Naming;
import com.mkyong.rmiinterface.Const;
import com.mkyong.rmiinterface.MergeSort;
import static com.mkyong.rmiinterface.MergeSort.getRandomString;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server{

    private static final long serialVersionUID = 1L;
    private static RMIJobServiceImp serviceJob;
    private static JobSchedule job;
    private static GUIServer ui;
    public static void main(String[] args) {
        init(Const._PathFileInit);
        ui =  new GUIServer();
        ui.setVisible(true);
        testMergeSort();
        try {
            serviceJob = new RMIJobServiceImp(job, ui);
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        ui.init(job);
    }
    
    public static void regisService(){
        
        try {
            Naming.rebind("//"+Const._IP_Server+"/"+Const._RMI_Name_Service1, serviceJob);
            System.out.println("Server ready");
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void unRegisService(){
        try {
            Naming.unbind(Const._RMI_Name_Service1);
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void testMergeSort(){

        ArrayList<String> task = new ArrayList();
        if(Const._GENERATE_TEXT_FILE_FLAG){
            System.out.println("Server generate text file....");
            MergeSort.genTextFile(Const._PathFileJob, Const._Charset, 10, Const._NUMBER_OF_TEXT); // 2^10
        }
        System.out.println("Server load file to memory...");
        try {
            MergeSort.CreateJobFromFile(Const._PathFileJob, task);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("do job schedule");
//        for(int i=0;i<10000000;i++){
//           // task.add(MergeSort.getRandomString(6)); // big memory use
//           //task.add(UUID.randomUUID().toString()); // huge of memory use
//           task.add("abcdefgjsdfsdfsdfs"); // very less memmory use
//        }
        
        job = new JobSchedule(task);
        System.out.println("task size "+task.size());
    }
    
    public static void init(String path){
        int i=0;
        String line;
        String[] dataSetting = new String[10];
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            while( (line = br.readLine())!=null ){
                dataSetting[i++] = line.split("=")[1];
            }
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println(path);
            Logger.getLogger(MergeSort.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MergeSort.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Const._IP_Server = dataSetting[0];
        if(dataSetting[1].compareTo("0")==0)Const._TIMEOUT_FLAG = false;
        Const._TIMEOUT = Integer.parseInt(dataSetting[2]);
        Const._PathFileJob = dataSetting[3];
        Const._PathFileResult = dataSetting[4];
        if(dataSetting[5].compareTo("0")==0)Const._GENERATE_TEXT_FILE_FLAG = false;
        Const._NUMBER_OF_TEXT = Integer.parseInt(dataSetting[6]);
    }
    
    
    
    

    

    

    
}
