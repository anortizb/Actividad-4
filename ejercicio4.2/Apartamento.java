/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmuebles;


public class Apartamento extends InmuebleVivienda{
    
    public Apartamento(int identificadorInmobiliario, int área, String dirección, int númeroHabitaciones, int númeroBaños) {
        super(identificadorInmobiliario, área, dirección, númeroHabitaciones, númeroBaños);
    }
    
    void imprimir() {
        super.imprimir(); 
    }
}
