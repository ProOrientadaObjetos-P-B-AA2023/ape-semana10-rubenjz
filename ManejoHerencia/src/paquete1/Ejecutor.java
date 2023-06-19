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
                    PrestamoAutomovil prestamoAuto1 = crearObjeto_PrestamoAutomovil(sc);
                    prestamoAuto1.setCiudadPrestamo();
                    prestamoAuto1.calcularValorMensualPagoAutomovil();
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
    
    public static PrestamoAutomovil crearObjeto_PrestamoAutomovil (Scanner teclado){
        //Persona y Prestamo
        System.out.println("INGRESE DATOS DEL BENEFICIARIO");
        teclado.nextLine();
        System.out.print("Nombre: "); String nombreB = teclado.nextLine();
        System.out.print("Apellido: "); String apellidoB = teclado.nextLine();
        System.out.print("Username: "); String userNameB = teclado.nextLine();
        Persona beneficiario = new Persona(nombreB, apellidoB, userNameB);
        System.out.print("Ingrese el Tiempo de prestamo en meses: "); double meses = teclado.nextDouble();
        teclado.nextLine();
        System.out.print("Ingrese la Ciudad del prestamo: "); String ciudad = teclado.nextLine();
        //Prestamo new = Prestamo(beneficiario, meses, ciudad);
        //PERSONA
        System.out.println("INGRESE DATOS DEL GARANTE 1"); 
        System.out.print("Nombre: "); String nombreG = teclado.nextLine();
        System.out.print("Apellido: "); String apellidoG = teclado.nextLine();
        System.out.print("Username: "); String userNameG = teclado.nextLine();
        Persona garante1 = new Persona(nombreG, apellidoG, userNameG);
        
        //PrestamoAutomovil
        System.out.println("INGRESE DATOS DEL AUTOMOVIL");
        System.out.print("Tipo: "); String tipoAutomovil = teclado.nextLine();
        System.out.print("Marca :"); String marcaAutomovil = teclado.nextLine();
        System.out.print("Valor del Automovil: "); double valorAutomovil = teclado.nextDouble();
        return new PrestamoAutomovil (tipoAutomovil, marcaAutomovil, garante1, valorAutomovil,beneficiario, meses, ciudad);
    }
    
    public static PrestamoEducativo crearObjeto_PrestamoEducativo(Scanner teclado){
        //PersonaBeneficiaria y Prestamo
        System.out.println("INGRESE DATOS DEL BENEFICIARIO");
        teclado.nextLine();
        System.out.print("Nombre: "); String nombreB = teclado.nextLine();
        System.out.print("Apellido: "); String apellidoB = teclado.nextLine();
        System.out.print("Username: "); String userNameB = teclado.nextLine();
        Persona beneficiario = new Persona(nombreB, apellidoB, userNameB);
        
        System.out.print("Ingrese el Tiempo de prestamo en meses: "); double meses = teclado.nextDouble();
        teclado.nextLine();
        System.out.print("Ingrese la Ciudad del prestamo: "); String ciudad = teclado.nextLine();
        //PrestamoEducativo
        System.out.print("Nivel de Estudio: "); String nivelEstudio = teclado.nextLine();
        System.out.print("Valor de la carrera: "); double valorCarrera = teclado.nextDouble();
        teclado.nextLine();
        System.out.println("INGRESE DATOS DEL CENTRO EDUCATIVO");
        System.out.print("Nombre:"); String nombreC = teclado.nextLine();
        System.out.print("Siglas:"); String siglasC = teclado.nextLine();
        InstitucionEducativa centroEducativo = new  InstitucionEducativa (nombreC,siglasC);
        return new PrestamoEducativo(nivelEstudio, centroEducativo, valorCarrera, beneficiario, meses, ciudad);
    }
}
