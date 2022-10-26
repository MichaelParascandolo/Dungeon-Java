import java.util.Random;

public class Encounter  {
    private Player player1 = new Player();
    private Enemy enemy1 = new Enemy();
    private Random ran = new Random();
    // make atk and def random?
    public boolean attack() {
        enemy1.setDef(ran.nextInt(101));
        System.out.println(enemy1.getDef());
    if(player1.getAtk() > enemy1.getDef()) {
        System.out.println("20XP Earned!");
        player1.setXP(20);
        System.out.println("Player XP: " + player1.getXP());
        return true;
    }
    else { 
        player1.setHealth(-20);
        System.out.println("Player Health: " + player1.getHealth());
        return false;
    }
    }
    public Player getPlayer() {
        return player1;
    }

}
