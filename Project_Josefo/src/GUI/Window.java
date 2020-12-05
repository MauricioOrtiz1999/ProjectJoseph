/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Soldado;
import TDAs.CircularDoublyLinkedList;
import java.util.Iterator;
import java.util.ListIterator;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
import javafx.scene.text.Font;
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
      private VBox opCont;
      private HBox h1;
      private HBox h2;
      private HBox h3;
      private HBox botones;
      private HBox title;
      private HBox opcionExtra;
      private ComboBox<Integer> cb1;
      private ComboBox<Integer> cb2;
      private ComboBox<String> cb3;
      private ComboBox<Integer> revivir;
      private Label titulo;
      private Label l1;
      private Label l2;
      private Label l3;
      private Label tituloOpcion;
      private Label opcionEx;
      private Button start;
      private Button pause;
      private Button resume;
      private Button revivirbtn;
      private AlgoritmoJosefo algo;

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
        titulo=new Label("El Problema De Josefo");
        
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
        pause=new Button("Pause");
        resume=new Button("Resume");
        
        botones=new HBox();
        title=new HBox();
        
        opCont=new VBox();
        tituloOpcion=new Label("Opcion Extra");
        opcionExtra=new HBox();
        opcionEx=new Label("Revivir Soldado:");
        revivir=new ComboBox(FXCollections.observableArrayList(1,2));
        revivirbtn=new Button("Revivir");
        
        configuraciones();
        
        h1.getChildren().addAll(l1,cb1);            
        h2.getChildren().addAll(l2,cb2);       
        h3.getChildren().addAll(l3,cb3);
        opcionExtra.getChildren().addAll(opcionEx,revivir);
        opCont.getChildren().addAll(tituloOpcion,opcionExtra,revivirbtn);
        title.getChildren().addAll(titulo);
        botones.getChildren().addAll(start,pause,resume);
        v.getChildren().addAll(h1,h2,h3,botones);
        container.getChildren().addAll(title,v,opCont);
        root.setRight(container);
    }
    
    public void configuraciones(){
        
        container.setStyle("-fx-background-color: #a8ebb7;");
        container.setSpacing(30);
        container.setAlignment(Pos.CENTER);
        
        title.setAlignment(Pos.CENTER);
        
        v.setSpacing(70);
        v.setPadding(new Insets(10));
        v.setAlignment(Pos.CENTER);
        
        revivirbtn.setDisable(true);
        pause.setDisable(true);
        resume.setDisable(true);
        
        l1.setStyle("-fx-font-size: 10pt; -fx-font-weight: bold;");
        l2.setStyle("-fx-font-size: 10pt; -fx-font-weight: bold;");
        l3.setStyle("-fx-font-size: 10pt; -fx-font-weight: bold;");
        tituloOpcion.setStyle("-fx-text-fill : #1d9634; -fx-font-size: 12pt; -fx-font-weight: bold;");
        opcionEx.setStyle("-fx-font-size: 10pt; -fx-font-weight: bold;");
        
        //Darle estilo a los Botones
        start.setStyle("-fx-background-color: #000000,linear-gradient(#7ebcea, #2f4b8f),linear-gradient(#426ab7, #263e75),linear-gradient(#395cab, #223768); -fx-background-insets: 0,1,2,3; -fx-background-radius: 3,2,2,2; -fx-padding: 12 30 12 30; -fx-text-fill: white; -fx-font-size: 12px;-fx-pref-height: 28px;-fx-pref-width: 110px;");
        pause.setStyle("-fx-background-color: #000000,linear-gradient(#7ebcea, #2f4b8f),linear-gradient(#426ab7, #263e75),linear-gradient(#395cab, #223768); -fx-background-insets: 0,1,2,3; -fx-background-radius: 3,2,2,2; -fx-padding: 12 30 12 30; -fx-text-fill: white; -fx-font-size: 12px;-fx-pref-height: 28px;-fx-pref-width: 110px;");
        resume.setStyle("-fx-background-color: #000000,linear-gradient(#7ebcea, #2f4b8f),linear-gradient(#426ab7, #263e75),linear-gradient(#395cab, #223768); -fx-background-insets: 0,1,2,3; -fx-background-radius: 3,2,2,2; -fx-padding: 12 30 12 30; -fx-text-fill: white; -fx-font-size: 12px;-fx-pref-height: 28px;-fx-pref-width: 110px;");
        revivirbtn.setStyle("-fx-background-color: #090a0c,linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),linear-gradient(#20262b, #191d22),radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));-fx-background-radius: 5,4,3,5;-fx-background-insets: 0,1,2,0;-fx-text-fill: white;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );-fx-font-family: \"Arial\";-fx-text-fill: linear-gradient(white, #d0d0d0);-fx-font-size: 12px;-fx-padding: 10 20 10 20;");
        
        //Darle estilo a los ComboBox
        cb1.setStyle("-fx-background-color:linear-gradient(#f0ff35, #a9ff00),radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);-fx-background-radius: 6, 5;-fx-background-insets: 0, 1;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-text-fill: #395306;");
        cb2.setStyle("-fx-background-color:linear-gradient(#f0ff35, #a9ff00),radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);-fx-background-radius: 6, 5;-fx-background-insets: 0, 1;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-text-fill: #395306;");
        cb3.setStyle("-fx-background-color:linear-gradient(#f0ff35, #a9ff00),radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);-fx-background-radius: 6, 5;-fx-background-insets: 0, 1;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-text-fill: #395306;");
        revivir.setStyle("-fx-background-color:linear-gradient(#f0ff35, #a9ff00),radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);-fx-background-radius: 6, 5;-fx-background-insets: 0, 1;-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );-fx-text-fill: #395306;");
        
        botones.setSpacing(10);
        botones.setPadding(new Insets(5));
        botones.setAlignment(Pos.CENTER);
        
        titulo.setStyle("-fx-text-fill : #1d9634; -fx-font-size: 15pt; -fx-font-weight: bold;");
        
        h1.setSpacing(15);
        h1.setAlignment(Pos.CENTER);
        cb1.setOnAction(e->{
            cb2.getItems().clear();
            for(int i=1;i<=cb1.getSelectionModel().getSelectedItem();i++)
                cb2.getItems().add(i);
            cb2.getSelectionModel().select(0);
            revivir.getItems().clear();
            for(int i=1;i<=cb1.getSelectionModel().getSelectedItem();i++)
                revivir.getItems().add(i);
            revivir.getSelectionModel().select(0);
        });
        cb1.getSelectionModel().select(0);
        
        h2.setSpacing(15);
        h2.setAlignment(Pos.CENTER);
        cb2.getSelectionModel().select(0);
        
        h3.setSpacing(15);
        h3.setAlignment(Pos.CENTER);
        cb3.getSelectionModel().select("Derecha");
        
        
        start.setOnAction(e->{
            llenarPane(cb1.getSelectionModel().getSelectedItem(),
                    cb2.getSelectionModel().getSelectedItem());
            revivirbtn.setDisable(true);
            algo=new AlgoritmoJosefo();
            algo.start();
                       
        });
        
        pause.setOnAction(e->algo.suspend());
        
        resume.setOnAction(e-> algo.resume());
        
        opCont.setAlignment(Pos.CENTER);
        opCont.setSpacing(10);
        opCont.setPadding(new Insets(10));
        
        revivir.getSelectionModel().select(0);
        
        opcionExtra.setAlignment(Pos.CENTER);
        opcionExtra.setSpacing(10);
        opcionExtra.setPadding(new Insets(10));
        
        revivirbtn.setOnAction(e-> revivirSoldado());
        
    }
    
    
    public void llenarPane(double numSoldados, int indx){
        g.getChildren().clear();
        soldados.clear();
        for(int i=1;i<=numSoldados;i++){
            Circle c=new Circle(20);
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
    
    private void revivirSoldado(){
        
        ListIterator<Soldado> it=soldados.ListIterator(revivir.getSelectionModel().getSelectedItem()-1);
        Soldado sold=it.next();
        sold.setVivo(true);
        sold.getCirculo().setFill(Color.GREEN);
        
    }

    public BorderPane getRoot(){
        return root;
    }
    
    private class AlgoritmoJosefo extends Thread{
        @Override
        public void run() {
            start.setDisable(true);
            pause.setDisable(false);
            resume.setDisable(false);
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
            
            start.setDisable(false);
            revivirbtn.setDisable(false);
            pause.setDisable(true);
            resume.setDisable(true);
        }
    }
    
    
}