import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrossBower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrossBower extends Enemy
{
    /**
     * Act - do whatever the CrossBower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    MyWorld world;
    public CrossBower()
    {
        world = (MyWorld) getWorld();
    }
    public void act()
    {
        // Add your action code here.
    }
    private void prophetFollow()
    {
        if(world.prophet.walkingDirection == "left")
        {
            this.setLocation(prophet.getX() - 17, prophet.getY());
        }
    }
}
