import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Kirsten here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kirsten extends Player
{
    /**
     * Act - do whatever the Kirsten wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean checkSideway;
    GreenfootImage[] image = new GreenfootImage[6];
    GreenfootImage[] invertedImage = new GreenfootImage[6];
    SimpleTimer timer = new SimpleTimer();
    SimpleTimer delay = new SimpleTimer();
    SimpleTimer knifeTimer = new SimpleTimer();
    private String walkingDirection= "right"; 
    int k = 0;
    int speedX = 1, speedY = 0;
    boolean canSwitch = true; 
    boolean keepLeft = false;
    MyWorld world;
    boolean canIndi = false;
    int num = 1;
    GreenfootSound sound = new GreenfootSound("sounds/stab.mp3");
    GreenfootSound sound2 = new GreenfootSound("sounds/coin.mp3");
    public Kirsten()
    {
        checkSideway = true;
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
        world = (MyWorld) getWorld();
        keyDown();
        if(isTouching(MusicNote.class))
        {
            sound2 = new GreenfootSound("sounds/coin.mp3");
            sound2.play();
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
        if (Greenfoot.isKeyDown("D"))
        {
            walkingDirection = "right";
            checkSideway = true;
           
            rightWalkAni();
            speedX = num;
            speedY = 0;
            keepLeft = false;
                //walkingDirection = "";
                //delay.mark();
            

        }
        else if (Greenfoot.isKeyDown("A"))
        {
            walkingDirection = "left";
            checkSideway = true;
            //if(checkSideway()){
                leftWalkAni();
                //walkingDirection = "";
                speedX = -num;
                speedY = 0;
                keepLeft = true;
                //delay.mark();
                
            //}

        }
        else if(Greenfoot.isKeyDown("W"))
        {
            walkingDirection = "up";
            checkSideway = false;
            speedX = 0;
            speedY = -num;
                //walkingDirection = "";
                //delay.mark();
        }
        else if(Greenfoot.isKeyDown("S"))
        {
            walkingDirection = "down";
            checkSideway = false;
            
            speedX = 0;
            speedY = num;
                //walkingDirection = "";
                //delay.mark();
            
        }

        if(keepLeft)
        {
            leftWalkAni();
        }
        else
        {
            rightWalkAni();
        }

        // if(walkingDirection == "up" && checkUpDown())
        // {
        // speedX = 0;
        // speedY = -1;
        // }
        // else if(walkingDirection == "down" && checkUpDown())
        // {
        // speedX = 0;
        // speedY = 1;
        // }
        // else if(walkingDirection == "left")
        // {
        // nowDirection = "left";
        // if(checkSideway()){
        // speedX = -1;
        // speedY = 0;
        // }
        // }
        // else if(walkingDirection == "right")
        // {
        // nowDirection = "right";
        // if(checkSideway())
        // {
        // speedX = 1;
        // speedY = 0;
        // }
        // }

        if (checkSideway)
        {
            if (!checkSideway())
                speedX = 0;
        }
        else
        {
            if (!checkUpDown())
                speedY = 0;
        }
        movement(speedX, speedY);
    }

    public boolean checkUpDown()
    {
        if(walkingDirection.equals("up"))
        {
            for (int i = 0; i < 3; i++)
            {
                ArrayList<Actor> upEncounters = (ArrayList<Actor>)getObjectsAtOffset(i * 5 - 5, 0, Actor.class);
                for (Actor upEncounter : upEncounters)
                {
                    if (upEncounter instanceof WorldBorder || upEncounter instanceof RuinedCar || upEncounter instanceof FallenTree || upEncounter instanceof SignPost)
                    {
                        return false;
                    }
                }
            }

        }
        else
        {
            for (int i = 0; i < 3; i++)
            {
                ArrayList<Actor> downEncounters = (ArrayList<Actor>)getObjectsAtOffset(i * 5 - 5, getImage().getHeight() / 2 + 5, Actor.class);
                for (Actor downEncounter : downEncounters)
                {
                    if (downEncounter instanceof WorldBorder || downEncounter instanceof RuinedCar || downEncounter instanceof FallenTree
                    || downEncounter instanceof SignPost)
                    {
                        return false;
                    }
                }
            }

        }
        return true;
    }

    public boolean checkSideway()
    {
        if (walkingDirection.equals("left"))
        {
            for (int i = 0; i < 2; i++)
            {
                ArrayList<Actor> leftEncounters = (ArrayList<Actor>)getObjectsAtOffset(-getImage().getWidth() / 2, i * (getImage().getHeight() / 2) + 4, Actor.class);
                for (Actor leftEncounter : leftEncounters)
                {
                    if (leftEncounter instanceof WorldBorder || leftEncounter instanceof RuinedCar || leftEncounter instanceof FallenTree
                    || leftEncounter instanceof SignPost)
                    {
                        return false;
                    }
                }
            }
        }
        else
        {
            for (int i = 0; i < 2; i++)
            {
                ArrayList<Actor> rightEncounters = (ArrayList<Actor>)getObjectsAtOffset(getImage().getWidth() / 2, i * (getImage().getHeight() / 2) + 4, Actor.class);
                for (Actor rightEncounter : rightEncounters)
                {
                    if (rightEncounter instanceof WorldBorder || rightEncounter instanceof RuinedCar || rightEncounter instanceof FallenTree || rightEncounter instanceof SignPost)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public void powerUp()
    {
        if(knifeTimer.millisElapsed() >= 5000)
        {
            canIndi = true;
            if(isTouching(Prophet.class) && Greenfoot.mouseClicked(null) || isTouching(Archer.class) && Greenfoot.mouseClicked(null)  || isTouching(CrossBower.class)
            && Greenfoot.mouseClicked(null))
            {
                sound.play();
                canIndi = false;
                world.enemyHealth--;
                if(world.enemyHealth == 2)
                {
                    world.removeObject(world.archer);
                }
                else if(world.enemyHealth == 1)
                {
                    world.removeObject(world.crossbower);
                }
                knifeTimer.mark();
            }
        }
    }

    private void movement(int x, int y)
    {
        this.setLocation(this.getX() + x, this.getY() + y);
    }
}

