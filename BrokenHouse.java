import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrokenHouse here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BrokenHouse extends Actor
{
    /**
     * Act - do whatever the BrokenHouse wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image = getImage();
    World world;
    BrokenHouse house;
    public void act()
    {
        // Add your action code here.
    }
    public void constructHouse(int x, int y, int amount, int e)
    {
        world = getWorld();
        for(int i = 1; i <= amount; i++)
        {
            house = new BrokenHouse();
            if(e == 0)
            {
                house.setImage("brokenhouse.png");
            }
            else if(e == 1)
            {
                house.setImage("redBrickBuilding.png");
            }
            world.addObject(house, x + image.getWidth() * i, y);
        }
    }
}
