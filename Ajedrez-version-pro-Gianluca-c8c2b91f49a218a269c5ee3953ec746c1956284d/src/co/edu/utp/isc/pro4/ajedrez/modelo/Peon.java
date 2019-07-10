/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.pro4.ajedrez.modelo;

import static co.edu.utp.isc.pro4.ajedrez.modelo.Color.BLANCO;
import static co.edu.utp.isc.pro4.ajedrez.modelo.Color.NEGRO;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
*
* @author utp
*/
public class Peon extends Ficha {

public Peon(Color color) {
super(color);
}

@Override
public void mover(Tablero tablero,Casilla casillaI, Casilla casillaF) {
boolean ocupada = false;
boolean validador=false;
Casilla casillaC;
int cI,cF,fI,fF;
cI = casillaI.getColumna() - 'A';//x Inicial
fI = casillaI.getFila() - 1;//y Inicial
cF = casillaF.getColumna() - 'A';//x Final
fF = casillaF.getFila() - 1 ;//y Final


if(this.getColor()==BLANCO){

if(cI==cF && fF==fI-1){
if(casillaF.isOcupada()==false){
casillaI.setFichaNull();
super.asociarFichaTablero(this, casillaF);

}
else { System.out.println("La casilla esta ocupada");}

}
else if((fI==6) && fF==fI-2 && cI==cF){

casillaC = tablero.getCasilla(fI-1, cI);
if(casillaF.isOcupada()==false && casillaC.isOcupada()==false){
casillaI.setFichaNull();
super.asociarFichaTablero(this, casillaF);

}
else { System.out.println("La casilla intermedia esta ocupada");}

}
else if(fF==fI-1 &&(cF==cI+1 || cF==cI-1)){

if(casillaF.isOcupada()==true && casillaF.getFicha().getColor()==NEGRO){
this.comer(casillaI,casillaF);

}
else {System.out.println("Ambas fichas son del mismo color");
}

}

}
else {
if(cI==cF && fF==fI+1){
if(casillaF.isOcupada()==false){
casillaI.setFichaNull();
super.asociarFichaTablero(this, casillaF);

}
else { System.out.println("La casilla esta ocupada");}

}
else if((fI==1) && fF==fI+2 && cI==cF){

casillaC = tablero.getCasilla(fI+1, cI);
if(casillaF.isOcupada()==false && casillaC.isOcupada()==false){
casillaI.setFichaNull();
super.asociarFichaTablero(this, casillaF);

}
else { System.out.println("La casilla intermedia esta ocupada");}

}
else if(fF==fI+1 &&(cF==cI+1 || cF==cI-1)){

if(casillaF.isOcupada()==true && casillaF.getFicha().getColor()==BLANCO){
this.comer(casillaI,casillaF);

}
else {System.out.println("Ambas fichas son del mismo color");}

}


}


}



@Override
public void draw(Graphics2D g, float x, float y) {
// 50x50 dibujar la ficha
g.setPaint(new GradientPaint(x, y,
getColor() == Color.BLANCO ? java.awt.Color.CYAN : java.awt.Color.BLACK,
x + 50, y + 50,
java.awt.Color.WHITE));
g.fill(new Ellipse2D.Float(x + 17, y + 15, 16, 16));
g.fill(new Rectangle2D.Float(x + 15, y + 30, 20, 15));
g.setPaint(java.awt.Color.BLACK);
g.draw(new Ellipse2D.Float(x + 17, y + 15, 16, 16));
g.draw(new Rectangle2D.Float(x + 15, y + 30, 20, 15));
}

}