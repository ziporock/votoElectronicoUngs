package ungs.edu.ve.vista;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;

import ungs.edu.ve.controlador.ControladorResultadosVotacion;

public class ResultadoVotacionVista extends JFrame {

	private ControladorResultadosVotacion controladorResultadosVotacion;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultadoVotacionVista window = new ResultadoVotacionVista();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResultadoVotacionVista() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		controladorResultadosVotacion = new ControladorResultadosVotacion();

		setTitle( "Resultado Votacion" );
		setSize( 640, 480 );
		setBackground( Color.gray );
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 638, 453);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblGanador = new JLabel("GANADOR");
		lblGanador.setBounds(257, 88, 87, 15);
		panel.add(lblGanador);

		JTextPane listaGanadoraText = new JTextPane();
		listaGanadoraText.setBounds(239, 128, 116, 33);
		listaGanadoraText.setText(controladorResultadosVotacion.getGanador()
				.getDescripcion());
		listaGanadoraText.setEditable(false);
		panel.add(listaGanadoraText);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(145, 225, 285, 144);
		panel.add(scrollPane);
		Object columnNames[] = { "Lista", "Cantidad De Votos", "Porcentaje" };
		Object[][] data = { { "Partido Obrero", 500, 50.0 },
				{ "Pan y Rosas", 250, 25.0 },
				{ "Frente Para la Victoria", 250, 25.0 } };
		
		table = new JTable(data,columnNames);
		table.enableInputMethods(false);
		scrollPane.setViewportView(table);
		
		
		

	
	


			}
	}

