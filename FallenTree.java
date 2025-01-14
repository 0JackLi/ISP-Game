import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FallenTree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FallenTree extends Actor
{
    /**
     * Act - do whatever the FallenTree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    World world; 
    FallenTree tree; 
    public void act()
    {
        // Add your action code here.
    }
    public void addFallenTree(int x, int y)
    {
        world = getWorld();
        tree = new FallenTree();
        world.addObject(tree, x, y);
    }
}
