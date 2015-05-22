/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication40;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author anda
 */
public class WinBoard extends JPanel {
    Font largeFeedbackFont = new Font("SansSerif", 0, 40);
    Font smallFeedbackFont = new Font("SansSerif", 0, 20);
     @Override
      public void paintComponent(Graphics g) {
		    g.setColor(new Color(20, 20, 20));
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			g.setFont(largeFeedbackFont);
			g.setColor(new Color(0, 80, 0));
			g.drawString("You Win!", 20, 40);
            g.setFont(smallFeedbackFont);
            g.setColor(new Color(255, 255, 255));
            g.drawString("Press ENTER to play again..", 20, 70);		}
}
