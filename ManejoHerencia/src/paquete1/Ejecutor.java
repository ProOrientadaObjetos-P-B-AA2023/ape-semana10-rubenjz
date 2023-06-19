package paquete1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import paquete2.Persona;
import paquete2.Prestamo;
import paquete3.PrestamoAutomovil;
import paquete4.InstitucionEducativa;
import paquete4.PrestamoEducativo;

public class Ejecutor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Prestamo> listap = new ArrayList<>();
        int opcion = 1;
        while(opcion != 0){
            System.out.println("Sistema de prestramos");
            System.out.println("|----------------------------|");
            System.out.println("|Opcion| Prestamo Automovil  |");
            System.out.println("|----------------------------|");
            System.out.println("|     0| Salir del Programa  |");
            System.out.println("|     1| Prestamo Automovil  |");
            System.out.println("|     2| Prestamo Educativo  |");
            System.out.println("|     3| Mostar              |");
            System.out.println("|----------------------------|");
            System.out.print("Ingrese una opcion: ");
            opcion = sc.nextByte();

            switch (opcion){
                case 0:
                    System.out.println("\nFue un placer haber ayudado.");
                    break;
                case 1:
                    System.out.println("\nPostulacion para Prestamo Automovil");
                    PrestamoAutomovil prestamoAuto1 = Object_PrestamoAutomovil(sc);
                    prestamoAuto1.setCiudadPrestamo();
                    prestamoAuto1.calcularValorMAutomovil();
                    listap.add(prestamoAuto1);
                    break;
                case 2:
                    System.out.println("\nPostulacion para Prestamo Educativo");
                    PrestamoEducativo prestamoEdu1 = crearObjeto_PrestamoEducativo(sc);
                    prestamoEdu1.setCiudadPrestamo();
                    prestamoEdu1.calcularValorMensualPago();
                    listap.add(prestamoEdu1);
                    break;
                case 3:
                    int n=1;
                    for(Prestamo prestamo : listap) {
                        System.out.println("Prestamo nro " + n);
                        System.out.println(prestamo.toString() );
                        n++;
                    } 
                    break;

                default:
                    System.err.println("ERROR! Escoja una opcion entre 0-3");
                    break;
            }
        }
    }
    
    public static PrestamoAutomovil Object_PrestamoAutomovil (Scanner teclado){
        String nombreB, apellidoB, userNameB, ciudad, nombreG, apellidoG, userNameG;
        String tipoAutomovil, marcaAutomovil;
        double meses, valorAutomovil;
        
        teclado.nextLine();
        System.out.println("Ingrese los datos del beneficiario");
        System.out.print("Nombre: ");
        nombreB = teclado.nextLine();
        System.out.print("Apellido: ");
        apellidoB = teclado.nextLine();
        System.out.print("Username: ");
        userNameB = teclado.nextLine();
        
        Persona beneficiario = new Persona(nombreB, apellidoB, userNameB);
        System.out.print("Ingrese en meses de cuanto tiempo desea el prestmo: ");
        meses = teclado.nextDouble();
        teclado.nextLine();
        System.out.print("Ingrese la Ciudad del prestamo: ");
        ciudad = teclado.nextLine();
        
        System.out.println("Ingrese datos del garante"); 
        System.out.print("Nombre: ");
        nombreG = teclado.nextLine();
        System.out.print("Apellido: ");
        apellidoG = teclado.nextLine();
        System.out.print("Username: ");
        userNameG = teclado.nextLine();
        
        Persona garante1 = new Persona(nombreG, apellidoG, userNameG);
        System.out.println("Ingrese los datos del automovil");
        System.out.print("Tipo del auto: ");
        tipoAutomovil = teclado.nextLine();
        System.out.print("Marca del auto:");
        marcaAutomovil = teclado.nextLine();
        System.out.print("Valor del auto: ");
        valorAutomovil = teclado.nextDouble();
        return new PrestamoAutomovil (tipoAutomovil, marcaAutomovil, garante1, valorAutomovil,beneficiario, meses, ciudad);
    }
    
    public static PrestamoEducativo crearObjeto_PrestamoEducativo(Scanner teclado){
        String nombreB, apellidoB, nombreusuarioB, ciudad, nombreC, siglasC;
        double meses, valorCarrera;
        
        teclado.nextLine();
        System.out.println("Ingrese los datos del beneficiario");
        System.out.print("Nombre: ");
        nombreB = teclado.nextLine();
        System.out.print("Apellido: ");
        apellidoB = teclado.nextLine();
        System.out.print("Username: ");
        nombreusuarioB = teclado.nextLine();
        Persona beneficiario = new Persona(nombreB, apellidoB, nombreusuarioB);
        
        System.out.print("Ingrese en meses de cuanto tiempo desea el prestmo: ");
        meses = teclado.nextDouble();
        teclado.nextLine();
        System.out.print("Ingrese la Ciudad del prestamo: ");
        ciudad = teclado.nextLine();
        
        System.out.print("Nivel de Estudio: "); String nivelEstudio = teclado.nextLine();
        System.out.print("Valor de la carrera: ");
        valorCarrera = teclado.nextDouble();
        teclado.nextLine();
        System.out.println("Ingrese los datos del centro educativo");
        System.out.print("Nombre:");
        nombreC = teclado.nextLine();
        System.out.print("Siglas:");
        siglasC = teclado.nextLine();
        InstitucionEducativa centroEducativo = new  InstitucionEducativa (nombreC,siglasC);
        return new PrestamoEducativo(nivelEstudio, centroEducativo, valorCarrera, beneficiario, meses, ciudad);
    }
}
