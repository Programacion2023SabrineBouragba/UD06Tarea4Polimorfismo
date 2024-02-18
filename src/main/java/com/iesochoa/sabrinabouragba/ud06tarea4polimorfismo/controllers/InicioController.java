package com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo.controllers;

import com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo.model.Circulo;
import com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo.model.Cuadrado;
import com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo.model.Figura;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InicioController implements Initializable {
    //figura actual
    Figura figuraActual;
    //posicion central
    int xInicial;
    int yInicial;
    //tamaño inicial
    int sizeInicial=50;
    //lista con las figuras
    //utilizamos polimorfismo
    ArrayList<Figura> figuras= new ArrayList<>();

    @FXML
    private Button btBorrarTodos;

    @FXML
    private Button btGuardar;

    @FXML
    private Button btIniciar;

    @FXML
    private Button btParar;

    @FXML
    private ColorPicker cpColor;

    @FXML
    private Pane pnPanel;

    @FXML
    private Slider slPosicionSize;

    @FXML
    private Slider slPosicionX;

    @FXML
    private Slider slPosicionY;

    @FXML
    void onClickBorrarTodo(ActionEvent event) {

    }

    @FXML
    void onClickColor(ActionEvent event) {
        if (figuraActual!=null){
            figuraActual.cambiarColor(cpColor.getValue());
        }
    }

    @FXML
    void onClickSeleccionFigura(MouseEvent event) {
        //si ya hay una figura la quitamos
        if(figuraActual !=null){
            figuraActual.borrar(pnPanel);
        }
        //event tiene el objeto al que se ha pulsado
        Object figuraSeleccionada=event.getSource();
        //comprobamos el tipo de clase para saber la figura a la que se ha pulsado
        if(figuraSeleccionada instanceof Circle){
            figuraActual =new Circulo(xInicial,yInicial,cpColor.getValue(),sizeInicial/2);
        }else if (figuraSeleccionada instanceof Rectangle){
            //por hacer
        }else{
            //por hacer
        }
        figuraActual.dibujar(pnPanel);
    }

    @FXML
    void onClickGuardar(ActionEvent event) {

    }

    @FXML
    void onClickIniciar(ActionEvent event) {

    }

    @FXML
    void onClickParar(ActionEvent event) {

    }

    @FXML
    void onClickSliderSize(MouseEvent event) {
        if (figuraActual!=null){
            figuraActual.cambiarSize((int)slPosicionSize.getValue());
        }
    }

    @FXML
    void onClickSliderX(MouseEvent event) {
        if (figuraActual!=null){
            figuraActual.cambiarPosicion((int)slPosicionX.getValue(), figuraActual.getY());
        }
    }

    @FXML
    void onClickSliderY(MouseEvent event) {
        if (figuraActual!=null){
            figuraActual.cambiarPosicion(figuraActual.getX(), (int)slPosicionY.getValue());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //se ejecutará cuando ya se muestre la scene
        Platform.runLater(() -> {
            //obtenemos el tamaño del padre del Pane, en nuestro caso el AnchorPane
            int anchoPanel=(int)pnPanel.getParent().getScene().getWidth();
            //El alto es el alto del padre - su posición
            int altoPanel=(int)(pnPanel.getParent().getScene().getHeight()-pnPanel.getLayoutY());
            //su nuevo tamaño
            pnPanel.setPrefWidth(anchoPanel);
            pnPanel.setPrefHeight(altoPanel);
            //el centro del panel
            xInicial=anchoPanel/2;
            yInicial=altoPanel/2;
            //le damos a los slader X Y el valor máximo para que no se salga la figura
            //del panel
            slPosicionX.setMax(anchoPanel);
            slPosicionX.setValue(xInicial);
            slPosicionY.setMax(altoPanel);
            slPosicionY.setValue(yInicial);
            //Desactivamos el botón Parar para que no se use
            //btParar.setDisable(true);
        });
    }
}
