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
        //1) n cannot be greater than 2^b
        //returns a boolean on whether or not it passes the input test
        int maxValue = (int) Math.pow(2, this.getB());
        boolean nIsWithinRange = this.getN() <= maxValue;
        return nIsWithinRange;
    }
}
