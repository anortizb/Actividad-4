/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmuebles;


public class CasaIndependiente extends CasaUrbana{
    
    protected static double valorArea = 3000000;
    
    public CasaIndependiente(int identificadorInmobiliario, int área, String dirección, int númeroHabitaciones, int númeroBaños, int númeroPisos) {
        super(identificadorInmobiliario, área, dirección, númeroHabitaciones, númeroBaños, númeroPisos);
    }
    
    void imprimir() {
        super.imprimir();
        System.out.println();
    }
    
}
