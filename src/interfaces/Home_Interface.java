package interfaces;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionListener;

public class Home_Interface extends JFrame {

    private JFrame frame;
    private JPanel mainPanel;
    private JPanel btnPanel;
    private JPanel editPanel;
    private JPanel conNamePanel;
    private JPanel conPanel;
    private JPanel resultSec;

    private JButton[] btnMain;
    private JButton calculate;

    private JLabel conName;
    private JLabel toLbl;
    private JLabel fromLbl;

    private JComboBox<String> fromUnit;
    private JComboBox<String> toUnit;

    private JTextField inputVal;
    private JTextField resultText;

    public static void main(String[] args) {
        Home_Interface hm = new Home_Interface();
        hm.createMainLayout();
    }

    private void createMainLayout() {

        String[] mainButtonTexts = {"Temperature", "Length", "Area", "Volume", "Weight"};

        frame = new JFrame("Unit Converter");

        mainPanel = new JPanel();
        btnPanel = new JPanel();
        editPanel = new JPanel();
        conNamePanel = new JPanel();
        conPanel = new JPanel();
        resultSec = new JPanel();

        btnMain = new JButton[5];
        calculate = new JButton("Calculate");

        conName = new JLabel("Conversion Name", SwingConstants.CENTER);
        fromLbl = new JLabel("From :", SwingConstants.CENTER);
        toLbl = new JLabel("To :", SwingConstants.CENTER);

        fromUnit = new JComboBox<>();
        toUnit = new JComboBox<>();

        inputVal = new JTextField();
        resultText = new JTextField();

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        btnPanel.setLayout(new GridLayout(5,1,5,5));
        btnPanel.setBorder(BorderFactory.createTitledBorder("Conversion"));

        editPanel.setLayout(new GridLayout(3,1,5,5));
        editPanel.setBorder(BorderFactory.createTitledBorder("Edit"));

        conNamePanel.setLayout(new GridLayout(2,1));

        conPanel.setLayout(new GridLayout(2,2,5,5));

        resultSec.setLayout(new GridLayout(2,1));

        conName.setSize(200,20);
        conName.setPreferredSize(new Dimension(500,20));

        inputVal.setPreferredSize(new Dimension(500, 20));
        inputVal.setHorizontalAlignment(JTextField.RIGHT);

        resultText.setPreferredSize(new Dimension(500,20));
        resultText.setEditable(false);
        resultText.setFont(new Font("Times New Roman", Font.BOLD, 15));
        resultText.setHorizontalAlignment(JTextField.CENTER);

        String[] f = {"Select a Conversion"};
        DefaultComboBoxModel<String> first = new DefaultComboBoxModel<>(f);
        fromUnit.setModel(first);
        toUnit.setModel(first);

        ActionListener listener = e -> {
            if(e.getSource() instanceof JButton) {
                String conversion = ((JButton) e.getSource()).getText();
                String[] unitList = getUnitList(conversion);
                DefaultComboBoxModel<String> modelFrom = new DefaultComboBoxModel<>(unitList);
                DefaultComboBoxModel<String> modelTo = new DefaultComboBoxModel<>(unitList);
                fromUnit.setModel(modelFrom);
                toUnit.setModel(modelTo);
                conName.setText(conversion);
            }
        };

        ActionListener calculateListener = e -> {
            if(e.getSource() instanceof JButton) {
                try {
                    String conversion = conName.getText();
                    String from = fromUnit.getSelectedItem().toString();
                    String to = toUnit.getSelectedItem().toString();
                    double value = Double.parseDouble(inputVal.getText());
                    Calculation obj = new Calculation();
                    double result = obj.calculate(value, from, to, conversion);
                    resultText.setText(String.format("%.3f", result));
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        };

        for(int i = 0; i < 5; i++){
            btnMain[i] = new JButton(mainButtonTexts[i]);
            btnMain[i].setMargin(new Insets(10,10,10,10));
            btnMain[i].addActionListener(listener);
            btnPanel.add(btnMain[i]);
        }
        calculate.addActionListener(calculateListener);

        conNamePanel.add(conName, BorderLayout.CENTER);
        conNamePanel.add(inputVal,BorderLayout.SOUTH);

        conPanel.add(fromLbl);
        conPanel.add(toLbl);
        conPanel.add(fromUnit, BorderLayout.WEST);
        conPanel.add(toUnit, BorderLayout.EAST);

        resultSec.add(resultText, BorderLayout.CENTER);
        resultSec.add(calculate, BorderLayout.CENTER);

        editPanel.add(conNamePanel, BorderLayout.NORTH);
        editPanel.add(conPanel,BorderLayout.CENTER);
        editPanel.add(resultSec, BorderLayout.SOUTH);

        mainPanel.add(btnPanel, BorderLayout.WEST);
        mainPanel.add(editPanel, BorderLayout.EAST);
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    private String[] getUnitList(String conversion) {
        switch (conversion) {
            case "Temperature":
                String[] Temperature = {"Celsius", "Fahrenheit", "Kelvin"};
                return Temperature;
            case "Length":
                String[] Length = {"Meter", "Kilometer", "Miles"};
                return Length;
            case "Area":
                String[] Area = {"Perch", "Rood", "Acre", "Hectare"};
                return Area;
            case "Volume":
                String[] Volume = {"Cubic Decimeter", "Cubic Meter", "Liter"};
                return Volume;
            case "Weight":
                String[] Weight = {"Pound", "Ounce", "Kilogram"};
                return Weight;
            default:
                String[] non = {"non"};
                return non;
        }
    }
}
