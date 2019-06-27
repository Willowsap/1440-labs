import java.util.ArrayList;
/**
 * Subclassed by all different objects used in a scene.
 * Provides basic functionality that all objects should have.
 * 
 * @author Willow Sapphire
 * @version 5/20/2019
 */
public abstract class SceneObject
{
    //the center of the object
    protected int xPos;
    //the bottom of the object
    protected int yPos;
    //contains all shapes making up the object
    protected ArrayList<ComplexShape> allParts;
    
    /**
     * The super constructor for scene objects.
     * Collects the x and y position of the object and
     * creates the arraylist of shapes.
     * @param xPos the x coordinate
     * @param yPos the y coordinate
     */
    public SceneObject(int xPos, int yPos)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.allParts = new ArrayList<ComplexShape>();
    }
    
    /**
     * Accessor method for the object's x coordinate.
     * @return the x coordinate.
     */
    public int getX()
    {
        return this.xPos;
    }
    
    /**
     * Accessor method for the object's y coordinate.
     * @return the y coordinate.
     */
    public int getY()
    {
        return this.yPos;
    }
    
    /**
     * set the center of the object to the given x coordinate.
     * @param xPos the x coordinate to place the object.
     */
    
    public void setX(int xPos)
    {
        this.xPos = xPos;
    }
    
    /**
     * set the bottom of the object to the given y coordinate.
     * @param yPos the y coordinate to place the object.
     */
    public void setY(int yPos)
    {
        this.yPos = yPos;
    }
    
    /**
     * Makes the object visible on the canvas.
     */
    public void makeVisible()
    {
        for (ComplexShape part : this.allParts)
        {
            part.makeVisible();
        }
    }
    
    /**
     * Makes the object invisible on the canvas.
     */
    public void makeInvisible()
    {
        for (ComplexShape part : this.allParts)
        {
            part.makeInvisible();
        }
    }
}
