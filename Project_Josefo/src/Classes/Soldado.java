
package Classes;

import javafx.scene.shape.Circle;

/**
 *
 * @author Group#9
 */
public class Soldado {
    private boolean vivo;
    private Circle circulo;
    public Soldado(Circle c){
        this.vivo=true;
        this.circulo=c;
    }
    public boolean isVivo(){
        return vivo;
    }
    public void setVivo(boolean vivo){
        this.vivo = vivo;
    }
    public Circle getCirculo() {
        return circulo;
    }
}