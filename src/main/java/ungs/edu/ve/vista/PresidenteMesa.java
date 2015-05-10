package ungs.edu.ve.vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import ungs.edu.ve.controlador.ControladorVotacion;
import ungs.edu.ve.controlador.ValidadorVotante;
import ungs.edu.ve.modelo.Claustro;
import ungs.edu.ve.modelo.Votante;
import ungs.edu.ve.modelo.dao.EntidadDAO;
import ungs.edu.ve.modelo.dao.EstadoDAO;
import ungs.edu.ve.modelo.dao.VotanteDAO;
import ungs.edu.ve.modelo.dao.impl.EntidadDAOImpl;
import ungs.edu.ve.modelo.dao.impl.EstadoDAOImpl;
import ungs.edu.ve.modelo.dao.impl.VotanteDAOImpl;
import ungs.edu.ve.util.CONSTANTE;

public class PresidenteMesa extends JFrame {

	/**
	 * 
	 */
	Logger logger = Logger.getLogger(PresidenteMesa.class);

	private Button buttonGenerarVoto;
	private JRadioButton radioFianlizado;
	private JRadioButton radioVotando;
	private JRadioButton radioLibre;
	private ControladorVotacion controladorVotacion;
	private VotanteDAO votanteDAO;
	private EstadoDAO estadoDAO;

	private static final long serialVersionUID = -3298221097107822223L;
	private JPanel contentPane;
	private JTextField inputNroDocumento;
	
	
	private JLabel laResultadoApeNom;
	private JLabel lbResultadoClaustro;
	private JPanel panelResultadoBusqueda;
	
	private Votante votante;
	private JButton btnAnular;
	private JButton btnHabilitar;
	

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

		controladorVotacion = new ControladorVotacion();
		estadoDAO = new EstadoDAOImpl();
		controladorVotacion.setEstadoDAO(estadoDAO);
		ValidadorVotante validador = new ValidadorVotante();
		controladorVotacion.setValidador(validador);
		votanteDAO = new VotanteDAOImpl();
		controladorVotacion.setVotanteDAO(votanteDAO);
		EntidadDAO<Claustro> claustroDao = new EntidadDAOImpl<Claustro>();
		controladorVotacion.setClaustroDao(claustroDao);

		controladorVotacion.inicializar();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 0, 361, 145);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));

		JLabel lblTerminal = new JLabel("Terminal 1");
		lblTerminal.setBounds(0, 12, 119, 20);
		panel.add(lblTerminal);

		radioLibre = new JRadioButton("Libre");
		radioLibre.setSelected(true);
		radioLibre.setBounds(10, 40, 69, 23);
		radioLibre.setEnabled(false);

		panel.add(radioLibre);

		radioVotando = new JRadioButton("Votando");
		radioVotando.setBounds(97, 40, 94, 23);
		radioVotando.setEnabled(false);
		panel.add(radioVotando);

		radioFianlizado = new JRadioButton("Voto Finalizado");
		radioFianlizado.setBounds(198, 40, 149, 23);
		radioFianlizado.getDisabledSelectedIcon();
		radioFianlizado.setEnabled(false);
		panel.add(radioFianlizado);

		buttonGenerarVoto = new Button("Generar voto Impreso");
		buttonGenerarVoto.setVisible(false);
		buttonGenerarVoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("generando voto");
				controladorVotacion.cerrarVoto(votante);
				buttonGenerarVoto.setVisible(false);

			}
		});
		buttonGenerarVoto.setBounds(10, 97, 181, 23);
		panel.add(buttonGenerarVoto);
		
		btnAnular = new JButton("Anular");
		btnAnular.setVisible(false);
		btnAnular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Pantalla input descripcion de anulacion
			}
		});
		btnAnular.setBounds(230, 95, 117, 25);
		panel.add(btnAnular);

		btnHabilitar = new JButton("Habilitar");
		btnHabilitar.setVisible(false);
		btnHabilitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controladorVotacion.habilitarVotante(votante);
					radioLibre.setSelected(false);
					radioFianlizado.setSelected(true);
					buttonGenerarVoto.setVisible(true);
					btnAnular.setVisible(true);
					

				} catch (Exception error) {
					logger.error(error.getMessage());
					PantallaError pantallaError = new PantallaError(error.getMessage());
				}
			}
		});
		btnHabilitar.setBounds(388, 372, 117, 25);
		contentPane.add(btnHabilitar);

		JPanel panelBusqueda = new JPanel();
		panelBusqueda.setBounds(12, 169, 521, 57);
		contentPane.add(panelBusqueda);
		panelBusqueda.setLayout(null);
		panelBusqueda.setBorder(BorderFactory.createLineBorder(Color.black));


		inputNroDocumento = new JTextField();
		inputNroDocumento.setBounds(137, 22, 161, 32);
		panelBusqueda.add(inputNroDocumento);
		inputNroDocumento.setColumns(10);

		JLabel lblBsqueda = new JLabel("Ingresar DNI:");
		lblBsqueda.setBounds(12, 30, 111, 15);
		panelBusqueda.add(lblBsqueda);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nroDocumentoText = inputNroDocumento.getText();
				try {
					Integer nroDocumento = Integer.parseInt(nroDocumentoText);
					votante = votanteDAO.getByNroDocumento(nroDocumento);
					cargarVotanteEnPanelResultado(votante);
					
				} catch (NumberFormatException e) {
					logger.error(e);
					System.err.println(CONSTANTE.ERROR_DNI_INGRESADO_INVALIDO+" "+ nroDocumentoText);
					PantallaError pantallaError=new PantallaError(CONSTANTE.ERROR_DNI_INGRESADO_INVALIDO);

				}catch (NullPointerException e) {
					logger.error(e);
					System.err.println(CONSTANTE.ERROR_DNI_INEXISTENTE+ " "+ nroDocumentoText);
					PantallaError pantallaError=new PantallaError(CONSTANTE.ERROR_DNI_INEXISTENTE);
				}catch (Exception e) {
					logger.error(e);
					PantallaError pantallaError=new PantallaError(e.getMessage());
				}

			}
		});
		btnBuscar.setBounds(364, 25, 125, 25);
		panelBusqueda.add(btnBuscar);

		panelResultadoBusqueda = new JPanel();
		panelResultadoBusqueda.setVisible(false);
		panelResultadoBusqueda.setBounds(12, 290, 521, 70);
		contentPane.add(panelResultadoBusqueda);
		panelResultadoBusqueda.setLayout(null);
		panelResultadoBusqueda.setBorder(BorderFactory.createLineBorder(Color.black));


		JLabel lbApellidoNombre = new JLabel("Apellido, Nombre:");
		lbApellidoNombre.setBounds(12, 12, 162, 15);
		panelResultadoBusqueda.add(lbApellidoNombre);

		JLabel lbClaustro = new JLabel("Claustro:");
		lbClaustro.setBounds(12, 53, 162, 15);
		panelResultadoBusqueda.add(lbClaustro);

		laResultadoApeNom = new JLabel("");
		laResultadoApeNom.setBounds(166, 12, 343, 15);
		panelResultadoBusqueda.add(laResultadoApeNom);

		lbResultadoClaustro = new JLabel("");
		lbResultadoClaustro.setBounds(166, 53, 343, 15);
		panelResultadoBusqueda.add(lbResultadoClaustro);

	}
	
	public void cargarVotanteEnPanelResultado(Votante votante){
		if(votante!=null){
			laResultadoApeNom.setText(votante.getApellido()+ ", "+votante.getNombre());
			lbResultadoClaustro.setText(votante.getClaustro().getNombre());
			panelResultadoBusqueda.setVisible(true);
			btnHabilitar.setVisible(true);

		}else{
			throw new NullPointerException("Vontante Inexistente");
		}

	}
}
