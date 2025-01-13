import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kirsten here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kirsten extends Actor
{
    /**
     * Act - do whatever the Kirsten wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] image = new GreenfootImage[6];
    GreenfootImage[] invertedImage = new GreenfootImage[6];
    SimpleTimer timer = new SimpleTimer();
    SimpleTimer delay = new SimpleTimer();
    String walkingDirection= "right", nowDirection = "right"; 
    int k = 0;
    int speedX = 1, speedY = 0;
    boolean canSwitch = true; 
    boolean keepLeft = false;
    public Kirsten()
    {
        for(int i = 0; i < 6; i++)
        {
            image[i] = new GreenfootImage("Kirsten" + i + ".png");
            invertedImage[i] = new GreenfootImage("Kirsten" + i + ".png");
            invertedImage[i].mirrorHorizontally();
        }
    }
    public void act()
    {
        // Add your action code here.
        keyDown();
        if(isTouching(MusicNote.class))
        {
            removeTouching(MusicNote.class);
            ((MyWorld) getWorld()).addScore(50);
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
    private void keyDown()
    {
        
            if(Greenfoot.isKeyDown("D"))
            {
                walkingDirection = "right";
                if(checkSideway()){
                    rightWalkAni();
                    speedX = 1;
                    speedY = 0;
                    keepLeft = false;
                    walkingDirection = "";
                    //delay.mark();
                }
            }
            else if(Greenfoot.isKeyDown("A"))
            {
                walkingDirection = "left";
                if(checkSideway()){
                    leftWalkAni();
                    walkingDirection = "";
                    speedX = -1;
                    speedY = 0;
                    keepLeft = true;
                    //delay.mark();
                }
            }
            else if(Greenfoot.isKeyDown("W"))
            {
                walkingDirection = "up";
                if(checkUpDown()){
                    speedX = 0;
                    speedY = -1;
                    walkingDirection = "";
                    //delay.mark();
                }
            }
            else if(Greenfoot.isKeyDown("S"))
            {
                walkingDirection = "down"; 
                if(checkUpDown()){
                    speedX = 0;
                    speedY = 1;
                    walkingDirection = "";
                    //delay.mark();
                }
            }
            if(keepLeft)
            {
                leftWalkAni();
            }
            else
            {
                rightWalkAni();
            }
            
             if(walkingDirection == "up" && checkUpDown())
            {
                speedX = 0;
                speedY = -1;
            }
            else if(walkingDirection == "down" && checkUpDown())
            {
                speedX = 0;
                speedY = 1;
            }
            else if(walkingDirection == "left")
            {
                nowDirection = "left";
                if(checkSideway()){
                    speedX = -1;
                    speedY = 0;
                }
            }
            else if(walkingDirection == "right")
            {
                nowDirection = "right";
                if(checkSideway())
                {
                    speedX = 1;
                    speedY = 0;
                }
            }
            movement(speedX, speedY);
    }
    private boolean checkUpDown()
    {
        if( this.getOneObjectAtOffset(-13, 0, VerticalBasicRoad.class) != null)
        {
            return true;
        }
        return false;
    }
    private boolean checkSideway()
    {
        if(nowDirection == "left" && this.getOneObjectAtOffset(-5, 0, BasicRoad.class)!= null 
        || nowDirection == "left" && this.getOneObjectAtOffset(-5, 0, Road.class)!= null 
        || nowDirection == "right" && this.getOneObjectAtOffset(5, 0, BasicRoad.class) != null 
        || nowDirection == "right" && this.getOneObjectAtOffset(5, 0, Road.class) != null)
        {
            return true;
        }
        return false;
    }
    private void movement(int x, int y)
    {
        this.setLocation(this.getX() + x, this.getY() + y);
    }
}
