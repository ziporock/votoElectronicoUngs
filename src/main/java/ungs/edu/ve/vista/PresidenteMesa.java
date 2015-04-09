package ungs.edu.ve.vista;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import ungs.edu.ve.controlador.ControladorVotacionImpl;

public class PresidenteMesa extends JFrame {

	/**
	 * 
	 */
	private Button button;
	private JRadioButton radioFianlizado;
	private JRadioButton radioVotando;
	private JRadioButton radioLibre;
	private ControladorVotacionImpl controladorVotacion;

	private static final long serialVersionUID = -3298221097107822223L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PresidenteMesa frame = new PresidenteMesa();
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
	public PresidenteMesa() {
		
		controladorVotacion=new ControladorVotacionImpl();
		
		controladorVotacion.inicializar();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 609, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 0, 371, 159);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTerminal = new JLabel("Terminal 1");
		lblTerminal.setBounds(0, 12, 119, 20);
		panel.add(lblTerminal);

		radioLibre = new JRadioButton("Libre");
		radioLibre.setSelected(true);
		radioLibre.setBounds(10, 40, 69, 23);
		panel.add(radioLibre);

		radioVotando = new JRadioButton("Votando");
		radioVotando.setBounds(97, 40, 94, 23);
		panel.add(radioVotando);

		radioFianlizado = new JRadioButton("Voto Finalizado");
		radioFianlizado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pasarVotoFinalizado();
			}
		});
		radioFianlizado.setBounds(198, 40, 149, 23);
		panel.add(radioFianlizado);

		button = new Button("Generar voto Impreso");
		button.setEnabled(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("generando voto");
				
				try {
					controladorVotacion.habilitarVotante("1");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		button.setBounds(228, 104, 86, 23);
		panel.add(button);

	}

	public void pasarVotoFinalizado() {
		button.setEnabled(true);
	}
}
