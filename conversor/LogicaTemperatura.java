package conversor_moneda;

import javax.swing.*;

public class LogicaTemperatura {
    private static Conversor conversor;
    static String temperatura;
    static double temperaturaDouble;
    static double resultadoConversion;
    public static boolean invertirConversionTemperatura = true; // Status boton invertir
    static String temperaturaConvertido;

    // indices para convertir la temperatura
    static Double[] conversion = {1.0, 33.8, 274.15, 493.47};
    //Simbolos de las temperaturas
    static String[] simboloTemperatura = {"°C", "°F", "K", "R",};
    String[] temperaturas = {"Celcius", "Farenheit", "Kelvin", "Rankine"};


    // Constructor
    public LogicaTemperatura(Conversor parentConversor) {
        this.conversor = parentConversor;
    }

    public static void llenarComboBox(JComboBox cbTemperaturaOrigen, JComboBox cbTemperaturaDestino) {

        try {
            temperatura = conversor.getTextFieldTemperatura().getText();
            if (temperatura.isEmpty())
                JOptionPane.showMessageDialog(null, "El campo importe no puede estar vacio!", "Error",
                        JOptionPane.ERROR_MESSAGE);
            else {
                temperaturaDouble = Double.parseDouble(temperatura);
                if (temperaturaDouble == 0) {
                    JOptionPane.showMessageDialog(null, "Esta intentando ingresar un valor no valido", "Operacion erronea",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    if (invertirConversionTemperatura == false) {
                        resultadoConversion = temperaturaDouble / conversion[cbTemperaturaDestino.getSelectedIndex() + 1];
                        temperaturaConvertido = String.format("%.2f", resultadoConversion);

                        JOptionPane.showMessageDialog(null,
                                temperatura + " " + simboloTemperatura[cbTemperaturaOrigen.getSelectedIndex()] + " son " + temperaturaConvertido + " "
                                        + simboloTemperatura[cbTemperaturaDestino.getSelectedIndex() + 1],
                                "Conversion exitosa", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        resultadoConversion = temperaturaDouble * conversion[cbTemperaturaOrigen.getSelectedIndex() + 1];
                        temperaturaConvertido = String.format("%.2f", resultadoConversion);

                        JOptionPane.showMessageDialog(null,
                                temperatura + " " + simboloTemperatura[cbTemperaturaOrigen.getSelectedIndex() + 1] + " son " + temperaturaConvertido + " "
                                        + simboloTemperatura[cbTemperaturaDestino.getSelectedIndex()],
                                "Conversion exitosa", JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(null, "Ingresa solo numeros", "Pues que te pasa :l", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void invertir (JComboBox cbTemperaturaOrigen, JComboBox cbTemperaturaDestino){
        if (invertirConversionTemperatura == false){
            invertirConversionTemperatura = true;
        }
        else {
            invertirConversionTemperatura = false;
        }
        cbTemperaturaDestino.removeAllItems();
        cbTemperaturaOrigen.removeAllItems();
        if (invertirConversionTemperatura == false) {
            cbTemperaturaOrigen.addItem(temperaturas[0]);
            for (int i = 1; i <= 3; i++) {
                cbTemperaturaDestino.addItem(temperaturas[i]);
            }
        }
        else {
            cbTemperaturaDestino.addItem(temperaturas[0]);
            for (int i = 1; i <=3; i++) {
                cbTemperaturaOrigen.addItem(temperaturas[i]);
            }
        }
    }

}
