/**
 * Constructs a background for the canvas.
 * 
 * @author Willow Sapphire
 * @version 6/20/2019
 */
public class Background extends SceneObject
{
    private String color;
    private ComplexSquare background;
    
    /**
     * Gathers the information for the background.
     * Creates the shapes required.
     * @param color the color for the background.
     */
    public Background(String color)
    {
        super(Picture.HORIZONTAL_CENTER, Picture.GROUND);
        this.color = color;
        this.background = new ComplexSquare(this.xPos, this.yPos, 300, color);
        this.allParts.add(background);
    }
    
    /**
     * Accessor for background color.
     * @return the current color of the background.
     */
    public String getColor()
    {
        return this.background.getColor();
    }
    
    /**
     * Mutator for the background color.
     * @param color the new color for the background.
     */
    public void setColor(String color)
    {
        this.background.changeColor(color);
    }
}
