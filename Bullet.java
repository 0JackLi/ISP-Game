import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private static GreenfootImage bulletImage;
    private int xDirection, yDirection;
    public Bullet(int xDirection, int yDirection)
    {
        bulletImage = new GreenfootImage("bullet.png");
        this.xDirection = xDirection;
        this.yDirection = yDirection;
        setImage(bulletImage);
    }
    
    private void tweakImage()
    {
        if (xDirection == 1)
        {
            setRotation(getRotation() + 180);
        }
        
        if (yDirection == 1)
        {
            setRotation(getRotation() - 90);
        }
        else
        {
            setRotation(getRotation() + 90);
        }
    }

    public void act()
    {
        setLocation(getX() + 2 * xDirection, getY() + 2 * yDirection); 
    }
}
