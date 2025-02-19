public class SmartBotPanel extends GamePanel{
    public SmartBotPanel(){
        super();
        this.addKeyListener(new KeyHandler());
        gm = new SmartBotManager();
    }
}
