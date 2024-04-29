package view;

import javax.swing.*;

import model.CalculatorModel;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class CalculatorView extends JFrame implements Observer {
    private final JTextField displayField;
    private final CalculatorModel model;

    public CalculatorView(CalculatorModel model) {
        this.model = model;
        this.model.addObserver(this);

        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new BorderLayout());

        displayField = new JTextField();
        displayField.setEditable(false);
        add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));
        String[] buttons = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};
        for (String b : buttons) {
            JButton button = new JButton(b);
            button.addActionListener(e -> model.performOperation(Double.parseDouble(displayField.getText()), b));
            buttonPanel.add(button);
        }
        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        displayField.setText(arg.toString());
    }
}

