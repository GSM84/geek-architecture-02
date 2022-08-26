package ru.geekbrains.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TreeFactory {
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    public static TreeType getTreeType(String name, String color){
        if (treeTypes.containsKey(name+color)){
            return treeTypes.get(name+color);
        } else {
            TreeType newTreeType = new TreeType(name, color);
            treeTypes.put(name+color,newTreeType);
            return newTreeType;
        }
    }

    public static int getTypeCount(){
        return treeTypes.size();
    }
}
