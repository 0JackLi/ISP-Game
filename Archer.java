import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CrossBower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Archer extends Enemy
{
    /**
     * Act - do whatever the CrossBower wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    MyWorld world;
    boolean keepLeft = false;
    int k = 0;
    GreenfootImage[] image = new GreenfootImage[6];
    GreenfootImage[] invertedImage = new GreenfootImage[6];
    SimpleTimer timer = new SimpleTimer();
    public Archer()
    {
        world = (MyWorld) getWorld();
        for(int i = 0; i < 6; i++)
        {
            image[i] = new GreenfootImage("Archer" + i + ".png");
            invertedImage[i] = new GreenfootImage("Archer" + i + ".png");
            invertedImage[i].mirrorHorizontally();
        }
    }
    public void act()
    {
        // Add your action code here.
        world = (MyWorld) getWorld();
        prophetFollow();
    }
    private void prophetFollow()
    {
        if(world.prophet.walkingDirection == "left")
        {
            this.setLocation(world.crossbower.getX() - 20, world.prophet.getY());
            keepLeft = true;
        }
        else if(world.prophet.walkingDirection == "right")
        {
            this.setLocation(world.crossbower.getX() - 20, world.prophet.getY());
            keepLeft = false;
        }
        else if(world.prophet.walkingDirection == "down")
        {
            this.setLocation(world.prophet.getX(), world.crossbower.getY()  - 20);
        }
        else if(world.prophet.walkingDirection == "up")
        {
            this.setLocation(world.prophet.getX(), world.crossbower.getY()  - 20);
        }
        if(keepLeft)
        {
            leftWalkAni();
        }
        else{
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
