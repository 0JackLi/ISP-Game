import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
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
    private boolean checkSideway;
    GreenfootImage[] image = new GreenfootImage[6];
    GreenfootImage[] invertedImage = new GreenfootImage[6];
    SimpleTimer timer = new SimpleTimer();
    SimpleTimer delay = new SimpleTimer();
    private String walkingDirection= "right"; 
    int k = 0;
    int speedX = 1, speedY = 0;
    boolean canSwitch = true; 
    boolean keepLeft = false;
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
        if (Greenfoot.isKeyDown("D"))
        {
            walkingDirection = "right";
            checkSideway = true;
            if(checkSideway()){
                rightWalkAni();
                speedX = 1;
                speedY = 0;
                keepLeft = false;
                //walkingDirection = "";
                //delay.mark();
            }

        }
        else if (Greenfoot.isKeyDown("A"))
        {
            walkingDirection = "left";
            checkSideway = true;
            if(checkSideway()){
                leftWalkAni();
                //walkingDirection = "";
                speedX = -1;
                speedY = 0;
                keepLeft = true;
                //delay.mark();
            }

        }
        else if(Greenfoot.isKeyDown("W"))
        {
            walkingDirection = "up";
            checkSideway = false;
            if(checkUpDown()){
                speedX = 0;
                speedY = -1;
                //walkingDirection = "";
                //delay.mark();
            }
        }
        else if(Greenfoot.isKeyDown("S"))
        {
            walkingDirection = "down";
            checkSideway = false;
            if(checkUpDown()){
                speedX = 0;
                speedY = 1;
                //walkingDirection = "";
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

    private boolean checkUpDown()
    {
        boolean validRoad = false;
        boolean validObstacle = true;
        if(walkingDirection.equals("up"))
        {
            ArrayList<Actor> upEncounters = (ArrayList<Actor>)getObjectsAtOffset(0, 0, Actor.class);
            for (Actor upEncounter : upEncounters)
            {
                if (upEncounter instanceof VerticalBasicRoad)
                {
                    validRoad = true;;
                }
                
                if (upEncounter instanceof WorldBorder || upEncounter instanceof RuinedCar)
                {
                    validObstacle = false;
                }
            }
        }
        else
        {
            ArrayList<Actor> downEncounters = (ArrayList<Actor>)getObjectsAtOffset(0, getImage().getHeight() / 2 + 5, Actor.class);
            for (Actor downEncounter : downEncounters)
            {
                if (downEncounter instanceof VerticalBasicRoad)
                {
                    validRoad = true;   
                }
                
                if (downEncounter instanceof WorldBorder || downEncounter instanceof RuinedCar)
                {
                    validObstacle = false;
                }
            }
        }
        return validRoad && validObstacle;
    }

    private boolean checkSideway()
    {
        boolean validRoad = false;
        boolean validObstacle = true;
        if (walkingDirection.equals("left"))
        {
            ArrayList<Actor> leftEncounters = (ArrayList<Actor>)getObjectsAtOffset(-getImage().getWidth() / 2, getImage().getHeight() / 2 - 5, Actor.class);
            for (Actor leftEncounter : leftEncounters)
            {
                if (leftEncounter instanceof BasicRoad || leftEncounter instanceof Road)
                {
                    validRoad = true;
                }
                
                if (leftEncounter instanceof WorldBorder || leftEncounter instanceof RuinedCar)
                {
                    validObstacle = false;
                }
            }
        }
        else
        {
            ArrayList<Actor> rightEncounters = (ArrayList<Actor>)getObjectsAtOffset(getImage().getWidth() / 2, getImage().getHeight() / 2 - 5, Actor.class);
            for (Actor rightEncounter : rightEncounters)
            {
                if (rightEncounter instanceof BasicRoad || rightEncounter instanceof Road)
                {
                    validRoad = true;
                }
                
                if (rightEncounter instanceof WorldBorder || rightEncounter instanceof RuinedCar)
                {
                    validObstacle = false;
                }
            }
        }
        return validRoad && validObstacle;
    }

    private void movement(int x, int y)
    {
        this.setLocation(this.getX() + x, this.getY() + y);
    }
}

