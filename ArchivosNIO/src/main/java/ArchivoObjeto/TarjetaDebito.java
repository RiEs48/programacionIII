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
public class TarjetaDebito implements Serializable{
    
    static final long SerialVersionUID=42L;
    // atributos
    private int Nrotarjeta;
    private int NroCuenta;
    private Double Saldo;
    private String Estado;
    
    // metodos
    
    
    public void Mostr5arTrajeta(){
    
            System.out.println("Nro Tarje:  "+this.Nrotarjeta);
            System.out.println("Nro Cuenta :"+this.NroCuenta);
            System.out.println("SALDO :"+this.Saldo);
            System.out.println("ESTADO :"+this.Estado);
            
    }

    public int getNrotarjeta() {
        return Nrotarjeta;
    }

    public void setNrotarjeta(int Nrotarjeta) {
        this.Nrotarjeta = Nrotarjeta;
    }

    public int getNroCuenta() {
        return NroCuenta;
    }

    public void setNroCuenta(int NroCuenta) {
        this.NroCuenta = NroCuenta;
    }

    public Double getSaldo() {
        return Saldo;
    }

    public void setSaldo(Double Saldo) {
        this.Saldo = Saldo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
}
