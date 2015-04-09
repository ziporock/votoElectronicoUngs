package ungs.edu.ve.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import ungs.edu.ve.controlador.ControladorResultadosVotacion;

public class ResultadoVotacionView {

	private JFrame frame;
	private ControladorResultadosVotacion controladorResultadosVotacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultadoVotacionView window = new ResultadoVotacionView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResultadoVotacionView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		controladorResultadosVotacion=new ControladorResultadosVotacion();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGanador = new JLabel("GANADOR");
		lblGanador.setBounds(182, 12, 87, 15);
		frame.getContentPane().add(lblGanador);
		
			
		JTextPane listaGanadoraText = new JTextPane();
		listaGanadoraText.setBounds(160, 28, 116, 33);
		listaGanadoraText.setText(controladorResultadosVotacion.getGanador().getNombre());
		listaGanadoraText.setEditable(false);
		frame.getContentPane().add(listaGanadoraText);
		
		JLabel lblResultados = new JLabel("Resultados");
		lblResultados.setBounds(182, 82, 87, 15);
		frame.getContentPane().add(lblResultados);
		
		JTextPane resultadosTotales = new JTextPane();
		resultadosTotales.setBounds(112, 109, 243, 117);
		resultadosTotales.setText(controladorResultadosVotacion.getResultados());
		resultadosTotales.setEditable(false);
		frame.getContentPane().add(resultadosTotales);
		
	
	}
}
