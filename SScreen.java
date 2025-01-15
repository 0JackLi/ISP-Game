import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SScreen extends World
{

    /**
     * Constructor for objects of class SScreen.
     * 
     */
    Intro background = new Intro();
    GreenfootImage backImage = background.getImage();
    Label gameName;
    public SScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        gameName = new Label("Survival is insufficient", 60);
        backImage.scale(600, 400);
        setBackground(backImage);
        addObject(gameName, getWidth()/2, getHeight()/2);
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(null))
        {
            Greenfoot.setWorld(new MyWorld());
        }
    }
}
