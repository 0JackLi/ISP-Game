import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bush here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bush extends Actor
{
    /**
     * Act - do whatever the Bush wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image = getImage();
    World world;
    Bush bush;
    public void act()
    {
        // Add your action code here.
    }
    public void constructBush(int x, int y, int amount)
    {
        world = getWorld();
        for(int i = 1; i <= amount; i++)
        {
            bush = new Bush();
            world.addObject(bush, x + (image.getWidth() - 25) * i, y);
        }
    }
}
