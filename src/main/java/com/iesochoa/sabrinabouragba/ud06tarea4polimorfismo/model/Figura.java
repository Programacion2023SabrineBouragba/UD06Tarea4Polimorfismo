package com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public abstract class Figura {
    private int x;
    private int y;
    private int deltaX=2;
    private int deltaY=1;
    private Color color;
    protected int size;


    //constructor
    public Figura(int x, int y, Color color, int size){
        this.x=x;
        this.y=y;
        this.color=color;
        this.size=size;
    }


    //Métodos para poder dibujar, borrar, cambiar posicion, color y tamaño de la figura en la que estamos trabajando
    public void dibujar(Pane pnPanel){

    }

    public void borrar(Pane pnPanel){

    }

    public void cambiarPosicion(int x, int y){

    }

    public void cambiarColor(Color color){

    }

    public void cambiarSize(int size){

    }

    public void moverFigura(Pane pnPanel){

    }

    //Métodos getters y setters para las coordenadas, asignar color, y deltas de la figura
    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x=x;
    }


    public int getY(){
        return y;
    }
    public void setY(int y){
        this.y=y;
    }


    public Color getColor(){
        return color;
    }
    public void setColor(Color color){
        this.color=color;
    }


    public int getDeltaX(){
        return deltaX;
    }
    public void setDeltaX(int deltaX){
        this.deltaX=deltaX;
    }


    public int getDeltaY(){
        return deltaY;
    }
    public void setDeltaY(int deltaY){
        this.deltaY=deltaY;
    }

}
