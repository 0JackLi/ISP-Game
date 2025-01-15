import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Knife here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Knife extends Actor
{
    /**
     * Act - do whatever the Knife wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    MyWorld world;
    SimpleTimer timer = new SimpleTimer();
    public Knife()
    {
        
    }
    public void act()
    {
        world = (MyWorld) getWorld();
        // Add your action code here.
    }
    private void checkHit()
    {
        if(isTouching(Prophet.class) || isTouching(Archer.class) || isTouching(CrossBower.class))
        {
            world.enemyHealth --;
            if(world.enemyHealth == 2)
            {
                world.removeObject(world.archer);
            }
            else if(world.enemyHealth == 1)
            {
                world.removeObject(world.crossbower);
            }
            else if(world.enemyHealth == 0)
            {
                world.removeObject(world.prophet);
            }
        }
    }
}
