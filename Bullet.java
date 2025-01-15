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
    MyWorld world;
    GreenfootSound sound = new GreenfootSound("sounds/rifle.mp3");
    int num = 0;
    public Bullet(int xDirection, int yDirection, int k)
    {
        bulletImage = new GreenfootImage("bullet.png");
        this.xDirection = xDirection;
        this.yDirection = yDirection;
        setImage(bulletImage);
        sound.play();
        num = k;
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
    
    public void checkHit()
    {
        if(this.isTouching(Dieter.class) || this.isTouching(Saydi.class) || this.isTouching(August.class) || this.isTouching(Kirsten.class))
        {
            world.playerHealth -= 1;
            world.removeObject(this);
        }
        if(world.playerHealth == 3)
        {
            world.removeObject(world.dieter);
        }
        else if(world.playerHealth == 2)
        {
            world.removeObject(world.saydi);
        }
        else if(world.playerHealth == 1)
        {
            world.removeObject(world.august);
        }
        else if(world.playerHealth == 0)
        {
            world.removeObject(world.kirsten);
        }
    }

    public void act()
    {
        world = (MyWorld) getWorld();
        setLocation(getX() + num * xDirection, getY() + num * yDirection); 
        checkHit();
    }
}
