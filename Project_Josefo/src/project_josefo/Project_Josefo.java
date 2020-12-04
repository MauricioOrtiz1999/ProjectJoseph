/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_josefo;

import GUI.Window;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author Mauricio Ortiz Lascano
 */
public class Project_Josefo extends Application {
    @Override
    public void start(Stage primaryStage) {
        Window w=new Window();
        
        Scene scene = new Scene(w.getRoot(), 1000, 600);
        
        primaryStage.setTitle("Algoritmo de Joseph");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}