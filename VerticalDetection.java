import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VerticalDetection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VerticalDetection extends DetectionTool
{
    public VerticalDetection(Actor actor, int direction)
    {
        followActor = actor;
        directionMovement = (int)Math.signum(direction);
        setImage(verticalImage);
    }
    
    public void act()
    {
        setLocation(followActor.getX(), followActor.getY() + directionMovement * getImage().getHeight() / 2);
    }
}
