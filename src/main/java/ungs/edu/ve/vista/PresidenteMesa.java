package ungs.edu.ve.vista;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ungs.edu.ve.controlador.ControladorVotacion;
import ungs.edu.ve.controlador.ValidadorVotante;
import ungs.edu.ve.modelo.dao.impl.EstadoDAOImpl;
import ungs.edu.ve.modelo.dao.impl.VotanteDAOImpl;
import ungs.edu.ve.modelo.dao.impl.VotanteDAOImplMock;

public class PresidenteMesa extends JFrame {

	/**
	 * 
	 */
	private Button button;
	private JRadioButton radioFianlizado;
	private JRadioButton radioVotando;
	private JRadioButton radioLibre;
	private ControladorVotacion controladorVotacion;

	private static final long serialVersionUID = -3298221097107822223L;
	private JPanel contentPane;
	private JTextField documento;

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
		
		controladorVotacion=new ControladorVotacion();
		VotanteDAOImpl votanteDAOImpl=new VotanteDAOImpl();
		EstadoDAOImpl estadoDAOImpl=new EstadoDAOImpl();
		ValidadorVotante validadorVotante=new ValidadorVotante();
		validadorVotante.setVotanteDAO(votanteDAOImpl);
		controladorVotacion.setValidador(validadorVotante);
		controladorVotacion.setEstadoDAO(estadoDAOImpl);
		controladorVotacion.setVotanteDAO(votanteDAOImpl);
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
				controladorVotacion.cerrarVoto(documento.getText());
				button.setEnabled(false);
				
			}
		});
		button.setBounds(228, 104, 86, 23);
		panel.add(button);
		
		documento = new JTextField();
		documento.setBounds(29, 194, 245, 60);
		contentPane.add(documento);
		documento.setColumns(10);
		
		JButton btnHabilitar = new JButton("Habilitar");
		btnHabilitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controladorVotacion.habilitarVotante(documento.getText());
					radioLibre.setSelected(false);
					radioFianlizado.setSelected(true);
					button.setEnabled(true);
					
				} catch (Exception error) {
					PantallaError pantallaError=new PantallaError(error.getMessage());
					pantallaError.setVisible(true);
				}
			}
		});
		btnHabilitar.setBounds(436, 254, 117, 25);
		contentPane.add(btnHabilitar);

	}

	public void pasarVotoFinalizado() {
		button.setEnabled(true);
	}
}
