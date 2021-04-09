/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArchivoObjeto;

import java.util.Scanner;

/**
 *
 * @author MARIO RIVAS
 */
public class PrincipalClienteTarjeta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int OPC = 0;
        boolean continuar = true;
        OperacionesClienteTarjeta obj = new OperacionesClienteTarjeta();
        Scanner lee = new Scanner(System.in);
        do {
            System.out.println(" MENU DE OPCIONES");
            System.out.println(" 1.CREAR ARCHIVO ");
            System.out.println("2. REGISTRAR CLIENTE -TARJETA");
            System.out.println("3.GUARDAR REGISTROS");
            System.out.println("4.MOSTRAR DATOS ");
            System.out.println("5.BLOEQUEAR TARJETA");
            System.out.println("6.DEPOSITAR DINERO");
            System.out.println("7.REALIZAR RETIRO");
            
            System.out.println("7. SALIR");
            System.out.println(" DIGITE UNA OPCION ");
            OPC = lee.nextInt();
            switch (OPC) {
                case 1:
                    obj.CrearArchivo();
                    break;
                case 2:
                    String res = "s";
                    while (res.equalsIgnoreCase("s")) {
                        obj.crearClienteTarjta();
                        System.out.println("DECEA SEGUIR REGISTRANDO CLIENTE  S/N ?");
                        res = lee.nextLine();
                    }

                    break;
                case 3:
                    obj.guardandoObject();
                    break;
                case 4:
                    obj.leerClientes();
                    obj.mostrarClIENTE();
                    break;
                case 5:
                    obj.leerClientes();
                    System.out.println("DIGITE EL NUMERO DE CEDULA DEL CLIENTE");
                    int cedula= lee.nextInt();
                    obj.CambiaEstado(cedula);
                    obj.guardandoObject();
                    break;
                case 6:
                    obj.leerClientes();
                    System.out.println("INGRESE EL NUMERO DE CEDULA ");
                    int ce=lee.nextInt();
                    System.out.println(" INGRESE EL MONTO   A DEPOSITAR");
                    double mon=lee.nextDouble();
                    obj.Depositar(ce, mon);
                    obj.guardandoObject();
                    break;
                case 7:
                    obj.leerClientes();
                    System.out.println("INGRESE LA CEDULA DE INDENDITDAD");
                    int c=lee.nextInt();
                    System.out.println("INGRESE EL MONTO A RETIRAR");
                    double ret=lee.nextDouble();
                    obj.Retirar(c, ret);
                    obj.guardandoObject();
                    break;
                    
                default:
                    continuar = false;
                    break;
            }

        } while (continuar);

    }

}
