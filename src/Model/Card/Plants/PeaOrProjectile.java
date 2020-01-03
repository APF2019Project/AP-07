package Model.Card.Plants;

import Model.Map.Cell;

public class PeaOrProjectile {

    private Cell cell;
    private int damage;//AP per attack
    private int speed=3;
    private boolean prickly;
    private boolean projectile;

    public PeaOrProjectile(int damage,boolean projectile, boolean prickly){
        this.damage=damage;
        this.projectile=projectile;
        this.prickly=prickly;
    }

    public Cell getCell(){
        return cell;
    }

    public void setCell(Cell cell){
        this.cell=cell;
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
