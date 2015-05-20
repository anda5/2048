/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author anda
 */
public class GameBoard extends JPanel{
    protected void paintComponent(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0, 0, this.getWidth(),this.getHeight());
    }
}
