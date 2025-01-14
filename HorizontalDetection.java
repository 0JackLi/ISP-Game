import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HorizontalDetection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HorizontalDetection extends DetectionTool
{
    public HorizontalDetection(Actor actor, int offset)
    {
        followActor = actor;
        offsetMultiplication = offset;
        setImage(horizontalImage);
    }
    
    public void act()
    {
        setLocation(followActor.getX() + offsetMultiplication * getImage().getWidth() / 2, followActor.getY());
    }
}
