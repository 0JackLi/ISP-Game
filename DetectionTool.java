import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class DetectionTool here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class DetectionTool extends Actor
{
    private static final boolean showDetection = false;
    protected static GreenfootImage horizontalImage, verticalImage;
    protected Actor followActor;
    protected int directionMovement;
    public DetectionTool()
    {
        horizontalImage = new GreenfootImage(150, 3);
        verticalImage = new GreenfootImage(3, 100);
        horizontalImage.setColor(Color.BLUE);
        verticalImage.setColor(Color.BLUE);
        horizontalImage.fillRect(0, 0, horizontalImage.getWidth(), horizontalImage.getHeight());
        verticalImage.fillRect(0, 0, verticalImage.getWidth(), verticalImage.getHeight());
        
        if (!showDetection)
        {
            horizontalImage.setTransparency(0);
            verticalImage.setTransparency(0);
        }
    }

    public boolean hasSpotted()
    {
        Player spottedPlayer = (Player)getOneIntersectingObject(Player.class);
        ArrayList<BlockBorder> visionBlockers = (ArrayList<BlockBorder>)getIntersectingObjects(BlockBorder.class);
        BlockBorder visionBlocker = null;
        int closestHeight = Integer.MAX_VALUE;
        for (BlockBorder blocker : visionBlockers)
        {
            if (Math.abs(blocker.getY() - followActor.getY()) < closestHeight)
            {
                closestHeight = Math.abs(blocker.getY() - followActor.getY());
                visionBlocker = blocker;
            }
        }
        
        if (spottedPlayer != null)
        {
            if (visionBlocker != null)
            {
                double playerDistance = Math.sqrt(Math.pow(spottedPlayer.getX() - followActor.getX(), 2) + Math.pow(spottedPlayer.getY() - followActor.getY(), 2)); //(Math.pow(visionBlocker.getX() - getX(), 2)
                double blockerDistance = visionBlocker.getY() + Math.signum(followActor.getY() - visionBlocker.getY()) * visionBlocker.getImage().getHeight() / 2 - followActor.getY();
                System.out.println(visionBlocker.getY() + ", " + visionBlocker.getImage().getHeight() / 2 + ", " + followActor.getY());
                System.out.println(playerDistance + ", " + blockerDistance);
                return playerDistance <= blockerDistance;
            }

            return true;
        }

        return false;
    }
}