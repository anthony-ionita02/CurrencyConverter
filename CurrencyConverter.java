import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
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
		label2.setText("Enter the USD amount you wish to convert:    $");
		
		
		JButton b1 = new JButton("Convert");
		b1.setBounds(400, 200, 100, 50);
		b1.addActionListener(this);
		

		tf = new JTextField();
		tf.setPreferredSize(new Dimension(200,35));
		
		
		
		String[] currencies = {"Bitcoin", "Euro", "Franc", "GBP", "Lira", "Peso", "Ruble", "Rupee", "Won", "Yen", "Yuan"}; 
		cb = new JComboBox(currencies);
		cb.setBounds(200, 200, 150, 50);
		frame.add(label2);
		frame.add(tf);
		frame.add(cb);
		frame.add(b1);
		frame.add(label1);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLayout(new FlowLayout()); 
		frame.setVisible(true);
		
		
    }


  
	public void actionPerformed(ActionEvent e) {
		try {
		String userChoice = (String) cb.getItemAt(cb.getSelectedIndex());
		String amountInput = tf.getText();
		String newString = "";
		
		for(int i = 0; i < amountInput.length(); i++) {
			if(amountInput.charAt(i) == ',' || amountInput.charAt(i) == '$') {
				continue;
			}
			newString = newString + amountInput.charAt(i);
		}
		
		double amountInputDouble = Double.parseDouble(newString);
		String s = formatMessage(userChoice, amountInputDouble);
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
			
		case "Won":
			rate = 1354.61;
			currencyName = "South Korean Won";
			currencySymbol = "\u20a9";
			break;
			
		case "Rupee":
			rate = 88.33;
			currencyName = "Indian Rupee";
			currencySymbol = "\uu20a8";
			break;
			
		case "Lira":
			rate = 32.16;
			currencyName = "Turkish Lira";
			currencySymbol = "\u20a4";
			break;
			
			
		default:
			return "Invalid entry";

		}
        
        double amountRounded = Math.round(amount * 100) / 100.00;
        double convertedAmountRounded = Math.round(amount * rate * 100) / 100.00;
        String dollarAmount = Double.toString(amountRounded); 
        String convertedAmount = Double.toString(convertedAmountRounded);
        
        
        
        return "$" + dollarAmount + " in " + currencyName + " is " + currencySymbol + convertedAmount; 
}



	
	public static void main(String[] args) {
		
		new CurrencyConverter();
		
	}
	
}

