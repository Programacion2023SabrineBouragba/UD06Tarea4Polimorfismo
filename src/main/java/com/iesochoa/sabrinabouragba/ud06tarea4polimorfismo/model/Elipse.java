package com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;

public class Elipse extends Figura{
    private Ellipse elipse;

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

    public void dibujar(Pane pane){
        pane.getChildren().add(elipse);
    }
    public void borrar(Pane pane){
        pane.getChildren().remove(elipse);
    }
    public void cambiarPosicion(int x, int y){
        setX(x);
        setY(y);
        elipse.setCenterX(x);
        elipse.setCenterY(y);
    }
    public void cambiarColor(Color color){
        this.setColor(color);

        elipse.setFill(color);
    }
    public void cambiarSize(int size){
        // Set the new bounding rectangle of the ellipse
        elipse.setRadiusX(size * 2);
        elipse.setRadiusY(size);

    }
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
