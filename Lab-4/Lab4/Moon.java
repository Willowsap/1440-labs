import java.util.HashMap;
/**
 * Constructs a beautiful moon.
 * 
 * @author Willow Sapphire
 * @version 6/20/2019
 */
public class Moon extends ComplexSceneObject
{
    private int size;  
    private String color;
    private String skyColor;
    private ComplexCircle moon;
    private ComplexCircle moonNegative;
    
    /**
     * Gathers the information for the foreground.
     * Creates the shapes required.
     * @param xPos the moon's x position.
     * @param yPos the moon's y position.
     * @param size the size of the moon.
     * @param color the color for the moon.
     * @param skyColor the color of the sky, used for the moon negative.
     */
    public Moon(int xPos, int yPos, int size, String color, String skyColor)
    {
        super(xPos, yPos);
        this.size = size;
        this.color = color;
        this.skyColor = skyColor;
        this.getSizes();
        this.getPositions();
        this.build();
    }
    
    /**
     * Builds the shapes for the moon.
     */
    public void build()
    {
        this.moon = new ComplexCircle(
            this.positions.get("moonX"),
            this.positions.get("moonY"),
            this.sizes.get("moon"),
            this.color);
        this.moonNegative = new ComplexCircle(
            this.positions.get("moonNegativeX"),
            this.positions.get("moonNegativeY"),
            this.sizes.get("moonNegative"),
            this.skyColor);
        this.allParts.add(moon);
        this.allParts.add(moonNegative);
    }
    
    /**
     * Creates a hashmap of moon parts to their sizes.
     * { String moonPart : int size }
     */
    protected void getSizes()
    {
        this.sizes = new HashMap<String, Integer>();
        this.sizes.put("moon", this.size);
        this.sizes.put("moonNegative", this.size);
    }
    
    /**
     * Creates a hashmap of flower parts to their coordinates.
     * { String flowerPartX : int xCoordinate,
     *   String flowerPartY : int yCoordinate }
     */
    protected void getPositions()
    {
        this.positions = new HashMap<String, Integer>();
        this.positions.put("moonX", this.xPos);
        this.positions.put("moonY", this.yPos);
        this.positions.put("moonNegativeX", this.xPos 
            + (this.sizes.get("moon") / 4));
        this.positions.put("moonNegativeY", this.yPos 
            + (this.sizes.get("moon") / 10));
    }
}
