/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArchivoObjeto;

import java.io.Serializable;

/**
 *
 * @author MARIO RIVAS
 */
public class Cliente implements Serializable{
 static final long serialVersionUID=43L;
 // atributos
 private String Nombre;
 private String ApellidoPat;
 private String ApellidoMat;
 private int Cedula;
 //definiendo la agregacion   que un cliente  puede tener una tarjeta  pero si quieremos que  puede tener varias  podemos  definir con un arraylist
 private TarjetaDebito tarjeta;
 
 public void MostrarCliente(){
     System.out.println(" NOMBRE :"+this.Nombre);
     System.out.println("apellido paterno :"+this.ApellidoPat);
     System.out.println("apellido materno :"+this.ApellidoMat);
     System.out.println("Carnet :"+this.Cedula);
     if (tarjeta!= null) {
         tarjeta.Mostr5arTrajeta();
         
     }else {
         System.out.println(" EL CLIENTE  NO TIENE TARJETA DE DEBITO AGREGADA!!!");
     }
     
     System.out.println("----------------------------------------------------------------------------------------------");
 
 
 }
   /// getter  y setters 

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoPat() {
        return ApellidoPat;
    }

    public void setApellidoPat(String ApellidoPat) {
        this.ApellidoPat = ApellidoPat;
    }

    public String getApellidoMat() {
        return ApellidoMat;
    }

    public void setApellidoMat(String ApellidoMat) {
        this.ApellidoMat = ApellidoMat;
    }

    public int getCedula() {
        return Cedula;
    }

    public void setCedula(int Cedula) {
        this.Cedula = Cedula;
    }

    public TarjetaDebito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaDebito tarjeta) {
        this.tarjeta = tarjeta;
    }
 
}
