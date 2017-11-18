package com.conti;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class FingerTable {
    private HashMap<Integer, Node> table;
    private TreeMap<Integer, Node> sortedTable;
    private int[][] tableAsIntegers;
    private UserInput userInput;

    public FingerTable(UserInput userInput, Node node, HashMap<Integer, Node> nodeObjectsById) {
        this.table = new HashMap<>();
        tableAsIntegers = computeTable(node, userInput);
        this.userInput = userInput;
        for(int i = 0; i < userInput.getB(); i++){
            int key = tableAsIntegers[i][0];
            Node value = nodeObjectsById.get(tableAsIntegers[i][1]);
            table.put(key, value);
        }
        sortedTable = new TreeMap<>(table);
    }

    public HashMap<Integer, Node> getTable() {
        return table;
    }

    public TreeMap<Integer, Node> getSortedTable(){
        return sortedTable;
    }

    private int[][] computeTable(Node node, UserInput userInput){
        int nodeId = node.getNodeId();
        int numberOfTableRows = userInput.getB();
        int tableKey, tableValue;
        final int NUMBER_OF_COLUMNS = 2;
        int[][] tableAsIntegers = new int[numberOfTableRows][NUMBER_OF_COLUMNS];
        for(int i = 0; i < numberOfTableRows; i++){
            tableKey = (int) (nodeId + Math.pow(2,i));
            tableValue = determineClosestNode(tableKey, Node.allExistingNodeIds.keySet(), userInput);
            tableAsIntegers[i][0]=tableKey;
            tableAsIntegers[i][1]=tableValue;
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
        return closestNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String a = "|   FingerTable  |\n";
        sb.append(a);
        for(int i = 0; i < userInput.getB(); i++){
            int key = tableAsIntegers[i][0];
            int value = tableAsIntegers[i][1];
            if(key < 10){
                sb.append("|   "+key+"     |  ");
            }else {
                sb.append("|   " + key + "   |  ");
            }
            sb.append(value + "   |\n");

        }
        return sb.toString();
    }
}