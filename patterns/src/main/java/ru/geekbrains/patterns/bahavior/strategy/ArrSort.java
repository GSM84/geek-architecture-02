package ru.geekbrains.patterns.bahavior.strategy;

public class ArrSort {
    private int[] arr;

    public ArrSort(int[] arr) {
        this.arr = arr;
    }

    void arrSort(Strategy strategy){
        arr =  strategy.sort();
    }

    public int[] getArr() {
        return arr;
    }
}
