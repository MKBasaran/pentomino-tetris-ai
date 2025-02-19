public class PlayerPanel extends GamePanel{
    public PlayerPanel(){
        super();
        this.addKeyListener(new KeyHandler());
        gm = new PlayerManager();
    }
}
