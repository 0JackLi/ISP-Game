import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class water here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class water extends Actor
{
    /**
     * Act - do whatever the water wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image = getImage();
    public water(){
        image.scale(image.getWidth() + 5, image.getHeight());
        setImage(image);
    }
    public void act()
    {
        // Add your action code here.
    }
}
