import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BasicRoad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BasicRoad extends Actor
{
    /**
     * Act - do whatever the BasicRoad wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image = getImage();
    World world;
    BasicRoad road;
    public BasicRoad()
    {
    }
    public void act()
    {
        // Add your action code here.
    }
    public void constructRoad(int x, int y, int amount)
    {
        world = getWorld();
        for(int i = 1; i <= amount; i++)
        {
            road = new BasicRoad();
            world.addObject(road, x + image.getWidth() * i, y);
        }
    }
}
