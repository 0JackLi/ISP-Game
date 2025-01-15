import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Prophet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Prophet extends Enemy
{
    /**
     * Act - do whatever the Prophet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */    
    private boolean checkSideway;
    private int randomAct, reloadAct;
    private static int maxSpeed;
    private VerticalDetection upwardDetection, downwardDetection;
    private HorizontalDetection leftwardDetection, rightwardDetection;
    public String walkingDirection; 
    GreenfootImage[] image = new GreenfootImage[6];
    GreenfootImage[] invertedImage = new GreenfootImage[6];
    SimpleTimer timer = new SimpleTimer();
    int k = 0;
    int speedX = 0, speedY = 0;
    boolean keepLeft = false;
    public Prophet(int maxSpeed, int time)
    {
        randomAct = 0;
        reloadAct = time; // 60 acts / second, 600 acts in maxSpeed0 seconds
        for(int i = 0; i < 6; i++)
        {
            image[i] = new GreenfootImage("prophet" + i + ".png");
            invertedImage[i] = new GreenfootImage("prophet" + i + ".png");
            invertedImage[i].mirrorHorizontally();
        }
        
        this.maxSpeed = maxSpeed;
        
        upwardDetection = new VerticalDetection(this, -maxSpeed);
        downwardDetection = new VerticalDetection(this, maxSpeed);
        leftwardDetection = new HorizontalDetection(this, -maxSpeed);
        rightwardDetection = new HorizontalDetection(this, maxSpeed);
    }
    
    public void addedToWorld(World world)
    {
        world.addObject(upwardDetection, 0, 0);
        world.addObject(downwardDetection, 0, 0);
        world.addObject(leftwardDetection,0, 0);
        world.addObject(rightwardDetection, 0, 0);
    }
    
    public void act()
    {
        // Add your action code here.
        //checkPlayer(((MyWorld) getWorld()).kirsten);
        if (rightwardDetection.hasSpotted() || leftwardDetection.hasSpotted() || downwardDetection.hasSpotted() || upwardDetection.hasSpotted()){
            chasePlayer();
            if (reloadAct == 0)
                shootBullet();
        }
        else
            randomMovement();
        
        directionMovement();
        reloadAct = (reloadAct == 0) ? reloadAct : reloadAct - maxSpeed;
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
            if (!checkSideway()){
                speedX = 0;
            }
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
        if(walkingDirection.equals("up"))
        {
            for (int i = 0; i < 3; i++)
            {
                ArrayList<Actor> upEncounters = (ArrayList<Actor>)getObjectsAtOffset(i * 5 - 5, 0, Actor.class);
                for (Actor upEncounter : upEncounters)
                {
                    if (upEncounter instanceof WorldBorder || upEncounter instanceof RuinedCar)
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
                    if (downEncounter instanceof WorldBorder || downEncounter instanceof RuinedCar)
                    {
                        return false;
                    }
                }
            }

        }
        return true;
    }

    private boolean checkSideway()
    {
        if (walkingDirection.equals("left"))
        {
            for (int i = 0; i < 2; i++)
            {
                ArrayList<Actor> leftEncounters = (ArrayList<Actor>)getObjectsAtOffset(-getImage().getWidth() / 2, i * (getImage().getHeight() / 2) + 4, Actor.class);
                for (Actor leftEncounter : leftEncounters)
                {
                    if (leftEncounter instanceof WorldBorder || leftEncounter instanceof RuinedCar)
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
                    if (rightEncounter instanceof WorldBorder || rightEncounter instanceof RuinedCar)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private void rightWalkAni()
    {
        if(timer.millisElapsed() >= 100)
        {
            timer.mark();
            k = (k + maxSpeed) % 6; 
            this.setImage(image[k]);
        }
    }

    private void leftWalkAni()
    {
        if(timer.millisElapsed() >= 100)
        {
            timer.mark();
            k = (k + maxSpeed) % 6;
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
                keepLeft = false;
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
                keepLeft = true;
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
    
    private void chasePlayer()
    {
        speedX = 0;
        speedY = 0;
        if (rightwardDetection.hasSpotted())
        {
            walkingDirection = "right";
            keepLeft = false;
            checkSideway = true;
            speedX = maxSpeed;
        }
        else if (leftwardDetection.hasSpotted())
        {
            walkingDirection = "left";
            checkSideway = true;
            speedX = -maxSpeed;
            keepLeft = true;
        }
        
        if (upwardDetection.hasSpotted())
        {
            walkingDirection = "up";
            checkSideway = false;
            speedY = -maxSpeed;
        }
        else if (downwardDetection.hasSpotted())
        {
            walkingDirection = "down";
            checkSideway = false;
            speedY = maxSpeed;
        }
    }
    
    private void shootBullet()
    {
        getWorld().addObject(new Bullet((int)Math.signum(speedX), (int)Math.signum(speedY), maxSpeed + 1), getX() + (int)Math.signum(speedX) * getImage().getWidth() / 2, getY() + (int)Math.signum(speedY) * getImage().getHeight() / 2); 
        reloadAct = 600;
    }
    
    private void randomMovement()
    {
        if (randomAct <= 0)
        {
            randomAct = Greenfoot.getRandomNumber(120) + 40;
            if (Greenfoot.getRandomNumber(2) == 1)
            {
                checkSideway = true;
                if (Greenfoot.getRandomNumber(2) == 1)
                {
                    walkingDirection = "left";
                    keepLeft = true;
                    speedX = -maxSpeed;
                }
                else
                {
                    walkingDirection = "right";
                    keepLeft = false;
                    speedX = maxSpeed;
                }
                speedY = 0;
            }
            else
            {
                checkSideway = false;
                if (Greenfoot.getRandomNumber(2) == 1)
                {
                    walkingDirection = "up";
                    speedY = -maxSpeed;
                }
                else
                {
                    walkingDirection = "down";
                    speedY = maxSpeed;
                }
                speedX = 0;
            }
        }
        else
        {
            randomAct--;
        }
    }
}