/*
 * Assignment 3 - roadrage
 * TCSS 305 - Fall 2016
*/
package model;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Truck vehicle class for use in the road rage simulator.
 * @author jamesm47
 * @version 10/29/18
 */
public class Truck extends AbstractVehicle implements Vehicle {
    /*** Amount of steps the truck will remain dead if it dies in a collision.*/
    private static final int DEATH_TIME = 0;
    /*** Temporary ArrayList for generating a random direction.*/
    private List<Direction> myRandDirs = new ArrayList<>();
    /**
     * Constructor for the Truck class.
     * @param theX sets the x coordinate.
     * @param theY sets the y coordinate.
     * @param theDir sets the starting direction.
     */
    public Truck(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, DEATH_TIME);
    }

    @Override
    /**
     * canPass is a method for determining is the truck can continue to move
     * in the direction it is facing.
     * @param theTerrain is the terrain the truck is facing.
     * @param theLight is the condition of the light that the truck is facing.
     * @return is whether or not the truck my pass.
     */
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return (theTerrain == Terrain.STREET || theTerrain == Terrain.LIGHT)
                        || (theTerrain == Terrain.CROSSWALK && theLight != Light.RED);
    }
    /**
     * chooseDirection is a method for determining the direction the truck
     * will travel. 
     * @param theNeighbors is a map of the surrounding terrain.
     * @return the chosen direction.
     */
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        myRandDirs.clear();
        if (!getStraightLeftRight(theNeighbors).containsValue(Terrain.STREET)
            && !getStraightLeftRight(theNeighbors).containsValue(Terrain.LIGHT)
            && !getStraightLeftRight(theNeighbors).containsValue(Terrain.CROSSWALK)) {
            return getDirection().reverse();
        } else {
            for (Map.Entry<Direction, Terrain> entry 
                            : getStraightLeftRight(theNeighbors).entrySet()) {
                if (entry.getValue() == Terrain.STREET
                    || entry.getValue() == Terrain.LIGHT
                    || entry.getValue() == Terrain.CROSSWALK) {
                    myRandDirs.add(entry.getKey());
                }
            }
            return myRandDirs.get(myRand.nextInt(myRandDirs.size()));
            
        }

    }
   

    @Override
    /**
     * Collide handles the results of a truck colliding with another vehicle.
     * @param theOther is the 2nd vehicle.
     */
    public void collide(final Vehicle theOther) {
        super.collide(theOther);

    }

    @Override
    /**
     * getDeathTime returns the number of steps the truck stays dead.
     * @return the death time.
     */
    public int getDeathTime() {
        return DEATH_TIME;
    }

    
    

    @Override
    /**
     * getDirection returns the direction the truck is currently facing.
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
