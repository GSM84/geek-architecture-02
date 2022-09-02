package ru.geekbrains.patterns.bahavior.iterator;

import java.util.Iterator;
import java.util.Random;

public class IterImpl implements Iterable<Integer> {

    private int digCount;
    private Random r = new Random();
    private int low = 1;
    private int high = 100;

    public IterImpl(int digCount) {
        this.digCount = digCount;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {

            int generated = 0;

            @Override
            public boolean hasNext() {
                return generated < digCount;
            }

            @Override
            public Integer next() {
                generated++;

                return getRandomValue();
            }
        };
    }

    private int getRandomValue(){
        return  r.nextInt(high-low) + low;
    }
}
