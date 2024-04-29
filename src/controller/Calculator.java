package controller;

import model.CalculatorModel;
import view.CalculatorView;

public class Calculator {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        new CalculatorView(model);
    }
}
