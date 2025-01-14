import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    protected int offsetMultiplication;
    public DetectionTool()
    {
        horizontalImage = new GreenfootImage(100, 3);
        verticalImage = new GreenfootImage(3, 50);
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
        WorldBorder visionBlocker = (WorldBorder)getOneIntersectingObject(WorldBorder.class);
        if (spottedPlayer != null)
        {
            if (visionBlocker instanceof BlockBorder)
            {
                double playerDistance = Math.sqrt(Math.pow(spottedPlayer.getX() - getX(), 2) + Math.pow(spottedPlayer.getY() - getY(), 2)); //(Math.pow(visionBlocker.getX() - getX(), 2)
                double blockerDistance = visionBlocker.getY() + Math.signum(getY() - visionBlocker.getY()) * visionBlocker.getImage().getHeight() / 2 - getY();
                return playerDistance <= blockerDistance;
            }

            return true;
        }

        return false;
    }
}
