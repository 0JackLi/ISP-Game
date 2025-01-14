import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SignPost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SignPost extends Actor
{
    /**
     * Act - do whatever the SignPost wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    World world; 
    SignPost post; 
    public void act()
    {
        // Add your action code here.
    }
    public void addSignPost(int x, int y)
    {
        world = getWorld();
        post = new SignPost();
        world.addObject(post, x, y);
    }
}
