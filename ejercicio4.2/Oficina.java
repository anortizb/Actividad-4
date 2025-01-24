/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmuebles;


public class Oficina extends Local {
    protected static double valorArea = 3500000;
    protected boolean esGobierno;
    
    public Oficina(int identificadorInmobiliario, int área, String dirección, tipo tipoLocal, boolean esGobierno) {
        super(identificadorInmobiliario, área, dirección, tipoLocal);
        this.esGobierno = esGobierno;
    }
    
    void imprimir() {
        super.imprimir(); 
        System.out.println("Es oficina gubernamental = " + esGobierno);
        System.out.println();
    }
}
