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
    BrokenHouse house = new BrokenHouse();
    Kirsten kirsten;
    August august;
    Saydi saydi; 
    Dieter dieter;
    MusicNote note = new MusicNote();
    SEComic sEComic = new SEComic();
    int score = 0;
    Label scoreLabel = new Label("Score: " + score, 40);
    SimpleTimer noteSpawnTime = new SimpleTimer();
    public static final int WORLD_WIDTH = 600;
    public static final int WORLD_HEIGHT = 400;
    Prophet prophet; 
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, true); 
        prepareWater();
        prepareFirstWorld();
        setBackground(grassImage);
        prepareCharacter(); 
        addObject(note, 0, 0);
        addObject(scoreLabel, 350, 37);
        
    }
    public void act()
    {
        scoreLabel.setValue("Score: " + score + "/1000");
        spawnSomeNotes();
        checkScore();
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
    
    private void spawnSomeNotes()
    {
        if(noteSpawnTime.millisElapsed() >= 5000)
        {
            note.spawnNote();
            noteSpawnTime.mark();
        }
    }
    
    private void checkScore()
    {
        if(score >= 1000)
        {
            sEComic.setImage(new GreenfootImage("SEcomic.jpg"));
        }
    }
    private void prepareFirstWorld()
    {
        addObject(basicroad, 59, 88);
        addObject(vbasicroad, 14, 104);
        addObject(tree, 10, 200);
        addObject(house, 60, 130);
        vbasicroad.constructRoad(14,104, 5);
        vbasicroad.constructRoad(14, 280, 1);
        house.constructHouse(60, 130, 3);
        //the road with the first ruined car
        basicroad.constructRoad(-29, 160, 4);
        addObject(rCar, 50, 160);
        house.constructHouse(0, 180, 3);
        tree.constructTree(10, 200, 7);
        //the road with the second ruined car
        vbasicroad.constructRoad(163, 191, 1);
        vbasicroad.constructRoad(163, 220, 1);
        basicroad.constructRoad(-29, 295, 3);
        rCar.addRuinedCar(50, 295);
        //the furtherest road on the left
        //the middle long road
        vbasicroad.constructRoad(283, 44, 6);
        basicroad.constructRoad(-32, 235, 5);
        tree.constructTree(10, 250, 3);
        house.constructHouse(165, 260, 1);
        basicroad.constructRoad(-29, 385, 6);
        basicroad.constructRoad(142, 295, 2);
        basicroad.constructRoad(112, 295, 1);
        vbasicroad.constructRoad(432, 45, 6);
        basicroad.constructRoad(268, 385, 3);
        basicroad.constructRoad(417, 385, 3);
        basicroad.constructRoad(239, 88, 1);
        basicroad.constructRoad(239, 160, 6);
        tree.constructTree(10, 325, 7);
        house.constructHouse(0, 350, 4);
        house.constructHouse(268, 180, 2);
        house.constructHouse(268, 220, 2);
        house.constructHouse(268, 260, 2);
        house.constructHouse(268, 300, 2);
        house.constructHouse(268, 340, 2);
        house.constructHouse(420, 180, 3);
        house.constructHouse(420, 220, 3);
        house.constructHouse(420, 260, 3);
        house.constructHouse(420, 300, 3);
        house.constructHouse(420, 340, 3);
        house.constructHouse(268, 128, 2);
        house.constructHouse(420, 128, 3);
        basicroad.constructRoad(-29, 88, 10);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepareCharacter()
    {
        kirsten = new Kirsten();
        august = new August();
        saydi = new Saydi();
        dieter = new Dieter();
        prophet = new Prophet(1, 1);
        addObject(dieter, 93, 376);
        addObject(saydi, 110, 376);
        addObject(august, 127, 376);
        addObject(kirsten,147,376);
        addObject(prophet, 50, 80);
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Road road = new Road();
        addObject(road,387,385);
        Road road2 = new Road();
        addObject(road2,240,160);
        Road road3 = new Road();
        addObject(road3,57,385);
        Road road4 = new Road();
        addObject(road4,525,88);
        addObject(sEComic,510,37);
    }
    
    public void addScore(int amount)
    {
        score += amount;
        if(score >= 1000)
        {
            score = 1000;
        }
    }
    private void addBorder()
    {
        for (int i = 0; i < 2; i++)
        {
            addObject(new HorizontalBorder(), getWidth() / 2, (i % 2 == 0) ? 73 : getHeight());
            addObject(new VerticalBorder(), i * getWidth() , getHeight() / 2); 
        }
    }
}
