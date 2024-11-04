import javax.swing.*;

public class Principal {

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                    null,
                    "=== Conversor de Monedas ===\n1. Realizar conversion\n2. Salir\nSeleccione una opcion:",
                    "Menu de Opciones",
                    JOptionPane.QUESTION_MESSAGE
            );

            if (opcion == null || opcion.equals("2")) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                salir = true;
            } else if (opcion.equals("1")) {
                realizarConversion();
            } else {
                JOptionPane.showMessageDialog(null, "Opcion no valida. Por favor, selecciona 1 o 2.");
            }
        }
    }

    private static void realizarConversion() {
        String divisaOrigen = JOptionPane.showInputDialog("Ingresa el codigo de moneda (siglas) que deseas convertir:");
        if (divisaOrigen == null) {
            JOptionPane.showMessageDialog(null, "Operacion cancelada.");
            return;
        }
        divisaOrigen = divisaOrigen.toUpperCase();

        String divisaDestino = JOptionPane.showInputDialog("Ingresa el codigo de moneda (siglas) al que deseas hacer la conversion:");
        if (divisaDestino == null) {
            JOptionPane.showMessageDialog(null, "Operacion cancelada.");
            return;
        }
        divisaDestino = divisaDestino.toUpperCase();

        String cantidadStr = JOptionPane.showInputDialog("Ingresa la cantidad que deseas convertir:");
        if (cantidadStr == null) {
            JOptionPane.showMessageDialog(null, "Operacion cancelada.");
            return;
        }

        try {
            double cantidad = Double.parseDouble(cantidadStr);

            ConsultarDivisa consultarDivisa = new ConsultarDivisa();
            Monedas tasas = consultarDivisa.buscaMoneda(divisaOrigen);

            if (tasas == null) {
                JOptionPane.showMessageDialog(null, "Hubo un problema al consultar las tasas de cambio. Por favor, verifica los mensajes de error y vuelve a intentarlo.");
                return;
            }

            if (tasas.conversion_rates() != null && tasas.conversion_rates().containsKey(divisaDestino)) {
                Double tasaDestino = tasas.conversion_rates().get(divisaDestino);
                Double cantidadConvertida = cantidad * tasaDestino;
                JOptionPane.showMessageDialog(null, String.format("La cantidad convertida es: %.2f %s", cantidadConvertida, divisaDestino));
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener la tasa de cambio para la moneda especificada.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Ingresa una cantidad numerica valida.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al realizar la conversion: " + e.getMessage());
        }
    }
}
