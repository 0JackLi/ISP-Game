import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VerticalBasicRoad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VerticalBasicRoad extends Actor
{
    /**
     * Act - do whatever the VerticalBasicRoad wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    World world;
    VerticalBasicRoad road;
    GreenfootImage image = getImage();
    public void act()
    {
        // Add your action code here.
    }

    public void constructRoad(int x, int y, int amount, int e)
    {
        world = getWorld();
        for(int i = 1; i <= amount; i++)
        {
            road = new VerticalBasicRoad();
            if(e == 0)
            {
                road.setImage("vertical.png");
            }
            else if(e == 1)
            {
                road.setImage("verticalLRoad.png");
            }
            world.addObject(road, x, y + image.getHeight() * i);
        }
    }
}
