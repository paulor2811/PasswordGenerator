package br.com.paulo.passwordgenerator;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Frame {

	private Generator generator = new Generator();
    private JFrame frame;
    private JPanel panel = new JPanel(new GridLayout(2, 1));
    JPanel panelColuna1 = new JPanel(new GridLayout(4, 1));
    JPanel panelColuna2 = new JPanel(new GridLayout(5, 1));
    private JPanel panel2 = new JPanel();
    JCheckBox checkminusculas;
    JCheckBox checkmaiusculas;
    JCheckBox checknumeros;
    JCheckBox checksimbolos;
    
    private String caracteres;
    
    private static final String minusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase();
    private static final String maiusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String simbolos = "!@#$%()[]{}?/|\\";
    private static final String numeros = "0123456789";
    
    private static final String version = "v1.0";

    public void Frame() {
    	
    	frame = new JFrame("PasswordGenerator " + version);
    	
        Border border = BorderFactory.createLineBorder(java.awt.Color.BLACK);
        panel.setBorder(BorderFactory.createCompoundBorder(border, 
          BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        frame.setBounds((int) (Toolkit.getDefaultToolkit().getScreenSize().width/2 - 320),
                (int) (Toolkit.getDefaultToolkit().getScreenSize().height/2 - 240), 640, 480);

        JLabel lbl1 = new JLabel("Número de digitos*");
        JCheckBox checkbox6 = new JCheckBox("6");
        JCheckBox checkbox8 = new JCheckBox("8");
        JCheckBox checkbox16 = new JCheckBox("16");
        
        JLabel lbl2 = new JLabel("Caracteres permitidos");
        checkminusculas = new JCheckBox("Minúsculas");
        checkmaiusculas = new JCheckBox("Maiúsculas");
        checknumeros = new JCheckBox("Números");
        checksimbolos = new JCheckBox("Símbolos");
        
        ButtonGroup group = new ButtonGroup();
        group.add(checkbox6);
        group.add(checkbox8);
        group.add(checkbox16);
        
        panelColuna1.add(lbl1);
        panelColuna1.add(checkbox6);
        panelColuna1.add(checkbox8);
        panelColuna1.add(checkbox16);
        
        panelColuna2.add(lbl2);
        panelColuna2.add(checkminusculas);
        panelColuna2.add(checkmaiusculas);
        panelColuna2.add(checknumeros);
        panelColuna2.add(checksimbolos);
        
        panel.add(panelColuna1, BorderLayout.WEST);
        panel.add(panelColuna2, BorderLayout.EAST);
        
        
        JTextArea textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(this.frame.getWidth(), 30));
        
        panel2.add(textArea);
        
        checkbox6.addActionListener((ActionListener) new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    if(checkbox6.isSelected()){
        	    	if(isEmpty() == 0) {
        	    		isSelected();
        	    		textArea.setText(generator.Generator(6));
        	    	}
        	    }
        	}
        });
        
        checkbox8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    if(checkbox8.isSelected()){
        	    	if(isEmpty() == 0) {
        	    		isSelected();
        	    		textArea.setText(generator.Generator(8));
        	    	}
        	    }
        	}
        });

        checkbox16.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(checkbox16.isSelected()){
        			if(isEmpty() == 0) {
        				isSelected();
        				textArea.setText(generator.Generator(16));
        			}
        		}
        	}
        });
        
        frame.add(panel, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    
    private void isSelected() {
    	caracteres = "";
    	if(checkminusculas.isSelected()) {
    		caracteres += minusculas;
    	}
    	if(checkmaiusculas.isSelected()) {
    		caracteres += maiusculas;
    	}
    	if(checksimbolos.isSelected()) {
    		caracteres += simbolos;
    	}
    	if(checknumeros.isSelected()) {
    		caracteres += numeros;
    	}
    	generator.setCHARS(caracteres);
    }
    private int isEmpty() {
    	if(checkminusculas.isSelected() || checkmaiusculas.isSelected() || checksimbolos.isSelected() || checknumeros.isSelected()) {
    		return 0;
    	} else {
    		JOptionPane.showMessageDialog(null, "Nenhuma opção marcada.", "Alerta", JOptionPane.WARNING_MESSAGE);
    		return 1;
    	}
    }
}
