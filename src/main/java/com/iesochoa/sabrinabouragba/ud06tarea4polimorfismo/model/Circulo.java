package com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Circulo extends Figura{
    private Circle circulo;

    public Circulo(int x, int y, Color color, int size){
        super(x, y, color, size);

        //iniciamos la variable circulo de radio size
        circulo= new Circle(size);
        //iniciamos u posicion X e Y
        circulo.setCenterX(x);
        circulo.setCenterY(y);

        //damos color
        circulo.setFill(color);
    }

    public void dibujar(Pane pane){
        pane.getChildren().add(circulo);
    }
    public void borrar(Pane pane){
        pane.getChildren().remove(circulo);
    }
    public void cambiarPosicion(int x, int y){
        setX(x);
        setY(y);
        circulo.setCenterX(x);
        circulo.setCenterY(y);
    }
    public void cambiarColor(Color color){
        this.setColor(color);
        circulo.setFill(color);
    }
    public void cambiarSize(int size){
        circulo.setRadius(size);
    }
    public void moverFigura(Pane pnPanel){
        //actualizamos la posicion del circulo sumando delta
        int newX=(int) circulo.getCenterX()+getDeltaX();
        int newY=(int) circulo.getCenterY()+getDeltaY();

        //cambiamos la direccion del circulo si alcanza los bordes
        //he llegado al borde
        if (newX <= circulo.getRadius()
                //ha llegado al borde derecho
                || newX >= pnPanel.getWidth() - circulo.getRadius())
        {//cambiamos su dirección
            setDeltaX(-getDeltaX());
        }//comprobamo si llega arriba o abajo
        if (newY <= circulo.getRadius() || newY >= pnPanel.getHeight() - circulo.getRadius()) {
            setDeltaY(-getDeltaY());
        }
        //nueva posición
        cambiarPosicion(newX,newY);
    }


}
