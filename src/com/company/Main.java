package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static int max = 120;

    public static void main(String[] args) throws IOException {

    callGenerator generator = new callGenerator();
    int n = 1000000;
    int ramki = 200;
    int arrivalTime = 20000;
    //generator.generator(n,arrivalTime,max);

    String main = "Liczba błedów strony dla n = " + n + ", czas pracy = " + arrivalTime + ", wielkość pamięci fizycznej = " + max + ", dla : ";

    symulation symulation = new symulation(n);
        System.out.println(symulation.rozmiary);
        System.out.println(symulation.globalSize);
        System.out.println(symulation.przydzialRowny(ramki));
        System.out.println(symulation.przydzialProporcjonalny(ramki));





    }
public static void display(int[] tab){
        for (int i : tab){
            System.out.println(i);
        }
}

}