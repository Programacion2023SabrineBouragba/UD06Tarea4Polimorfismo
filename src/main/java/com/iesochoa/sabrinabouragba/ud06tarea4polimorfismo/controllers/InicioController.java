package com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo.controllers;

import com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo.model.Figura;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

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
    void onClickCirculo(MouseEvent event) {

    }

    @FXML
    void onClickColor(ActionEvent event) {

    }

    @FXML
    void onClickCuadrado(MouseEvent event) {

    }

    @FXML
    void onClickElipse(MouseEvent event) {

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

    }

    @FXML
    void onClickSliderX(MouseEvent event) {

    }

    @FXML
    void onClickSliderY(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
