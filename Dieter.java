import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dieter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dieter extends Player
{
    /**
     * Act - do whatever the Dieter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] image = new GreenfootImage[6];
    GreenfootImage[] invertedImage = new GreenfootImage[6];
    SimpleTimer timer = new SimpleTimer();
    boolean keepLeft = false;
    boolean isUp = false, isDown = false, isLeft = false, isRight = true; 
    GreenfootSound sound = new GreenfootSound("sounds/coin.mp3");
    MyWorld world;
    public Dieter()
    {
        for(int i = 0; i < 6; i++)
        {
            image[i] = new GreenfootImage("Dieter" + i + ".png");
            invertedImage[i] = new GreenfootImage("Dieter" + i + ".png");
            invertedImage[i].mirrorHorizontally(); 
        }
    }

    public void act()
    {
        world = (MyWorld) getWorld();
        keyDown();
         if(isTouching(MusicNote.class))
        {
            sound = new GreenfootSound("sounds/coin.mp3");
            sound.play();
            removeTouching(MusicNote.class);
            ((MyWorld) getWorld()).addScore(50);
        }
        withKirsten();
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
    private void withKirsten()
    {
        if(((MyWorld) getWorld()).kirsten.checkUpDown() && Greenfoot.isKeyDown("W"))
        {
            isUp = true;
            isDown = false;
            isRight = false;
            isLeft = false;
        }
        else if(((MyWorld) getWorld()).kirsten.checkUpDown() && Greenfoot.isKeyDown("S"))
        {
            isUp = false;
            isDown = true;
            isRight = false;
            isLeft = false;
        }
        else if(((MyWorld) getWorld()).kirsten.checkSideway() && Greenfoot.isKeyDown("A"))
        {
            isUp = false;
            isDown = false;
            isRight = false;
            isLeft = true;
        }
        else if(((MyWorld) getWorld()).kirsten.checkSideway() && Greenfoot.isKeyDown("D"))
        {
            isUp = false;
            isDown = false;
            isRight = true;
            isLeft = false;
        }

        if(isUp)
        {
            setLocation(world.kirsten.getX(), world.saydi.getY() + 17);
        }
        else if(isDown)
        {
            setLocation(world.kirsten.getX(), world.saydi.getY() - 17); 
        }
        else if(isLeft)
        {
            setLocation(world.saydi.getX() - 17, world.kirsten.getY());
        }
        else if(isRight)
        {
            setLocation(world.saydi.getX() - 17, world.kirsten.getY());
        }
    }
}
