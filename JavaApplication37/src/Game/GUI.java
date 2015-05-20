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
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.InputStream;
import java.net.URL;
import java.util.Hashtable;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author anda
 */
public class GUI {
    Game game;
    int HIGHT = 500;
    int WIDTH = 420;
    int BOARDSIZE =100;
    int marginSize =5;
    Color backgroundColor = new Color(255,255,120);
    myFrame frame;
    Map numberTiles ;
    GameBoard gb;
    
    public GUI(){
        game = new Game();
        frame = new myFrame();
        frame.setFocusable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(new myFrame());
        loadNumberTiles();
         gb = new GameBoard();
       // gb.setFocusable(true);
        
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
    
    private void loadNumberTiles(){
        numberTiles = new Hashtable();
        ClassLoader cldr = getClass().getClassLoader();
//    
        ImageIcon img0 = new ImageIcon(this.getClass().getResource("images/home.jpg"));
        ImageIcon img1 = new ImageIcon(this.getClass().getResource("images/1.jpg"));
        ImageIcon img2 = new ImageIcon(this.getClass().getResource("images/2.jpg"));
        ImageIcon img4 = new ImageIcon(this.getClass().getResource("images/4.jpg"));
        ImageIcon img8 = new ImageIcon(this.getClass().getResource("images/8.jpg"));
        ImageIcon img16 = new ImageIcon(this.getClass().getResource("images/16.jpg"));
        ImageIcon img32 = new ImageIcon(this.getClass().getResource("images/32.jpg"));
        ImageIcon img64 = new ImageIcon(this.getClass().getResource("images/164png.jpg"));
        ImageIcon img128= new ImageIcon(this.getClass().getResource("images/128jpg.jpg"));
        ImageIcon img256= new ImageIcon(this.getClass().getResource("images/256.jpg"));
        ImageIcon img512= new ImageIcon(this.getClass().getResource("images/512png.png"));
        ImageIcon img1024= new ImageIcon(this.getClass().getResource("images/1024.jpg"));
          
        

        numberTiles.put(0, img0);
        numberTiles.put(1, img1);
        numberTiles.put(2, img2);
        numberTiles.put(4, img4);
        numberTiles.put(8, img8);
        numberTiles.put(16, img16);
        numberTiles.put(32, img32);
        numberTiles.put(64, img64);
        numberTiles.put(128, img128);
        numberTiles.put(256, img256);
        numberTiles.put(512, img512);
        numberTiles.put(1024, img1024);
        
    }
    public Map getTiles()
    {
        return numberTiles;
    }  
    public class GameBoard extends JPanel implements KeyListener{
    protected void paintComponent(Graphics g){
        
        int X,Y;
        g.setColor(Color.black);
        g.fillRect(0, 0, 800,800);
        int[][] board = game.getGameBoard();
        
        for(int y = 1;y<5 ;y++){
            for(int x =1;x<5;x++){
                 X = (8*x)+(90*(x-1));
                 Y = (8*y)+(90*(y-1));
                 int number = board[y-1][x-1];
                if(numberTiles.containsKey(number)){
                 ImageIcon thisTile = (ImageIcon) numberTiles.get(number);
                 thisTile.paintIcon(this, g, X, Y);
                 }
        }
    }
}

        @Override
        public void keyTyped(KeyEvent ke) {
             //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode()==KeyEvent.VK_UP){
                //To change body of generated methods, choose Tools | Templates.
        }
           else if(ke.getKeyCode()==KeyEvent.VK_DOWN){
                //To change body of generated methods, choose Tools | Templates.
        }
           else  if(ke.getKeyCode()==KeyEvent.VK_LEFT){
                //To change body of generated methods, choose Tools | Templates.
        }
           else  if(ke.getKeyCode()==KeyEvent.VK_RIGHT){
                   
               }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    class myFrame extends JFrame implements KeyListener{

     @Override
        public void keyTyped(KeyEvent ke) {
             //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if(ke.getKeyCode()==KeyEvent.VK_UP){
               System.out.println("pressed");
               game.pushUp();
               game.addNewNumber();
               gb.repaint();
        }
           else if(ke.getKeyCode()==KeyEvent.VK_DOWN){
                game.pushDown();
               game.addNewNumber();
               gb.repaint();//To change body of generated methods, choose Tools | Templates.
        }
           else  if(ke.getKeyCode()==KeyEvent.VK_LEFT){
               game.pushLeft();
               game.addNewNumber();
               gb.repaint(); //To change body of generated methods, choose Tools | Templates.
        }
           else  if(ke.getKeyCode()==KeyEvent.VK_RIGHT){
                   game.pushRight();
               game.addNewNumber();
               gb.repaint();
               }
        }

        @Override
        public void keyReleased(KeyEvent ke) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
