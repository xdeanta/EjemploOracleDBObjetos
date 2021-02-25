/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaoracleobjectos;

import java.io.Serializable;

/**
 *
 * @author oracle
 */
public class Direccion implements Serializable {
    private String calle;
    private String ciudad;
    private int zip;

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public Direccion(String calle, String ciudad, int zip) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.zip = zip;
    }
    
    
    
}
