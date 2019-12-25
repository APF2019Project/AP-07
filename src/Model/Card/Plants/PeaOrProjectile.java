package Model.Card.Plants;

public class PeaOrProjectile {

    private int x;
    private int y;
    private int damage;//AP per attack
    private int speed=3;
    private boolean prickly;
    private boolean projectile;

    public PeaOrProjectile(int damage,boolean projectile, boolean prickly){
        this.damage=damage;
        this.projectile=projectile;
        this.prickly=prickly;
    }

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

    public boolean isProjectile() {
        return projectile;
    }

}
