package org.imie.morpion.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import org.imie.morpion.model.MorpionGrid;
import org.imie.morpion.model.Piece;

public class MorpionDraw extends JPanel {
	MorpionGrid morpionGrid;
	View view;
	public MorpionDraw (View view,MorpionGrid morpionGrid){
		this.morpionGrid=morpionGrid;
		this.view = view;
		
		addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int returnX;
				int returnY;
				returnX = e.getX()/100;
				returnY = e.getY()/100;
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}} );
		}
	
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.clearRect(0, 0, 300, 300);
        graphics2D.drawLine(100, 0, 100, 300);
        graphics2D.drawLine(200, 0, 200, 300);
        graphics2D.drawLine(0, 100, 300, 100);
        graphics2D.drawLine(0, 200, 300, 200);

               
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                morpionGrid.get(x, y) ;
                if (morpionGrid.get(x,y)==Piece.CIRCLE){
                	drawCircle(graphics2D, x,y);
                }
                if (morpionGrid.get(x,y)==Piece.CROSS){
                	drawCross(graphics2D, x,y);
                }
             }
          
            
        }
    }
    
    public void drawCircle (Graphics2D graphics2D,int x,int y){
    	graphics2D.drawOval(x*100,y*100,100,100);   	
    }
    public void drawCross (Graphics2D graphics2D,int x,int y){
    	graphics2D.drawLine(x*100,y*100,x*100+100,y*100+100);
    	graphics2D.drawLine((x+1)*100,(y)*100,x*100,(y+1)*100);
    }
}
