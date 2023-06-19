package paquete4;

import paquete2.Persona;
import paquete2.Prestamo;

public class PrestamoEducativo extends Prestamo{
    public String nivelEstudio;
    public InstitucionEducativa centroEducativo;
    public double valorCarrera;
    public double valorMensualPagoCarrera;

    public PrestamoEducativo() {}
    public PrestamoEducativo(String nivelEstudio, InstitucionEducativa centroEducativo, double valorCarrera, Persona beneficiario, double tMeses, String ciudadPrestamo) {
        super(beneficiario, tMeses, ciudadPrestamo);
        this.nivelEstudio = nivelEstudio;
        this.centroEducativo = centroEducativo;
        this.valorCarrera = valorCarrera;
    }

    public void calcularValorMensualPago(){
        this.valorMensualPagoCarrera = (this.valorCarrera/ tMeses) - ( (this.valorCarrera/ tMeses) * 0.10 );
    }
    
    @Override
    public String toString() {
        return super.toString()+
                "\nPrestamoEducativo\n" +
                "===================" +
                "Nivel de Estudio: " + nivelEstudio + "\n"+ 
                "Centro Educativo: " + 
                centroEducativo.toString() + "\n"+ 
                "Valor de la Carrera: " + valorCarrera + "\n"+  
                "Valor para el pago mensual del prestamo del valor de la carrera: " + valorMensualPagoCarrera + "\n";
    }
}
