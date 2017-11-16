package com.conti;


class UserInput {
    private int b;
    private int n;

    UserInput(int b, int n) {
        this.b = b;
        this.n = n;
    }

    int getB() {
        return b;
    }

    int getN() {
        return n;
    }

    boolean verifyInput(){
        //Checks the following requirements:
        //1) n cannot be greater than 2^b
        //returns a boolean on whether or not it passes the input test
        int maxValue = (int) Math.pow(2, this.getB());
        boolean nIsWithinRange = this.getN() <= maxValue;
        return nIsWithinRange;
    }
}
