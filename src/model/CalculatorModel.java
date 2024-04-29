package model;

import java.util.Observable;

public class CalculatorModel extends Observable {
    private double currentValue = 0.0;
    private double memory = 0.0;

    public void performOperation(double value, String operator) {
        switch (operator) {
            case "+":
                currentValue += value;
                break;
            case "-":
                currentValue -= value;
                break;
            case "*":
                currentValue *= value;
                break;
            case "/":
                if (value == 0) {
                    setChanged();
                    notifyObservers("Error: Division by Zero");
                    return;
                }
                currentValue /= value;
                break;
            case "sqrt":
                currentValue = Math.sqrt(value);
                break;
            case "sqr":
                currentValue = value * value;
                break;
            case "M+":
                memory += currentValue;
                break;
            case "M-":
                memory -= currentValue;
                break;
            case "MC":
                memory = 0;
                break;
            case "MR":
                currentValue = memory;
                break;
        }
        setChanged();
        notifyObservers(currentValue);
    }

    public void clear() {
        currentValue = 0.0;
        setChanged();
        notifyObservers(currentValue);
    }
}
