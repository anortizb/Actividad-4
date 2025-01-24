/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.inmuebles;


public class Inmuebles {
    protected int identificadorInmobiliario;
    protected int área;
    protected String dirección; 
    protected double precioVenta; 
    
    Inmuebles(int identificadorInmobiliario, int área, String dirección) {
        this.identificadorInmobiliario = identificadorInmobiliario;
        this.área = área;
        this.dirección = dirección;    
    }
    
    double calcularPrecioVenta(double valorArea) {
        precioVenta = área * valorArea;
        return precioVenta;
    }
    
    void imprimir() {
        System.out.println("Identificador inmobiliario = " + identificadorInmobiliario);
        System.out.println("Area = " + área);
        System.out.println("Dirección = " + dirección);
        System.out.println("Precio de venta = $" + precioVenta);
        }
}
