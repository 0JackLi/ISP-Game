import greenfoot.*; 
import java.util.Random;
 // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
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
    Random random = new Random();
    PearlSky sky = new PearlSky();
    water Water = new water();
    Knife knife;
    GreenfootImage waterImage = Water.getImage();
    BasicRoad basicroad = new BasicRoad(); 
    VerticalBasicRoad vbasicroad = new VerticalBasicRoad();
    Tree tree = new Tree();
    Grass grass = new Grass();
    GreenfootImage grassImage = grass.getImage();
    RuinedCar rCar = new RuinedCar(); 
    FallenTree fTree = new FallenTree();
    Road road = new Road();
    night Night = new night();
    Moon moon = new Moon();
    Darkness dark = new Darkness();
    pink Pink = new pink();
    Red red = new Red();
    BrokenHouse house = new BrokenHouse();
    Bush bush = new Bush();
    SignPost sign = new SignPost();
    Kirsten kirsten;
    August august;
    Saydi saydi; 
    Dieter dieter;
    MusicNote note = new MusicNote();
    SEComic sEComic = new SEComic();
    Sign sign2 = new Sign();
    public int score = 0;
    Label scoreLabel = new Label("Score: " + score, 40);
    Label secLabel = new Label("Time: " + 30, 20);
    Label endLabel = new Label("Time: 300", 25);
    SimpleTimer noteSpawnTime = new SimpleTimer();
    SimpleTimer strengthTimer = new SimpleTimer();
    SimpleTimer gameTime = new SimpleTimer();
    SimpleTimer delay = new SimpleTimer();
    public static final int WORLD_WIDTH = 600;
    public static final int WORLD_HEIGHT = 400;
    Prophet prophet;
    CrossBower crossbower;
    Archer archer; 
    int sec = 30;
    int gameSec = 300;
    boolean actStrength = false;
    public int playerHealth = 4;
    public int enemyHealth = 3;
    Indicator indi = new Indicator();
    GreenfootImage indiIm = indi.getImage();
    GreenfootSound sound; 
    boolean isT = true, isF = true;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, true); 
        addObject(note, 0, 0);
        prepareWater();
        prepareFirstWorld();
        setBackground(grassImage);
        prepareCharacter();
        addObject(scoreLabel, 350, 37);
        addObject(endLabel, 50, 50);
        sound = new GreenfootSound("sounds/level1.mp3");
        sound.play();
    }
    public void act()
    {
        
        if(enemyHealth <= 2 && isT)
        {
            score = 0;
            sound.stop();
            removeObjects(getObjects(Actor.class));
            prepareSecondWorld();
            prepareCharacter2(2); 
            isT = false;
            actStrength = false;
            addObject(scoreLabel, 350, 37);
            addObject(endLabel, 50, 50);
            sound = new GreenfootSound("sounds/level2.mp3");
            sound.play();
            sec = 30;
        }
        else if(enemyHealth <= 1 && isF)
        {
            score = 0;
            sound.stop();
            removeObjects(getObjects(Actor.class));
            prepareFinalWorld();
            prepareCharacter2(3);
            isF = false;
            actStrength = false;
            addObject(scoreLabel, 350, 37);
            addObject(endLabel, 50, 50);
            sound = new GreenfootSound("sounds/level3.mp3");
            sound.play();
            sec = 30;
        }
        checkGameEnd();
        scoreLabel.setValue("Score: " + score + "/1000");
        spawnSomeNotes();
        checkScore();
        checkOnClick();
        gameCountDown();
        if(actStrength)
        {
            strengthBar();
        }
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
            spawnNote();
            noteSpawnTime.mark();
        }
    }
    private void gameCountDown()
    {
        if(gameTime.millisElapsed() >= 1000)
        {
            gameSec--;
            endLabel.setValue("Time: " + gameSec);
            gameTime.mark();
        }
    }
    private void checkScore()
    {
        if(score >= 1000)
        {
            sEComic.setImage(new GreenfootImage("SEcomic.jpg"));
        }
        else
        {
            sEComic.setImage(new GreenfootImage("SEBComic.png"));
        }
    }
    private void checkOnClick()
    {
        if(Greenfoot.mouseClicked(sEComic) && score >= 1000)
        {
            removeObject(sEComic);
            removeObject(scoreLabel);
            red = new Red();
            addObject(red, 450, 50);
            addObject(secLabel, 450, 50);
            actStrength = true;
            kirsten.num = 2;
            score = 0;
            GreenfootSound so = new GreenfootSound("sounds/Hypercharge.mp3");
            so.play();
        }
    }
    public void spawnNote()
    {
        for(int i = 0; i < 2; i++)
        {
            note = new MusicNote();
            int k = random.nextInt(200);
            addObject(note,  15, 100 + k);
        }
        for(int i = 0; i < 2; i++)
        {
            note = new MusicNote();
            int k = random.nextInt(200);
            addObject(note,  435, 100 + k);
        }
        for(int i = 0; i < 1; i++)
        {
            note = new MusicNote();
            int k = random.nextInt(300);
            addObject(note,  0 + k, 80);
        }
    }
    
    private void prepareFirstWorld()
    {
        
        addObject(basicroad, 59, 88);
        addObject(vbasicroad, 14, 104);
        addObject(tree, 10, 200);
        addObject(house, 60, 130);
        vbasicroad.constructRoad(14,104, 5, 0);
        vbasicroad.constructRoad(14, 280, 1, 0);
        house.constructHouse(60, 130, 3, 0);
        //the road with the first ruined car
        basicroad.constructRoad(-29, 160, 4, 0);
        addObject(rCar, 60, 160);
        house.constructHouse(0, 180, 3, 0);
        tree.constructTree(10, 200, 7, 0);
        //the road with the second ruined car
        vbasicroad.constructRoad(163, 191, 1, 0);
        vbasicroad.constructRoad(163, 220, 1, 0);
        basicroad.constructRoad(-29, 295, 3, 0);
        rCar.addRuinedCar(60, 295);
        //the furtherest road on the left
        //the middle long road
        vbasicroad.constructRoad(283, 44, 6, 0);
        basicroad.constructRoad(-32, 235, 5, 0);
        tree.constructTree(10, 250, 3, 0);
        house.constructHouse(165, 260, 1, 0);
        basicroad.constructRoad(-29, 385, 6, 0);
        basicroad.constructRoad(142, 295, 2, 0);
        basicroad.constructRoad(112, 295, 1, 0);
        vbasicroad.constructRoad(432, 45, 6, 0);
        basicroad.constructRoad(268, 385, 3, 0);
        basicroad.constructRoad(417, 385, 3, 0);
        basicroad.constructRoad(239, 88, 1, 0);
        basicroad.constructRoad(239, 160, 6, 0);
        tree.constructTree(10, 325, 7, 0);
        house.constructHouse(0, 350, 4, 0);
        house.constructHouse(268, 180, 2, 0);
        house.constructHouse(268, 220, 2, 0);
        house.constructHouse(268, 260, 2, 0);
        house.constructHouse(268, 300, 2, 0);
        house.constructHouse(268, 340, 2, 0);
        house.constructHouse(420, 180, 3, 0);
        house.constructHouse(420, 220, 3, 0);
        house.constructHouse(420, 260, 3, 0);
        house.constructHouse(420, 300, 3, 0);
        house.constructHouse(420, 340, 3, 0);
        house.constructHouse(268, 128, 2, 0);
        house.constructHouse(420, 128, 3, 0);
        basicroad.constructRoad(-29, 88, 10, 0);
        prepare();
        addObject(sEComic,510,37);
        addBorder();
    }
    
    private void prepareSecondWorld()
    {
        addObject(Night, 300, -300);
        addObject(basicroad, 59, 88);
        addObject(vbasicroad, 14, 104);
        addObject(tree, 10, 200);
        vbasicroad.constructRoad(14,104, 5, 1);
        vbasicroad.constructRoad(14, 280, 1, 1);
        tree.constructTree(30, 130, 6, 0);
        tree.constructTree(10, 130, 7, 0);
        //the road with the first ruined car
        basicroad.constructRoad(-29, 160, 4, 1);
        addObject(fTree, 50, 160);
        tree.constructTree(68, 180, 3, 0);
        tree.constructTree(10, 200, 7, 0);
        tree.constructTree(25, 200, 6, 0);
        //the road with the second ruined car
        vbasicroad.constructRoad(163, 191, 1, 1);
        vbasicroad.constructRoad(163, 220, 1, 1);
        basicroad.constructRoad(-29, 295, 3, 1);
        fTree.addFallenTree(50, 295);
        //the furtherest road on the left
        //the middle long road
        vbasicroad.constructRoad(283, 44, 6, 1);
        basicroad.constructRoad(-32, 235, 5, 1);
        tree.constructTree(10, 250, 3, 0);
        tree.constructTree(15, 260, 3, 0);
        tree.constructTree(175, 250, 1, 0);
        tree.constructTree(165, 260, 2, 0);
        basicroad.constructRoad(-29, 385, 6, 1);
        basicroad.constructRoad(142, 295, 2, 1);
        basicroad.constructRoad(112, 295, 1, 1);
        vbasicroad.constructRoad(432, 45, 6, 1);
        basicroad.constructRoad(268, 385, 3, 1);
        basicroad.constructRoad(417, 385, 3, 1);
        basicroad.constructRoad(239, 88, 1, 1);
        basicroad.constructRoad(239, 160, 6, 1);
        tree.constructTree(10, 325, 7, 0);
        tree.constructTree(10, 335, 7, 0);
        tree.constructTree(0, 350, 7, 0);
        tree.constructTree(10, 350, 7, 0);
        tree.constructTree(268, 170, 4, 0);
        tree.constructTree(268, 180, 4, 0);
        tree.constructTree(268, 190, 4, 0);
        tree.constructTree(268, 200, 4, 0);
        tree.constructTree(268, 210, 4, 0);
        tree.constructTree(268, 220, 4, 0);
        tree.constructTree(268, 230, 4, 0);
        tree.constructTree(268, 240, 4, 0);
        tree.constructTree(268, 250, 4, 0);
        tree.constructTree(268, 260, 4, 0);
        tree.constructTree(268, 270, 4, 0);
        tree.constructTree(268, 280, 4, 0);
        tree.constructTree(268, 290, 4, 0);
        tree.constructTree(268, 300, 4, 0);
        tree.constructTree(268, 310, 4, 0);
        tree.constructTree(268, 320, 4, 0);
        tree.constructTree(268, 330, 4, 0);
        tree.constructTree(268, 340, 4, 0);
        tree.constructTree(268, 350, 4, 0);
        tree.constructTree(420, 180, 5, 0);
        tree.constructTree(420, 190, 5, 0);
        tree.constructTree(420, 200, 5, 0);
        tree.constructTree(420, 210, 5, 0);
        tree.constructTree(420, 220, 5, 0);
        tree.constructTree(420, 230, 5, 0);
        tree.constructTree(420, 240, 5, 0);
        tree.constructTree(420, 250, 5, 0);
        tree.constructTree(420, 260, 5, 0);
        tree.constructTree(420, 270, 5, 0);
        tree.constructTree(420, 280, 5, 0);
        tree.constructTree(420, 290, 5, 0);
        tree.constructTree(420, 300, 5, 0);
        tree.constructTree(420, 310, 5, 0);
        tree.constructTree(420, 320, 5, 0);
        tree.constructTree(420, 330, 5, 0);
        tree.constructTree(420, 340, 5, 0);
        tree.constructTree(420, 350, 5, 0);
        tree.constructTree(268, 128, 4, 0);
        tree.constructTree(280, 128, 3, 0);
        tree.constructTree(440, 125, 4, 0);
        tree.constructTree(420, 128, 5, 0);
        basicroad.constructRoad(-29, 88, 10, 1);
        Pprepare();
        addObject(dark, 100, 100);
        addObject(moon, 50, 35);
        addObject(sEComic,510,37);
        addBorder();
    }
    
    private void prepareFinalWorld()
    {
        addObject(bush, 0, 0);
        addObject(sign, 0, 0);
        addObject(sky, 300, -10);
        house.setImage("redBrickBuilding.png");
        addObject(basicroad, 59, 88);
        addObject(vbasicroad, 14, 104);
        addObject(tree, 10, 200);
        addObject(house, 60, 130);
        vbasicroad.constructRoad(14,104, 5, 0);
        vbasicroad.constructRoad(14, 280, 1, 0);
        house.constructHouse(60, 130, 3, 1);
        //the road with the first ruined car
        basicroad.constructRoad(-29, 160, 4, 0);
        addObject(rCar, 60, 160);
        house.constructHouse(0, 180, 3, 1);
        tree.constructTree(10, 200, 6, 1);
        //the road with the second ruined car
        vbasicroad.constructRoad(163, 191, 1, 0);
        vbasicroad.constructRoad(163, 220, 1, 0);
        basicroad.constructRoad(-29, 295, 3, 0);
        rCar.addRuinedCar(60, 295);
        //the furtherest road on the left
        //the middle long road
        vbasicroad.constructRoad(283, 44, 6, 0);
        basicroad.constructRoad(-32, 235, 5, 0);
        tree.constructTree(10, 250, 3, 1);
        house.constructHouse(165, 260, 1, 1);
        basicroad.constructRoad(-29, 385, 6, 0);
        basicroad.constructRoad(142, 295, 2, 0);
        basicroad.constructRoad(112, 295, 1, 0);
        vbasicroad.constructRoad(432, 45, 6, 0);
        basicroad.constructRoad(268, 385, 3, 0);
        basicroad.constructRoad(417, 385, 3, 0);
        basicroad.constructRoad(239, 88, 1, 0);
        basicroad.constructRoad(239, 160, 6, 0);
        tree.constructTree(10, 325, 7, 1);
        tree.constructTree(0, 350, 7, 1);
        tree.constructTree(268, 180, 3, 1);
        house.constructHouse(268, 220, 2, 1);
        house.constructHouse(268, 260, 2, 1);
        tree.constructTree(268, 300, 4, 1);
        tree.constructTree(268, 340, 4, 1);
        bush.constructBush(440, 180, 4);
        tree.constructTree(440, 220, 5, 1);
        tree.constructTree(440, 260, 5, 1);
        tree.constructTree(440, 300, 5, 1);
        tree.constructTree(440, 340, 5, 1);
        tree.constructTree(268, 128, 4, 1);
        basicroad.constructRoad(-29, 88, 10, 0);
        bush.constructBush(25, 100, 6);
        bush.constructBush(440, 118, 4);
        bush.constructBush(440, 128, 4);
        Aprepare();
        sign.addSignPost(285, 215);
        addObject(sign2, 405, 160);
        addObject(Pink, 250, 250);
        addObject(sEComic,510,37);
        addBorder();
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
        prophet = new Prophet(1, 600);
        crossbower = new CrossBower();
        archer = new Archer();
        addObject(dieter, 93, 376);
        addObject(saydi, 110, 376);
        addObject(august, 127, 376);
        addObject(kirsten,147,376);
        addObject(archer, 10, 80);
        addObject(crossbower, 30, 80);
        addObject(prophet, 50, 80);
    }
    private void prepareCharacter2(int s)
    {
        if(playerHealth == 4)
        {
            kirsten = new Kirsten();
            august = new August();
            saydi = new Saydi();
            dieter = new Dieter();
            addObject(dieter, 93, 376);
            addObject(saydi, 110, 376);
            addObject(august, 127, 376);
            addObject(kirsten,147,376);
        }
        else if(playerHealth == 3)
        {
            kirsten = new Kirsten();
            august = new August();
            saydi = new Saydi();
            addObject(saydi, 110, 376);
            addObject(august, 127, 376);
            addObject(kirsten,147,376);
        }
        else if(playerHealth == 2)
        {
            kirsten = new Kirsten();
            august = new August();
            addObject(august, 127, 376);
            addObject(kirsten,147,376);
        }
        else
        {
            kirsten = new Kirsten();
            addObject(kirsten, 147, 376);
        }
        if(enemyHealth == 3)
        {
            prophet = new Prophet(s, 600);
            crossbower = new CrossBower();
            archer = new Archer();
            addObject(archer, 10, 80);
            addObject(crossbower, 30, 80);
            addObject(prophet, 50, 80);
        }
        else if(enemyHealth == 2)
        {
            prophet = new Prophet(s, 300);
            crossbower = new CrossBower();
            addObject(crossbower, 30, 80);
            addObject(prophet, 50, 80);
        }
        else
        {
            prophet = new Prophet(s, 300);
            addObject(prophet, 50, 80);
        }
    }
    private void strengthBar()
    {
        if(strengthTimer.millisElapsed() >= 1000)
        {
            GreenfootImage img = red.getImage();
            img.scale(img.getWidth() - 2, img.getHeight());
            red.setImage(img);
            strengthTimer.mark();
            sec--;
            secLabel.setValue(sec);
            addObject(indi, 0, 0);
        }
        if(kirsten.canIndi)
        {
            indiIm.setTransparency(255);
        }
        else
        {
            indiIm.setTransparency(0);
        }
        if(sec <= 0)
        {
            actStrength = false;
            removeObject(red);
            removeObject(secLabel);
            removeObject(indi); 
            sec = 30;
            kirsten.num = 1;
            addObject(sEComic, 510, 37);
            addObject(scoreLabel, 350, 37);
        }
        kirsten.powerUp();
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
    }
    private void Pprepare()
    {
        PRoad road = new PRoad();
        addObject(road,387,385);
        PRoad road2 = new PRoad();
        addObject(road2,240,160);
        PRoad road3 = new PRoad();
        addObject(road3,57,385);
        PRoad road4 = new PRoad();
        addObject(road4,525,88);
    }
    private void Aprepare()
    {
        ARoad road = new ARoad();
        addObject(road,387,385);
        ARoad road2 = new ARoad();
        addObject(road2,240,160);
        ARoad road3 = new ARoad();
        addObject(road3,57,385);
        ARoad road4 = new ARoad();
        addObject(road4,525,88);
    }
    
    public void addScore(int amount)
    {
        if(!actStrength)
        {
            score += amount;
        }
        if(score >= 1000)
        {
            score = 1000;
        }
    }

    private void addBorder()
    {
        addObject(new BlockBorder(240, 43), 149, 124);
        addObject(new BlockBorder(240, 46), 149, 198);
        addObject(new BlockBorder(120, 31), 89, 265);
        addObject(new BlockBorder(91, 31), 223, 265);
        addObject(new BlockBorder(240, 61), 149, 340);
        addObject(new BlockBorder(120, 43), 358, 124);
        addObject(new BlockBorder(120, 196), 358, 273);
        addObject(new BlockBorder(getWidth() - 447, 43), (getWidth() - 447) / 2 + 447, 124);
        addObject(new BlockBorder(getWidth() - 447, 196), (getWidth() - 447) / 2 + 447, 273);
        for (int i = 0; i < 2; i++)
        {
            addObject(new HorizontalBorder(getWidth()), getWidth() / 2, (i % 2 == 0) ? 73 : getHeight());
            addObject(new VerticalBorder(getHeight()), i * getWidth() , getHeight() / 2); 
        }
    }
    private void checkGameEnd()
    {
        if(enemyHealth <= 0)
        {
            sound.stop();
            Greenfoot.setWorld(new WinningEndScreen("winner", gameSec));
        }
        else if(playerHealth <= 0 || gameSec <= 0)
        {
            sound.stop();
            Greenfoot.setWorld(new WinningEndScreen("loser", gameSec/2));
        }
    }
}
