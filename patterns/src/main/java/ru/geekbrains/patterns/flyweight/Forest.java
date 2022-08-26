package ru.geekbrains.patterns.flyweight;

import java.util.ArrayList;

public class Forest {
    private ArrayList<Tree> trees = new ArrayList<>();

    void plantTree(int x, int y, String name, String color){
        TreeType type = TreeFactory.getTreeType(name, color);
        Tree tr = new Tree(type, x, y);
        trees.add(tr);
    }

    public int getTreeCount(){
        return trees.size();
    }
}
