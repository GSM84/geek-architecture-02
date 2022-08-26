package ru.geekbrains.patterns.flyweight;

public class Main {
    public static void main(String[] args) {
        Forest forest = new Forest();
        System.out.println(forest.getTreeCount());

        forest.plantTree(1,1,"Береза", "Желтая");
        forest.plantTree(1,3,"Береза", "Желтая");
        forest.plantTree(1,3,"Береза", "Желтая");
        forest.plantTree(1,4,"Клен", "Желтая");

        System.out.println("Деревьев " + forest.getTreeCount());
        System.out.println("Типов "+ TreeFactory.getTypeCount());
    }
}
