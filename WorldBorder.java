import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WorldBorder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class WorldBorder extends Actor
{
    protected static GreenfootImage borderImage;
    public static final boolean hideBorder = false;
    public WorldBorder(int imageWidth, int imageHeight)
    {
        borderImage = new GreenfootImage(imageWidth, imageHeight);
        if (hideBorder)
            borderImage.setTransparency(0);
        
        borderImage.setColor(Color.RED);
        borderImage.fillRect(0, 0, borderImage.getWidth(), borderImage.getHeight());
        setImage(borderImage);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
