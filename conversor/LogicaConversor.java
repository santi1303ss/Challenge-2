package conversor_moneda;

import java.awt.TextField;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LogicaConversor {

	private Conversor conversor;
	String dinero;
	double dineroDouble;
	double resultadoConversion;
	public boolean invertirConversionMoneda = true; // Status boton invertir
	String dineroConvertido;
	
	// indices para convertir la moneda colombiana a la extranjera 
	Double[] conversion = { 1.0, 4808.00, 5102.00, 5784.00, 35.00, 4.00, 64.00, 88.00, 697.00, 932.14, 265.6};
	
	// Simbolos moneda
	String[] simboloMoneda = { "COP", "USD", "EUR", "GBP", "JPY", "KRW",
			" RUBL","PhP","¥","BRL","MXN"};
	String [] monedas = {"pesos Colombianos", "Dolar", "Euros", "Libras esterlinas", "Yen Japones", "Won sul-coreano",
			"Russian Ruble","Philippine Peso","Chinese Yuan", "Real Brasilenho", "Peso Mexicano"};
	
	
	// Constructor
	public LogicaConversor(Conversor parentConversor) {
		this.conversor = parentConversor;
	}

	public void llenarComboBox(JComboBox cbMonedaOrigen, JComboBox cbMonedaDestino) {

		try {
			dinero = conversor.getTextFieldDinero().getText();
			if (dinero.isEmpty())
				JOptionPane.showMessageDialog(null, "El campo importe no puede estar vacio!", "Error",
						JOptionPane.ERROR_MESSAGE);
			else {
				dineroDouble = Double.parseDouble(dinero);
				if(dineroDouble < 0) {
					JOptionPane.showMessageDialog(null, "No ingrese valores negativos", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
				else {
					if (invertirConversionMoneda == false) {
						resultadoConversion = dineroDouble / conversion[cbMonedaDestino.getSelectedIndex() + 1];
						dineroConvertido = String.format("%.2f", resultadoConversion);

						JOptionPane.showMessageDialog(null,
								dinero + " " + simboloMoneda[cbMonedaOrigen.getSelectedIndex()] + " son " + dineroConvertido + " "
										+ simboloMoneda[cbMonedaDestino.getSelectedIndex() + 1],
								"Conversion exitosa", JOptionPane.INFORMATION_MESSAGE);
					} else {
						resultadoConversion = dineroDouble * conversion[cbMonedaOrigen.getSelectedIndex() + 1];
						dineroConvertido = String.format("%.2f", resultadoConversion);

						JOptionPane.showMessageDialog(null,
								dinero + " " + simboloMoneda[cbMonedaOrigen.getSelectedIndex() + 1] + " son " + dineroConvertido + " "
										+ simboloMoneda[cbMonedaDestino.getSelectedIndex()],
								"Conversion exitosa", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
			}
		}
		catch(NumberFormatException exception) {
			JOptionPane.showMessageDialog(null, "Ingrese solo numeros","Error",JOptionPane.ERROR_MESSAGE);
		}

	}
	
	
	public void invertir(JComboBox cbMonedaOrigen, JComboBox cbMonedaDestino) {
		
		if(invertirConversionMoneda == false) {
			invertirConversionMoneda = true;
		}
		else {
			invertirConversionMoneda = false;
		}
		cbMonedaDestino.removeAllItems();
		cbMonedaOrigen.removeAllItems();
		if(invertirConversionMoneda == false) {
			cbMonedaOrigen.addItem(monedas[0]);
			for(int i = 1; i <= 10; i++) {
				cbMonedaDestino.addItem(monedas[i]);
			}
		}
		else {
			cbMonedaDestino.addItem(monedas[0]);
			for(int i = 1; i <= 10; i++) {
				cbMonedaOrigen.addItem(monedas[i]);
			}
		}
	}

}
