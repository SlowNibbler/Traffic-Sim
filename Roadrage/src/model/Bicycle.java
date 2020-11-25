/*
 * Assignment 3 - roadrage
 * TCSS 305 - Fall 2016
*/
package model;


import java.util.Map;

/**
 * Bicycle vehicle class for use in the road rage simulator.
 * @author jamesm47
 * @version 10/29/18
 */
public class Bicycle extends AbstractVehicle implements Vehicle {
    /*** Amount of steps the bicycle will remain dead if it dies in a collision.*/
    private static final int DEATH_TIME = 35;
    /**
     * Constructor for the Bicycle class.
     * @param theX sets the x coordinate.
     * @param theY sets the y coordinate.
     * @param theDir sets the starting direction.
     */
    public Bicycle(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, DEATH_TIME);
    }

    @Override
    /**
     * canPass is a method for determining is the bicycle can continue to move
     * in the direction it is facing.
     * @param theTerrain is the terrain the bicycle is facing.
     * @param theLight is the condition of the light that the bicycle is facing.
     * @return is whether or not the bicycle my pass.
     */
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        return theTerrain == Terrain.STREET
               || theTerrain == Terrain.TRAIL 
               || ((theTerrain == Terrain.LIGHT && (theLight != Light.RED)) 
               && (theTerrain == Terrain.LIGHT && (theLight != Light.YELLOW)))
               || ((theTerrain == Terrain.CROSSWALK && (theLight != Light.RED))
               && (theTerrain == Terrain.CROSSWALK && (theLight != Light.YELLOW)));
    }
    
    
    /**
     * chooseDirection is a method to get the direction the bicycle will travel.
     * @param theNeighbors is a map of the surrounding terrain.
     * @return the direction the bicycle will travel, as determined by the 
     * assisting methods.
     */
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        return keepGoingTrail(theNeighbors);

    }
    
    /**
     * keepGoingStraightStreet is an additional method to assist chooseDirection.
     * It handles the bicycles behavior for traveling on trails.
     * @param theNeighbors is a map of the surrounding terrain.
     * @return the direction the bicycle will travel.
     */
    public Direction keepGoingTrail(final Map<Direction, Terrain> theNeighbors) {
        if (theNeighbors.get(super.myDirection) == Terrain.TRAIL) {
            return myDirection;
        }
        for (Map.Entry<Direction, Terrain> entry 
            : getStraightLeftRight(theNeighbors).entrySet()) {
            if (entry.getValue() == Terrain.TRAIL) {
                return entry.getKey();
            }
        }
        return keepGoingStreet(theNeighbors);
    }
    
    /**
     * keepGoingStraightStreet is an additional method to assist chooseDirection.
     * It handles the bicycles behavior when there are no possible trails to go on.
     * @param theNeighbors is a map of the surrounding terrain.
     * @return the direction the bicycle will travel.
     */
    private Direction keepGoingStreet(final Map<Direction, Terrain> theNeighbors) {
        if (theNeighbors.get(super.myDirection) == Terrain.STREET) {
            return myDirection;
        }
        for (Map.Entry<Direction, Terrain> entry 
            : getStraightLeftRight(theNeighbors).entrySet()) {
            if (entry.getValue() == Terrain.STREET
                || entry.getValue() == Terrain.LIGHT 
                || entry.getValue() == Terrain.CROSSWALK) {
                return entry.getKey();
            }
        }
        return chooseLeftRight(theNeighbors);
    }




    @Override
    /**
     * Collide handles the results of a bicycle colliding with another vehicle.
     * @param theOther is the 2nd vehicle.
     */
    public void collide(final Vehicle theOther) {
        super.collide(theOther);

    }

    @Override
    /**
     * getDeathTime returns the number of steps the bicycle stays dead.
     * @return the death time.
     */
    public int getDeathTime() {
        return DEATH_TIME;
    }


    @Override
    /**
     * getDirection returns the direction the bicycle is currently facing.
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
