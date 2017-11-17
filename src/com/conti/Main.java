package com.conti;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        UserInput input = getUserInput();
        HashMap<Integer, Node> nodeObjectsById = createNodes(input);
        System.out.println("Debug: All the keys are: " + nodeObjectsById.keySet());
        createFingerTables(input, nodeObjectsById);
        //createRandomKeyId(input);
        //display
    }

    private static UserInput getUserInput() {
        System.out.println("Welcome to chord! To begin, please enter your id-space (B) value:");
        int b;
        int n;
        b = getValue();
        System.out.println("Thank you. Next, enter in the number of nodes (N):");
        n = getValue();
        UserInput userInput = new UserInput(b, n);
        validateUserInput(userInput);

        return userInput;
    }

    private static int getValue() {
        Scanner scan = new Scanner(System.in);
        int value;
        try {
            value = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error. Please enter an integer");
            value = getValue();
        }
        return value;
    }

    private static void validateUserInput(UserInput userInput){
        if (userInput.verifyInput()) {
            System.out.println("Thank you, your input has been accepted");
            System.out.println("B: [" + Integer.toString(userInput.getB()) + "]");
            System.out.println("N: [" + Integer.toString(userInput.getN()) + "]");
        } else {
            System.out.println("Your input was not valid (n was too large for b).\n");
            System.out.println("");
            System.out.println("Please retry to enter your values");
            getUserInput();
        }
    }

    private static HashMap<Integer, Node> createNodes(UserInput userInput){
        int numberOfNodes = userInput.getN();
        HashMap<Integer, Node> allNodesById = new HashMap<>();
        for (int i = 0; i < numberOfNodes; i++){
            Node node = new Node(userInput);
            int nodeId = node.getNodeId();
            System.out.println("Debug: Created node with id: "+nodeId);
            allNodesById.put(nodeId, node);
        }
        return allNodesById;
    }

    private static void createFingerTables(UserInput userInput, HashMap<Integer, Node> nodeObjectsById) {
        int numberOfNodes = userInput.getN();
        Collection<Node> allNodes = nodeObjectsById.values();
        System.out.println("Debug: allNodes Collection: "+allNodes);
        for(Node node: allNodes){
            FingerTable fingerTable = new FingerTable(userInput, node, nodeObjectsById);
            node.setFingerTable(fingerTable);
        }
    }
}
