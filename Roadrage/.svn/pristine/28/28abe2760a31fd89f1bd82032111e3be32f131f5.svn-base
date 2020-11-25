/*
 * Assignment 3 - roadrage
 * TCSS 305 - Fall 2016
*/
package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/**
 * Abstract Vehicle parent class for child vehicles.
 * @author jamesm47
 * @version 10/29/18
 */
public abstract class AbstractVehicle implements Vehicle {
    
    /*** Initial x coordinate for vehicle. */
    protected int myInitialX;
    /*** Initial y coordinate for vehicle. */
    protected int myInitialY;
    /*** Initial direction for vehicle. */
    protected Direction myInitialDirection;
    /*** Initial alive state for vehicle. */
    protected boolean myLifeState = true;
    
    /*** Initializes the vehicles deathCounter. */
    protected int myDeathCounter;
    /*** Direction for vehicle. */
    protected Direction myDirection;
    /*** X coordinate for vehicle. */
    protected int myX;
    /*** Y coordinate for vehicle. */
    protected int myY;
    /*** Death time for vehicle. */
    protected int myDeathTime;
    /**
     * Random instance to be used by vehicles when
     * generating a random direction.
     */
    protected Random myRand = new Random();
    
    /**
     * Initializes a vehicle to the inputed specifications.
     * Also records the initial parameters for use in the reset method.
     * @param theX is the initial x coordinate.
     * @param theY is the initial y coordinate.
     * @param theDir is the initial direction.
     * @param theDeathTime is the vehicles death time.
     */
    public AbstractVehicle(final int theX, final int theY, 
                           final Direction theDir, final int theDeathTime) {
        myDirection = theDir;
        myX = theX;
        myY = theY;
        myDeathTime = theDeathTime;
        myInitialX = theX;
        myInitialY = theY;
        myInitialDirection = theDir;
        myDeathCounter = theDeathTime;
    }
    
    /**
     * @return the vehicle class name in string form.
     */
    public String toString() {
        return getClass().getSimpleName().toLowerCase();
    }
    
    /**
     * getImageFileName returns the .gif file name for
     * a vehicle.
     * @return a string of the .gif file name.
     */
    public String getImageFileName() {
        if (isAlive()) {
            return getClass().getSimpleName().toLowerCase() + ".gif";
        } else {
            return getClass().getSimpleName().toLowerCase() + "_dead.gif";
        }
    }
    

    /**
     * Poke is a method to iterate a vehicles DeathCounter.
     */
    public void poke() {
        if (!isAlive()) {
            myDeathCounter -= 1;
            if (myDeathCounter == 0) {
                myLifeState = true;
                myDeathCounter = myDeathTime;
                myDirection = Direction.random();
            }
        }

    }
    
    /**
     * Method to remove the reverse direction from a map
     * of surrounding directions.
     * @param theNeighbors is the surrounding directions.
     * @return theNeighbors but without reverse.
     */
    protected Map<Direction, Terrain> getStraightLeftRight(
           final Map<Direction, Terrain> theNeighbors) {
        final Map<Direction, Terrain> copy = new HashMap<>();
        copy.putAll(theNeighbors);
        copy.remove(myDirection.reverse());
        return copy;
    }
    /**
     * Method for vehicles that prioritize turning left if
     * possible, and then right.
     * @param theNeighbors is the surrounding directions.
     * @return the direction depending on what is available to move.
     */
    protected Direction chooseLeftRight(final Map<Direction, Terrain> theNeighbors) {
        if (theNeighbors.get(myDirection.left()) == Terrain.STREET 
            || theNeighbors.get(myDirection.left()) == Terrain.LIGHT 
            || theNeighbors.get(myDirection.left()) == Terrain.CROSSWALK) {
            return myDirection.left();
        } else if (theNeighbors.get(myDirection.right()) == Terrain.STREET 
            || theNeighbors.get(myDirection.right()) == Terrain.LIGHT 
            || theNeighbors.get(myDirection.right()) == Terrain.CROSSWALK) {
            return myDirection.right();
        } else {
            return myDirection.reverse();
        }
    }
   
    /**
     * Method to handle collisions.
     * When called, it sets the vehicle with the higher DeathTime
     * to not Alive.
     * @param theOther is the 2nd vehicle in the collision.
     */
    public void collide(final Vehicle theOther) {
        if (myDeathTime > theOther.getDeathTime()) {
            myLifeState = false;
        }
    }
    /**
     * When called, it returns vehicles to their
     * initial position.
     */
    public void reset() {
        myX = myInitialX;
        myY = myInitialY;
        myDirection = myInitialDirection;
        myLifeState = true;

    }
    
}
