import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Indicator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Indicator extends Actor
{
    /**
     * Act - do whatever the Indicator wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    MyWorld world;
    public void act()
    {
        // Add your action code here.
        world = (MyWorld) getWorld();
        setLocation(world.kirsten.getX(), world.kirsten.getY() - 20);
    }
}
