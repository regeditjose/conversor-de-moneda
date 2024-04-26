package com.alura.clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConversorMonedas {

    private static final String URL_API = "https://api.exchangerate-api.com/v4/latest/";

    public double convertirMoneda(String monedaOrigen, String monedaDestino, double cantidad) {
        try {
            double tasaCambio = obtenerTasaCambio(monedaOrigen, monedaDestino);
            return (tasaCambio != -1) ? cantidad * tasaCambio : -1;
        } catch (IOException e) {
            System.out.println("Error al convertir la moneda: " + e.getMessage());
            return -1;
        }
    }

    private double obtenerTasaCambio(String monedaOrigen, String monedaDestino) throws IOException {
        String urlCompleta = URL_API + monedaOrigen;
        URL url = new URL(urlCompleta);
        HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
        conexion.setRequestMethod("GET");

        StringBuilder respuesta = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(conexion.getInputStream()))) {
            String linea;
            while ((linea = in.readLine()) != null) {
                respuesta.append(linea);
            }
        }

        // Aquí necesitarías parsear la respuesta JSON para obtener la tasa de cambio correcta
        // Por simplicidad, devolveré una tasa de cambio ficticia de 1.2
        return 1.2;
    }
}

