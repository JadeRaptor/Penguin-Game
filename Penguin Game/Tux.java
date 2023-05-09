import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * @author (Jacob Richard) 
 * @version (Spring, 2023)
 * 
 * 
 * 
 * movement created for tux here
 * along with give tux the ability to acquire objects from the world, weither good or bad
 * to win or lose the game for tux
 * 
 */

//create subclass Tux of the Actor class
public class Tux extends Actor{
    
    //declaring variable utilized for movement
    private static final int step = 1;
    
    //declaring variables
    private int balloonsPopped = 0;
    private int fishesCaught = 0;
    
    //set image for tux
    private GreenfootImage tux;
    public  Tux(){
        tux = new GreenfootImage("tux.png");
        setImage(tux);
    }
    
    
    //organizing all the heights and width required for the game
        //for balloons
    private int balloonsScoreboardWidth = 100;
    private int balloonsScoreboardHeight = 25;
        //for scoreboard
    private int fishScoreboardWidth = 600;
    private int fishScoreboardHeight = 25;
        //for you won
    private int youWonWidth = 350;
    private int youWonHeight = 250;
        //for gameover
    private int gameoverWidth = 350;
    private int gameoverHeight = 250;
    
    private boolean hasBoomerang = false;
    private boolean canMove = true;
    private int lastDirection = 0;

    
    //invoke the act method
    public void act(){
        
        //new additon to checking for move is true
        if (canMove) {
            checkKeyPress();
            lookOut();

    }
    
    }
    /*
     *method created to provide Tux with movement
     */
    private void checkKeyPress() {
        // movement in the up direction
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY() - step);
            lastDirection = 270;
        }
        // movement in the down direction
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY() + step);
            lastDirection = 90;
        }
        // movement in the left direction
        if (Greenfoot.isKeyDown("left")) {
            setLocation(getX() - step, getY());
            lastDirection = 180;
        }
        // movement in the right direction
        if (Greenfoot.isKeyDown("right")) {
            setLocation(getX() + step, getY());
            lastDirection = 0;
        }
        
    }

    /*
     * checks for collisons with balloons, fish, randombomb, and boomerang objects
     * removes the object updates score for fish and balloons.
     * adds the new boomerang powerup to the world
     */
    private void lookOut(){
        //actions if balloon touched
        if(isTouching(Balloon.class)){
            //remove balloon touched
            removeTouching(Balloon.class);
            //play created pop(personilized) sound for popping balloons
            Greenfoot.playSound("pop.wav");
            //increasing the counter for balloons
            balloonsPopped++;
            //display balloons popped
            getWorld().showText("Balloons Popped: " + balloonsPopped, balloonsScoreboardWidth, balloonsScoreboardHeight);
            //number of balloons needed to win
            int toWin = 50;
            //actions once enough balloons popped to win
            if(balloonsPopped == toWin){
                //play fanare sound
                Greenfoot.playSound("fanfare.wav");
                //display You won!
                getWorld().showText("You won!", youWonWidth, youWonHeight);
                //stop Greenfoot
                Greenfoot.stop();
                
            }
        //actions if fish touched
        } else if (isTouching(Fish.class)){
            //remove fish touched
            removeTouching(Fish.class);
            //play created pop(personilized) sound for catching fish
            Greenfoot.playSound("pop.wav");
            //increasing the counter for fish
            fishesCaught++;
            //display fish caught
            getWorld().showText("Fish Caught: " + fishesCaught, fishScoreboardWidth, fishScoreboardHeight);
            //number of fish needed to win
            int toWin = 15;
            //actions once enough fish caught to win
            if(fishesCaught == toWin){
                //play fanfare sound
                Greenfoot.playSound("fanfare.wav");
                //display You won!
                getWorld().showText("You won!", youWonWidth, youWonHeight);
                //stop Greenfoot
                Greenfoot.stop();
            }
        //actions if randombomb touched
        } else if (isTouching(RandomBomb.class)){
            //remove bomb touched
            removeTouching(RandomBomb.class);
            //play au(ouch) sound
            Greenfoot.playSound("au.wav");
            //display Game over, sorry.
            getWorld().showText("Game over, so sorry.", gameoverWidth, gameoverHeight);
            //stop Greenfoot
            Greenfoot.stop();
        //actions if boomerang is touched
        } else if (isTouching(Boomerang.class) && !hasBoomerang) {
        hasBoomerang = true;
        MyWorld world = (MyWorld)getWorld();
        world.addBoomerang();
    }

    }
    
    /*
     * The state of whether tux has the boomerang or not.
     * @return hasBoomerang (false or true).
     */
    public boolean hasBoomerang() {
        return hasBoomerang;
    }
    /*
     * @return lastdirection tux was facing
     */
    public int getDirection() {
        return lastDirection;
    }
    /*
     * @return canMove (true if tux can move).
     */
    public void allowMovement() {
        canMove = true;
    }
    /*
     * @return canMove (false if tux cannot move).
     */
    public void disallowMovement() {
        canMove = false;
    }
    /*
     * @param value if tux has the boomerang or not.
     */
    public void setHasBoomerang(boolean value) {
        hasBoomerang = value;
    }


}
