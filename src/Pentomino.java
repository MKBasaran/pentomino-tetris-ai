import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Pentomino {
    public PentominoBlocks piece[] = new PentominoBlocks[5];
    public PentominoBlocks tempPiece[] = new PentominoBlocks[5];
    
    int autoDropCounter = 0;
    public int direction = 1;
    boolean leftCollision, rightCollision, bottomCollision, topCollison, staticCollision; 
    public boolean active = true;
    public boolean deactivating;
    int deactivateCounter = 0;

    public void create(Color c){
        piece[0] = new PentominoBlocks(c);
        piece[1] = new PentominoBlocks(c);
        piece[2] = new PentominoBlocks(c);
        piece[3] = new PentominoBlocks(c);
        piece[4] = new PentominoBlocks(c);

        tempPiece[0] = new PentominoBlocks(c);
        tempPiece[1] = new PentominoBlocks(c);
        tempPiece[2] = new PentominoBlocks(c);
        tempPiece[3] = new PentominoBlocks(c);
        tempPiece[4] = new PentominoBlocks(c);
    }

    public void setXY(int x, int y){}

    public void updateXY(){
        for(int i = 0; i < tempPiece.length; i++){
            piece[i].y = tempPiece[i].y;
            piece[i].x = tempPiece[i].x;
        }
    }

    public void getDirection1(){}
    public void getDirection2(){}
    public void getDirection3(){}
    public void getDirection4(){}
    public String getPentomino(){
        return null;
    }

    public void checkTempCollision() {
        leftCollision = false;
        rightCollision = false;
        bottomCollision = false;
        topCollison = false;
        staticCollision = false;
    
        // Check collision with static blocks and frame boundaries
        for (int i = 0; i < this.tempPiece.length; i++) {
            // Check frame collision
            if (this.tempPiece[i].x < GameManager.leftX) {
                leftCollision = true; // If it goes outside left
            }
            
            if(this.tempPiece[i].x + PentominoBlocks.SIZE > GameManager.rightX){
                rightCollision = true;
            }

            if (this.tempPiece[i].y + PentominoBlocks.SIZE > GameManager.bottomY) {
                bottomCollision = true; // If it goes below the bottom boundary
            }

            if(this.tempPiece[i].y < GameManager.topY){
                topCollison = true;
            }
    
            // Check collision with static blocks
            for (PentominoBlocks staticBlock : GameManager.staticBlocks) {
                if (tempPiece[i].x  == staticBlock.x && tempPiece[i].y == staticBlock.y) {
                    staticCollision = true;
                    return;
                }
            }
        }
    }

    public void moveTempDown(){
        for(int i = 0; i < tempPiece.length; i++){
            tempPiece[i].y = piece[i].y + PentominoBlocks.SIZE;
            tempPiece[i].x = piece[i].x;
        }
    }

    public void moveTempLeft(){
        for(int i = 0; i < tempPiece.length; i++){
            tempPiece[i].y = piece[i].y;
            tempPiece[i].x = piece[i].x - PentominoBlocks.SIZE;
        }
    }

    public void moveTempRight(){
        for(int i = 0; i < tempPiece.length; i++){
            tempPiece[i].y = piece[i].y;
            tempPiece[i].x = piece[i].x + PentominoBlocks.SIZE;
        }
    }

    public void changeRotation(){
        switch (direction){
            case 1:
                getDirection2();
            break;
            case 2:
                getDirection3();
            break;
            case 3:
                getDirection4();
            break;
            case 4:
                getDirection1();
            break;
        }

        checkTempCollision();
        while(leftCollision == true || rightCollision == true || topCollison == true)
        {
            if (bottomCollision == true || staticCollision == true) {
                break;
            }
            if(topCollison == true){
                for (int i = 0; i < tempPiece.length; i++) {
                    tempPiece[i].y += PentominoBlocks.SIZE;
                }
            }
            if(rightCollision == true){
                for (int i = 0; i < tempPiece.length; i++) {
                    tempPiece[i].x -= PentominoBlocks.SIZE;
                }
            }else if(leftCollision == true){
                for (int i = 0; i < tempPiece.length; i++) {
                    tempPiece[i].x += PentominoBlocks.SIZE;
                }
            }
            checkTempCollision();
        }

        if(bottomCollision == false && staticCollision == false){
            updateXY();
        }
    }

    public void moveDown(){
        moveTempDown();
        checkTempCollision();
        if (bottomCollision == false && staticCollision == false) {
            updateXY();
            autoDropCounter = 0;
        }
    }

    public void dropFast(){
        while (bottomCollision == false && staticCollision == false) {
            moveTempDown();
            checkTempCollision();
            if (bottomCollision == false && staticCollision == false) {
                updateXY();
            }
        }
    }

    public void moveLeft(){
        moveTempLeft();
        checkTempCollision();
        if (leftCollision == false && staticCollision == false) {
            updateXY();
        }
    }

    public void moveRight(){
        moveTempRight();
        checkTempCollision();
        if (rightCollision == false && staticCollision == false) {
            updateXY();
        }
    }

    public void drop(){
        moveTempDown();
        checkTempCollision();

        if(bottomCollision || staticCollision){
            deactivating = true;
        }
        else
        {
            autoDropCounter++;  
            if(autoDropCounter == GameManager.dropInterval){
                updateXY();
                autoDropCounter = 0;
            } 
        } 
    }
    
    public void deactivating(){
        deactivateCounter++;
        if(deactivateCounter == 30){
            deactivateCounter = 0;

            if(bottomCollision || staticCollision){
                active = false;
            }
        }
    }

    public void draw(Graphics2D g2){
        int margin = 4;
        g2.setColor(piece[0].c); // Color of the first block
        g2.fillRect(piece[0].x + margin, piece[0].y + margin, PentominoBlocks.SIZE - (2 * margin), PentominoBlocks.SIZE - (2 * margin));
        g2.fillRect(piece[1].x + margin, piece[1].y + margin, PentominoBlocks.SIZE - (2 * margin), PentominoBlocks.SIZE - (2 * margin));
        g2.fillRect(piece[2].x + margin, piece[2].y + margin, PentominoBlocks.SIZE - (2 * margin), PentominoBlocks.SIZE - (2 * margin));
        g2.fillRect(piece[3].x + margin, piece[3].y + margin, PentominoBlocks.SIZE - (2 * margin), PentominoBlocks.SIZE - (2 * margin));
        g2.fillRect(piece[4].x + margin, piece[4].y + margin, PentominoBlocks.SIZE - (2 * margin), PentominoBlocks.SIZE - (2 * margin));
    }
}