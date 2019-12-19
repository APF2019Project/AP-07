package Model.Card.Plants;
import Model.Card.Zombies.Zombie;
import Model.Map.Cell;

public class PeaOrProjectile {

    private Cell cell;
    private String name;
    private int damage;
    private int speed=3;
    private boolean prickly;
    private double speedReduction;
    private boolean projectile;

    public void speedReduce(Zombie zombie) {
        //kahesh sorate zombie
    }

    public PeaOrProjectile(Cell cell, String name, int damage, boolean prickly, double speedReduction, boolean projectile){
        this.cell=cell;
        this.name=name;
        this.damage=damage;
        this.prickly=prickly;
        this.speedReduction=speedReduction;
        this.projectile=projectile;
    }

}
