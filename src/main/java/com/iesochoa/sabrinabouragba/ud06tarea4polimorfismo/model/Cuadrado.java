package com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cuadrado extends Figura{
    private Rectangle cuadrado;

    public Cuadrado(int x, int y, Color color, int size){
        super(x, y, color, size);

        //iniciamos varible cuadrado con el tamño dado
        cuadrado= new Rectangle(size, size);

        //iniciamos posicion X e Y
        cuadrado.setX(x);
        cuadrado.setY(y);
        //damos color
        cuadrado.setFill(color);

    }

    public void dibujar(Pane pane){
        pane.getChildren().add(cuadrado);
    }
    public void borrar(Pane pane){
        pane.getChildren().remove(cuadrado);
    }
    public void cambiarPosicion(int x, int y){
        setX(x);
        setY(y);
        cuadrado.setX(x);
        cuadrado.setY(y);
    }
    public void cambiarColor(Color color){
        this.setColor(color);
        cuadrado.setFill(color);
    }
    public void cambiarSize(int size){
        cuadrado.setWidth(size*2);
        cuadrado.setHeight(size*2);
    }
    public void moverFigura(Pane pnPanel){
        //actualizamos la posicion del circulo sumando delta
        int newX=(int) cuadrado.getX()+getDeltaX();
        int newY=(int) cuadrado.getY()+getDeltaY();

        // Cambiamos la dirección del cuadrado si alcanza los bordes
        // Revisa los límites izquierdo y derecho
        if (newX <= 0 || newX >= pnPanel.getWidth() - cuadrado.getWidth()) {
            setDeltaX(-getDeltaX());
        }
        // Revisa los límites superior e inferior
        if (newY <= 0 || newY >= pnPanel.getHeight() - cuadrado.getHeight()) {
            setDeltaY(-getDeltaY());
        }
        // Nueva posición
        cambiarPosicion(newX, newY);
    }
}
