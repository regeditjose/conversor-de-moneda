package com.alura.clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class conversorDeMonedas {

    public static void main(String[] args) {
        try {
            BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Bienvenido al Conversor de Monedas");
            System.out.println("----------------------------------");

            System.out.println("Ingrese la moneda de origen (ej. USD):");
            String monedaOrigen = lector.readLine();

            System.out.println("Ingrese la moneda de destino (ej. EUR):");
            String monedaDestino = lector.readLine();

            System.out.println("Ingrese la cantidad a convertir:");
            double cantidad = Double.parseDouble(lector.readLine());

            ConversorMonedas conversor = new ConversorMonedas();
            double cantidadConvertida = conversor.convertirMoneda(monedaOrigen, monedaDestino, cantidad);

            if (cantidadConvertida != -1) {
                System.out.println(cantidad + " " + monedaOrigen + " = " + cantidadConvertida + " " + monedaDestino);
            } else {
                System.out.println("No se pudo obtener la tasa de cambio.");
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

