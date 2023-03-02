//Autor Kevin Santiago Lopez
//sigueme en linkedIn https://www.linkedin.com/in/kevin-santiago-lopez-gomez-7bba35207/
//Sigueme en instagram
//sSigueme en Git https://github.com/santi1303ss

package conversor_moneda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Conversor {

	private JFrame frame;
	private JTextField textFieldDinero;
	private JTextField textFieldTemperatura;
	private JTextField textFieldUnidad;
	public int indexActual = 0;
	private JComboBox comboBoxLongitudDe = new JComboBox();
	private JComboBox comboBoxLongitudA = new JComboBox();
	private JLabel lblTituloMedida = new JLabel();
	private JLabel lblTituloTemperatura = new JLabel();
	private JPanel conversorTemperatura = new JPanel();

	//Atributos para el IMS
	private JLabel pesoLabel, estaturaLabel, imsLabel, mensajeLabel;
	private JTextField pesoField, estaturaField, imsField;
	private JButton calcularButton;



	public JLabel getLblTituloMedida() {
		return lblTituloMedida;
	}

	public JLabel getLblTituloTemperatura() {
		return lblTituloTemperatura;
	}

	public JComboBox getComboBoxLongitudDe() {
		return comboBoxLongitudDe;
	}

	public void setComboBoxLongitudDe(JComboBox comboBoxLongitudDe) {
		this.comboBoxLongitudDe = comboBoxLongitudDe;
	}

	public JComboBox getComboBoxLongitudA() {
		return comboBoxLongitudA;
	}

	public void setComboBoxLongitudA(JComboBox comboBoxLongitudA) {
		this.comboBoxLongitudA = comboBoxLongitudA;
	}
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTextFieldDinero() {
		return textFieldDinero;
	}

	public void setTextFieldDinero(JTextField textFieldDinero) {
		this.textFieldDinero = textFieldDinero;
	}

	public JTextField getTextFieldTemperatura() {
		return textFieldTemperatura;
	}

	public void setTextFieldTemperatura(JTextField textFieldTemperatura) {
		this.textFieldTemperatura = textFieldTemperatura;
	}
	public JTextField getTextFieldUnidad() {
		return textFieldUnidad;
	}

	public void setTextFieldUnidad(JTextField textFieldUnidad) {
		this.textFieldUnidad = textFieldUnidad;
	}


	LogicaConversor logicaConversor;
	LogicaTemperatura logicaTemperatura;
	LogicaConversorLongitud logicaConversorLongitud;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor window = new Conversor();
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
	public Conversor() {
		initialize();
		//logicaConversor = new LogicaConversor(this);	

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		logicaConversor = new LogicaConversor(this);
		logicaTemperatura = new LogicaTemperatura(this);
		logicaConversorLongitud = new LogicaConversorLongitud(this);


		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(120, 100, 550, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CardLayout myLayout = new CardLayout();
		frame.getContentPane().setLayout(myLayout);

		JPanel panelSeleccion = new JPanel();
		panelSeleccion.setBackground(new Color(52, 160, 239));
		frame.getContentPane().add(panelSeleccion, "panelSeleccion");
		panelSeleccion.setLayout(null);

		JComboBox comboBoxSeleccion = new JComboBox();
		comboBoxSeleccion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxSeleccion.setBackground(new Color(0xFF5685A9, true));
		comboBoxSeleccion.setModel(new DefaultComboBoxModel(new String[]{"Conversor de Moneda", "Conversor de Temperatura", "Conversor de Longitud", "Conversor de Masa", "Conversor de Capacidad"}));

		comboBoxSeleccion.setBounds(175, 56, 190, 25);
		panelSeleccion.add(comboBoxSeleccion);


		JButton btnAceptarSeleccion = new JButton("Aceptar");
		btnAceptarSeleccion.setForeground(new Color(255, 255, 255));
		btnAceptarSeleccion.setBackground(new Color(38, 105, 150));
		btnAceptarSeleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textFieldUnidad.setText("");
				indexActual = comboBoxSeleccion.getSelectedIndex();
				if (indexActual == 0) {
					myLayout.show(frame.getContentPane(), "panelConversorMoneda");
				} else if (indexActual == 1){
					myLayout.show(frame.getContentPane(),"panelConversorTemperatura");
				} else if (indexActual == 2 || indexActual == 3 || indexActual ==4) {
					myLayout.show(frame.getContentPane(), "panelConversorHorario");
					logicaConversorLongitud.inicializarComboBox();
				}
			}
		});
		btnAceptarSeleccion.setBounds(100, 116, 85, 21);
		panelSeleccion.add(btnAceptarSeleccion);

		JButton btnCancelarSeleccion = new JButton("Cancelar");
		btnCancelarSeleccion.setForeground(new Color(255, 255, 255));
		btnCancelarSeleccion.setBackground(new Color(38, 105, 150));
		btnCancelarSeleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancelarSeleccion.setBounds(350, 116, 85, 21);
		panelSeleccion.add(btnCancelarSeleccion);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(134, 177, 227));
		panel_2.setBounds(0, 0, 536, 46);
		panelSeleccion.add(panel_2);

		JLabel lblTitulo = new JLabel("CONVERSOR ALURA");
		lblTitulo.setForeground(new Color(250, 255, 255));
		lblTitulo.setFont(new Font("Myanmar Text", Font.CENTER_BASELINE, 18));
		panel_2.add(lblTitulo);

		//Divisas
		JPanel panelConversorMoneda = new JPanel();
		panelConversorMoneda.setBackground(new Color(210, 98, 135));
		frame.getContentPane().add(panelConversorMoneda, "panelConversorMoneda");
		panelConversorMoneda.setLayout(null);

		textFieldDinero = new JTextField();
		textFieldDinero.setBounds(20, 80, 96, 19);
		textFieldDinero.setBackground(new Color(224, 163, 178));
		panelConversorMoneda.add(textFieldDinero);
		textFieldDinero.setColumns(10);

		JComboBox<String> comboBoxDe = new JComboBox();
		comboBoxDe.setBackground(new Color(224, 163, 178));
		comboBoxDe.setBounds(126, 79, 142, 21);
		panelConversorMoneda.add(comboBoxDe);

		JComboBox<String> comboBoxA = new JComboBox();
		comboBoxA.setBackground(new Color(224, 163, 178));
		comboBoxA.setBounds(373, 79, 142, 21);
		panelConversorMoneda.add(comboBoxA);



		//Inicializar comboBox con los valores del Array que contienen las representaciones de la moneda
		logicaConversor.invertir(comboBoxDe, comboBoxA);

		JButton btnInvertirSeleccion = new JButton("Invertir");
		btnInvertirSeleccion.setForeground(new Color(255, 255, 255));
		btnInvertirSeleccion.setBackground(new Color(175, 36, 75));
		btnInvertirSeleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				logicaConversor.invertir(comboBoxDe, comboBoxA);
			}
		});
		btnInvertirSeleccion.setBounds(278, 79, 85, 21);
		panelConversorMoneda.add(btnInvertirSeleccion);

		JButton btnRegresando = new JButton("Atras");
		btnRegresando.setForeground(new Color(255, 255, 255));
		btnRegresando.setBackground(new Color(175, 36, 75));
		btnRegresando.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "panelSeleccion");
			}
		});
		btnRegresando.setBounds(0, 153, 85, 21);
		panelConversorMoneda.add(btnRegresando);

		JButton btnConvertirMoneda = new JButton("convertir");
		btnConvertirMoneda.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConvertirMoneda.setForeground(new Color(255, 255, 255));
		btnConvertirMoneda.setBackground(new Color(175, 36, 75));
		btnConvertirMoneda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				logicaConversor.llenarComboBox(comboBoxDe, comboBoxA);

			}
		});
		btnConvertirMoneda.setBounds(206, 110, 120, 35);
		panelConversorMoneda.add(btnConvertirMoneda);

		JLabel lblNewLabel = new JLabel("Importe");
		lblNewLabel.setFont(new Font("Myanmar Text", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 59, 57, 13);
		panelConversorMoneda.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Desde la moneda");
		lblNewLabel_1.setBounds(126, 57, 107, 13);
		panelConversorMoneda.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("A la moneda");
		lblNewLabel_2.setBounds(373, 57, 69, 13);
		panelConversorMoneda.add(lblNewLabel_2);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 36, 75));
		panel.setBounds(0, 0, 536, 46);
		panelConversorMoneda.add(panel);

		JLabel lblNewLabel_3 = new JLabel("CONVERSOR DE DIVISAS");
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Myanmar Text", Font.CENTER_BASELINE,18));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));


		//Temperatura
		JPanel panelConversorTemperatura = new JPanel();
		panelConversorTemperatura.setBackground(new Color(255, 185, 143));
		frame.getContentPane().add(panelConversorTemperatura,"panelConversorTemperatura");
		panelConversorTemperatura.setLayout(null);

		textFieldTemperatura = new JTextField();
		textFieldTemperatura.setBounds(20,80,70,25);
		textFieldTemperatura.setBackground(new Color(224, 209, 177));
		panelConversorTemperatura.add(textFieldTemperatura);
		textFieldTemperatura.setColumns(8);

		JComboBox<String> comboBoxtTempDe = new JComboBox<>();
		comboBoxtTempDe.setBackground(new Color(255, 185, 103));
		comboBoxtTempDe.setBounds(135, 80, 142, 21);
		panelConversorTemperatura.add(comboBoxtTempDe);


		JComboBox<String> comboBoxtTempA = new JComboBox<>();
		comboBoxtTempA.setBackground(new Color(255, 185, 103));
		comboBoxtTempA.setBounds(373, 80, 142, 21);
		panelConversorTemperatura.add(comboBoxtTempA);

		//Inicializacion de los Array

		logicaTemperatura.invertir(comboBoxtTempDe,comboBoxtTempA);

		JButton btnInvertirLaSeleccion = new JButton("Invertir");
		btnInvertirLaSeleccion.setForeground(new Color(255, 255, 255));
		btnInvertirLaSeleccion.setBackground(new Color(255, 198, 11));
		btnInvertirLaSeleccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				logicaTemperatura.invertir(comboBoxtTempDe, comboBoxtTempA);
			}
		});
		btnInvertirLaSeleccion.setBounds(283, 79, 85, 21);
		panelConversorTemperatura.add(btnInvertirLaSeleccion);

		JButton btnRegresar = new JButton("Atras");
		btnRegresar.setForeground(new Color(255, 255, 255));
		btnRegresar.setBackground(new Color(255, 198, 11));
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "panelSeleccion");
			}
		});
		btnRegresar.setBounds(0, 153, 85, 21);
		panelConversorTemperatura.add(btnRegresar);

		JButton btnConvertirTemperatura = new JButton("Convertir ° ");
		btnConvertirTemperatura.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConvertirTemperatura.setForeground(new Color(255,255,255));
		btnConvertirTemperatura.setBackground(new Color(255, 198, 11));
		btnConvertirTemperatura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LogicaTemperatura.llenarComboBox(comboBoxtTempDe,comboBoxtTempA);
			}
		});

		btnConvertirTemperatura.setBounds(206,110,120,35);
		panelConversorTemperatura.add(btnConvertirTemperatura);

		JLabel lblNewLabel1= new JLabel("Temperatura");
		lblNewLabel1.setFont(new Font("Myanmar Text", Font.BOLD, 12));
		lblNewLabel1.setBounds(20,60,100,15);
		panelConversorTemperatura.add(lblNewLabel1);

		JLabel lblNewLabel2 = new JLabel("Desde la Temperatura °");
		lblNewLabel2.setBounds(140, 60, 150, 15);
		panelConversorTemperatura.add(lblNewLabel2);

		JLabel lblNewLabel3 = new JLabel("A la Temperatura °");
		lblNewLabel3.setBounds(373, 60, 120, 15);
		panelConversorTemperatura.add(lblNewLabel3);

		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(255, 178, 11));
		panel1.setBounds(0, 0, 536, 46);
		panelConversorTemperatura.add(panel1);

		JLabel lblNewLabelXD = new JLabel("CONVERSOR DE TEMPERATURAS");
		panel1.add(lblNewLabelXD);
		lblNewLabelXD.setFont(new Font("Myanmar Text", Font.BOLD, 18));
		lblNewLabelXD.setForeground(new Color(255, 255, 255));

		//Longitudes

		JPanel panelConversorLongitud = new JPanel();
		panelConversorLongitud.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panelConversorLongitud, "panelConversorHorario");
		panelConversorLongitud.setLayout(null);

		//JComboBox comboBoxLongitudDe = new JComboBox();
		comboBoxLongitudDe.setBounds(238, 74, 63, 27);
		panelConversorLongitud.add(comboBoxLongitudDe);

		//JComboBox comboBoxLongitudA = new JComboBox();
		comboBoxLongitudA.setBounds(332, 74, 63, 27);
		panelConversorLongitud.add(comboBoxLongitudA);

		//logicaConversorLongitud.inicializarLongitud(comboBoxLongitudDe, comboBoxLongitudA, logicaConversorLongitud.longitud);
		//logicaConversorLongitud.inicializarComboBox(comboBoxLongitudDe, comboBoxLongitudA);

		textFieldUnidad = new JTextField();
		textFieldUnidad.setBounds(117, 74, 96, 27);
		panelConversorLongitud.add(textFieldUnidad);
		textFieldUnidad.setColumns(10);

		JButton btnConvertirLongitud = new JButton("Convertir");
		btnConvertirLongitud.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnConvertirLongitud.setForeground(new Color(255, 255, 255));
		btnConvertirLongitud.setBackground(new Color(225, 200, 72));
		btnConvertirLongitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				logicaConversorLongitud.conversionUnidades();

			}
		});
		btnConvertirLongitud.setBounds(185, 111, 137, 36);
		panelConversorLongitud.add(btnConvertirLongitud);

		JButton btnRegresarLongitud = new JButton("Regresar");
		btnRegresarLongitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "panelSeleccion");
			}
		});
		btnRegresarLongitud.setBounds(0, 242, 85, 21);
		panelConversorLongitud.add(btnRegresarLongitud);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 181, 36));
		panel_1.setBounds(0, 0, 536, 46);
		panelConversorLongitud.add(panel_1);

		//JLabel lblTituloMedida = new JLabel("CONVERSOR LONGITUD");
		lblTituloMedida.setForeground(new Color(241, 231, 158));
		panel_1.add(lblTituloMedida);
		lblTituloMedida.setFont(new Font("Myanmar Text", Font.BOLD, 18));

		JLabel lblNewLabel_4 = new JLabel("Cantidad");
		lblNewLabel_4.setBounds(117, 52, 63, 13);
		panelConversorLongitud.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Convertir de");
		lblNewLabel_5.setBounds(237, 52, 85, 13);
		panelConversorLongitud.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Convertir a");
		lblNewLabel_6.setBounds(332, 52, 77, 13);
		panelConversorLongitud.add(lblNewLabel_6);

		JButton btnNewButton = new JButton("Atras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "panelSeleccion");
			}
		});
		btnNewButton.setBackground(new Color(255, 210, 62));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(0, 153, 85, 21);
		panelConversorLongitud.add(btnNewButton);

		//Conversion de temperaturas
		lblTituloTemperatura.setForeground(new Color(241, 231, 158));
		panel_1.add(lblTituloTemperatura);
		lblTituloTemperatura.setFont(new Font("Myanmar Text", Font.BOLD, 18));

		JLabel lblNewLabel_7 = new JLabel("Cantidad");
		lblNewLabel_5.setBounds(117, 52, 63, 13);
		panelConversorLongitud.add(lblNewLabel_4);

		JLabel lblNewLabel_8 = new JLabel("Convertir de");
		lblNewLabel_5.setBounds(237, 52, 85, 13);
		panelConversorLongitud.add(lblNewLabel_5);

		JLabel lblNewLabel_9 = new JLabel("Convertir a");
		lblNewLabel_6.setBounds(332, 52, 77, 13);
		panelConversorLongitud.add(lblNewLabel_6);

		JButton btnNewBotton = new JButton("Atras");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myLayout.show(frame.getContentPane(), "panelSeleccion");
			}
		});
		btnNewButton.setBackground(new Color(255, 210, 62));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(0, 153, 85, 21);
		panelConversorLongitud.add(btnNewButton);


		/*Label imgUnidad = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/")).getImage();
		imgUnidad.setIcon(new ImageIcon(img));
		imgUnidad.setBounds(412, 56, 114, 108);
		panelConversorLongitud.add(imgUnidad);
		*/

	}




	public void setLblTituloMedida(JLabel lblTituloMedida) {
		this.lblTituloMedida = lblTituloMedida;
	}

	public int getIndexActual() {
		return indexActual;
	}

	public void setIndexActual(int indexActual) {
		this.indexActual = indexActual;
	}
}
