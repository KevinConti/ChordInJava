package com.conti;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UserInput input = getUserInput();
        //TODO createNodes();
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
}
