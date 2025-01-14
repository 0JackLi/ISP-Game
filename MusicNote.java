import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class MusicNote here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicNote extends Actor
{
    /**
     * Act - do whatever the MusicNote wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer timer = new SimpleTimer();
    MusicNote note;
    private int animationMovement;
    private boolean isUp;
    public MusicNote()
    {
        animationMovement = 10;
    }
    public void act()
    {
        // Add your action code here.
        if (!isUp)
        {
            setLocation(getX(), getY() + 1);
            animationMovement = animationMovement - 1;
            isUp = (animationMovement <= 0);
        }
        else
        {
            setLocation(getX(), getY() - 1);
            animationMovement = animationMovement + 1;
            isUp = !(animationMovement >= 10);
        }
    }
}
