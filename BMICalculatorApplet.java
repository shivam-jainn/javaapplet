import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*<applet code="BMICalculatorApplet.class" width="300" height="250">
    </applet>*/

public class BMICalculatorApplet extends Applet implements ActionListener {
    private static final long serialVersionUID = 1L;

    private TextField weightField, heightField, resultField;
    private Button calculateButton;

    public void init() {
        // Set the layout to null for absolute positioning
        setLayout(null);

        Label weightLabel = new Label("Enter Weight (kg):");
        weightLabel.setBounds(20, 20, 120, 20);
        add(weightLabel);

        weightField = new TextField();
        weightField.setBounds(150, 20, 100, 20);
        add(weightField);

        Label heightLabel = new Label("Enter Height (m):");
        heightLabel.setBounds(20, 60, 120, 20);
        add(heightLabel);

        heightField = new TextField();
        heightField.setBounds(150, 60, 100, 20);
        add(heightField);

        calculateButton = new Button("Calculate BMI");
        calculateButton.setBounds(20, 100, 120, 30);
        add(calculateButton);
        calculateButton.addActionListener(this);

        Label resultLabel = new Label("BMI Result:");
        resultLabel.setBounds(20, 150, 120, 20);
        add(resultLabel);

        resultField = new TextField();
        resultField.setBounds(150, 150, 100, 20);
        resultField.setEditable(false);
        add(resultField);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == calculateButton) {
            calculateBMI();
        }
    }

    private void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());

            // Calculate BMI
            double bmi = weight / (height * height);

            // Display BMI
            resultField.setText(String.format("%.2f", bmi));

            // Highlight the result based on BMI categories
            if (bmi < 18.5) {
                resultField.setBackground(Color.YELLOW);
            } else if (bmi >= 18.5 && bmi < 24.9) {
                resultField.setBackground(Color.GREEN);
            } else if (bmi >= 25 && bmi < 29.9) {
                resultField.setBackground(Color.ORANGE);
            } else {
                resultField.setBackground(Color.RED);
            }
        } catch (NumberFormatException e) {
            resultField.setText("Invalid input");
            resultField.setBackground(Color.WHITE);
        }
    }
}