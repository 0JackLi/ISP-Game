import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinningEndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinningEndScreen extends World
{

    /**
     * Constructor for objects of class WinningEndScreen.
     * 
     */
    GreenfootSound outro; 
    WinningEnd background = new WinningEnd();
    GreenfootImage backImage = background.getImage();
    Label gameOverDisplay;
    public WinningEndScreen(String k, int score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        if(k.equals("winner"))
        {
            gameOverDisplay = new Label("Winner", 90);
            outro = new GreenfootSound("sounds/winningoutro.mp3");
        }
        else
        {
            gameOverDisplay = new Label("You lose", 90);
            outro = new GreenfootSound("sounds/losingoutro.mp3");
        }
        Label highScoreLabel = new Label("Final Score: " + score, 40);
        backImage.scale(600, 400);
        setBackground(backImage);

        addObject(gameOverDisplay, getWidth()/2, getHeight()/2-20);
        addObject(highScoreLabel, 150, 30);
        outro.playLoop();
        
    }
}
