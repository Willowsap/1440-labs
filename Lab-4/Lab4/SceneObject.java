import java.util.ArrayList;
/**
 * Subclassed by all different objects used in a scene.
 * 
 * @author Willow Sapphire
 * @version 5/20/2019
 */
public abstract class SceneObject
{
    public static final int GROUND = 300;
    public static final int HORIZONTAL_CENTER = 150;
    //the center of the object
    protected int xPos;
    //the bottom of the object
    protected int yPos;
    //contains all shapes making up the object
    protected ArrayList<ComplexShape> allParts;
    
    public SceneObject(int xPos, int yPos)
    {
        this.xPos = xPos;
        this.yPos = yPos;
        this.allParts = new ArrayList<ComplexShape>();
    }
    
    public int getX()
    {
        return this.xPos;
    }
    
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
     * Makes the heart visible on the canvas.
     */
    public void makeVisible()
    {
        for (ComplexShape part : this.allParts)
       {
           part.makeVisible();
       }
    }
    
    /**
     * Makes the heart invisible on the canvas.
     */
    public void makeInvisible()
    {
        for (ComplexShape part : this.allParts)
       {
           part.makeInvisible();
       }
    }
}
