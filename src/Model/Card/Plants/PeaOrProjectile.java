package Model.Card.Plants;

public class PeaOrProjectile {

    private int x;
    private int y;
    private int damage;//AP per attack
    private int speed=3;
    private boolean prickly;
    private double speedReduction;
    private boolean projectile;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isPrickly() {
        return prickly;
    }

    public double getSpeedReduction() {
        return speedReduction;
    }

    public PeaOrProjectile(int damage){
        this.damage=damage;
    }

    public boolean isProjectile() {
        return projectile;
    }

}
