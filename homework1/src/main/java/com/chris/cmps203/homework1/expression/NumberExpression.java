package com.chris.cmps203.homework1.expression;

/**
 * The Number expression of Arith expression
 */

public class NumberExpression extends AbstractArithExpression{

    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int execute() {
        return this.getNumber();
    }
}

