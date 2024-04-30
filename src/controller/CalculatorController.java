package controller;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.CalculatorModel;
import view.CalculatorView;

public class CalculatorController {
    private CalculatorView view;
    private CalculatorModel model;
    private String currentOperation;
    private double currentOperand;

    public CalculatorController(CalculatorView view, CalculatorModel model) {
        this.view = view;
        this.model = model;
        this.initController();
    }

    private void initController() {
        // Number buttons
        for (JButton button : view.getNumberButtons()) {
            button.addActionListener(e -> appendNumber(e.getActionCommand()));
        }

        // Operation buttons
        view.getAddButton().addActionListener(e -> setOperation("+"));
        view.getSubtractButton().addActionListener(e -> setOperation("-"));
        view.getMultiplyButton().addActionListener(e -> setOperation("*"));
        view.getDivideButton().addActionListener(e -> setOperation("/"));
        view.getSqrtButton().addActionListener(e -> performSingleOperandOperation("sqrt"));
        view.getSquareButton().addActionListener(e -> performSingleOperandOperation("sq"));

        // Memory buttons
        view.getMemoryAddButton().addActionListener(e -> updateMemory(1));
        view.getMemorySubtractButton().addActionListener(e -> updateMemory(-1));
        view.getMemoryRecallButton().addActionListener(e -> recallMemory());
        view.getMemoryClearButton().addActionListener(e -> clearMemory());

        // Other controls
        view.getEqualsButton().addActionListener(e -> computeResult());
        view.getClearButton().addActionListener(e -> clearAll());
        view.getDeleteButton().addActionListener(e -> deleteLastCharacter());
        view.getDecimalButton().addActionListener(e -> appendDecimal());
    }

    private void appendNumber(String number) {
        try {
            String currentDisplay = view.getDisplayField().getText();
            view.getDisplayField().setText(currentDisplay + number);
        } catch (Exception e) {
            view.getDisplayField().setText("Error appending number");
        }
    }

    private void setOperation(String operator) {
        try {
            currentOperand = Double.parseDouble(view.getDisplayField().getText());
            currentOperation = operator;
            view.getDisplayField().setText("");
        } catch (NumberFormatException e) {
            view.getDisplayField().setText("Invalid number");
        }
    }

    private void computeResult() {
        double secondOperand = Double.parseDouble(view.getDisplayField().getText());
        try {
            double result = model.calculate(currentOperand, secondOperand, currentOperation);
            view.getDisplayField().setText(String.valueOf(result));
            currentOperand = result;  // Update the current operand for continued operations
        } catch (IllegalArgumentException e) {
            view.getDisplayField().setText("Error");
            currentOperation = "";  // Reset the operation on error
        }
    }

    private void performSingleOperandOperation(String operation) {
        try {
            double operand = Double.parseDouble(view.getDisplayField().getText());
            double result = switch (operation) {
                case "sqrt" -> {
                    if (operand < 0) throw new IllegalArgumentException("Cannot take sqrt of negative number");
                    yield Math.sqrt(operand);
                }
                case "sq" -> operand * operand;
                default -> throw new UnsupportedOperationException("Unsupported operation");
            };
            view.getDisplayField().setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            view.getDisplayField().setText("Invalid number");
        } catch (IllegalArgumentException | UnsupportedOperationException e) {
            view.getDisplayField().setText(e.getMessage());
        }
    }

    private void updateMemory(double multiplier) {
        try {
            double value = Double.parseDouble(view.getDisplayField().getText());
            if (multiplier == 1) {
                model.addToMemory(value);
            } else if (multiplier == -1) {
                model.subtractFromMemory(value);
            }
        } catch (NumberFormatException e) {
            view.getDisplayField().setText("Invalid input");
        } catch (Exception e) {
            view.getDisplayField().setText("Error in memory operation: " + e.getMessage());
        }
    }

    private void recallMemory() {
        try {
            double memoryValue = model.getMemory();
            view.getDisplayField().setText(String.valueOf(memoryValue));
        } catch (Exception e) {
            view.getDisplayField().setText("Error recalling memory");
        }
    }

    private void clearAll() {
        try {
            view.getDisplayField().setText("");
            currentOperation = null;
            currentOperand = 0;
            model.clearMemory();
        } catch (Exception e) {
            view.getDisplayField().setText("Error clearing calculator");
        }
    }

    private void deleteLastCharacter() {
        try {
            String currentText = view.getDisplayField().getText();
            if (!currentText.isEmpty()) {
                view.getDisplayField().setText(currentText.substring(0, currentText.length() - 1));
            }
        } catch (Exception e) {
            view.getDisplayField().setText("Error deleting character");
        }
    }

    private void appendDecimal() {
        try {
            String currentDisplay = view.getDisplayField().getText();
            if (!currentDisplay.contains(".")) {
                view.getDisplayField().setText(currentDisplay + ".");
            }
        } catch (Exception e) {
            view.getDisplayField().setText("Error appending decimal");
        }
    }
    
    private void clearMemory() {
        try {
            model.clearMemory();
            view.getDisplayField().setText("");  
        } catch (Exception e) {
            view.getDisplayField().setText("Error clearing memory");
        }
    }

}
