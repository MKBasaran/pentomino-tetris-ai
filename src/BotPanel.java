public class BotPanel extends GamePanel{
    public BotPanel(){
        super();
        this.addKeyListener(new KeyHandler());
        gm = new BotManager();
    }
}
