package com.conti;

import java.util.HashMap;
import com.conti.UserInput;


public class Node {
    public static HashMap<Integer, Boolean> allExistingNodeIds = new HashMap<>();
    private UserInput userInput;
    private int nodeId;
    private FingerTable fingerTable;

    public Node(UserInput userInput) {
        this.userInput = userInput;
        this.nodeId = createRandomUniqueId();
        allExistingNodeIds.put(nodeId, true);
    }

    private int createRandomUniqueId(){
        boolean isUnique = false;
        int id = -1;
        while (!isUnique) {
            id = generatePossibleId();
            isUnique = checkForUniqueId(id);
        }

        return id;
    }

    private int generatePossibleId(){
        int max = (int) Math.pow(2, this.userInput.getB());

        int range = max + 1;
        return (int)(Math.random() * range + 1);
    }

    private boolean checkForUniqueId(int id){
        boolean isUnique;
            if (allExistingNodeIds.get(id) == null){
                isUnique = true;
            }
            else isUnique = false;
            return isUnique;
    }

    public int getNodeId() {
        return nodeId;
    }

    public FingerTable getFingerTable() {
        return fingerTable;
    }

    public void setFingerTable(FingerTable fingerTable) {
        this.fingerTable = fingerTable;
    }

    @Override
    public String toString() {
        return "N"+this.getNodeId();
    }
}
