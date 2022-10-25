public class Encounter  {
    static Player player1 = new Player();
    Enemy enemy1 = new Enemy();
    // encounter can be enemy, item, 

    public void fight() {
    if(player1.getAtk() > enemy1.getDef()) {
        // System.out.println("Player Won");
        System.out.println("20XP Earned!");
        // System.out.println("Plater XP Before: " + player1.getXP());
        player1.setXP(20);
        System.out.println("Player XP: " + player1.getXP());
    }
    else { 
        System.out.println("Player Lost");
    }
    }
}
