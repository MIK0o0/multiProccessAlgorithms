package com.company;

import Comparators.arrivalComparator;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class callGenerator {

    public void writeTasks(ArrayList<Call> list){
        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("tasks.ser"))){
            writer.writeObject(list);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void generator(int n,int activeTime,int start,int end, ArrayList<Call> list){
        Random random = new Random();
        int i = 0;
        for(;i<n;i++){
            list.add(new Call(i,random.nextInt(start,end) ,random.nextInt(1,activeTime)));
        }
        Collections.sort(list,new arrivalComparator());

    }
    public void generator(int n,int activeTime,int max){
        ArrayList<Call> tsaksList = new ArrayList<>();
        Random random = new Random();
        int i = 0;
        for(;i<n;i++){
            tsaksList.add(new Call(i,random.nextInt(1,max+1) ,random.nextInt(1,activeTime)));
        }

        Collections.sort(tsaksList,new arrivalComparator());
        writeTasks(tsaksList);
    }
    public ArrayList<Call> reader(){
        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream("tasks.ser"))){
            Object ob = reader.readObject();
            reader.close();
            return (ArrayList) ob;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
