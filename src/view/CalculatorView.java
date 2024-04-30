package view;

import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame {
    private JTextField displayField;
    private JButton[] numberButtons;
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton, clearButton;
    private JButton memoryAddButton, memorySubtractButton, memoryRecallButton, memoryClearButton;
    private JButton sqrtButton, squareButton, deleteButton, decimalButton;

    public CalculatorView() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        displayField = new JTextField();
        displayField.setHorizontalAlignment(JTextField.RIGHT);
        add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            buttonPanel.add(numberButtons[i]);
        }

        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        equalsButton = new JButton("=");
        decimalButton = new JButton(".");
        clearButton = new JButton("AC");

        memoryAddButton = new JButton("M+");
        memorySubtractButton = new JButton("M-");
        memoryRecallButton = new JButton("MR");
        memoryClearButton = new JButton("MC");

        sqrtButton = new JButton("Sqrt");
        squareButton = new JButton("x^2");
        deleteButton = new JButton("Del");

        // Add buttons to the panel
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(equalsButton);
        buttonPanel.add(decimalButton);
        buttonPanel.add(sqrtButton);
        buttonPanel.add(squareButton);
        buttonPanel.add(memoryAddButton);
        buttonPanel.add(memorySubtractButton);
        buttonPanel.add(memoryRecallButton);
        buttonPanel.add(memoryClearButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.CENTER);
        pack();  // Size the frame
        setVisible(true);
    }

    public JTextField getDisplayField() {
        return displayField;
    }

    public JButton[] getNumberButtons() {
        return numberButtons;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubtractButton() {
        return subtractButton;
    }

    public JButton getMultiplyButton() {
        return multiplyButton;
    }

    public JButton getDivideButton() {
        return divideButton;
    }

    public JButton getEqualsButton() {
        return equalsButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getMemoryAddButton() {
        return memoryAddButton;
    }

    public JButton getMemorySubtractButton() {
        return memorySubtractButton;
    }

    public JButton getMemoryRecallButton() {
        return memoryRecallButton;
    }

    public JButton getMemoryClearButton() {
        return memoryClearButton;
    }

    public JButton getSqrtButton() {
        return sqrtButton;
    }

    public JButton getSquareButton() {
        return squareButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getDecimalButton() {
        return decimalButton;
    }
}
