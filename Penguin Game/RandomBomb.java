import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * @author (Jacob Richard) 
 * @version (Spring, 2023)
 * 
 * RandomBomb class for game
 * 
 * 
 */

//create subclass RandomBomb of the Actor class
public class RandomBomb extends Actor
{
    //set image for bomb
    private GreenfootImage bomb;
    public  RandomBomb(){
        bomb = new GreenfootImage("bomb.png");
        setImage(bomb);
    }
    
    
    //invoke act method
    public void act()
    {
        
    }
}
