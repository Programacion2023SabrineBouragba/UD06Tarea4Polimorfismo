package com.iesochoa.sabrinabouragba.ud06tarea4polimorfismo.model;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Figura {
    private int x;
    private int y;
    private int deltaX=2;
    private int deltaY=1;
    private Color color;
    private int size;


    //constructor
    public Figura(int x, int y, Color color, int size){
        this.x=x;
        this.y=y;
        this.color=color;
        this.size=size;
    }

    private void dibujar(Pane pnPanel){

    }

    private void vorrar(Pane pnPanel){

    }

    private void cambiarPosicion(int x, int y){

    }

    private void cambiarColor(Color color){

    }

    private void cambiarSize(int size){

    }

    private void moverFigura(Pane pnPanel){

    }


    public int getX(){
        return x;
    }
    public void setX(int x){
        this.x=x;
    }


    private int getY(){
        return y;
    }
    private void setY(int y){
        this.y=y;
    }


    private Color getColor(){
        return color;
    }
    private void setColor(Color color){
        this.color=color;
    }


    private int getDeltaX(){
        return deltaX;
    }
    private void setDeltaX(int deltaX){
        this.deltaX=deltaX;
    }


    private int getDeltaY(){
        return deltaY;
    }
    private void setDeltaY(int deltaY){
        this.deltaY=deltaY;
    }


    private int getSize(){
        return size;
    }
    private void setSize(int size){
        this.size=size;
    }

}
