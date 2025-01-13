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
    Tree tree = new Tree();
    Grass grass = new Grass();
    GreenfootImage grassImage = grass.getImage();
    RuinedCar rCar = new RuinedCar(); 
    Road road = new Road();
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepareWater();
        prepareFirstWorld();
        setBackground(grassImage);
        prepareCharacter(); 
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
        addObject(tree, 45, 130);
        basicroad.constructRoad(59, 88, 3);
        vbasicroad.constructRoad(14,104, 5);
        tree.constructTree(10, 100, 7);
        //the road with the first ruined car
        basicroad.constructRoad(-1, 160, 4);
        addObject(rCar, 50, 160);
        tree.constructTree(10, 200, 7);
        basicroad.constructRoad(-1, 235, 4);
        tree.constructTree(10, 250, 3);
        //the road with the second ruined car
        basicroad.constructRoad(-1, 295, 2);
        basicroad.constructRoad(148, 295, 1);
        vbasicroad.constructRoad(163, 220, 1);
        rCar.addRuinedCar(50, 295);
        //the furtherest road on the left
        tree.constructTree(10, 325, 7);
        basicroad.constructRoad(-1, 385, 4);
        //the middle long road
        vbasicroad.constructRoad(283, 44, 6);
            addObject(road, 256, 295);
            road = new Road();
            addObject(road, 268, 385);
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepareCharacter()
    {
        Kirsten kirsten = new Kirsten();
        addObject(kirsten,147,376);
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
}
