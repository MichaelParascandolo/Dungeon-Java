public class Enemy {
    private int Atk = 45;
    private int Speed = 65;
    private int Def = 0;
    private int Life = 90;
    private int ExpValue = 50;
    
    // GETTERS
    public int getAtk() {
        return Atk;
    }
    public int getSpeed() {
        return Speed;
    }
    public int getDef() {
        return Def;
    }
    public int getLife() {
        return Life;
    }
    public int getXP() {
        return ExpValue;
    }

    // SETTERS
    public int setAtk(int x) {
        return Atk += x;
    }
    public int setSpeed(int x) {
        return Speed += x;
    }
    public int setDef(int x) {
        return Def += x;
    }
    public int setLife(int x) {
        return Life += x;
    }
    public int setXP(int x) {
        return ExpValue += x;
    }

}
