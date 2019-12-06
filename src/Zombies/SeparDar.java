package Zombies;

public class SeparDar extends Zombie {
    private int ArmourHealth;
    public void setArmourHealth(int armourHealth)
    {
        this.ArmourHealth = armourHealth;
    }
    public void defend(){

    }
    public void beingAffected(){

    }
    public boolean isArmourOfMetal() {
        return true;
    }
}
