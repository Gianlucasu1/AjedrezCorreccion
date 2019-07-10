/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.pro4.ajedrez.modelo;

import co.edu.utp.isc.pro4.ajedrez.controlador.Ajedrez;
import static co.edu.utp.isc.pro4.ajedrez.modelo.Color.BLANCO;
import static co.edu.utp.isc.pro4.ajedrez.modelo.Color.NEGRO;

/**
 *
 * @author utp
 */
public class Jugador {

    private Ajedrez ajedrez;
    private final String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public void jugar(Casilla casillaI, Casilla casillaF,int turno) {
       if(casillaI.getFicha()!=null) {
       if(turno==0){
        if(casillaI.isOcupada()){
            Ficha f;
            
            f = casillaI.getFicha();  
           Color color1=f.getColor();
            if(color1==BLANCO){
            f.mover(ajedrez.getTablero(), casillaI, casillaF);}
            else {System.out.println("No es su turno");
            ajedrez.cambioTurno();
            
            }
        }}
       else {
           Ficha f;
            
            f = casillaI.getFicha();  
           Color color1=f.getColor();
            if(color1==NEGRO){
            f.mover(ajedrez.getTablero(), casillaI, casillaF);}
            else {System.out.println("No es su turno");
            ajedrez.cambioTurno();
            }
        }
       }
       else if(casillaI.getFicha()==null && casillaF.getFicha()==null) {
           ajedrez.cambioTurno();
       
       }
    }
    

    public void setAjedrez(Ajedrez ajedrez) {
        this.ajedrez = ajedrez;
    }

    public String getNombre() {
        return this.nombre;
    }

    
    private void rendirse() {
        // No me gusta pero los estudiantes lo pidieron
        ajedrez.rendirse();
    }
    
}
