/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santiago Pulgarin && Camilo Guerrero
 */
public class Fecha {
    
    byte day;
    byte month;
    byte year;

    public Fecha(byte day, byte month, byte year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
   

    public byte dia(byte day) {
        return day;
    }

    public byte mes(byte month) {
        return month;
    }

    public byte anio(byte year) {
        return year;
    }

    // -1 si esta fecha es anterior a la otra
    // 0 si son iguales
    // 1 si esta fecha es posterior a la otra
    public byte comparar(Fecha otra) {
        if (day == otra.day && month == otra.month && year == otra.year) {
            return 0;    
        }
        if (day < otra.day || month < otra.month || year < otra.year) {
            return -1;
        }
        return 1;
    }

    @Override
    public String toString() {
        return "Fecha{" + "day=" + day + ", month=" + month + ", year=" + year + '}';
    }
}