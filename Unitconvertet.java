import javax.swing.*;
import java. awt.*;
import java.awt.event.*;


public class Unitconvertet extends JFrame{
   private JComboBox<String> typeBox;
   private JTextField inpuTextField;
   private JLabel resultLabel;
 

public Unitconvertet(){
 setTitle("Unit converter"); 
 setSize(400,200);
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setLayout(new GridLayout(4,1));  

 String[]types = {"Meters to Feet", "Feet to Meters", "Celsius to Fahrenheit", "Fahrenheit to Celsius", "Kg to Pounds", "Pounds to Kg"};
 typeBox =new JComboBox<>(types);
 inpuTextField = new JTextField();
 JButton convertBtn = new JButton("convert");
 resultLabel = new JLabel("Result:", JLabel.CENTER);

 convertBtn.addActionListener(e -> convert());

 add(typeBox);
 add(inpuTextField);
 add(convertBtn);
 add(resultLabel);

 setVisible(true);
}

private void convert(){
    try{
        double input = Double.parseDouble(inpuTextField.getText());
        String type = (String)typeBox.getSelectedItem();
        double res =0;
        
        switch(type){
            case "Meters to Feet":
            res = input * 3.281;
            break;
            case "Feet to Meters":
            res = input / 3.281;
            break;
            case "Celsius to Fahrenheit":
            res = (input * 9/5) + 32;
            break;
            case "Fahrenheit to Celsius":
            res = (input - 32) * 5/9;
            break;
            case "Kg to Pounds":
            res = input * 2.205;
            break;
            case "Pounds to Kg":
            res = input / 2.205;
            break;
        }
        resultLabel.setText("Result: " + res);
    }catch(NumberFormatException ex){
        resultLabel.setText("Invalid input");
    }

}
public static void main(String[] args) {
   SwingUtilities.invokeLater(Unitconvertet::new); 
}
}