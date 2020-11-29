/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Soldado;
import TDAs.CircularDoublyLinkedList;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
/**
 *
 * @author PC
 */
public class Window {
    private CircularDoublyLinkedList<Soldado> soldados;
    private BorderPane root;
    private ComboBox<Integer> cb1;
    private ComboBox<Integer> cb2;
    private ComboBox<String> cb3;
    private TextField tf1;
    private TextField tf2;
    private Button b;
    private StackPane g;
    
    public Window() {
        root=new BorderPane();        
        soldados=new CircularDoublyLinkedList<>();
        g=new StackPane();
        VBox v=new VBox();
        v.setStyle("-fx-background-color: #a8ebb7;");
        v.setSpacing(100);
        v.setPadding(new Insets(10));
        v.setAlignment(Pos.CENTER);
        Label titulo=new Label("El problema de Josefo");
        titulo.setStyle("-fx-text-fill : #1d9634; -fx-font-size: 15pt; -fx-font-weight: bold;");
        HBox h1= new HBox();
        h1.setSpacing(15);
        Label l1=new Label("Número de personas");
        cb1=new ComboBox(FXCollections.observableArrayList(2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
        cb1.setOnAction(e->{            
            int numSoldados=cb1.getSelectionModel().getSelectedItem();
            cb2.getItems().clear();
            for(int i=1;i<=numSoldados;i++)
                cb2.getItems().add(i);
            cb2.getSelectionModel().select(0);
        });
        cb1.getSelectionModel().select(0);
        h1.getChildren().addAll(l1,cb1);
        HBox h2=new HBox();
        h2.setSpacing(15);
        Label l2=new Label("Persona que iniciará");
        cb2=new ComboBox(FXCollections.observableArrayList(1, 2));
        cb2.getSelectionModel().select(0);
        h2.getChildren().addAll(l2,cb2);
        HBox h3=new HBox();
        h3.setSpacing(15);
        Label l3=new Label("Orden de ejecución");
        cb3=new ComboBox(FXCollections.observableArrayList("Derecha", "Izquierda"));
        cb3.getSelectionModel().select("Derecha");
        h3.getChildren().addAll(l3,cb3);
        b=new Button("Start");
        b.setOnAction(e->{
            algoritmoJosefo(cb1.getSelectionModel().getSelectedItem(),
                    cb2.getSelectionModel().getSelectedItem(),cb3.getSelectionModel().getSelectedItem());
        });
        v.getChildren().addAll(titulo,h1,h2,h3,b);
        root.setRight(v);
    }

    public BorderPane getRoot(){
        return root;
    }
    
    public void algoritmoJosefo(int numSoldados,int inicia, String direccion){
        soldados=new CircularDoublyLinkedList<>();
        g.getChildren().clear();
        for(int i=0;i<numSoldados;i++){
            soldados.addLast(new Soldado(i));
            Circle c=new Circle(10);
            c.setTranslateX(150 * Math.cos(Math.toRadians(((360 / (double) numSoldados) * i)+90)));
            c.setTranslateY(150 * Math.sin(Math.toRadians(((360 / (double) numSoldados) * i)+90)));            
            g.getChildren().add(c);
        }
        root.setCenter(g);
    }
}