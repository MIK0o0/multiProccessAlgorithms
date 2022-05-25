package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

    int n = 1000000;
    int ramki = 1000;
    int arrivalTime = 20000;
    Zapis zapis = new Zapis();
    String main = "Dane wejściowe : 10 procesów, liczba żądań = " + n + ", czas pracy = " + arrivalTime + ", liczba dostępnych ramek = " + ramki + " ----------------------------------------------";

    symulation symulation = new symulation(n);
    ArrayList<Integer> rozmiary = symulation.rozmiary;
    ArrayList<Integer> przydzialRowny = symulation.przydzialRowny(ramki);
    ArrayList<Integer> przydzialPropo = symulation.przydzialProporcjonalny(ramki);
    ArrayList<Integer> sterowanieCzesto = symulation.sterowanieCzestoscia(ramki,arrivalTime);
    ArrayList<Integer> przydzialStrefo= symulation.przydzialStrefowy(ramki,100);

    zapis.zapis(main);
    String tym = new String();
        System.out.println(main);
    for (int i = 0;i<=rozmiary.size();i++){
        if (i == 10){
            tym = "Łączna liczba błędów: dla p. równego: " + przydzialRowny.get(i) + ",  dla p. proporcjalnego: " + przydzialPropo.get(i) +
                    ", dla sterowania częst.: " + sterowanieCzesto.get(i) + ", dla p. strefowego: " + przydzialStrefo.get(i) + "////////////////////////////////////////////////////////\n";
            zapis.zapis2(main);
            zapis.zapis2(tym);
        }else {
            tym = "Rozmiar procesu: " + rozmiary.get(i) + " l. błędów dla p. równego: " + przydzialRowny.get(i) + ", l. błędów dla p. proporcjalnego: " + przydzialPropo.get(i) +
                    ", l. błędów dla sterowania częst.: " + sterowanieCzesto.get(i) + ", l.błędów dla p. strefowego: " + przydzialStrefo.get(i);
        }
        System.out.println(tym);
        zapis.zapis(tym);
    }

    }
}


