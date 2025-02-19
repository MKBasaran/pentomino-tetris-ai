import java.awt.Color;

public class PentominoU extends Pentomino{

    public PentominoU(){
        create(new Color(0, 0, 153));
    }

    public String getPentomino(){
        return "U";
    }
    
    public void setXY(int x, int y){
        piece[0].x = x;
        piece[0].y = y;

        piece[1].x = piece[0].x - PentominoBlocks.SIZE;
        piece[1].y = piece[0].y - PentominoBlocks.SIZE;

        piece[2].x = piece[0].x - PentominoBlocks.SIZE;
        piece[2].y = piece[0].y;

        piece[3].x = piece[0].x + PentominoBlocks.SIZE;
        piece[3].y = piece[0].y;

        piece[4].x = piece[0].x + PentominoBlocks.SIZE;
        piece[4].y = piece[0].y - PentominoBlocks.SIZE;  
    }

    public void getDirection1(){
        tempPiece[0].x = piece[0].x;
        tempPiece[0].y = piece[0].y;

        tempPiece[1].x = piece[0].x - PentominoBlocks.SIZE;
        tempPiece[1].y = piece[0].y - PentominoBlocks.SIZE;

        tempPiece[2].x = piece[0].x - PentominoBlocks.SIZE;
        tempPiece[2].y = piece[0].y;

        tempPiece[3].x = piece[0].x + PentominoBlocks.SIZE;
        tempPiece[3].y = piece[0].y;

        tempPiece[4].x = piece[0].x + PentominoBlocks.SIZE;
        tempPiece[4].y = piece[0].y - PentominoBlocks.SIZE;
        direction = 1;
    }
        
    public void getDirection2(){
        tempPiece[0].x = piece[0].x;
        tempPiece[0].y = piece[0].y;

        tempPiece[1].x = piece[0].x + PentominoBlocks.SIZE;
        tempPiece[1].y = piece[0].y - PentominoBlocks.SIZE;

        tempPiece[2].x = piece[0].x;
        tempPiece[2].y = piece[0].y - PentominoBlocks.SIZE;

        tempPiece[3].x = piece[0].x;
        tempPiece[3].y = piece[0].y + PentominoBlocks.SIZE;

        tempPiece[4].x = piece[0].x + PentominoBlocks.SIZE;
        tempPiece[4].y = piece[0].y + PentominoBlocks.SIZE;
        direction = 2;
    }
    
    public void getDirection3(){
        tempPiece[0].x = piece[0].x;
        tempPiece[0].y = piece[0].y;

        tempPiece[1].x = piece[0].x + PentominoBlocks.SIZE; 
        tempPiece[1].y = piece[0].y + PentominoBlocks.SIZE;

        tempPiece[2].x = piece[0].x + PentominoBlocks.SIZE; 
        tempPiece[2].y = piece[0].y;

        tempPiece[3].x = piece[0].x - PentominoBlocks.SIZE; 
        tempPiece[3].y = piece[0].y;

        tempPiece[4].x = piece[0].x - PentominoBlocks.SIZE;
        tempPiece[4].y = piece[0].y + PentominoBlocks.SIZE;
        direction = 3;
    }
    
    public void getDirection4(){
        tempPiece[0].x = piece[0].x;
        tempPiece[0].y = piece[0].y;

        tempPiece[1].x = piece[0].x - PentominoBlocks.SIZE;
        tempPiece[1].y = piece[0].y + PentominoBlocks.SIZE;

        tempPiece[2].x = piece[0].x;
        tempPiece[2].y = piece[0].y + PentominoBlocks.SIZE;

        tempPiece[3].x = piece[0].x;
        tempPiece[3].y = piece[0].y - PentominoBlocks.SIZE;

        tempPiece[4].x = piece[0].x - PentominoBlocks.SIZE;
        tempPiece[4].y = piece[0].y - PentominoBlocks.SIZE;
        direction = 4;
    }
}