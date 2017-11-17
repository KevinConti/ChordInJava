package com.conti;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class FingerTable {
    private HashMap<Integer, Node> table;

    public FingerTable(UserInput userInput, Node node, HashMap<Integer, Node> nodeObjectsById) {
        this.table = new HashMap<>();
        int[][] tableKeyValuePairs = computeTable(node, userInput);
    }

    public HashMap<Integer, Node> getTable() {
        return table;
    }

    private int[][] computeTable(Node node, UserInput userInput){
        int nodeId = node.getNodeId();
        int numberOfTableRows = userInput.getB();
        int tableKey, tableValue;
        final int NUMBER_OF_COLUMNS = 2;
        int[][] tableAsIntegers = new int[numberOfTableRows][NUMBER_OF_COLUMNS];
        System.out.println("");
        System.out.println("Debug: nodeId = "+nodeId);
        for(int i = 0; i < numberOfTableRows; i++){
            tableKey = (int) (nodeId + Math.pow(2,i));
            //TODO if the tableKey is too high (above 2^b id spaces), tableKey = tableKey - MAX_ID_SPACE
            System.out.println("Debug: tableKey = "+tableKey);
            tableValue = determineClosestNode(tableKey, Node.allExistingNodeIds.keySet(), userInput);
        }
        return tableAsIntegers;
    }

    int determineClosestNode(int key, Set<Integer> allKeys, UserInput userInput){

        TreeSet<Integer> sortedKeys = new TreeSet(allKeys);
        int closestNode;
        if (sortedKeys.ceiling(key) != null){
            closestNode = sortedKeys.ceiling(key);
        }
        else{
            //key is higher than all entries in finger table, therefore either:
            //1) Higher than max id-space (2^b) or
            //2) Within id-space but finger table has lower entries
            //In the case of #1 we should subtract 2^b and look for the ceiling again
            //In the case of #2 we should use the first value in sorted keys
            int maxValue = (int) Math.pow(2, userInput.getB());
            if (key > maxValue){
                key = key - maxValue;
                closestNode = sortedKeys.ceiling(key);
            } else {
                closestNode = sortedKeys.first();
            }
        }


        System.out.println("Out of keys: "+sortedKeys);
        System.out.println("Closest node value to "+key + " is " +closestNode);
        return closestNode;
    }
}