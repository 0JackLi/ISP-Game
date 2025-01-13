import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class August here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class August extends Actor
{
    /**
     * Act - do whatever the August wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] image = new GreenfootImage[6];
    GreenfootImage[] invertedImage = new GreenfootImage[6];
    SimpleTimer timer = new SimpleTimer();
    boolean keepLeft = false;
    public August()
    {
        for(int i = 0; i < 6; i++)
        {
            image[i] = new GreenfootImage("August" + i + ".png");
            invertedImage[i] = new GreenfootImage("August" + i + ".png");
            invertedImage[i].mirrorHorizontally(); 
        }
    }

    public void act()
    {
        MyWorld world = (MyWorld) getWorld();
        setLocation(world.kirsten.getX() - 20, world.kirsten.getY());
        keyDown();
        if(isTouching(MusicNote.class))
        {
            removeTouching(MusicNote.class);
            ((MyWorld) getWorld()).addScore(50);
        }
    }
    int k = 0;
    private void keyDown()
    {
        if(Greenfoot.isKeyDown("D"))
        {
            keepLeft = false;
        }
        else if(Greenfoot.isKeyDown("A"))
        {
            keepLeft = true;
        }
        if(keepLeft)
        {
            leftWalkAni();
        }
        else
        {
            rightWalkAni();
        }
    }
     private void rightWalkAni()
    {
        if(timer.millisElapsed() >= 100)
        {
            timer.mark();
            k = (k + 1) % 6; 
            this.setImage(image[k]);
        }
    }
    private void leftWalkAni()
    {
        if(timer.millisElapsed() >= 100)
        {
            timer.mark();
            k = (k + 1) % 6;
            this.setImage(invertedImage[k]);
        }
    }
}
