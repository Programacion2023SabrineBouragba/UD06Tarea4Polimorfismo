package com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

//Clase Hija Elipse de la Clase Padre Figura
public class Elipse extends Figura{
    private Ellipse elipse;

    //Constructor
    public Elipse(int x, int y, Color color, int size){
        super(x, y, color, size);

        //iniciamos la variable circulo de radio size
        elipse= new Ellipse();
        //iniciamos u posicion X e Y
        elipse.setCenterX(x);
        elipse.setCenterY(y);

        //damos color
        elipse.setFill(color);
        cambiarSize(size);
    }

    //Método dónde dibuja la figura en el panel
    public void dibujar(Pane pane){
        pane.getChildren().add(elipse);
    }
    //Método dónde borra la figura del panel
    public void borrar(Pane pane){
        pane.getChildren().remove(elipse);
    }
    //Método dónde cambia la posición de la figura en panel
    public void cambiarPosicion(int x, int y){
        setX(x);
        setY(y);
        elipse.setCenterX(x);
        elipse.setCenterY(y);
    }
    //Método dónde cambia el color de la figura
    public void cambiarColor(Color color){
        this.setColor(color);

        elipse.setFill(color);
    }
    //Método dónde cambia el tamaño de la figura
    public void cambiarSize(int size){
        // Set the new bounding rectangle of the ellipse
        elipse.setRadiusX(size * 2);
        elipse.setRadiusY(size);

    }
    //Método dónde se mueve la figura dentro del panel
    public void moverFigura(Pane pnPanel){
        //actualizamos la posicion de la figura, sumando delta
        int newX=(int) elipse.getCenterX()+getDeltaX();
        int newY=(int) elipse.getCenterY()+getDeltaY();

        //cambiamos la direccion X de la elipse
        if (newX<= elipse.getRadiusX()
                || newX >= pnPanel.getWidth() - elipse.getRadiusX())
        {//cambiamos la direccion
            setDeltaX((-getDeltaX()));
        }
        //comprobamos si llega a los bordes eje Y
        if (newY<= elipse.getRadiusY()
                ||  newY >= pnPanel.getHeight() - elipse.getRadiusY())
        {//cambiamos la direccion
            setDeltaY((-getDeltaY()));
        }

        //nueva posicion
        cambiarPosicion(newX, newY);
    }

}
