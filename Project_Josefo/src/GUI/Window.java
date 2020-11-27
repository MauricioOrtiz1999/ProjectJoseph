/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Soldado;
import TDAs.CircularDoublyLinkedList;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
/**
 *
 * @author PC
 */
public class Window {
    private final CircularDoublyLinkedList<Soldado> soldados;
    private BorderPane root;
    private ComboBox cb;
    private TextField tf1;
    private TextField tf2;
    private Button b;
    
    public Window() {
        root=new BorderPane();
        soldados=new CircularDoublyLinkedList<>();        
        VBox v=new VBox();
        v.setSpacing(30);
        v.setAlignment(Pos.CENTER);
        Label titulo=new Label("El problema de Josefo");
        HBox h1= new HBox();
        h1.setSpacing(10);
        Label l1=new Label("Número de personas");
        tf1=new TextField();
        h1.getChildren().addAll(l1,tf1);
        HBox h2=new HBox();
        h2.setSpacing(15);
        Label l2=new Label("Persona que inicira");
        tf2=new TextField();
        h2.getChildren().addAll(l2,tf2);
        HBox h3=new HBox();
        h3.setSpacing(25);
        Label l3=new Label("Orden de ejecución");
        cb=new ComboBox(FXCollections.observableArrayList("Derecha", "Izquierda"));
        h3.getChildren().addAll(l3,cb);
        b=new Button("Start");
        v.getChildren().addAll(titulo,h1,h2,h3,b);
        root.setRight(v);        
    }

    public BorderPane getRoot() {
        return root;
    }
    
}