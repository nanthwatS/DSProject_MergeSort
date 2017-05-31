/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mkyong.rmiserver;

import com.mkyong.rmiinterface.Task;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Micky
 */
public class JobSchedule {
    
    public ArrayList<String> jobs;
    public LinkedList<Task> unSortTask;
    public LinkedList<Task> sortTask;
    public LinkedList<Task> sendTask;
    public LinkedList<Task> unSortTask2;
    public JobSchedule(ArrayList<String> jobs){
       this.jobs = jobs;
       unSortTask = new LinkedList();
       sortTask = new LinkedList();
       sendTask = new LinkedList();
       doJobSchedule();
    }
    
    
    private void doJobSchedule(){
        int start, end, size = jobs.size(),range = size/8;
        System.out.println(unSortTask.size());
        ArrayList<String> temp;
        for(int i=0;i<=7;i++){
            start = i*range; 
            end = (i+1)*range-1;
            if(i==7){
                end = (size-1);
            }
            System.out.println("task id "+i+" data from "+start+" to "+end);
            System.out.println("range = "+(end-start+1)+" "+(range));
            temp = new ArrayList<String>(jobs.subList(start, end+1));
            unSortTask.add(new Task(i, temp));
        }
        jobs = null;
        System.gc();
    }
    
    public Task deleteSendTask(int id){
        for(int i=0;i<sendTask.size();i++){
            if( sendTask.get(i).getId() == id){
                return sendTask.remove(i);
            }
        }
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
}
