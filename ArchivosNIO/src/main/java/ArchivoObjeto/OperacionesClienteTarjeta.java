/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArchivoObjeto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MARIO RIVAS
 */
public class OperacionesClienteTarjeta {

    List<Cliente> listaCliente;
    Scanner lee = new Scanner(System.in);

    // creamos un constructor vacio y  inicializamos nuestra  listacliente en arraylist
    public OperacionesClienteTarjeta() {

        listaCliente = new ArrayList<>();
    }

    //metodos
    public void crearClienteTarjta() {

        Cliente cliente = new Cliente();
        TarjetaDebito tarje = new TarjetaDebito();
        System.out.println("INGRESE  EL NOMBRE ");
        cliente.setNombre(lee.nextLine());
        System.out.println("INGRESE EL APELLIDO PATERNO ");
        cliente.setApellidoPat(lee.nextLine());
        System.out.println("INGRESE EL APELLIDO MATERNO");
        cliente.setApellidoMat(lee.nextLine());
        System.out.println("ingrese el NUMERO DE CARNET ");
        cliente.setCedula(lee.nextInt());
        /// llenando los datos de la Tarjeta
        System.out.println(" INGRESE EL NUMERO  DE TARJETA :");
        tarje.setNrotarjeta(lee.nextInt());
        System.out.println("INGRESE EL  Numero de cuenta :");
        tarje.setNroCuenta(lee.nextInt());
        System.out.println("ingrese el saldo de la tarjeta");
        tarje.setSaldo(lee.nextDouble());
        tarje.setEstado("activo");
        // agregando la tarjeta  al  cleiente 
        cliente.setTarjeta(tarje);
        // adicionando  el cleinte  a la lista  de  clientes 
        listaCliente.add(cliente);
        System.out.println(" REGISTRO REALIZADO EXITOSAMENTE!!!");
    }

    public void mostrarClIENTE() {
        if (listaCliente != null) {

            System.out.println("*****CLIENTES ACTIVOS //*//******");
            for (Cliente clienteaux : listaCliente) {
                clienteaux.MostrarCliente();
            }

        }

    }

    //cambiando el estado de una  tarjeta activa!!
    public void CambiaEstado(int cedula) {
        int sw = 0;
        if (listaCliente != null) {
            for (Cliente cliente : listaCliente) {
                if (cliente.getCedula() == cedula) {
                    sw = 1;
                    cliente.getTarjeta().setEstado("INACTIVO");
                    System.out.println("SU TARJETA  AH SIDO BLOQUEADA EXITOSAMENTE");

                }

            }
            if (sw == 0) {
                System.out.println("CLIENTE NO ENCONTRADO !!!");

            }

        }
    }

    //realizacon  el deposito a una cuenta
    public void Depositar(int cedula, double monto) {
        int sw = 1;
        if (listaCliente != null) {
            for (Cliente cliente : listaCliente) {
                if (cliente.getCedula() == cedula) {
                    sw = 1;
                    if (cliente.getTarjeta().getEstado().equalsIgnoreCase("ACTIVO")) {
                        double saldo = cliente.getTarjeta().getSaldo();
                        saldo = saldo + monto;
                        cliente.getTarjeta().setSaldo(saldo);
                        System.out.println("DEPOSITO REALIZADO");

                    } else {
                        System.out.println("TARJETA BLOQUEADA!!!");
                    }
                }

            }
            if (sw == 0) {
                System.out.println("el cliente no esta registrado !!!");

            }
        }

    }

    // retirar fondos siempre y cuaando la tarjeta este activa y tenga saldo 
    public void Retirar(int cedula, double reti) {
        int sw = 1;
        if (listaCliente != null) {
            for (Cliente cliente : listaCliente) {
                if (cliente.getCedula() == cedula && cliente.getTarjeta().getEstado().equalsIgnoreCase("activo")) {
                    sw = 1;
                    if (cliente.getTarjeta().getSaldo() <= reti) {
                        double ret = cliente.getTarjeta().getSaldo();
                        ret = ret - reti;
                        cliente.getTarjeta().setSaldo(ret);
                        System.out.println("RETIRO REALIZADO");

                    } else {
                        System.out.println("SU TARJETA ESTA BLOQUEADA !!!");
                    }

                }

            }
            if (sw == 0) {
                System.out.println("el cliente no se encuentra registrado");

            }

        }

    }

    //  CREARNOS UN  ARCHIVO
    public void CrearArchivo() {
        Path path = Paths.get("D:\\programacionIII\\archivosClienete.txt");
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
                System.out.println(" el arvhi se creo correctamente");
            } else {
                System.out.println(" el arvho ya existe");
            }
        } catch (Exception e) {
        }
// guardando la lista  cliente   dentro  dela archivo creado con aterioridad 

    }

    public void guardandoObject() {
        String ruta = "D:\\programacionIII\\archivosClienete.txt";
        try {
            FileOutputStream archivo = new FileOutputStream(ruta);
            ObjectOutputStream OOS = new ObjectOutputStream(archivo);
            OOS.writeObject(listaCliente);
            OOS.close();
            archivo.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesClienteTarjeta.class.getName()).log(Level.SEVERE, null, ex);

        } catch (IOException ex) {

            Logger.getLogger(OperacionesClienteTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void leerClientes() {

        String ruta = "D:\\programacionIII\\archivosClienete.txt";
        try {
            FileInputStream archivo = new FileInputStream(ruta);
            ObjectInputStream OIS = new ObjectInputStream(archivo);
            if (OIS != null) {
                listaCliente = (List<Cliente>) OIS.readObject();
            } else {
                System.out.println(" EL OBJETO ES NULO");
            }

        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesClienteTarjeta.class.getName()).log(Level.SEVERE, null, e);
        } catch (IOException ex) {
            Logger.getLogger(OperacionesClienteTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {

            Logger.getLogger(OperacionesClienteTarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
