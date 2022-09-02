package ru.geekbrains.patterns.bahavior.strategy;


public class Main {
    public static void main(String[] args) {

        ArrSort srt = new ArrSort(new int[]{3, 4, 6, 8, 1});

        for (int i = 0; i < srt.getArr().length; i++) {
            System.out.println(srt.getArr()[i]);
        }
        System.out.println();
        srt.arrSort(() -> {
            int[] arr = srt.getArr();
            for (int i = 0; i < arr.length; i++) {
                int min = arr[i];
                int min_i = i;

                for (int j = i+1; j < arr.length; j++) {
                    if (arr[j] < min) {
                        min = arr[j];
                        min_i = j;
                    }
                }
                if (i != min_i) {
                    int tmp = arr[i];
                    arr[i] = arr[min_i];
                    arr[min_i] = tmp;
                }
            }

            return arr;
        });

        for (int i = 0; i < srt.getArr().length; i++) {
            System.out.println(srt.getArr()[i]);
        }
    }
}
