package com.chris.cmps203.homework1.expression;

/**
 * The Minus expression of Arith expression
 */

public class MinusExpression extends AbstractArithExpression{

    private AbstractArithExpression expression1;
    private AbstractArithExpression expression2;

    public AbstractArithExpression getExpression1() {
        return expression1;
    }

    public void setExpression1(AbstractArithExpression expression) {
        this.expression1 = expression;
    }

    public AbstractArithExpression getExpression2() {
        return expression2;
    }

    public void setExpression2(AbstractArithExpression expression) {
        this.expression2 = expression;
    }

    public int execute() {
        return this.getExpression1().execute() - this.getExpression2().execute();
    }


}
