public class Player {
    private int HeroLevel = 1;
    private int Atk = 100;
    private int Speed = 50;
    private int Def = 30;
    private int Health = 100;
    private int MaxHealth = 150;
    private int XP = 0;
    // Every 100 xp you level up
    // Level up mechanic updates alls stats by 1
    // player is an encounter


    // GETTERS
    public int getAtk() {
        return Atk;
    }
    public int getDef() {
        return Def;
    }
    public int getSpeed() {
        return Speed;
    }
    public int getHealth() {
        return Health;
    }
    public int getMaxHealth() {
        return MaxHealth;
    }
    public int getLevel() {
        return HeroLevel;
    }
    public int getXP() {
        return XP;
    }
    
    //SETTERS
    public int setAtk(int x) {
        return Atk += x;
    }
    public int setDef(int x) {
        return Def += x;
    }
    public int setSpeed(int x) {
        return Speed += x;
    }
    public int setHealth(int x) {
        return Health += x;
    }
    public int setMaxHealth(int x) {
        return MaxHealth += x;
    }
    public int setLevel(int x) {
        return HeroLevel += x;
    }
    public int setXP(int x) {
        return XP += x;
    }
    
}
