import greenfoot.*;
import java.util.List;
/**
 * 
 * @author (Jacob Richard) 
 * @version (Spring, 2023)
 * 
 * 
 * 
 * boomerang attributes implemented for world
 * boomerang helps tux collect fish and balloons but not bombs

 * 
 */

//create subclass boomerang of the Actor class
public class Boomerang extends Actor {
    
    
    private Tux tux;
    private boolean isFlying = false;
    private int direction = 0;
    private int movementCounter = 0;
    private int range = 400;
    boolean hasRotated = false;
    
    //set image for boomerang
    private GreenfootImage boomerang;
    public  Boomerang(){
        boomerang = new GreenfootImage("boomerang.png");
        setImage(boomerang);
    }
    /*
     * sets the tux reference to the world when boomerang added
     * @param world world to which the boomerang objects is added to
     */
    public void addedToWorld(World world) {
        tux = getWorld().getObjects(Tux.class).get(0);
    }
    
    
    
    /*
     * if to carry out boomerang functions
     * else for movement and next condition of boomerang being thrown
     */
    
    public void act() {
        if (tux.hasBoomerang()) {
            if (isFlying) {
                throwBoomerang();
                grabObjects();
            } else {
                moveWithTux();
                checkKeyPress();
            }
        }
    }
    
    
    /*
     * throws the boomerang and returns it to tux
     * will boomerang is thrown tux cannot move until it returns
     */
    private void throwBoomerang() {
        //moves the boomerang
        move(1);
        //keeps count of the boomerang flying through the air
        movementCounter++;
        //half the range to rotate the boomerang
        if (movementCounter >= range / 2) {
            if (!hasRotated) {
                setRotation(getRotation() + 180);
                hasRotated = true;
            }
            //reset the counter
            movementCounter = 0;
            
            //else if for if the boomerang hits the side of the world
        } else if (getX() <= 0 || getX() >= getWorld().getWidth() - 1 || 
        getY() <= 0 || getY() >= getWorld().getHeight() - 1) {
                setRotation(getRotation() + 180);
                hasRotated = true;
        }
        
        //stops boomerang if touching tux and has completed a boomerang rotation
        if (isTouching(Tux.class) && hasRotated) {
            isFlying = false;
            tux.allowMovement();
            movementCounter = 0;
            hasRotated = false;
        }
    }
    /*
     * allows the boomerang to acquire fish and balloons
     */

    private void grabObjects() {
        //gets objects that are intersecting with the boomerang
        List<Actor> grabbedObjects = getIntersectingObjects(null);
        //each object that is acquired
        for (Actor i : grabbedObjects) {
            //move balloon or fish along with boomerang
            if (i instanceof Balloon || i instanceof Fish) {
                i.setLocation(getX(), getY());
            }
        }
    }
    
    /*
     * move the boomerang along with tux
     */
    private void moveWithTux() {
        setLocation(tux.getX(), tux.getY());
        setRotation(tux.getDirection());

    }
    /*
     * spacebar utilized to throw the boomerang
     */
    private void checkKeyPress() {
        if (Greenfoot.isKeyDown("space") && !isFlying) {
            isFlying = true;
            tux.disallowMovement();
            movementCounter = 0;
        }
    }
}
