package com.company;

import java.util.ArrayList;

public class LRU {
    public int lruAlgo(ArrayList<Call> list,int size) {
        ArrayList<Call> ramka3 = new ArrayList<>();
        int result = 0;
        for (int k = 0; k < list.size(); k++) {
            result += check(ramka3,size,list.get(k));
        }
        return result;
    }
    public int check(ArrayList<Call> tab,int size, Call c){
        for (int i = 0; i < tab.size(); i++) {
            if (tab.get(i).equals(c)) {
                Call tym = tab.get(i);
                tab.remove(i);
                tab.add(tym);
                return 0;
            }
        }
        if (tab.size() >= size) {
            tab.remove(0);
        }
        tab.add(c);
        return 1;
    }

    public ArrayList<Integer> lruAlgo(ArrayList<ArrayList<Call>> list,int size,int ramki,int arrivalTime,ArrayList<Integer> rozmiary) {
        ArrayList<ArrayList<Call>> ramkiList = new ArrayList<>();
        ArrayList<Integer> sizeRamka = new ArrayList<>();
        ArrayList<Integer> errorRamka = new ArrayList<>();
        ArrayList<Integer> indexRamka = new ArrayList<>();

        for(int i = 0;i<10;i++){
            ramkiList.add(new ArrayList<>());
            sizeRamka.add(size);
            errorRamka.add(0);
            indexRamka.add(0);
        }


        int freeRamki = ramki-(size*10);
        int arT = 0;
        int result = 0;
        while (arT < arrivalTime){
            for (int k = 0; k < ramkiList.size(); k++) {
                if (indexRamka.get(k) < list.get(k).size()) {
                    while (list.get(k).get(indexRamka.get(k)).getArrivalTime() < arT) {
                        errorRamka.set(k, (errorRamka.get(k) + check(ramkiList.get(k), sizeRamka.get(k), list.get(k).get(indexRamka.get(k)))));
                        indexRamka.set(k, indexRamka.get(k) + 1);

                        if (errorRamka.get(k) > rozmiary.get(k) && freeRamki > 0){
                            sizeRamka.set(k,sizeRamka.get(k) +1);
                            freeRamki--;
                        }
                        if (errorRamka.get(k) < (rozmiary.get(k)/2)+1 && freeRamki<ramki && sizeRamka.get(k)>2){
                            sizeRamka.set(k,sizeRamka.get(k)-1);
                            freeRamki++;
                        }
                        if (indexRamka.get(k) >= list.get(k).size()) {
                            freeRamki += sizeRamka.get(k);
                            sizeRamka.set(k,0);
                            break;
                        }
                    }
                }
            }
            arT++;
        }
        int globalError = 0;
        for (Integer t:errorRamka){
            globalError += t;
        }
        errorRamka.add(globalError);
        return errorRamka;
    }
}

