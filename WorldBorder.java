import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldBorder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class WorldBorder extends Actor
{
    protected static GreenfootImage horizontalImage, verticalImage;
    public WorldBorder()
    {
        verticalImage = new GreenfootImage(1, MyWorld.WORLD_HEIGHT);
        horizontalImage = new GreenfootImage(MyWorld.WORLD_WIDTH, 1);
        verticalImage.setColor(Color.RED);
        horizontalImage.setColor(Color.RED);
        verticalImage.fillRect(0, 0, verticalImage.getWidth(), verticalImage.getHeight());
        horizontalImage.fillRect(0, 0, horizontalImage.getWidth(), horizontalImage.getHeight());
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
