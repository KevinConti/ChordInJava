package com.conti;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        UserInput input = getUserInput();
        HashMap<Integer, Node> nodeObjectsById = createNodes(input);
        createFingerTables(input, nodeObjectsById);
        int randomKey = createRandomKeyId(input);
        Node nStart = determineStartNode(nodeObjectsById);
        System.out.println("");
        System.out.println("The randomKeyId is "+randomKey);
        System.out.println("The starting node will be "+nStart);
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
            allNodesById.put(nodeId, node);
        }
        return allNodesById;
    }

    private static void createFingerTables(UserInput userInput, HashMap<Integer, Node> nodeObjectsById) {
        int numberOfNodes = userInput.getN();
        Collection<Node> allNodes = nodeObjectsById.values();
        for(Node node: allNodes){
            FingerTable fingerTable = new FingerTable(userInput, node, nodeObjectsById);
            node.setFingerTable(fingerTable);
            System.out.println("Debug: Finger Table = \n"+fingerTable);
        }
    }

    private static int createRandomKeyId(UserInput userInput){
        int max = (int) Math.pow(2, userInput.getB());

        int range = max + 1;
        return (int)(Math.random() * range + 1);
    }

    private static Node determineStartNode(HashMap<Integer, Node> nodeObjectsById) {
        Set<Integer> keySet = nodeObjectsById.keySet();
        TreeSet<Integer> sortedKeys = new TreeSet<>(keySet);
        int firstNode = sortedKeys.first();
        int secondNode = sortedKeys.higher(firstNode);
        System.out.println("Debug: Out of "+keySet);
        System.out.println("Debug: firstNode = "+firstNode);
        System.out.println("Debug: secondNode = "+secondNode);

        return nodeObjectsById.get(secondNode);
    }
}
