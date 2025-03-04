import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyHandler implements KeyListener{

    public static boolean upPressed, downPressed, leftPressed, rightPressed, pausePressed, spacePressed;
        
    @Override
    public void keyTyped(KeyEvent e){

    }
    @Override
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = true;
        }   
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }  
        if(code == KeyEvent.VK_S){
            downPressed = true;
        }  
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }  
         if(code == KeyEvent.VK_UP){
            upPressed = true;
        }   
        if(code == KeyEvent.VK_LEFT){
            leftPressed = true;
        }  
        if(code == KeyEvent.VK_DOWN){
            downPressed = true;
        }  
        if(code == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }  
        if(code == KeyEvent.VK_SPACE){
            spacePressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e){
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = false;
        }   
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }  
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }  
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
         if(code == KeyEvent.VK_UP){
            upPressed = false;
        }   
        if(code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }  
        if(code == KeyEvent.VK_DOWN){
            downPressed = false;
        }  
        if(code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }  
        if(code == KeyEvent.VK_SPACE){
            spacePressed = false;
        }
        if(code == KeyEvent.VK_ESCAPE){
            if(pausePressed){
                pausePressed = false;
            }else{
                pausePressed = true;
            }
        }
    }    
}