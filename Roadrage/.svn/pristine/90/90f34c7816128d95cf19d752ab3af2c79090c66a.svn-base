/*
 * Assignment 3 - roadrage
 * TCSS 305 - Fall 2016
*/
package model;


import java.util.Map;

/**
 * Car vehicle class for use in the road rage simulator.
 * @author jamesm47
 * @version 10/29/18
 */
public class Car extends AbstractVehicle implements Vehicle {
    
    /*** Amount of steps the car will remain dead if it dies in a collision.*/
    private static final int DEATH_TIME = 15;
    /**
     * Constructor for the Car class.
     * @param theX sets the x coordinate.
     * @param theY sets the y coordinate.
     * @param theDir sets the starting direction.
     */    
    public Car(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, DEATH_TIME);
    }

    @Override
    /**
     * canPass is a method for determining is the car can continue to move
     * in the direction it is facing.
     * @param theTerrain is the terrain the car is facing.
     * @param theLight is the condition of the light that the car is facing.
     * @return is whether or not the car my pass.
     */
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return theTerrain == Terrain.STREET
                        || (theTerrain == Terrain.LIGHT && (theLight != Light.RED))
                        || (theTerrain == Terrain.CROSSWALK 
                        && (theLight != Light.RED || theLight != Light.YELLOW));
    }

    /**
     * chooseDirection is a method for determining the direction the car
     * will travel. 
     * @param theNeighbors is a map of the surrounding terrain.
     * @return the chosen direction.
     */    
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        if (theNeighbors.get(super.myDirection) == Terrain.STREET 
            || theNeighbors.get(super.myDirection) == Terrain.LIGHT 
            || theNeighbors.get(super.myDirection) == Terrain.CROSSWALK) {
            return myDirection;
        } else {
            return chooseLeftRight(theNeighbors);
        }

    }
  



    @Override
    /**
     * Collide handles the results of a car colliding with another vehicle.
     * @param theOther is the 2nd vehicle.
     */
    public void collide(final Vehicle theOther) {
        super.collide(theOther);

    }

    @Override
    /**
     * getDeathTime returns the number of steps the car stays dead.
     * @return the death time.
     */
    public int getDeathTime() {
        return DEATH_TIME;
    }


    @Override
    /**
     * getDirection returns the direction the car is currently facing.
     * @return the direction.
     */
    public Direction getDirection() {
        return super.myDirection;
    }

    @Override
    public int getX() {
        return super.myX;
    }

    @Override
    public int getY() {
        return super.myY;
    }

    @Override
    public boolean isAlive() {
        return super.myLifeState;
    }

    @Override
    public void poke() {
        super.poke();

    }

    @Override
    public void reset() {
        super.reset();

    }

    @Override
    public void setDirection(final Direction theDir) {
        super.myDirection = theDir;

    }

    @Override
    public void setX(final int theX) {
        super.myX = theX;

    }

    @Override
    public void setY(final int theY) {
        super.myY = theY;

    }

}
