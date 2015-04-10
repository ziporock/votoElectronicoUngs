package ungs.edu.ve.vista;

import java.awt.Checkbox;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class PantallaVotanteSeleccionLista extends JFrame {

	private JPanel contentPane;
	private static PantallaVotanteSeleccionLista frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new PantallaVotanteSeleccionLista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaVotanteSeleccionLista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String mensajeImportante = "Importante \n\nEl Sistema admite:\n\nVoto en Blanco, \nNo selecciona ninguna lista."
				+ "\n\nVOTO IMPUGNADO, \n Seleccionando mas de dos listas \n\n Se permite la eleccion de una o hasta"
				+ "dos listas como maximo";

		JTextPane textPane = new JTextPane();
		textPane.setText(mensajeImportante);
		textPane.setBounds(12, 12, 126, 225);
		contentPane.add(textPane);

		Checkbox checkbox = new Checkbox("Lista 1");
		checkbox.setBounds(170, 12, 115, 23);
		contentPane.add(checkbox);

		Checkbox checkbox_1 = new Checkbox("Lista 2");
		checkbox_1.setBounds(170, 41, 115, 23);
		contentPane.add(checkbox_1);

		Checkbox checkbox_2 = new Checkbox("Lista 3");
		checkbox_2.setBounds(170, 70, 115, 23);
		contentPane.add(checkbox_2);

		Checkbox checkbox_3 = new Checkbox("Lista 4");
		checkbox_3.setBounds(170, 99, 115, 23);
		contentPane.add(checkbox_3);

		Checkbox checkbox_4 = new Checkbox("Lista 5");
		checkbox_4.setBounds(170, 128, 115, 23);
		contentPane.add(checkbox_4);

		Checkbox checkbox_5 = new Checkbox("Lista 6");
		checkbox_5.setBounds(170, 159, 115, 23);
		contentPane.add(checkbox_5);

		JButton btnVotar = new JButton("Votar");
		btnVotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PopupConfirmacionVoto popupConfirmacionVoto = new PopupConfirmacionVoto();
				popupConfirmacionVoto.setVisible(true);
			}
		});
		btnVotar.setBounds(319, 223, 117, 25);
		contentPane.add(btnVotar);
	}

	public static void cerrar() {
		frame.setVisible(false);
	}
}
