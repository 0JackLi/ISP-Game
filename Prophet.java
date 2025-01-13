import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Prophet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Prophet extends Actor
{
    /**
     * Act - do whatever the Prophet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean checkSideway;
    private String walkingDirection= "right"; 
    GreenfootImage[] image = new GreenfootImage[6];
    GreenfootImage[] invertedImage = new GreenfootImage[6];
    SimpleTimer timer = new SimpleTimer();
    int k = 0;
    int speedX = 0, speedY = 0;
    boolean keepLeft = false;
    public Prophet(int x, int y)
    {
        checkSideway = true;
        for(int i = 0; i < 6; i++)
        {
            image[i] = new GreenfootImage("Kirsten" + i + ".png");
            invertedImage[i] = new GreenfootImage("Kirsten" + i + ".png");
            invertedImage[i].mirrorHorizontally();
            speedX = x;
            speedY = y;
        }
    }
    public void act()
    {
        // Add your action code here.
        checkPlayer(((MyWorld) getWorld()).kirsten);
    }
    private void directionMovement()
    {
        if(keepLeft)
        {
            leftWalkAni();
        }
        else
        {
            rightWalkAni();
        }

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
    private void movement(int x, int y)
    {
        this.setLocation(this.getX() + x, this.getY() + y);
    }
    private void checkPlayer(Actor actor)
    {
        if(this.getX() != actor.getX() && this.getY() != actor.getY())
        {
            if(this.getY() < actor.getY())
            {
                walkingDirection = "down";
                if(checkUpDown())
                {
                    movement(0, speedY);
                }
            }
            else if(this.getY() > actor.getY())
            {
                walkingDirection = "up";
                if(checkUpDown())
                {
                    movement(0, -speedY);
                }

            }
            if(this.getX() < actor.getX())
            {
                walkingDirection = "right";
                if(checkSideway())
                {
                    movement(speedX, 0);
                }
                else{
                    movement(-speedX, 0); 
                }
            }
            else
            {
                walkingDirection = "left";
                if(checkSideway())
                {
                    movement(-speedX, 0);
                }
                else{
                    movement(speedX, 0); 
                }
            }
        }
    }
}
