/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author PC
 */
public class Soldado {
    private boolean vivo;
    private int position;
    public Soldado(int position) {
        vivo=true;
        this.position = position;
    }
    public boolean isVivo() {
        return vivo;
    }
    public int getPosition() {
        return position;
    }
    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
    public void setPosition(int position) {
        this.position = position;
    }    
}