package pl.edu.ug.tent.springweb;

import java.util.List;

public class Operation {
    private float a;
    private float b;
    private char operator;
    private float result = 0;

    public Operation() {

    }

    public void setA(float a) {
        this.a = a;
    }

    public void setB(float b) {
        this.b = b;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public String Calc() {
        switch (operator) {
            case '+':
                this.result = a + b;
                break;
            case '-':
                this.result = a - b;
                break;
            case '*':
                this.result = a * b;
                break;
            case '/': {
                if (b == 0)
                    return "YouCantDivideBy0";
                else
                    this.result = a / b;
            }
        }
        return Float.toString(result);
    }

    @Override
    public String toString() {
        return a + " " + operator + " " + b + " = " + result;
    }
}
