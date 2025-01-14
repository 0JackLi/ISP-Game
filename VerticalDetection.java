import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VerticalDetection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VerticalDetection extends DetectionTool
{
    public VerticalDetection(Actor actor, int offset)
    {
        followActor = actor;
        offsetMultiplication = offset;
        setImage(verticalImage);
    }
    
    public void act()
    {
        setLocation(followActor.getX(), followActor.getY() + offsetMultiplication * getImage().getHeight() / 2);
    }
}
