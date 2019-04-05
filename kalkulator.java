import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class kalkulator extends JFrame{
	private static JTextField tampilanTextField = new JTextField();

	private static String operant1 = "";
	private static String operant2 = "";
	private static String operatorDipilih = "";
	private boolean setelahOperator = false;

	private JButton tombol1 = new JButton("1");
	private JButton tombol2 = new JButton("2"); 
	private JButton tombolTambah = new JButton("+");
	private JButton tombolSamadengan = new JButton("=");
	private JPanel panel = new JPanel();

	Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();
	private int jml=1;

	kalkulator(){
		super("kalkulator in java");
		panel.setLayout(null);
		setSize(350,200);
		setLocation(dimensi.width/2-getWidth()/2,dimensi.height/2-getHeight()/2);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		tampilanTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
		tampilanTextField.setEditable(false);
		tampilanTextField.setBounds(55,20,200,25);

		tombol1.addActionListener(new TombolHandler());
		tombol2.addActionListener(new TombolHandler());
		tombolTambah.addActionListener(new TombolHandler());
		tombolSamadengan.addActionListener(new TombolHandler());

		panel.add(tampilanTextField);

		panel.add(tombol1);
		panel.add(tombol2);
		panel.add(tombolTambah);
		panel.add(tombolSamadengan);

		getContentPane().add(panel);
		setVisible(true);
	}
	private class TombolHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton tombol = (JButton)e.getSource();

			if (tombol.getText().equals("1")) {
				if (setelahOperator) {tampilanTextField.setText("1");
				} else{
					tampilanTextField.setText(tampilanTextField.getText()+"1");
				}
				setelahOperator=false;
			}else if (tombol.getText().equals("2")){
				if (setelahOperator) {
					tampilanTextField.setText("2");
				}else {
					tampilanTextField.setText(tampilanTextField.getText()+"2");
				}
				setelahOperator = false;

			}else if (tombol.getText().equals("+")) {
				operatorDipilih = "+";
				setelahOperator = true;
		
			}else if (tombol.getText().equals("=")) {
				operant2 = tampilanTextField.getText();

				double operantPertama = 0;
				double operantKedua = 0;

				try{
					operantPertama = Double.parseDouble(operant1);
				}catch (Exception ex) {
				}

				try{
					operantKedua = Double.parseDouble(operant2);
				}catch (Exception ex) {
				}

				if (operatorDipilih == "+") {
					tampilanTextField.setText(Double.toString(operantPertama+operantKedua));
					
				}
				
			}
		}
	}
  public static void main(String args[]){
  	kalkulator kalkulator = new kalkulator();
  }

 }