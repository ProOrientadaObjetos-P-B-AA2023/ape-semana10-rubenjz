package paquete2;

public class Prestamo {
    public Persona beneficiario;
    public double tMeses;
    public String ciudadPrestamo;

    public Prestamo() {}

    public Prestamo(Persona beneficiario, double tMeses, String ciudadPrestamo) {
        this.beneficiario = beneficiario;
        this.tMeses = tMeses;
        this.ciudadPrestamo = ciudadPrestamo;
    }

    public void setCiudadPrestamo() {
        this.ciudadPrestamo = ciudadPrestamo.toLowerCase();
    }

    @Override
    public String toString() {
        return beneficiario.toString() +
                "\nBeneficiario\n" +
                "============\n" +
                "El tiempo del prestamo en meses es: " + tMeses + "\n" +
                "La ciudad del prestamo: " + ciudadPrestamo + "\n";
    }
}
