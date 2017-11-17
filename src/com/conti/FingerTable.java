package com.conti;

import java.util.HashMap;

public class FingerTable {
    private int numberOfEntries;
    private HashMap<Integer, Integer> table;

    public FingerTable(int numberOfEntries, HashMap<Integer, Integer> table) {
        this.numberOfEntries = numberOfEntries;
        this.table = table;
    }

    public int getNumberOfEntries() {

        return numberOfEntries;
    }

    public HashMap<Integer, Integer> getTable() {
        return table;
    }
}