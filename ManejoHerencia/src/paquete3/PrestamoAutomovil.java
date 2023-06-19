package paquete3;

import paquete2.*;

public class PrestamoAutomovil extends Prestamo {
    public String tAutomovil;
    public String marcaAutomovil;
    public Persona garante;
    public double valorAutomovil;
    public double valorMAutomovil;

    public PrestamoAutomovil() {}

    public PrestamoAutomovil(String tipoAutomovil, String marcaAutomovil, Persona garante, double valorAutomovil, Persona beneficiario, double tiempoMeses, String ciudadPrestamo) {
        super(beneficiario, tiempoMeses, ciudadPrestamo);
        this.tAutomovil = tipoAutomovil;
        this.marcaAutomovil = marcaAutomovil;
        this.garante = garante;
        this.valorAutomovil = valorAutomovil;
    }

    public void calcularValorMAutomovil() {
        this.valorMAutomovil = (this.valorAutomovil / tMeses) ;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPrestamo Automovil\n" +
                "===================\n" +
                "Tipo de automovil: " + tAutomovil + "\n" +
                "Marca de automovil: " + marcaAutomovil + "\n" +
                "Garante 1\n" +
                "===========\n" +
                garante.toString() +
                "Valor de automovil: " + valorAutomovil + "\n" +
                "Valor mensual de pago del prestamo del automovil: " + valorMAutomovil + "\n";
    }
  
}