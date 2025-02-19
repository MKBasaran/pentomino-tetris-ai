import java.awt.Color;

public class PentominoV extends Pentomino{

    public PentominoV(){
        create(Color.CYAN);
    }

    public String getPentomino(){
        return "V";
    }
    
    public void setXY(int x, int y) {
        piece[0].x = x - PentominoBlocks.SIZE;
        piece[0].y = y + PentominoBlocks.SIZE;

        piece[1].x = piece[0].x;
        piece[1].y = piece[0].y - 2 * PentominoBlocks.SIZE;

        piece[2].x = piece[0].x;
        piece[2].y = piece[0].y - PentominoBlocks.SIZE;

        piece[3].x = piece[0].x + PentominoBlocks.SIZE;
        piece[3].y = piece[0].y;

        piece[4].x = piece[0].x + 2 * PentominoBlocks.SIZE;
        piece[4].y = piece[0].y;
    }

    public void getDirection1() {
        tempPiece[0].x = piece[0].x - 2 * PentominoBlocks.SIZE;
        tempPiece[0].y = piece[0].y;

        tempPiece[1].x = tempPiece[0].x;
        tempPiece[1].y = tempPiece[0].y - 2 * PentominoBlocks.SIZE;

        tempPiece[2].x = tempPiece[0].x;
        tempPiece[2].y = tempPiece[0].y - PentominoBlocks.SIZE;

        tempPiece[3].x = tempPiece[0].x + PentominoBlocks.SIZE;
        tempPiece[3].y = tempPiece[0].y;

        tempPiece[4].x = tempPiece[0].x + 2 * PentominoBlocks.SIZE;
        tempPiece[4].y = tempPiece[0].y;
        direction = 1;
    }

    public void getDirection2() {
        tempPiece[0].x = piece[0].x;
        tempPiece[0].y = piece[0].y - 2 * PentominoBlocks.SIZE;

        tempPiece[1].x = tempPiece[0].x + 2 * PentominoBlocks.SIZE;
        tempPiece[1].y = tempPiece[0].y;

        tempPiece[2].x = tempPiece[0].x + PentominoBlocks.SIZE;
        tempPiece[2].y = tempPiece[0].y;

        tempPiece[3].x = tempPiece[0].x; 
        tempPiece[3].y = tempPiece[0].y + PentominoBlocks.SIZE;

        tempPiece[4].x = tempPiece[0].x;
        tempPiece[4].y = tempPiece[0].y + 2 * PentominoBlocks.SIZE;
        direction = 2;
    }

    public void getDirection3() {
        tempPiece[0].x = piece[0].x + 2 * PentominoBlocks.SIZE;
        tempPiece[0].y = piece[0].y;

        tempPiece[1].x = tempPiece[0].x;
        tempPiece[1].y = tempPiece[0].y + 2 * PentominoBlocks.SIZE;

        tempPiece[2].x = tempPiece[0].x;
        tempPiece[2].y = tempPiece[0].y + PentominoBlocks.SIZE;

        tempPiece[3].x = tempPiece[0].x - PentominoBlocks.SIZE;
        tempPiece[3].y = tempPiece[0].y;

        tempPiece[4].x = tempPiece[0].x - 2 * PentominoBlocks.SIZE;
        tempPiece[4].y = tempPiece[0].y;
        direction = 3;
    }

    public void getDirection4() {
        tempPiece[0].x = piece[0].x;
        tempPiece[0].y = piece[0].y + 2 * PentominoBlocks.SIZE;

        tempPiece[1].x = tempPiece[0].x - 2 * PentominoBlocks.SIZE;
        tempPiece[1].y = tempPiece[0].y;

        tempPiece[2].x = tempPiece[0].x - PentominoBlocks.SIZE;
        tempPiece[2].y = tempPiece[0].y;

        tempPiece[3].x = tempPiece[0].x;
        tempPiece[3].y = tempPiece[0].y - PentominoBlocks.SIZE;

        tempPiece[4].x = tempPiece[0].x;
        tempPiece[4].y = tempPiece[0].y - 2 * PentominoBlocks.SIZE;
        direction = 4;
    }
}