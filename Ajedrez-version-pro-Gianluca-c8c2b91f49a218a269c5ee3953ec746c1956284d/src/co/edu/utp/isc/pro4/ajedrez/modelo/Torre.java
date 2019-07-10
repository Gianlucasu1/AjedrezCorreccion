/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.pro4.ajedrez.modelo;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

/**
 *
 * @author utp
 */
public class Torre extends Ficha {

    public Torre(Color color) {
        super(color);
    }

    @Override
    public void mover(Tablero tablero, Casilla casillaI, Casilla casillaF) {
         boolean ocupada = false;
            int cI,cF,fI,fF;
            cI = casillaI.getColumna() - 'A';//x Inicial
            fI = casillaI.getFila() - 1;//y Inicial
            cF = casillaF.getColumna() - 'A';//x Final 
            fF = casillaF.getFila() - 1 ;//y Final
            Casilla casillaC;
            Casilla casillaComp;
            
            if((fI==fF) || (cI==cF)){
    
            if (casillaF.getColumna() == casillaI.getColumna() && casillaF.getFila() > casillaI.getFila()){
                    cI = cI;
                    fI = fI + 1;
                }
                else if(casillaF.getColumna() == casillaI.getColumna() && casillaF.getFila() < casillaI.getFila()){
                    cI = cI;
                    fI = fI - 1;
                }
                else if(casillaF.getColumna() < casillaI.getColumna() && casillaF.getFila() == casillaI.getFila()){
                    cI = cI - 1;
                    fI = fI;
                }
                else if(casillaF.getColumna() > casillaI.getColumna() && casillaF.getFila() == casillaI.getFila()){
                    cI = cI + 1;
                    fI = fI;
                }
            
            casillaC=tablero.getCasilla(fI,cI);
            casillaComp=casillaC;
            ocupada=casillaC.isOcupada();
            while(((casillaC.getFila() != casillaF.getFila()) || (casillaC.getColumna() != casillaF.getColumna())) && ocupada==false){
                    ocupada=casillaC.isOcupada();
                   casillaC = tablero.getCasilla(fI,cI);
                 
               
                    if (casillaF.getColumna() == casillaI.getColumna() && casillaF.getFila() > casillaI.getFila()){
                        cI = cI;
                        fI = fI + 1;
                    }
                    else if(casillaF.getColumna() == casillaI.getColumna() && casillaF.getFila() < casillaI.getFila()){
                        cI = cI;
                        fI = fI - 1;
                    }
                    else if(casillaF.getColumna() < casillaI.getColumna() && casillaF.getFila() == casillaI.getFila()){
                        cI = cI - 1;
                        fI = fI;
                    }
                    else if(casillaF.getColumna() > casillaI.getColumna() && casillaF.getFila() == casillaI.getFila()){
                        cI = cI + 1;
                        fI = fI;
                    }
                    
                }
            
            if(casillaF.isOcupada()==false){
            
            if(ocupada==false){
                               casillaI.setFichaNull();
                               super.asociarFichaTablero(this, casillaF);
                               
                               }
            else {
                System.out.println("Hay una ficha en la trayectoria");
            }
            
            }
            
            else {
                   if(casillaComp==casillaF){
                                             if(this.getColor() != casillaF.getFicha().getColor())
                                             {
                                             this.comer(casillaI,casillaF);
                                             
                                             }
                                             else { System.out.println("Ambas fichas son del mismo color");}
                   
                                             }
                   else {  
                       if((this.getColor() != casillaF.getFicha().getColor())&& ocupada==false){
                        
                        this.comer(casillaI,casillaF);
                        
                      
                        }
                         else{
                       System.out.println("Ambas fichas son del mismo color");
                   }}
            
            
            }
            
    
    
           }
            
            else{
                System.out.println("De esa forma no se mueve la torre");
            }
        
            
    }

    

    public void draw(Graphics2D g, float x, float y) {
        GeneralPath polyline = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 17);
        polyline.moveTo(x + 5, y + 5);
        polyline.lineTo(x + 5, y + 15);
        polyline.lineTo(x + 10, y + 15);
        polyline.lineTo(x + 10, y + 45);
        polyline.lineTo(x + 40, y + 45);
        polyline.lineTo(x + 40, y + 15);
        polyline.lineTo(x + 45, y + 15);
        polyline.lineTo(x + 45, y + 5);
        polyline.lineTo(x + 37, y + 5);
        polyline.lineTo(x + 37, y + 10);
        polyline.lineTo(x + 29, y + 10);
        polyline.lineTo(x + 29, y + 5);
        polyline.lineTo(x + 21, y + 5);
        polyline.lineTo(x + 21, y + 10);
        polyline.lineTo(x + 13, y + 10);
        polyline.lineTo(x + 13, y + 5);
        polyline.lineTo(x + 5, y + 5);

        g.setPaint(new GradientPaint(x, y,
                getColor() == Color.BLANCO ? java.awt.Color.CYAN : java.awt.Color.BLACK,
                x + 100, y + 50,
                java.awt.Color.WHITE));
        g.fill(polyline);

        g.setColor(java.awt.Color.BLACK);
        g.draw(polyline);
    }

    

}
