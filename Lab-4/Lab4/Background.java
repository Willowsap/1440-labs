/**
 * Constructs a background for the canvas.
 * 
 * @author Willow Sapphire
 * @version 6/20/2019
 */
public class Background extends SceneObject
{
    private ComplexSquare background;
    
    /**
     * Gathers the information for the background.
     * Creates the shapes required.
     * @param color the color for the background.
     */
    public Background(String color)
    {
        super(150, 300);
        background = new ComplexSquare(150, 300, 300, color);
        this.allParts.add(background);
    }
    
    public void resize(double sizeMultiplier)
    {
        System.out.println("Cannot resize the background");
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
