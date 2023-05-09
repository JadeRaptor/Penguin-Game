import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Jacob Richard) 
 * @version (Spring, 2023)
 * 
 * Balloon class for game
 * 
 * 
 */

//create subclass Balloon of the Actor class
public class Balloon extends Actor
{
    //set image for balloon
    private GreenfootImage balloon;
    public  Balloon(){
        balloon = new GreenfootImage("balloon2.png");
        setImage(balloon);
    }
    
    
    
    
    
    //invoke act method
    public void act()
    {
        
    }
}
