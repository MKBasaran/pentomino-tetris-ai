import java.util.Random;

public class PlayerManager extends GameManager{
    public PlayerManager(){
        super();
        dropInterval = 60;
        currentPentomino = pickPentomino();
        currentPentomino.setXY(STARTX, STARTY);

        nextPentomino = pickPentomino();
        nextPentomino.setXY(NEXTPENTAMINO_X, NEXTPENTAMINO_Y);
    }

    public Pentomino pickPentomino(){
        Pentomino pentomino = null;
        int i = new Random().nextInt(12);
        switch (i) {
            case 0:  pentomino = new PentominoF();break;
            case 1:  pentomino = new PentominoI();break;
            case 2:  pentomino = new PentominoL();break;
            case 3:  pentomino = new PentominoN();break;
            case 4:  pentomino = new PentominoP();break;
            case 5:  pentomino = new PentominoT();break;
            case 6:  pentomino = new PentominoU();break;
            case 7:  pentomino = new PentominoV();break;
            case 8:  pentomino = new PentominoW();break;
            case 9:  pentomino = new PentominoX();break;
            case 10: pentomino = new PentominoY();break;
            case 11: pentomino = new PentominoZ();break;
        }
        return pentomino;
    }

    public void changeUpdate(){
        if (KeyHandler.upPressed){
            currentPentomino.changeRotation();
            KeyHandler.upPressed = false;
        }
        else if (KeyHandler.downPressed) {
            currentPentomino.moveDown();
            KeyHandler.downPressed = false;
        }
        else if(KeyHandler.spacePressed) {
            currentPentomino.dropFast();
            KeyHandler.spacePressed =  false;
        }
        else if (KeyHandler.leftPressed) {
            currentPentomino.moveLeft();
            KeyHandler.leftPressed = false;
        }
        else if (KeyHandler.rightPressed) {
            currentPentomino.moveRight();
            KeyHandler.rightPressed = false;
        }
        currentPentomino.drop();
    }

    public void changeSpeed(){
        if(level == 3){
            dropInterval = 50;
        }else if(level == 5){
            dropInterval = 40;
        }else if(level == 7){
            dropInterval = 30;
        }
    }
}