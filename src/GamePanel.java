import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class GamePanel extends JPanel implements Runnable{

    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;
    final int FPS=60;
    Thread gameThread;
    GameManager gm;

    public GamePanel() {
        // Panel settings
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.BLACK);
        this.setLayout(null);
    }

    public void run() {
        double  drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
    
        while(gameThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime-lastTime) / drawInterval;
            lastTime=currentTime;

            if(delta >= 1)
            {
                if(KeyHandler.pausePressed == false && gm.gameOver == false){
                    gm.update();
                }
                repaint();
                delta--;
            }
        }
    }

    public void launchGame(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        gm.draw(g2);
    }
}