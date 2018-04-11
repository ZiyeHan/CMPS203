package com.chris.cmps203.homework1;

import static org.junit.Assert.assertTrue;

import com.chris.cmps203.homework1.calculator.Calculator;
import com.chris.cmps203.homework1.expression.AddExpression;
import com.chris.cmps203.homework1.expression.MinusExpression;
import com.chris.cmps203.homework1.expression.MultiplyExpression;
import com.chris.cmps203.homework1.expression.NumberExpression;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for Calculator.
 */
public class CalculatorTest
{

    Calculator calculator;

    @Before
    public void initialize() {
        calculator= new Calculator();
    }

    @Test
    /**
     * AST: null
     */
    public void nullTest()
    {
        try{
            calculator.eval(null);
            assertTrue(false);
        }catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    /**
     * AST: 1 := 1
     */
    public void numberTest()
    {
        try {
            NumberExpression numberExpression = new NumberExpression();
            numberExpression.setNumber(1);
            assertTrue(calculator.eval(numberExpression) == 1);
        }catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    /**
     * AST: 1 + (-3) := -2
     */
    public void addTest()
    {
        try {
            AddExpression addExpression = new AddExpression();
            NumberExpression numberExpression1 = new NumberExpression();
            NumberExpression numberExpression2 = new NumberExpression();
            numberExpression1.setNumber(1);
            numberExpression2.setNumber(-3);
            addExpression.setExpression1(numberExpression1);
            addExpression.setExpression2(numberExpression2);
            assertTrue(calculator.eval(addExpression) == -2);
        }catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    /**
     * AST: 5 - 3 := 2
     */
    public void minusTest()
    {
        try {
            MinusExpression minusExpression = new MinusExpression();
            NumberExpression numberExpression1 = new NumberExpression();
            NumberExpression numberExpression2 = new NumberExpression();
            numberExpression1.setNumber(5);
            numberExpression2.setNumber(3);
            minusExpression.setExpression1(numberExpression1);
            minusExpression.setExpression2(numberExpression2);
            assertTrue(calculator.eval(minusExpression) == 2);
        }catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    /**
     * AST: 3 * 4 := 12
     */
    public void MultiplyTest()
    {
        try {
            MultiplyExpression multiplyExpression = new MultiplyExpression();
            NumberExpression numberExpression1 = new NumberExpression();
            NumberExpression numberExpression2 = new NumberExpression();
            numberExpression1.setNumber(3);
            numberExpression2.setNumber(4);
            multiplyExpression.setExpression1(numberExpression1);
            multiplyExpression.setExpression2(numberExpression2);
            assertTrue(calculator.eval(multiplyExpression) == 12);
        }catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    /**
     * AST: 3 - 4 + 5 := 4
     */
    public void compositeTest1()
    {
        try {
            MinusExpression minusExpression = new MinusExpression();
            AddExpression addExpression = new AddExpression();
            NumberExpression numberExpression1 = new NumberExpression();
            NumberExpression numberExpression2 = new NumberExpression();
            NumberExpression numberExpression3 = new NumberExpression();
            numberExpression1.setNumber(3);
            numberExpression2.setNumber(4);
            numberExpression3.setNumber(5);
            minusExpression.setExpression1(numberExpression1);
            minusExpression.setExpression2(numberExpression2);
            addExpression.setExpression1(minusExpression);
            addExpression.setExpression2(numberExpression3);
            assertTrue(calculator.eval(addExpression) == 4);
        }catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    /**
     * AST: 3 * 4 + 5 := 17
     */
    public void compositeTest2()
    {
        try {
            MultiplyExpression multiplyExpression = new MultiplyExpression();
            AddExpression addExpression = new AddExpression();
            NumberExpression numberExpression1 = new NumberExpression();
            NumberExpression numberExpression2 = new NumberExpression();
            NumberExpression numberExpression3 = new NumberExpression();
            numberExpression1.setNumber(3);
            numberExpression2.setNumber(4);
            numberExpression3.setNumber(5);
            multiplyExpression.setExpression1(numberExpression1);
            multiplyExpression.setExpression2(numberExpression2);
            addExpression.setExpression1(multiplyExpression);
            addExpression.setExpression2(numberExpression3);
            assertTrue(calculator.eval(addExpression) == 17);
        }catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    /**
     * AST: 3 * (4 + 5) := 27
     */
    public void reorderCompositeTest()
    {
        try {
            MultiplyExpression multiplyExpression = new MultiplyExpression();
            AddExpression addExpression = new AddExpression();
            NumberExpression numberExpression1 = new NumberExpression();
            NumberExpression numberExpression2 = new NumberExpression();
            NumberExpression numberExpression3 = new NumberExpression();
            numberExpression1.setNumber(3);
            numberExpression2.setNumber(4);
            numberExpression3.setNumber(5);
            addExpression.setExpression1(numberExpression2);
            addExpression.setExpression2(numberExpression3);
            multiplyExpression.setExpression1(numberExpression1);
            multiplyExpression.setExpression2(addExpression);
            assertTrue(calculator.eval(multiplyExpression) == 27);
        }catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    /**
     * A complex one
     * AST: (3 - 5) * (4 + 5) * 2 - 1 := -37
     */
    public void complexCompositeTest()
    {
        try {
            MinusExpression minusExpression1 = new MinusExpression();
            MultiplyExpression multiplyExpression1 = new MultiplyExpression();
            MultiplyExpression multiplyExpression2 = new MultiplyExpression();
            MinusExpression minusExpression2 = new MinusExpression();
            AddExpression addExpression = new AddExpression();
            NumberExpression numberExpression1 = new NumberExpression();
            NumberExpression numberExpression2 = new NumberExpression();
            NumberExpression numberExpression3 = new NumberExpression();
            NumberExpression numberExpression4 = new NumberExpression();
            NumberExpression numberExpression5 = new NumberExpression();
            NumberExpression numberExpression6 = new NumberExpression();
            numberExpression1.setNumber(3);
            numberExpression2.setNumber(5);
            numberExpression3.setNumber(4);
            numberExpression4.setNumber(5);
            numberExpression5.setNumber(2);
            numberExpression6.setNumber(1);
            minusExpression2.setExpression1(numberExpression1);
            minusExpression2.setExpression2(numberExpression2);
            addExpression.setExpression1(numberExpression3);
            addExpression.setExpression2(numberExpression4);
            multiplyExpression1.setExpression1(minusExpression2);
            multiplyExpression1.setExpression2(addExpression);
            multiplyExpression2.setExpression1(multiplyExpression1);
            multiplyExpression2.setExpression2(numberExpression5);
            minusExpression1.setExpression1(multiplyExpression2);
            minusExpression1.setExpression2(numberExpression6);
            assertTrue(calculator.eval(minusExpression1) == -37);
        }catch (Exception e){
            e.printStackTrace();
            assertTrue(false);
        }
    }


}

