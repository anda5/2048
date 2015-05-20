/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author anda
 */
public class GUI {
    int HIGHT = 424;
    int WIDTH = 340;
    int BOARDSIZE =296;
    int marginSize =16;
    Color backgroundColor = new Color(255,255,120);
    JFrame frame;
    
    public GUI(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameBoard gb = new GameBoard();
        
        JPanel north = new JPanel();
        north.setLayout(new GridLayout());
        north.setPreferredSize(new Dimension(WIDTH,82));
        
        JLabel gameLabel = new JLabel("1024",SwingConstants.CENTER);
        gameLabel.setFont(new Font("Serif",Font.BOLD,20));
        north.add(gameLabel);
        north.add(new JLabel("Score",SwingConstants.CENTER));
        north.add(new JLabel("Higth Score:",SwingConstants.CENTER));
        north.setBackground(backgroundColor);
        
        JPanel west = new JPanel();
        west.setPreferredSize(new Dimension(marginSize,BOARDSIZE));
        west.setBackground(backgroundColor);
        
        JPanel east= new JPanel();
        east.setPreferredSize(new Dimension(marginSize,BOARDSIZE));
        east.setBackground(backgroundColor);
        
        JPanel south = new JPanel();
        south.setPreferredSize(new Dimension(WIDTH,marginSize));
        south.setBackground(backgroundColor);
        
        frame.getContentPane().add(north,BorderLayout.NORTH);
        frame.getContentPane().add(east,BorderLayout.EAST);
        frame.getContentPane().add(south,BorderLayout.SOUTH);
        frame.getContentPane().add(west,BorderLayout.WEST);
        frame.getContentPane().add(gb,BorderLayout.CENTER);
        frame.getContentPane().setPreferredSize(new Dimension(WIDTH,HIGHT));
        frame.pack();
        frame.setVisible(true);
    }
    
}
