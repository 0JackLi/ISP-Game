import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tree extends Actor
{
    /**
     * Act - do whatever the Tree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image = getImage();
    World world;
    Tree tree;
    public void act()
    {
        // Add your action code here.
    }
    public void constructTree(int x, int y, int amount)
    {
        world = getWorld();
        for(int i = 1; i <= amount; i++)
        {
            tree = new Tree();
            world.addObject(tree, x + (image.getWidth() - 25) * i, y);
        }
    }
}
