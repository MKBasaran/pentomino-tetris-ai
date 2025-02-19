import javax.swing.JFrame;

public class MainFrame extends JFrame {

    private StartMenuPanel startMenuPanel;

    public MainFrame() {
        startMenuPanel = new StartMenuPanel(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(GamePanel.WIDTH, GamePanel.HEIGHT);
        this.setContentPane(startMenuPanel);
        this.setVisible(true);
    }

    public void launchPlayerGame() {
        PlayerPanel playerPanel = new PlayerPanel();
        this.setContentPane(playerPanel);
        this.revalidate();
        this.repaint();
        playerPanel.requestFocusInWindow();
        playerPanel.launchGame();
    }
    
    public void launchBotGame() {
        BotPanel botPanel = new BotPanel();
        this.setContentPane(botPanel);
        this.revalidate();
        this.repaint();
        botPanel.requestFocusInWindow();
        botPanel.launchGame();
    }

    public void launchSmartBotGame() {
        SmartBotPanel smartBotPanel = new SmartBotPanel();
        this.setContentPane(smartBotPanel);
        this.revalidate();
        this.repaint();
        smartBotPanel.requestFocusInWindow();
        smartBotPanel.launchGame();
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}