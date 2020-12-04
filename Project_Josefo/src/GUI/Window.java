/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Soldado;
import TDAs.CircularDoublyLinkedList;
import java.util.ListIterator;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
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
      private Background backGround;
      private BackgroundImage bImage;
      private BackgroundSize bSize;
      private Image image;
      private VBox v;
      private VBox container;
      private HBox h1;
      private HBox h2;
      private HBox h3;
      private HBox botones;
      private HBox title;
      private ComboBox<Integer> cb1;
      private ComboBox<Integer> cb2;
      private ComboBox<String> cb3;
      private Label titulo;
      private Label l1;
      private Label l2;
      private Label l3;
      private Button start;
      private Button stop;
      private Button resume;

    public Window() {
        iniciar();
    }
    
    public void iniciar(){
        soldados=new CircularDoublyLinkedList<>();
        
        root=new BorderPane();
        
        //Set del BackGround 
        image=new Image("/Imagenes/backGround.jpg");
        bSize=new BackgroundSize(1000,600,false,false,true,true);
        bImage=new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,bSize);
        backGround=new Background(bImage);
        root.setBackground(backGround);
        
        soldados=new CircularDoublyLinkedList<>();
        g=new StackPane();
        root.setCenter(g);
        
        container=new VBox();
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
        stop=new Button("Stop");
        resume=new Button("Resume");
        
        botones=new HBox();
        title=new HBox();
        
        configuraciones();
        
        h1.getChildren().addAll(l1,cb1);            
        h2.getChildren().addAll(l2,cb2);       
        h3.getChildren().addAll(l3,cb3);
        title.getChildren().addAll(titulo);
        botones.getChildren().addAll(start,stop,resume);
        v.getChildren().addAll(h1,h2,h3,botones);
        container.getChildren().addAll(title,v);
        root.setRight(container);
    }
    public void configuraciones(){
        
        container.setStyle("-fx-background-color: #a8ebb7;");
        container.setSpacing(70);
        container.setAlignment(Pos.CENTER);
        
        title.setAlignment(Pos.CENTER);
        
        v.setSpacing(100);
        v.setPadding(new Insets(10));
        v.setAlignment(Pos.CENTER);
        
        botones.setSpacing(10);
        botones.setPadding(new Insets(5));
        botones.setAlignment(Pos.CENTER);
        
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
            AlgoritmoJosefo a=new AlgoritmoJosefo();
            a.start();            
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
    
    private class AlgoritmoJosefo extends Thread{
        @Override
        public void run() {
            try{
                Thread.sleep(1500);
            }catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            ListIterator<Soldado> lS=soldados.ListIterator(cb2.getSelectionModel().getSelectedItem()-1);
            int soldadosVivos=soldados.size();
            boolean b=cb3.getSelectionModel().getSelectedItem().equals("Derecha");
            while(soldadosVivos>1){
                Soldado s1;
                if(b)s1=lS.next();
                else s1=lS.previous();
                if(s1.isVivo()){
                    Soldado s;
                    if(b){
                        do
                            s=lS.next();
                        while(!s.isVivo());
                    }else{
                        do
                            s=lS.previous();
                        while(!s.isVivo());
                    }
                    s.setVivo(false);
                    s.getCirculo().setFill(Color.RED);
                    soldadosVivos--;
                    try{
                        Thread.sleep(1500);
                    }catch (InterruptedException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }
    }
    
    
}