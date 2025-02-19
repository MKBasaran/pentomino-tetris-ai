import java.util.Random;

public class BotManager extends GameManager{
    boolean oneTime = true;

    public BotManager(){
        super();
        dropInterval = 40;
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
        if(oneTime){
            oneTime = false;
            int move = new Random().nextInt(4);
            if((move == 0 || move == 3) && currentPentomino.deactivating == false){
                currentPentomino.changeRotation();
            }
            else if (move == 1) {
                currentPentomino.moveLeft();
            }
            else if (move == 2) {
                currentPentomino.moveRight();
            }
        }
        currentPentomino.drop();
        if(currentPentomino.autoDropCounter == 0){
            oneTime = true;
        }
    }
}
