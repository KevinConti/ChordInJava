package com.conti;


public class UserInput {
    private int b;
    private int n;

    public UserInput(int b, int n) {
        this.b = b;
        this.n = n;
    }

    public int getB() {
        return b;
    }

    public int getN() {
        return n;
    }

    public boolean verifyInput(){
        //Checks the following requirements:
        //1) 5 <= n <= 15
        //2) 5 <= B <= 10
        boolean nIsWithinRange = this.getN() <= 15 && this.getN() >= 5;
        boolean bIsWithinRange = this.getB() <= 10 && this.getB() >= 5;
        return (nIsWithinRange && bIsWithinRange);
    }
}
