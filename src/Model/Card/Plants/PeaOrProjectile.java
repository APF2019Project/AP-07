package Model.Card.Plants;

import Model.Card.Zombies.Zombie;
import Model.Map.Cell;
import Model.Map.Map;

public class PeaOrProjectile {

    private int x;
    private int y;
    private int damage;//AP per attack
    private int speed=3;
    private boolean backward;
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

    public void move(Map map){
        Cell cell = map.getCell(this.x,this.y);
        int i = 0;
        while (i<this.speed){
            if (map.getCell(x,y++).zombies.size()==0)
                y++;
            else {
                map.getCell(x,y++).zombies.get(0).setHP(-this.damage);
                map.getCell(x,y).peas.remove(this);
                break;
            }
            i++;
        }
    }

    public boolean isProjectile() {
        return projectile;
    }

}
