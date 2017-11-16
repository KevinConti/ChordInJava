package com.conti;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInputTest {
    @Test
    void whenTwoNumbersAreInputTheProperObjectIsCreated(){
        UserInput input = new UserInput(4,5);
        assertEquals(4, input.getB());
        assertEquals(5, input.getN());
    }

    @Test
    void whenNIsTooLargeVerifyInputFails(){
        UserInput input = new UserInput(3, 100);
        assertFalse(input.verifyInput(), "Expected false");
    }

}