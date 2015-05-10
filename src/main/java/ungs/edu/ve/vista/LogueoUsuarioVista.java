package ungs.edu.ve.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ungs.edu.ve.controlador.ControladorLogueoUsuarios;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogueoUsuarioVista {
	private static JPanel panel_1;
	private static ControladorLogueoUsuarios controladorLogueoUsuarios;
	
	public static void main(String[] args) {
		controladorLogueoUsuarios=new ControladorLogueoUsuarios();
		JFrame frame = new JFrame("VE- LOGUEO");
		frame.setSize(300, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1);
		placeComponents(panel_1);

		frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {
		
		panel_1.setLayout(null);
		JLabel userLabel = new JLabel("Usuario");
		userLabel.setBounds(10, 10, 80, 25);
		panel.add(userLabel);

		final JTextField userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		panel.add(userText);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10, 40, 80, 25);
		panel.add(passwordLabel);

		final JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		panel.add(passwordText);

		JButton loginButton = new JButton("Ingresar");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String usuario=userText.getText();
			String pass=passwordText.getText();
			controladorLogueoUsuarios.ingresarUsuario(usuario,pass );
			}
		});
		loginButton.setBounds(10, 86, 119, 25);
		
		panel.add(loginButton);

	
	}

}
