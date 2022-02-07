package com.training.tetris;

import java.util.Comparator;

public class CountryComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int l1 = ((Country) o1).getName().length();
        int l2 = ((Country) o2).getName().length();
        return Integer.compare(l1, l2);

        //((Country) o1).getName().length().compareTo(((Country) o2).getName());
    }
}
