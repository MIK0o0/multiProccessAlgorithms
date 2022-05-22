package com.company;

import java.io.Serializable;

public class Call implements Serializable {
    private final static long serialVersionUID = -8420577340779607644L;
    private int number;
    public int arrivalTime;
    private int pageNUM;

    private int licznik =1;

    public Call(int number, int segement, int arrivalTime) {
        this.number = number;
        this.arrivalTime = arrivalTime;
        this.pageNUM = segement;

    }
    public boolean equals(Call c){
        if (this.pageNUM == c.pageNUM){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Task{" +
                "number=" + number +
                ", arrivalTime=" + arrivalTime +
                ", pageNUM=" + pageNUM +
                '\n';
    }

    public int getLicznik() {
        return licznik;
    }

    public void setLicznik(int licznik) {
        this.licznik = licznik;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getSegment() {
        return pageNUM;
    }

    public void setWaitingTime(int waitingTime) {
        this.pageNUM = waitingTime;
    }


    public int getPageNUM() {
        return pageNUM;
    }

    public void setPageNUM(int pageNUM) {
        this.pageNUM = pageNUM;
    }

}
