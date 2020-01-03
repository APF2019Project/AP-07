package Model.Card.Plants;

import Model.Map.Cell;

public class PeaOrProjectile {

    private Cell cell;
    private int damage;//AP per attack
    private int speed=3;
    private boolean backward;
    private boolean prickly;
    private boolean projectile;

    public PeaOrProjectile(int damage,boolean projectile){
        this.damage=damage;
        this.projectile=projectile;
    }

    public Cell getCell(){
        return cell;
    }

    public void setCell(Cell cell){
        this.cell=cell;
    }

    public void setX(int x) {
        this.cell.setX(x);
    }

    public void setY(int y) {
        this.cell.setY(y);
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
