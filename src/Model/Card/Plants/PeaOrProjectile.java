package Model.Card.Plants;

public class PeaOrProjectile {

    private int x;
    private int y;
    private int damage;//AP per attack
    public int speed = 3;
    private boolean projectile;

    public PeaOrProjectile(int damage,boolean projectile){
        this.damage=damage;
        this.projectile=projectile;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isProjectile() {
        return projectile;
    }


}
