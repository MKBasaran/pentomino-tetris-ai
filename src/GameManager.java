import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

public abstract class GameManager{
    final int WIDTH = 5 * PentominoBlocks.SIZE;
    final int HEIGHT = 15 * PentominoBlocks.SIZE;
    public static int leftX;
    public static int rightX;
    public static int topY;
    public static int bottomY;
    Pentomino currentPentomino;
    final int STARTX;
    final int STARTY;
    Pentomino nextPentomino;
    final int NEXTPENTAMINO_X;
    final int NEXTPENTAMINO_Y;
    static int dropInterval = 0;

    public static ArrayList<PentominoBlocks> staticBlocks = new ArrayList<>();

    boolean gameOver;
    
    // Effect 
    boolean effectCounterOn;
    int effectCounter;
    ArrayList<Integer> effectY = new ArrayList<>();

    // Score
    int level = 1;
    int score;
    int lines;

    int highScore;

    public GameManager(){
        // Main area to play
        topY = ((GamePanel.HEIGHT - HEIGHT) / 2) + 5;
        bottomY = topY + HEIGHT;
        leftX = ((GamePanel.WIDTH - WIDTH) / 2) + 5; // 5 = half of boar
        rightX = leftX + WIDTH;
    
        STARTX = leftX + 2 * PentominoBlocks.SIZE;
        STARTY = topY + PentominoBlocks.SIZE; // Adjusted to add a gap from the top

        NEXTPENTAMINO_X = leftX - 5 + WIDTH + 10 + 320;
        NEXTPENTAMINO_Y = topY - 5 + ((HEIGHT + 10)/2) + 100;

        highScore = HighScoreManager.loadHighScore();
    }

    public Pentomino pickPentomino(){
        Pentomino pentomino = null;
        return pentomino;
    };

    public void changeSpeed(){}

    public void update(){
        if (!currentPentomino.active) {
            for (PentominoBlocks block : currentPentomino.piece) {
                staticBlocks.add(block);
            }

            currentPentomino.deactivating = false;

            currentPentomino = nextPentomino;
            currentPentomino.setXY(STARTX, STARTY);
            nextPentomino = pickPentomino();
            nextPentomino.setXY(NEXTPENTAMINO_X, NEXTPENTAMINO_Y);

            checkDelete();

            if (isGameOver()) {
                gameOver = true;
                return; // Stop further game updates if game is over
            }
        }

        if(currentPentomino.deactivating){
            currentPentomino.deactivating();
        }

        changeUpdate();
    }

    public void changeUpdate(){};

    private void checkDelete() {
        boolean findRow = false;
        effectCounter = 0;
        effectCounterOn = false;

        // Identify full rows
        for (int y = topY; y < bottomY; y += PentominoBlocks.SIZE) {
            boolean rowComplete = true;

            // Check each cell in the row
            for (int x = leftX; x < rightX; x += PentominoBlocks.SIZE) {
                if (!checkCell(x, y)) {
                    rowComplete = false;
                    break; // Break out of the loop if any cell in the row is empty
                }
            }

            if (rowComplete) {
                findRow = true;
                lines++;
                score += 10 * level;
                effectCounterOn = true;
                effectY.add(y);
                removeRow(y);
                shiftBlocksDown(y);
            }
        }

        if (findRow == true) {
            level++;
            HighScoreManager.updateHighScore(score);
            highScore = HighScoreManager.loadHighScore();
            changeSpeed();
        }
    }

    private void removeRow(int rowY) {
        staticBlocks.removeIf(block -> block.y == rowY);
    }

    private void shiftBlocksDown(int fromY) {
        for (PentominoBlocks block : staticBlocks) {
            if (block.y < fromY) {
                block.y += PentominoBlocks.SIZE;
            }
        }
    }

    private boolean checkCell(int x, int y) {
        for (PentominoBlocks block : staticBlocks) {
            if (block.x == x && block.y == y) {
                return true; // Block found at this cell
            }
        }
        return false; // No block found at this cell
    }

    private boolean isGameOver() {
        for (PentominoBlocks block : currentPentomino.piece) {
            for (PentominoBlocks staticBlock : staticBlocks) {
                if (block.x == staticBlock.x && block.y == staticBlock.y) {
                    return true; // Game over if any new block overlaps with static blocks
                }
            }
        }
        return false;
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(10f));
        g2.drawRect(leftX - 5, topY - 5, WIDTH + 10, HEIGHT + 10);

        g2.drawRect(leftX - 5 + WIDTH + 10 + 100, topY - 5 + ((HEIGHT + 10)/2) + 50, (WIDTH + 10) * 2, ((HEIGHT + 10)/2) - 50);
        g2.setFont(new Font("Arial",Font.PLAIN,30));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawString("NEXT",leftX - 5 + WIDTH + 10 + 150, topY - 5 + ((HEIGHT + 10)/2) + 150);
        
        // Draw score frame
        g2.drawRect(leftX - 5 + WIDTH + 10 + 100, topY - 5, (WIDTH + 10) * 2, ((HEIGHT + 10)/2));
        g2.drawString("LEVEL: " + level, leftX - 5 + WIDTH + 10 + 100 + 20, topY - 5 + 50);
        g2.drawString("CREDIT: " + lines , leftX - 5 + WIDTH + 10 + 100 + 20, topY - 5 + 100);
        g2.drawString("SCORE: " + score, leftX - 5 + WIDTH + 10 + 100 + 20, topY - 5 + 150);
        g2.drawString("HIGH SCORE: " + highScore, leftX - 5 + WIDTH + 10 + 100 + 20, topY - 5 + 200);

        if(currentPentomino != null){
            currentPentomino.draw(g2);
        }

        // Draw the next Pentamino 
        nextPentomino.draw(g2);

        for(int i = 0; i<staticBlocks.size(); i++){
            staticBlocks.get(i).draw(g2);
        }

        if(effectCounterOn){
            effectCounter++;

            g2.setColor(Color.red);
            for(int i = 0; i<effectY.size();i++){
                g2.fillRect(leftX, effectY.get(i), WIDTH, PentominoBlocks.SIZE);
            }

            if(effectCounter == 10){
                effectCounterOn = false;
                effectCounter = 0;
                effectY.clear();
            }
        }

        g2.setColor(Color.yellow);
        g2.setFont(g2.getFont().deriveFont(50f));

        if(gameOver){
            g2.drawString("GAME OVER!", leftX - ((WIDTH) * 2) - 150, topY + 250);
        }

        else if(KeyHandler.pausePressed){
            g2.drawString("PAUSED", leftX - ((WIDTH) * 2) - 100, topY + 250);
        }

        g2.setColor(Color.cyan);
        g2.setFont(new Font("Times new Roman", Font.ITALIC, 60));
        g2.drawString("Pentomino Tetris ", leftX - ((WIDTH) * 3) - 50, topY + 50);
    }
}