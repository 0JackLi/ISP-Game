import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

/**
 * Write a description of class MusicNote here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicNote extends Actor
{
    /**
     * Act - do whatever the MusicNote wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer timer = new SimpleTimer();
    Random random = new Random();
    MusicNote note;
    public MusicNote()
    {
    }
    public void act()
    {
        // Add your action code here.
        
    }
    public void spawnNote()
    {
        for(int i = 0; i < 2; i++)
        {
            note = new MusicNote();
            int k = random.nextInt(200);
            ((MyWorld) getWorld()).addObject(note,  15, 100 + k);
        }
        for(int i = 0; i < 2; i++)
        {
            note = new MusicNote();
            int k = random.nextInt(200);
            ((MyWorld) getWorld()).addObject(note,  435, 100 + k);
        }
        for(int i = 0; i < 1; i++)
        {
            note = new MusicNote();
            int k = random.nextInt(300);
            ((MyWorld) getWorld()).addObject(note,  0 + k, 80);
        }
    }
}
