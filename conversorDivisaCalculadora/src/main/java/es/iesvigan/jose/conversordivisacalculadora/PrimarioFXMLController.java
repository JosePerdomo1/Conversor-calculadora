/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package es.iesvigan.jose.conversordivisacalculadora;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.DoubleStringConverter;

/**
 * FXML Controller class
 *
 * @author Jose Antonio
 */
public class PrimarioFXMLController implements Initializable {

    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private Button numero6;
    @FXML
    private Button numero7;
    @FXML
    private Button numero5;
    @FXML
    private Button numero2;
    @FXML
    private Button numero4;
    @FXML
    private Button numero9;
    @FXML
    private Button numero1;
    @FXML
    private Button numero8;
    @FXML
    private Button dec;
    @FXML
    private Button igual;
    @FXML
    private Button numero0;
    @FXML
    private Button suma;
    @FXML
    private Button numero3;
    @FXML
    private Label resultado;
    @FXML
    private Button bin;

    private List<String> listaMonedas = Arrays.asList("Bolivares", "Dólares", "Pesos Colombianos");
    @FXML
    private Label resultadoConversor;
    @FXML
    private TextField inputEuros;
    @FXML
    private Button botonCambiar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void listadoMoneda(MouseEvent event) {
        if (comboBox.getItems().isEmpty()) { // Comprobar si ComboBox está vacío
            comboBox.getItems().addAll(listaMonedas); // Añadir elementos a ComboBox
        }
    }

    @FXML
    private void cambios(MouseEvent event) {
        String monedaSeleccionada = comboBox.getValue(); // Obtener la moneda seleccionada
        if (monedaSeleccionada == null) {
            monedaSeleccionada = "Dólares"; // Establecer el valor predeterminado
        }
        double tasaConversion = obtenerTasaConversion(monedaSeleccionada); // Obtener la tasa de conversión correspondiente
        String valorEurosStr = inputEuros.getText(); // Obtener el valor introducido en el campo de texto
        double valorEuros;
        if (valorEurosStr.matches("\\d*\\.?\\d*")) { // Validar que solo haya números y puntos
            valorEuros = Double.parseDouble(valorEurosStr);
            double valorConvertido = valorEuros * tasaConversion;
            resultadoConversor.setText(String.format("%.2f", valorConvertido) + " " + monedaSeleccionada); // Mostrar el resultado en el Label con 2 decimales
        } else {
            resultadoConversor.setText("Error: el valor introducido no es válido."); // Mostrar mensaje de error en el Label
        }
    }

    private double obtenerTasaConversion(String moneda) {
        switch (moneda) {
            case "Bolivares":
                return 26.91;
            case "Dólares":
                return 1.10;
            case "Pesos Colombianos":
                return 4975.37;
            default:
                return 1.1;
        }
    }
    private String teclaSuma;
    private int suma2;
    private String teclaIgual;
    private int sumaIgual;
    boolean entroBinario = false;
    private String igualBinario;
    private String sumaBinario;

    @FXML
    private void decimales(MouseEvent event) {
        entroBinario = false;
        resultado.setText("");
        int suma2, sumaIgual = 0;
        for (int i = 2; i < 10; i++) {
            try {
                // Obtener el objeto "numeroX" utilizando reflexión
                Class<?> clase = this.getClass();
                Field campo = clase.getDeclaredField("numero" + i);
                Object objeto = campo.get(this);

                // Llamar al método "setDisable(true)" en el objeto
                Method metodo = objeto.getClass().getMethod("setDisable", boolean.class);
                metodo.invoke(objeto, false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void binarios(MouseEvent event) {
        entroBinario = true;
        resultado.setText("");

        for (int i = 2; i < 10; i++) {
            String numeros = "numero" + i + ".setDisable(true);";
            try {
                // Obtener el objeto "numeroX" utilizando reflexión
                Class<?> clase = this.getClass();
                Field campo = clase.getDeclaredField("numero" + i);
                Object objeto = campo.get(this);

                // Llamar al método "setDisable(true)" en el objeto
                Method metodo = objeto.getClass().getMethod("setDisable", boolean.class);
                metodo.invoke(objeto, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    private void numero6(MouseEvent event) {
        String numero = "6";
        guardarNumeros(numero);
    }

    @FXML
    private void numero7(MouseEvent event) {
        String numero = "7";
        guardarNumeros(numero);
    }

    @FXML
    private void numero5(MouseEvent event) {
        String numero = "5";
        guardarNumeros(numero);
    }

    @FXML
    private void numero2(MouseEvent event) {
        String numero = "2";
        guardarNumeros(numero);
    }

    @FXML
    private void numero4(MouseEvent event) {
        String numero = "4";
        guardarNumeros(numero);
    }

    @FXML
    private void numero9(MouseEvent event) {
        String numero = "9";
        guardarNumeros(numero);
    }

    @FXML
    private void numero1(MouseEvent event) {
        String numero = "1";
        guardarNumeros(numero);
    }

    private void guardarNumeros(String num) {
        String numeroViejo = resultado.getText();
        resultado.setText(numeroViejo + num);

    }

    @FXML
    private void numero8(MouseEvent event) {
        String numero = "8";
        guardarNumeros(numero);
    }

    @FXML
    private void numero3(MouseEvent event) {
        String numero = "3";
        guardarNumeros(numero);
    }

    @FXML
    private void teclaIgual(MouseEvent event) {
        if (entroBinario) {
            igualBinario=resultado.getText();
            resultado.setText(sumarBinarios(sumaBinario, igualBinario));
        } else {
            teclaIgual = resultado.getText();
            sumaIgual = Integer.parseInt(teclaIgual);
            resultado.setText(suma2 + sumaIgual + "");
        }
    }

    @FXML
    private void numero0(MouseEvent event) {
        String numero = "0";
        guardarNumeros(numero);
    }

    @FXML
    private void teclaSuma(MouseEvent event) {
        if (entroBinario) {
            sumaBinario = resultado.getText();
        } else {
            teclaSuma = resultado.getText();
            suma2 = Integer.parseInt(teclaSuma);
        }
        resultado.setText("");

    }

    public static String sumarBinarios(String binario1, String binario2) {
        // Convertir las cadenas binarias a arreglos de caracteres
        char[] arr1 = binario1.toCharArray();
        char[] arr2 = binario2.toCharArray();

        // Crear un arreglo para almacenar el resultado
        char[] resultado = new char[Math.max(arr1.length, arr2.length) + 1];

        // Inicializar el acarreo y los índices de los arreglos
        int acarreo = 0;
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = resultado.length - 1;

        // Sumar los dígitos de los arreglos desde la posición más baja
        while (i >= 0 || j >= 0) {
            int suma = acarreo;

            if (i >= 0) {
                suma += arr1[i] - '0';
                i--;
            }

            if (j >= 0) {
                suma += arr2[j] - '0';
                j--;
            }

            resultado[k] = (char) ((suma % 2) + '0');
            acarreo = suma / 2;
            k--;
        }

        // Asegurarse de que el acarreo final se incluya en el resultado si es necesario
        if (acarreo > 0) {
            resultado[k] = (char) (acarreo + '0');
        } else {
            k++;
        }

        // Convertir el arreglo de caracteres del resultado a una cadena
        return new String(resultado, k, resultado.length - k);
    }

}
