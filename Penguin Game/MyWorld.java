import greenfoot.*;  // import the greenfoot package with all its classes

/**
 * 
 * @author (Jacob Richard) 
 * @version (Spring, 2023)
 * 
 * designing a program to populate area with balloons, fish, bombs, and a tux the penguin
 * the object of the game is to catch 15 fish or pop 50 balloons
 * be careful not to blow up from the bombs
 * powerup boomerang added for project 2
 * 
 */


/*
 * create subclass MyWorld of the World class
 */
public class MyWorld extends World{
    
    //set constant variables for world dimensions
    private static final int WIDTH = 700;
    private static final int HEIGHT = 500;
    private static final int PIXEL = 1;
    
    //delcared variables for Tux's starting point
    private int tuxWidth = 650;
    private int tuxHeight = 450;
    
    //delcared variables for balloons
    private int balloonsToSpawn = 85;
    private int balloonsToPop = 50;
    
    //delcared variables for fish
    private int fishToSpawn = 20;
    private int fishToCatch = 15;
    
    //delcared variables for bombs
    private int bombsToSpawn = 15;
    
    //delcared variables for text placement
    private int textlineWidth = 350;
    private int textline1Height = 100;
    private int textline2Height = 150;
    private int textline3Height = 200;
    private int textline4Height = 250;
    private int textline5Height = 300;
    
    //set the initial spawn of game to false
    private boolean spawn = false;
    
    //declaring the boomerang
    private int boomerangCount = 0;
    
    //create MyWorld class
    public MyWorld(){    
        
        // Create a new world with 700x500 cells with a cell size of 1x1 pixels by utilizing the constant variables
        super(WIDTH, HEIGHT, PIXEL);
        
        //display the tutorial text on how to start the game
        showText("Use arrows to move the penguin Tux.",textlineWidth, textline1Height);
        showText("Catch " + fishToCatch + " fish or pop " + balloonsToPop + " blue ballons to win." , textlineWidth, textline2Height);
        showText("Touching a bomb ends the game.", textlineWidth, textline3Height);
        showText("Press space to throw the boomerang powerup once it's collected.", textlineWidth, textline4Height);
        
        
        //source for run button in Java reference: https://charbase.com/25b6-unicode-black-right-pointing-triangle
        showText("Press \u25B6 Run to start then s.", textlineWidth, textline5Height);
        
        
        
        
  
  
 
    }
   
    /*
     * spawn in the world by push the s-key, invoking the prepare method
     */
    public void act(){
        //user must hit s to populate area
        if(Greenfoot.isKeyDown("s") && spawn == false){
            //invoke the prepare method
            prepare();
            
            //spawn set to true to prevent user from spamming s
            spawn = true;
    }
    }
    
    /*
     * invoke prepare method
     */
    
    private void prepare(){
        
        //set background for game
        setBackground("bluerock.jpg");
        
        //add all objects to the game
        addTux();
        addBalloons(balloonsToSpawn);
        addFish(fishToSpawn);
        addRandomBomb(bombsToSpawn);
        addBoomerang();
        
        //clear out unnecessary text from initial screen
        showText("", textlineWidth, textline1Height);
        showText("", textlineWidth, textline2Height);
        showText("", textlineWidth, textline3Height);
        showText("", textlineWidth, textline4Height);
        showText("", textlineWidth, textline5Height);
        
        //move controls tooltip towards the bottom
        int movementHeight = 475;
        showText("Use arrows to move the penguin Tux.",textlineWidth, movementHeight);
        
        

    }
    /*
     * a method created to add Tux
     */
    public void addTux() {
        //new instance of the Tux class created
        Tux tux = new Tux();
        
        //add tux to the world
        addObject(tux, tuxWidth,tuxHeight);
    }
    /*
     * a method created to add balloons
     */
    public void addBalloons(int numBalloons) {
        //a for loop to iterate through all the balloons
        for (int i=0; i<numBalloons; i++) {
            //new instance of the Balloon class created
            Balloon balloon = new Balloon();
            
            //random locations set for balloons
            int balloonWidth = Greenfoot.getRandomNumber(getWidth());
            int ballonHeight = Greenfoot.getRandomNumber(getHeight());
            
            //balloons added
            addObject(balloon, balloonWidth,ballonHeight);
    }
    }
    /*
     * a method created to add fish
     */
    public void addFish(int numFish){
        //a for loop to iterate through all the fish
        for (int i=0; i<numFish; i++) {
            //new instance of the Fish class created
            Fish fish = new Fish();
            
            //random locations set for fish
            int fishWidth = Greenfoot.getRandomNumber(getWidth());
            int fishHeight = Greenfoot.getRandomNumber(getHeight());
            
            //fish added
            addObject(fish, fishWidth,fishHeight);
        }
    }
    
    /*
     * a method created to add bombs
     */
    public void addRandomBomb(int numBombs){
        //a for loop to iterate through all the bombs
        for (int i=0; i<numBombs; i++) {
            
            //new instance of the RandomBomb class created
            RandomBomb bomb = new RandomBomb();
            
            //random locations set for bombs
            //ensuring no bombs spawn on top of Tux the penguin
            int bombWidth = Greenfoot.getRandomNumber(getWidth()-100);
            int bombHeight = Greenfoot.getRandomNumber(getHeight()-100);
            
            //bombs added
            addObject(bomb, bombWidth, bombHeight);
    }
    }
    /*
     * method to add boomerang randomly on screen
     */
    public void addBoomerang(){
            Boomerang boomerang = new Boomerang();
        
            int boomerangWidth = Greenfoot.getRandomNumber(getWidth()-100);
            int boomerangHeight = Greenfoot.getRandomNumber(getHeight()-100);
            
            //bombs added
            addObject(boomerang, boomerangWidth, boomerangHeight);
    }

    




}


