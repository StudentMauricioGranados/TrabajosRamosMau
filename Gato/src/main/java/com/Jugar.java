/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import dao.Juego;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Jose Ramos
 */
@Named(value = "jugar")
@RequestScoped
public class Jugar extends Juego {

    private String mensajeIdentificacion;
    private boolean bloquear1_1 = false;
    private boolean bloquear1_2 = false;
    private boolean bloquear1_3 = false;
    private boolean bloquear2_1 = false;
    private boolean bloquear2_2 = false;
    private boolean bloquear2_3 = false;
    private boolean bloquear3_1 = false;
    private boolean bloquear3_2 = false;
    private boolean bloquear3_3 = false;

    public boolean isBloquear1_1() {
        return bloquear1_1;
    }

    public void setBloquear1_1(boolean bloquear1_1) {
        this.bloquear1_1 = bloquear1_1;
    }

    public boolean isBloquear1_2() {
        return bloquear1_2;
    }

    public void setBloquear1_2(boolean bloquear1_2) {
        this.bloquear1_2 = bloquear1_2;
    }

    public boolean isBloquear1_3() {
        return bloquear1_3;
    }

    public void setBloquear1_3(boolean bloquear1_3) {
        this.bloquear1_3 = bloquear1_3;
    }

    public boolean isBloquear2_1() {
        return bloquear2_1;
    }

    public void setBloquear2_1(boolean bloquear2_1) {
        this.bloquear2_1 = bloquear2_1;
    }

    public boolean isBloquear2_2() {
        return bloquear2_2;
    }

    public void setBloquear2_2(boolean bloquear2_2) {
        this.bloquear2_2 = bloquear2_2;
    }

    public boolean isBloquear2_3() {
        return bloquear2_3;
    }

    public void setBloquear2_3(boolean bloquear2_3) {
        this.bloquear2_3 = bloquear2_3;
    }

    public boolean isBloquear3_1() {
        return bloquear3_1;
    }

    public void setBloquear3_1(boolean bloquear3_1) {
        this.bloquear3_1 = bloquear3_1;
    }

    public boolean isBloquear3_2() {
        return bloquear3_2;
    }

    public void setBloquear3_2(boolean bloquear3_2) {
        this.bloquear3_2 = bloquear3_2;
    }

    public boolean isBloquear3_3() {
        return bloquear3_3;
    }

    public void setBloquear3_3(boolean bloquear3_3) {
        this.bloquear3_3 = bloquear3_3;
    }

    public String getMensajeIdentificacion() {
        return mensajeIdentificacion;
    }

    public void setMensajeIdentificacion(String mensajeIdentificacion) {
        this.mensajeIdentificacion = mensajeIdentificacion;
    }

    /**
     * Creates a new instance of Ingresar
     */
    public Jugar() {

    }
//logica

    public void Gato() {
        //validar por filas
        if (!posicion1_1.isEmpty() && !posicion1_2.isEmpty() && !posicion1_3.isEmpty()) {
            if (posicion1_1.equals(posicion1_2) && posicion1_1.equals(posicion1_3)) {//1,1 1,2 1,1 1,3
                calcular(posicion1_3);
            }

        } 
        if (!posicion2_1.isEmpty() && !posicion2_2.isEmpty() && !posicion2_3.isEmpty()) {
            if (posicion2_1.equals(posicion2_2) && posicion2_1.equals(posicion2_3)) {//2,1 2,2 2,1 2,3
                calcular(posicion2_1);
            }

        } 
        if (!posicion3_1.isEmpty() && !posicion3_2.isEmpty() && !posicion3_3.isEmpty()) {
            if (posicion3_1.equals(posicion3_2) && posicion3_1.equals(posicion3_3)) {//3,1 3,2 3,1 3,3
                calcular(posicion3_1);
            }
            //validar columnas
        } 
        if (!posicion1_1.isEmpty() && !posicion2_1.isEmpty() && !posicion3_1.isEmpty()) {
            if (posicion1_1.equals(posicion2_1) && posicion2_1.equals(posicion3_1)) {//1,1 2,1 2,1 3,1
                calcular(posicion1_1);
            }
        } 
        if (!posicion1_2.isEmpty() && !posicion2_2.isEmpty() && !posicion3_2.isEmpty()) {
            if (posicion1_2.equals(posicion2_2) && posicion2_2.equals(posicion3_2)) {//1,2 2,2 2,2 3,2
                calcular(posicion1_2);
            }
        } 
        if (!posicion1_3.isEmpty() && !posicion2_3.isEmpty() && !posicion3_3.isEmpty()) {
            if (posicion1_3.equals(posicion2_3) && posicion2_3.equals(posicion3_3)) {//1,3 2,3 2,3 3,3
                calcular(posicion1_3);
            }
        } //valifar x
         if (!posicion1_1.isEmpty() && !posicion2_2.isEmpty() && !posicion3_3.isEmpty()) {
            if (posicion1_1.equals(posicion2_2) && posicion2_2.equals(posicion3_3)) {//1,1 2,2 2,2 3,3
                calcular(posicion1_1);
            }
        } 
         if (!posicion3_1.isEmpty() && !posicion2_2.isEmpty() && !posicion1_3.isEmpty()) {
            if (posicion3_1.equals(posicion2_2) && posicion2_2.equals(posicion1_3)) {//3,1 2,2 2,2 1,3   
                calcular(posicion3_1);

            }

        }
    }

    public String calcular(String n) {
//        
        if (n.equals("x")) {
            this.mensajeIdentificacion = "Gana el jugador 1";
        } else if (n.equals("o")) {
            this.mensajeIdentificacion = "Gana el jugador 2";
        }

        return ganador;
    }

    public void rondaGato() {
        validar();
        Gato();

    }

    public void resetGame() {
        posicion1_1 = "";
        posicion1_2 = "";
        posicion1_3 = "";
        posicion2_1 = "";
        posicion2_2 = "";
        posicion2_3 = "";
        posicion3_1 = "";
        posicion3_2 = "";
        posicion3_3 = "";
    }

    public void validar() {

        bloquear1_1 = !posicion1_1.isBlank();
        bloquear1_2 = !posicion1_2.isBlank();
        bloquear1_3 = !posicion1_3.isBlank();
        bloquear2_1 = !posicion2_1.isBlank();
        bloquear2_2 = !posicion2_2.isBlank();
        bloquear2_3 = !posicion2_3.isBlank();
        bloquear3_1 = !posicion3_1.isBlank();
        bloquear3_2 = !posicion3_2.isBlank();
        bloquear3_3 = !posicion3_3.isBlank();
    }
}
