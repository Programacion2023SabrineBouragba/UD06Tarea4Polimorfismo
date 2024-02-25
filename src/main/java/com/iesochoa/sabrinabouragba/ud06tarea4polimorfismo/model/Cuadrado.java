package com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//Clase Hija Cuadrado de la Clase Padre Figura
public class Cuadrado extends Figura{
    private Rectangle cuadrado;

    //Constructor
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

    //Método dónde dibuja la figura en el panel
    public void dibujar(Pane pane){
        pane.getChildren().add(cuadrado);
    }
    //Método dónde borra la figura del panel
    public void borrar(Pane pane){
        pane.getChildren().remove(cuadrado);
    }
    //Método dónde cambia la posición de la figura en panel
    public void cambiarPosicion(int x, int y){
        setX(x);
        setY(y);
        cuadrado.setX(x);
        cuadrado.setY(y);
    }
    //Método dónde cambia el color de la figura
    public void cambiarColor(Color color){
        this.setColor(color);
        cuadrado.setFill(color);
    }
    //Método dónde cambia el tamaño de la figura
    public void cambiarSize(int size){
        cuadrado.setWidth(size*2);
        cuadrado.setHeight(size*2);
    }
    //Método dónde se mueve la figura dentro del panel
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
