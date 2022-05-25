package com.company;

import java.util.ArrayList;
import java.util.Random;

public class symulation {
    callGenerator generator = new callGenerator();
    Random random = new Random();
    LRU lru = new LRU();


    public ArrayList<Integer> rozmiary = new ArrayList<>();
    public int globalSize = 0;
    private ArrayList<ArrayList<Call>> lista = new ArrayList<>();
    public symulation(int n){

        int quantiti = n;
        int dwa = 2;
        int proc = 10;
        for (int i=0;i<10;i++){
            rozmiary.add((dwa*2)-dwa);
            globalSize += rozmiary.get(i);
            int maksi = quantiti *proc/100;
            lista.add(new ArrayList<>());
            if (i == 9){
                generator.generator(quantiti,10000,dwa, dwa+(dwa/2),lista.get(i) );
            }else{
                generator.generator(random.nextInt(1,maksi),10000,dwa,dwa+(dwa/2),lista.get(i) );
            }
            quantiti -= lista.get(i).size();
            dwa *=2;
            proc += 5;
        }
    }
    public ArrayList<Integer> przydzialRowny(int ramki){
        int size = ramki/ lista.size();
        ArrayList<Integer> result = new ArrayList<>();
        int global = 0;
        for (int i = 0;i<lista.size();i++){
            result.add(lru.lruAlgo(lista.get(i),size));
            global += result.get(i);
        }
        result.add(global);
        return result;
    }
    public ArrayList<Integer> przydzialProporcjonalny(int ramki){

        ArrayList<Integer> result = new ArrayList<>();
        int global = 0;
        for (int i = 0;i<lista.size();i++){
            int size = (rozmiary.get(i)* ramki)/globalSize ;
            if (size == 0){
                size++;
            }

            result.add(lru.lruAlgo(lista.get(i),size));
            global += result.get(i);
        }
        result.add(global);
        return result;
    }

    public ArrayList<Integer> sterowanieCzestoscia(int ramki,int arrivalT){
        return lru.lruAlgo(lista,ramki/20,ramki,arrivalT,rozmiary);
    }



    public ArrayList<Integer> przydzialStrefowy(int ramki,int zakres){
        ArrayList<Integer> unikaty = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        int global = 0;
        int globalUnikat = 0;
        for (int i =0;i<10;i++){
            unikaty.add(unikat(lista.get(i),zakres));
            globalUnikat += unikaty.get(i);
        }
        for (int i = 0;i<lista.size();i++){
            int size = (unikaty.get(i)* ramki)/globalUnikat ;
            if (size == 0){
                size++;
            }

            result.add(lru.lruAlgo(lista.get(i),size));
            global += result.get(i);
        }
        result.add(global);
        return result;


    }
    public int unikat(ArrayList<Call> tab,int zakres){
        ArrayList<Call> tym = new ArrayList<>();
        tym.add(tab.get(0));
        for (int i = 0; i < zakres; i++) {
            boolean flag = true;
            for (int k = 0;k<tym.size();k++){
                if (tab.get(i).equals(tym.get(k))){
                    flag = false;
                }
            }
            if (flag){
                tym.add(tab.get(i));
            }
        }

        return tym.size();
    }
}
