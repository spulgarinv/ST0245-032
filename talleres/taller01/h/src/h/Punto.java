/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package h;

/**
 *
 * @author cl18417
 */
public class Punto {
    
   
    private double x, y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public double x(double x) {
        return x;
    }

    public double y(double y) {
        return y;
    }

    // http://mathworld.wolfram.com/PolarCoordinates.html
    public double radioPolar() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    // http://mathworld.wolfram.com/PolarCoordinates.html
    public double anguloPolar() {
        return Math.atan2(y, x);
        
    }

    // http://mathworld.wolfram.com/Distance.html
    public double distanciaEuclidiana(Punto otro) {
        return Math.sqrt(Math.pow(x-otro.x, 2)+Math.pow(y-otro.y, 2));
    }
}