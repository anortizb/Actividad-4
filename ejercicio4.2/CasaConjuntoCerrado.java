/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmuebles;


public class CasaConjuntoCerrado extends CasaUrbana {
    protected static double valorArea = 2500000;
    protected int valorAdministración;
    protected boolean tienePiscina;
    protected boolean tieneCamposDeportivos;
    
    public CasaConjuntoCerrado(int identificadorInmobiliario, int área, String dirección, int númeroHabitaciones, int númeroBaños, int númeroPisos, int valorAdministración, boolean tienePiscina, boolean tieneCamposDeportivos) {
        super(identificadorInmobiliario, área, dirección, númeroHabitaciones, númeroBaños, númeroPisos);
        this.valorAdministración = valorAdministración;
        this.tienePiscina = tienePiscina;
        this.tieneCamposDeportivos = tieneCamposDeportivos;
    }
    
    void imprimir() {
        super.imprimir();
        System.out.println("Valor de la administración = " + valorAdministración);
        System.out.println("Tiene piscina? = " + tienePiscina);
        System.out.println("Tiene campos deportivos? = " + tieneCamposDeportivos);
        System.out.println();
    }
}
