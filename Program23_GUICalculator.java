// Program 23: Write a program that works as a simple calculator. Use a Grid Layout to arrange
// Buttons for digits and for the + - * % operations. Add a text field to display the result.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Program23_GUICalculator extends JFrame implements ActionListener {
    private JTextField display;
    private String currentInput = "";
    private String operator = "";
    private double firstNumber = 0;
    private boolean operatorPressed = false;
    
    public Program23_GUICalculator() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Display field
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setText("0");
        add(display, BorderLayout.NORTH);
        
        // Button panel with GridLayout
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        
        // Button labels
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "CE", "%", "√"
        };
        
        // Create and add buttons
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            buttonPanel.add(button);
        }
        
        add(buttonPanel, BorderLayout.CENTER);
        
        setSize(400, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.matches("[0-9]")) {
            // Number button pressed
            if (operatorPressed) {
                currentInput = "";
                operatorPressed = false;
            }
            currentInput += command;
            display.setText(currentInput);
        } else if (command.equals(".")) {
            // Decimal point
            if (!currentInput.contains(".")) {
                currentInput += ".";
                display.setText(currentInput);
            }
        } else if (command.matches("[+\\-*/%]")) {
            // Operator pressed
            if (!currentInput.isEmpty()) {
                if (!operator.isEmpty()) {
                    calculate();
                } else {
                    firstNumber = Double.parseDouble(currentInput);
                }
                operator = command;
                operatorPressed = true;
            }
        } else if (command.equals("=")) {
            // Equals button
            if (!operator.isEmpty() && !currentInput.isEmpty()) {
                calculate();
                operator = "";
            }
        } else if (command.equals("C")) {
            // Clear all
            currentInput = "";
            firstNumber = 0;
            operator = "";
            display.setText("0");
        } else if (command.equals("CE")) {
            // Clear entry
            currentInput = "";
            display.setText("0");
        } else if (command.equals("√")) {
            // Square root
            if (!currentInput.isEmpty()) {
                double num = Double.parseDouble(currentInput);
                if (num >= 0) {
                    double result = Math.sqrt(num);
                    display.setText(String.valueOf(result));
                    currentInput = String.valueOf(result);
                } else {
                    display.setText("Error");
                    currentInput = "";
                }
            }
        }
    }
    
    private void calculate() {
        if (currentInput.isEmpty()) return;
        
        double secondNumber = Double.parseDouble(currentInput);
        double result = 0;
        
        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    display.setText("Error");
                    currentInput = "";
                    operator = "";
                    return;
                }
                break;
            case "%":
                result = firstNumber % secondNumber;
                break;
        }
        
        // Format result
        if (result == (long) result) {
            display.setText(String.valueOf((long) result));
            currentInput = String.valueOf((long) result);
        } else {
            display.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
        }
        
        firstNumber = result;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Program23_GUICalculator();
            }
        });
    }
}

