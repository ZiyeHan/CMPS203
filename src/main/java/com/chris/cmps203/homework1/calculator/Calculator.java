package com.chris.cmps203.homework1.calculator;

import com.chris.cmps203.homework1.expression.AbstractArithExpression;

/**
 * The calculator tool class, used directly by users.
 */

public class Calculator {

    /**
     * Calculate result of the expression
     * @param inputExpression
     * @return execution result of the expression
     */
    public int eval(AbstractArithExpression inputExpression) throws Exception{
        if(inputExpression == null){
            throw new Exception("Input expression can not be null");
        }
        try{
            return inputExpression.execute();
        }catch(Exception e){
            throw new Exception("Error during expression execution");
        }
    }

}

