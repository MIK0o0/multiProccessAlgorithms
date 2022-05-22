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
}

