import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    water Water = new water();
    GreenfootImage waterImage = Water.getImage();
    BasicRoad basicroad = new BasicRoad(); 
    VerticalBasicRoad vbasicroad = new VerticalBasicRoad();
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepareWater();
        prepareFirstWorld();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepareWater()
    {
        for(int i = 0; i < Math.round((double)getWidth()/waterImage.getWidth()); i++){
            addObject(Water,  50 + waterImage.getWidth() * i, 35);
            Water = new water();
        }
    }

    private void prepareFirstWorld()
    {
        addObject(basicroad, 59, 88);
        addObject(vbasicroad, 14, 104);
        basicroad.constructRoad(59, 88, 3);
        vbasicroad.constructRoad(14,104, 5);
        basicroad.constructRoad(-1, 385, 4);
        basicroad.constructRoad(-1, 235, 4);
    }
}
