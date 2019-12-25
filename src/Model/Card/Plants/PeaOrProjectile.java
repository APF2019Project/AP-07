package Model.Card.Plants;
import Model.Card.Zombies.Zombie;

public class PeaOrProjectile {

    private int x;
    private int y;
    private int damage=1;
    private int speed=3;
    private boolean prickly;
    private double speedReduction;
    private boolean projectile;

    public boolean isProjectile() {
        return projectile;
    }

}
