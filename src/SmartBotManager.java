public class SmartBotManager extends GameManager{
    boolean oneTime = true;
    int i = 0;
    int y = 0;

    public SmartBotManager(){
        super();
        dropInterval = 20;
        currentPentomino = pickPentomino();
        currentPentomino.setXY(STARTX, STARTY);
        nextPentomino = pickPentomino();
        nextPentomino.setXY(NEXTPENTAMINO_X, NEXTPENTAMINO_Y);
    }

    public Pentomino pickPentomino(){
        Pentomino pentomino = null;
        if(i == 12){
            i = 0;
        }
        i++;
        switch (i) {
            case 1:  pentomino = new PentominoP();break;
            case 2:  pentomino = new PentominoL();break;
            case 3:  pentomino = new PentominoI();break;
            case 4:  pentomino = new PentominoW();break;
            case 5:  pentomino = new PentominoZ();break;
            case 6:  pentomino = new PentominoT();break;
            case 7:  pentomino = new PentominoN();break;
            case 8:  pentomino = new PentominoU();break;
            case 9:  pentomino = new PentominoX();break;
            case 10: pentomino = new PentominoY();break;
            case 11: pentomino = new PentominoF();break;
            case 12: pentomino = new PentominoV();break;
        }
        
        return pentomino;
    }

    public void changeUpdate(){
        if(oneTime){
            oneTime = false;
            y++;
            if(currentPentomino.getPentomino() == "P") {
                if(y == 1){
                }else if(y == 2){
                    currentPentomino.changeRotation();
                }else if(y == 3){
                    currentPentomino.changeRotation();
                }else if(y == 4){
                    currentPentomino.moveRight();
                }else if(y == 5){
                    currentPentomino.moveRight();
                }else if(y == 6){
                    currentPentomino.dropFast();
                    y = 1;
                }
            }else if(currentPentomino.getPentomino() == "L"){
                if(y == 1){
                }else if(y == 2){
                    currentPentomino.changeRotation();
                }else if(y == 3){
                    currentPentomino.moveLeft();
                }else if(y == 4){
                    currentPentomino.dropFast();
                    y = 1;
                }
            }else if(currentPentomino.getPentomino() == "I"){
                if(y == 1){
                }else if(y == 2){
                    currentPentomino.moveLeft();
                }else if(y == 3){
                    currentPentomino.moveLeft();
                }else if(y == 4){
                    currentPentomino.dropFast();
                    y = 1;
                }
            }else if(currentPentomino.getPentomino() == "W"){
                if(y == 1){
                }else if(y == 2){
                    currentPentomino.changeRotation();
                }else if(y == 3){
                    currentPentomino.moveRight();
                }else if(y == 4){
                    currentPentomino.dropFast();
                    y = 1;
                }
            }else if(currentPentomino.getPentomino() == "Z"){
                if(y == 1){
                }else if(y == 2){
                    currentPentomino.changeRotation();
                }else if(y == 3){
                    currentPentomino.moveRight();
                }else if(y == 4){
                    currentPentomino.dropFast();
                    y = 1;
                }
            }else if(currentPentomino.getPentomino() == "T"){
                if(y == 1){
                }else if(y == 2){
                    currentPentomino.changeRotation();
                }else if(y == 3){
                    currentPentomino.changeRotation();
                }else if(y == 4){
                    currentPentomino.changeRotation();
                }else if(y == 5){
                    currentPentomino.dropFast();
                    y = 1;
                }
            }else if(currentPentomino.getPentomino() == "N"){
                if(y == 1){
                }else if(y == 2){
                    currentPentomino.moveLeft();
                }else if(y == 3){
                    currentPentomino.moveLeft();
                }else if(y == 4){
                    currentPentomino.dropFast();
                    y = 1;
                }
            }else if(currentPentomino.getPentomino() == "U"){
                if(y == 1){
                }else if(y == 2){
                    currentPentomino.moveRight();
                }else if(y == 3){
                    currentPentomino.dropFast();
                    y = 1;
                }
            }else if(currentPentomino.getPentomino() == "X"){
                if(y == 1){
                }else if(y == 2){
                    currentPentomino.moveRight();
                }else if(y == 3){
                    currentPentomino.dropFast();
                    y = 1;
                }
            }else if(currentPentomino.getPentomino() == "Y"){
                if(y == 1){
                }else if(y == 2){
                    currentPentomino.changeRotation();
                }else if(y == 3){
                    currentPentomino.changeRotation();
                }else if(y == 4){
                    currentPentomino.moveLeft();
                }else if(y == 5){
                    currentPentomino.moveLeft();
                }else if(y == 6){
                    currentPentomino.dropFast();
                    y = 1;
                }
            }else if(currentPentomino.getPentomino() == "F"){
                if(y == 1){
                }else if(y == 2){
                    currentPentomino.changeRotation();
                }else if(y == 3){
                    currentPentomino.dropFast();
                    y = 1;
                }
            }else if(currentPentomino.getPentomino() == "V"){
                if(y == 1){
                }else if(y == 2){
                    currentPentomino.changeRotation();
                }else if(y == 3){
                    currentPentomino.changeRotation();
                }else if(y == 4){
                    currentPentomino.moveRight();
                }else if(y == 5){
                    currentPentomino.dropFast();
                    y = 1;
                }
            }
        }
        currentPentomino.drop();
        if(currentPentomino.autoDropCounter == 0 && currentPentomino.deactivating == false){
            oneTime = true;
        }
    }
}
