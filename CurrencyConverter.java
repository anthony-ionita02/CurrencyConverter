import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;





/*
 * Anthony Ionita
 * 
 * This program provides a simple GUI that allows users to enter input regarding what currency 
 * they wish to convert USD into. The values converted are based on the conversion rates as of 
 * 04/07/2024. 
 */





public class CurrencyConverter implements ActionListener{
	
	
	JFrame frame;
	JLabel label1;
	JLabel label2;
	JComboBox cb;
	JTextField tf;

	
	public CurrencyConverter() {
		
		frame = new JFrame("Drop down menu example");
		
		label1 = new JLabel();
		label1.setHorizontalAlignment(JLabel.RIGHT);
		label1.setSize(400, 100);
		label2 = new JLabel();
		label2.setHorizontalAlignment(JLabel.LEFT);
		label2.setSize(400, 100);
		label2.setText("Enter the USD amount you wish to convert");
		
		
		JButton b1 = new JButton("Convert");
		b1.setBounds(400, 200, 100, 50);
		b1.addActionListener(this);
		

		tf = new JTextField();
		tf.setPreferredSize(new Dimension(200,35));
		
		
		
		String[] currencies = {"Euro", "GBP", "Yen", "Yuan", "Peso", "Ruble", "Franc", "Bitcoin"}; 
		cb = new JComboBox(currencies);
		cb.setBounds(200, 200, 150, 50);
		frame.add(cb);
		frame.add(b1);
		frame.add(label2);
		frame.add(tf);
		frame.add(label1);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLayout(new FlowLayout()); //see what happens when you set to "flow" instead of null
		frame.setVisible(true);
		
		
    }


  
	public void actionPerformed(ActionEvent e) {
		try {
		String userChoice = (String) cb.getItemAt(cb.getSelectedIndex());
		double amountInput = Double.parseDouble(tf.getText());
		String s = formatMessage(userChoice, amountInput);
		label1.setText(s);
		} 
		catch(NumberFormatException ex) {
			label1.setText("Please enter a numerical value in the text box.");
		}
		
		
		
	}
	
	
	
	
	
    public String formatMessage(String inputCurrency, double amount) {
		
		double rate = 0;
		String currencyName = "";
		String currencySymbol = "";
		
        switch(inputCurrency) {
		
		case "Euro":
			rate = 0.92;
			currencyName = "Euro";
			currencySymbol = "\u20ac";
			break;
		
		case "GBP":
			rate = 0.79;
			currencyName = "Pounds sterling";
			currencySymbol = "\u00a3";
			break;
			
		case "Yen":
			rate = 151.61;
			currencyName = "Japanese Yen";
			currencySymbol = "\u00a5";
			break;
			
		case "Yuan":
			rate = 7.23;
			currencyName = "Chinese Yuan";
			currencySymbol = "\u00a5";
			break;
			
		case "Peso":
			rate = 16.45;
			currencyName = "Mexican Pesos";
			currencySymbol = "\u20b1";
			break;
			
		case "Ruble":
			rate = 92.58;
			currencyName = "Russian Rubles";
			currencySymbol = "\u20bd";
			break;
			
		case "Franc":
			rate = 0.90;
			currencyName = "Swiss Francs";
			currencySymbol = "\u20a3";
			break;
			
		case "Bitcoin":
			rate = 0.000014;
			currencyName = "Bitcoin";
			currencySymbol = "\u20bf";
			break;
			
			
		default:
			return "Invalid entry";

		}
        
        String dollarAmount = Double.toString(amount);
        String convertedAmount = Double.toString(amount * rate);
        
        
        
        try {
        	
            String leftSide = "";
            String rightSide = "";
            
            for(int i = 0; i < dollarAmount.length() - 1 || dollarAmount.charAt(i) == '.'; i++) {
            	if(dollarAmount.charAt(i) == '.') {
        	    	leftSide = dollarAmount.substring(0,i);
        	    	rightSide = dollarAmount.substring(i, i + 3);
        	    }
            }
            	
            
            leftSide = "";
            rightSide = "";
            
            for(int i = 0; i < convertedAmount.length() - 1 || convertedAmount.charAt(i) == '.'; i++) {
            	if(convertedAmount.charAt(i) == '.') {
        	    	leftSide = convertedAmount.substring(0,i);
        	    	rightSide = convertedAmount.substring(i, i + 3);
        	    }
        }
        convertedAmount = leftSide + rightSide;
        }
        catch(Exception e) {
        	
        }
        
        String returnString = "$" + dollarAmount + " in " + currencyName + " is " + currencySymbol + convertedAmount;
        
        return returnString;
}



	
	public static void main(String[] args) {
		
		new CurrencyConverter();
	}
	
}

