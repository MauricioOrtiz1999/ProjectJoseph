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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
/**
 *
 * @author PC
 */
public class Window {
      private CircularDoublyLinkedList<Soldado> soldados;    
      private BorderPane root;    
      private StackPane g;
      private VBox v;
      private HBox h1;
      private HBox h2;
      private HBox h3;
      private ComboBox<Integer> cb1;
      private ComboBox<Integer> cb2;
      private ComboBox<String> cb3;
      private Label titulo;
      private Label l1;
      private Label l2;
      private Label l3;
      private Button start;

    public Window() {
        iniciar();
    }
    
    public void iniciar(){
        soldados=new CircularDoublyLinkedList<>();
        
        root=new BorderPane();        
        soldados=new CircularDoublyLinkedList<>();
        g=new StackPane();
        root.setCenter(g);
        
        v=new VBox();
        titulo=new Label("El problema de Josefo");
        
        h1= new HBox();
        l1=new Label("Número de personas");
        cb1=new ComboBox(FXCollections.observableArrayList(2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
        
        h2=new HBox();
        l2=new Label("Persona que iniciará");
        cb2=new ComboBox(FXCollections.observableArrayList(1, 2));
        
        h3=new HBox();
        l3=new Label("Orden de ejecución");
        cb3=new ComboBox(FXCollections.observableArrayList("Derecha", "Izquierda"));
        
        start=new Button("Start");
        
        configuraciones();
        
        h1.getChildren().addAll(l1,cb1);            
        h2.getChildren().addAll(l2,cb2);       
        h3.getChildren().addAll(l3,cb3);        
        v.getChildren().addAll(titulo,h1,h2,h3,start);
        root.setRight(v);
    }
    public void configuraciones(){
        v.setStyle("-fx-background-color: #a8ebb7;");
        v.setSpacing(100);
        v.setPadding(new Insets(10));
        v.setAlignment(Pos.CENTER);
        
        titulo.setStyle("-fx-text-fill : #1d9634; -fx-font-size: 15pt; -fx-font-weight: bold;");
        
        h1.setSpacing(15);
        cb1.setOnAction(e->{
            cb2.getItems().clear();
            for(int i=1;i<=cb1.getSelectionModel().getSelectedItem();i++)
                cb2.getItems().add(i);
            cb2.getSelectionModel().select(0);
        });
        cb1.getSelectionModel().select(0);
        
        h2.setSpacing(15);
        cb2.getSelectionModel().select(0);
        
        h3.setSpacing(15);
        cb3.getSelectionModel().select("Derecha");
        
        start.setOnAction(e->{
            llenarPane(cb1.getSelectionModel().getSelectedItem(),
                    cb2.getSelectionModel().getSelectedItem());
            //AlgoritmoJosefo a=new AlgoritmoJosefo();
            //a.start();            
        });
    }
    public void llenarPane(double numSoldados, int indx){
        g.getChildren().clear();
        soldados.clear();
        for(int i=1;i<=numSoldados;i++){
            Circle c=new Circle(10);
            c.setTranslateX(Math.cos(Math.toRadians(((360 / numSoldados) * i)+90))*150);
            c.setTranslateY(Math.sin(Math.toRadians(((360 / numSoldados) * i)+90))*150);
            soldados.addLast(new Soldado(c));
            Label l=new Label(String.valueOf(i));
            l.setStyle("-fx-text-fill : white; -fx-font-weight: bold;");
            l.setTranslateX(Math.cos(Math.toRadians(((360 / numSoldados) * i)+90))*150);
            l.setTranslateY(Math.sin(Math.toRadians(((360 / numSoldados) * i)+90))*150);
            if(i==indx)
                c.setFill(Color.ORANGE);
            else
                c.setFill(Color.GREEN);
            g.getChildren().addAll(c,l);
        }
    }

    public BorderPane getRoot(){
        return root;
    }
    
    
}