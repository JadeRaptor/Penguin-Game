import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Jacob Richard) 
 * @version (Spring, 2023)
 * 
 * Fish class for game
 * 
 * 
 */

//create subclass Fish of the Actor class
public class Fish extends Actor
{
    //set image for fish
    private GreenfootImage fish;
    public  Fish(){
        fish = new GreenfootImage("fish3.png");
        setImage(fish);
    }
    
    
    //invoke act method
    public void act()
    {
        
    }
}
