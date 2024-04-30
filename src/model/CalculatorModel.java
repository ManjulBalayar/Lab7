package model;

public class CalculatorModel {
    private double memory = 0.0;

    public double calculate(double operand1, double operand2, String operator) {
        try {
            switch (operator) {
                case "+": return operand1 + operand2;
                case "-": return operand1 - operand2;
                case "*": return operand1 * operand2;
                case "/":
                    if (operand2 == 0) throw new ArithmeticException("Cannot divide by zero.");
                    return operand1 / operand2;
                default: throw new IllegalArgumentException("Invalid operator.");
            }
        } catch (ArithmeticException e) {
            // Log error or handle it as necessary
            throw e; // Rethrowing to allow the controller to handle it
        } catch (Exception e) {
            // Catching any other unexpected errors
            throw new RuntimeException("Error performing calculation: " + e.getMessage());
        }
    }

    public void addToMemory(double value) {
        try {
            memory += value;
        } catch (Exception e) {
            throw new RuntimeException("Error adding to memory: " + e.getMessage());
        }
    }

    public void subtractFromMemory(double value) {
        try {
            memory -= value;
        } catch (Exception e) {
            throw new RuntimeException("Error subtracting from memory: " + e.getMessage());
        }
    }

    public double getMemory() {
        try {
            return memory;
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving memory: " + e.getMessage());
        }
    }

    public void clearMemory() {
        try {
            memory = 0.0;
        } catch (Exception e) {
            throw new RuntimeException("Error clearing memory: " + e.getMessage());
        }
    }
}
