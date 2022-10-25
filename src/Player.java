public class Player {
    private int HeroLevel = 1;
    private int Atk = 20;
    private int Speed = 50;
    private int Def = 30;
    private int Health = 100;
    private int MaxHealth = 150;
    private int XP = 0;

    public int getAtk() {
        return Atk;
    }
    public int getDef() {
        return Def;
    }
    public int setHealth(int x) {
        return Health -= x;
    }
    public int getHealth() {
        return Health;
    }
    public int getXP() {
        return XP;
    }
    public int setXP(int x) {
         XP += x;
         return XP;
    }
// Every 100 xp you level up
// Level up mechanic updates alls stats by 1
// player is an encounter
}
