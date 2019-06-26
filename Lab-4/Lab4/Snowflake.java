import java.util.HashMap;

/**
 * Constructs a beautiful snow using basic shapes.
 *
 * @author Willow Sapphire
 * @version 6/20/2019
 */
public class Snowflake extends SceneObject 
{
    private int size;
    private String color;
    private ComplexCircle snowflake;
    private HashMap<String, Integer> sizes;
    private HashMap<String, Integer> positions;
    
    /**
     * Collects and calculates all required information for the snowflake.
     * Builds the snow but does not display it.
     * @param xPos the x coordinate at which to place the snowflake
     * @param yPos the y coordinate at which to place the bottom of the snowflake
     * @param size
     */
    public Snowflake(int xPos, int yPos, int size) 
    {
        super(xPos, yPos);
        this.size = size;
        this.buildSnowflake();
    }
    
    public void fall(int distance)
    {
        this.snowflake.slowMoveVertical(distance);
    }
    
    /**
     * Builds the different parts of the snow.
     * The different sections are split up so that
     * one method does not need to be responsible for all.
     */
    private void buildSnowflake()
    {
        this.snowflake = new ComplexCircle(this.xPos, this.yPos, 
            this.size, this.color);
        this.allParts.add(snowflake);
    }
}
