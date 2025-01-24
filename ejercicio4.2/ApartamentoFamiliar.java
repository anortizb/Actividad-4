/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmuebles;


public class ApartamentoFamiliar extends Apartamento{
    protected static double valorArea = 2000000;
    protected int valorAdministración;
    
    public ApartamentoFamiliar(int identificadorInmobiliario, int área, String dirección, int númeroHabitaciones, int númeroBaños, int valorAdministración) {
        super(identificadorInmobiliario, área, dirección, númeroHabitaciones, númeroBaños);
        this.valorAdministración = valorAdministración;
    }
    
    void imprimir() {
        super.imprimir(); 
        System.out.println("Valor de la administración = $" + valorAdministración);
        System.out.println();
    }
}
