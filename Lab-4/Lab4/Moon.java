/**
 * Constructs a beautiful moon.
 * 
 * @author Willow Sapphire
 * @version 6/20/2019
 */
public class Moon extends SceneObject
{
    public static final int GROUND = 300;
    public static final int HORIZONTAL_CENTER = 150;

    private int size;  
    private String color;
    private String skyColor;
    private ComplexCircle moon;
    private ComplexCircle moonNegative;
    
    /**
     * Gathers the information for the foreground.
     * Creates the shapes required.
     * @param color the color for the foreground.
     * @param skyColor the color of the sky.
     * @param horizon how far up to extend the foreground.
     */
    public Moon(int xPos, int yPos, int size, String color, String skyColor)
    {
        super(xPos, yPos);
        this.size = size;
        this.color = color;
        this.skyColor = skyColor;
        this.makeMoon();
    }
    
    public void makeMoon()
    {
        this.moon = new ComplexCircle(
            this.xPos,
            this.yPos,
            this.size,
            this.color);
        this.moonNegative = new ComplexCircle(
            this.xPos + (size / 4),
            this.yPos + (size / 10),
            this.size,
            this.skyColor);
        this.allParts.add(moon);
        this.allParts.add(moonNegative);
    }
}
