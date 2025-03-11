import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * The VATCalculator class inputs an amount of money without VAT from
 * one text field and outputs the amount with VAT to the other text field.
 */
public class VATCalculator implements ActionListener
{
    private JTextField withoutVATTextField;
    private JTextField withVATTextField;
    private JButton addVATButton;
    private JButton addDollarsButton;
    private JButton addEurosButton;
    private JButton clearButton;
    private JFrame frame;
    private static final double VAT_PERCENTAGE = 20.0;
        
    public JLabel label;
    private JLabel EurosDollars;

    /**
     * The GUI is created in the constructor.
     */ 
    public VATCalculator()
    {
        frame = new JFrame("VAT Calculator");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());
        
        label = new JLabel("Pounds");
        contentPane.add(label);
        
        withoutVATTextField = new JTextField(15);
        contentPane.add(withoutVATTextField);   
        
        addEurosButton = new JButton("Euros");
        contentPane.add(addEurosButton);
        addEurosButton.addActionListener(this);  
        
        addDollarsButton = new JButton("Dollars");
        contentPane.add(addDollarsButton);
        addDollarsButton.addActionListener(this);
        
        clearButton = new JButton("Clear");
        contentPane.add(clearButton);
        clearButton.addActionListener(this);
        
        EurosDollars = new JLabel("Euros/dollars");
        contentPane.add(EurosDollars);
        
        withVATTextField = new JTextField(15);
        contentPane.add(withVATTextField);        
        
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * The main method allows the program to be run without BlueJ.
     */ 
    public static void main(String[] args)
    {
        VATCalculator calculator = new VATCalculator();
    }

    /**
     * Find which button triggered the event and call the appropriate method.
     */
    public void actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();
        if (command.equals("Add VAT")) {
            addVAT();
        }
        if (command.equals("Clear")) {
            clear();
        }
    }
    
    /**
     * Input the amount of money from the first text field.
     */ 
    public double getAmountWithoutVAT()
    {
        double amountWithoutVAT
                = Double.parseDouble(withoutVATTextField.getText());
        return amountWithoutVAT;
    }

    /**
     * Add VAT and output to the second textfield.
     */ 
    public void addVAT()
    {
        double amountWithVAT 
                = (1.0 + VAT_PERCENTAGE/100.0) * getAmountWithoutVAT();
        withVATTextField.setText("" + amountWithVAT);
    }
    
    /**
     * Clear both textfields.
     */      
    public void clear()
    {
        withoutVATTextField.setText("");
        withVATTextField.setText("");
    }
}