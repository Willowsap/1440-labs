/**
 * Constructs a foreground for the canvas.
 * 
 * @author Willow Sapphire
 * @version 6/20/2019
 */
public class Foreground extends SceneObject
{
    public static final int SIZE = 300;
    
    private int horizon;
    private String color;
    private ComplexSquare foreground;
    
    /**
     * Gathers the information for the foreground.
     * Creates the shapes required.
     * @param color the color for the foreground.
     * @param horizon how far up to extend the foreground.
     */
    public Foreground(String color, int horizon)
    {
        super(Picture.HORIZONTAL_CENTER, Picture.GROUND + horizon);
        this.color = color;
        this.foreground = new ComplexSquare(
            this.xPos, this.yPos, SIZE, this.color);
        this.allParts.add(foreground);
    }
    
    /**
     * Accessor for foreground color.
     * @return the current color of the foreground.
     */
    public String getColor()
    {
        return this.foreground.getColor();
    }
    
    /**
     * Mutator for the foreground color.
     * @param color the new color for the foreground.
     */
    public void setColor(String color)
    {
        this.foreground.changeColor(color);
    }
}
