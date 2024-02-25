package com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo.controllers;

import com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo.model.Circulo;
import com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo.model.Cuadrado;
import com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo.model.Elipse;
import com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo.model.Figura;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

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
    Timeline timeline;

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
    private AnchorPane apCrearFiguras;

    /**
     * Funcionalidad al dar clic para guardar la figura y borrarla del panel.
     * Guarda todas las figuras en la lista.
     */
    @FXML
    void onClickGuardar(ActionEvent event) {
        //añadimos la figura a la lista
        figuras.add(figuraActual);
        //quitamos la figura de la pantalla
        figuraActual.borrar(pnPanel);
    }

    /**
     * Funcionalidad al dar clic para borrar todas las figuras.
     * Borra todas las figuras de la lista.
     */
    @FXML
    void onClickBorrarTodo(ActionEvent event) {
        //borramos de la lista todas las figuras
        figuras.clear();
    }

    /**
     * Funcionalidad al dar clic para asignar color a las figuras.
     * Cambia color de las figuras.
     */
    @FXML
    void onClickColor(ActionEvent event) {
        if (figuraActual!=null){
            figuraActual.cambiarColor(cpColor.getValue());
        }
    }

    /**
     * Acción donde se selecciona una figura.
     * Si ya hay una figura seleccionada, la borra del panel.
     * Luego, crea una nueva instancia de la figura seleccionada y la dibuja en el panel.
     */
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
        } else if (figuraSeleccionada instanceof Rectangle) {
            figuraActual = new Cuadrado(xInicial, yInicial, cpColor.getValue(), sizeInicial/2);
        }else if (figuraSeleccionada instanceof Ellipse){
            figuraActual =new Elipse(xInicial,yInicial,cpColor.getValue(),sizeInicial/2);
        }

        figuraActual.dibujar(pnPanel);
    }

    /**
     * Acción donde se inicia la lista de figuras.
     * Borra las figuras del panel.
     * Luego, se incia el trayecto establecido.
     */
    @FXML
    void onClickIniciar(ActionEvent event) {
        //quitamos figura actual del panel
        if (figuraActual!=null){
            figuraActual.borrar(pnPanel);
        }
        //dibujamos las figuras
        for (Figura figura: figuras){
            figura.dibujar(pnPanel);
        }
        probandoFiguras(false);
        //iniciamos la animacion
        iniciaMovimiento();
    }

    /**
     * Acción donde se para la lista de figuras.
     */
    @FXML
    void onClickParar(ActionEvent event) {
        //quitamos las figuras
        for (Figura figura: figuras){
            figura.borrar(pnPanel);
        }

        //iniciamos la animacion
        timeline.stop();
        probandoFiguras(true);
    }

    /**
     * Acción donde se establece el tamaño de la figura.
     */
    @FXML
    void onClickSliderSize(MouseEvent event) {
        if (figuraActual!=null){
            figuraActual.cambiarSize((int)slPosicionSize.getValue());
        }
    }

    /**
     * Acción donde se establece posicion X de la figura.
     */
    @FXML
    void onClickSliderX(MouseEvent event) {

        if (figuraActual!=null){
            figuraActual.cambiarPosicion((int)slPosicionX.getValue(), figuraActual.getY());
        }
    }

    /**
     * Acción donde se establece posicion Y de la figura.
     */
    @FXML
    void onClickSliderY(MouseEvent event) {
        if (figuraActual!=null){
            figuraActual.cambiarPosicion(figuraActual.getX(), (int)slPosicionY.getValue());
        }
    }

    /**
     * Inicializa el controlador después de que se haya cargado la interfaz de usuario.
     * Configura el tamaño del panel y los valores iniciales de los sliders.
     */
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
            //le damos a los slader X Y el valor máximo para que no se salga la figura del panel
            slPosicionX.setMax(anchoPanel);
            slPosicionX.setValue(xInicial);
            slPosicionY.setMax(altoPanel);
            slPosicionY.setValue(yInicial);
        });

        probandoFiguras(true);
    }

    /**
     * Si estamos configurando figuras, habilita los elementos relacionados con la creación de figuras.
     * Si no estamos configurando figuras, solo habilita el botón para detener la animación.
     *
     * @param estamosConfigurando indica si estamos configurando las figuras.
     */
    private void probandoFiguras(boolean estamosConfigurando) {
        //Habilita o deshabilita los elementos
        apCrearFiguras.setDisable(!estamosConfigurando);
        btIniciar.setDisable(!estamosConfigurando);
        btParar.setDisable(estamosConfigurando);
    }

    /**
     * Mueve todas las figuras en el panel según sus deltas.
     * Este método se llama repetidamente para actualizar la posición de las figuras durante la animación.
     */
    private void moverFigura(){
        for (Figura figura:figuras){
            figura.moverFigura(pnPanel);
        }
    }

    /**
     * Inicia el movimiento de las figuras en el panel.
     * Este método inicia la animación que mueve las figuras en el panel.
     */
    void iniciaMovimiento(){
        //crear timeline para animacion
        if (timeline==null){
            //cada 16ms llama a moverFiguras
            timeline=new Timeline(new KeyFrame(Duration.millis(16), event2->moverFigura()));
            //repite la animacion indefinidamente
            timeline.setCycleCount(Timeline.INDEFINITE);
        }
        //animacion se repite indefinidamente
        timeline.play();
    }

}
