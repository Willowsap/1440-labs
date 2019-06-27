import java.util.HashMap;
import java.util.Map;

/**
 * Blueprint for creating complex scene objects.
 * 
 * @author Willow Sapphire
 * @version 6/20/2019
 */

public abstract class ComplexSceneObject extends SceneObject
{
    protected HashMap<String, Integer> sizes;
    protected HashMap<String, Integer> positions;
    
    /**
     * Creates the scene object.
     * @param xPos the x coordinate.
     * @param yPos the y coordinate.
     */
    public ComplexSceneObject(int xPos, int yPos)
    {
        super(xPos, yPos);
    }
    
    /**
     * Resizes the object based on a given multiplier.
     * ex. a multiplier of 2 would double the size of the object.
     * @param sizeMultiplier the factor by which to change the object's size.
     */
    public void resize(double sizeMultiplier)
    {
        for (Map.Entry<String, Integer> entry : this.sizes.entrySet()) 
        {
            String key = entry.getKey();
            Integer value = entry.getValue();
            this.sizes.put(key, (int) (value * sizeMultiplier) <= 0 
                ? 1 : (int) (value * sizeMultiplier));
        }
        this.getPositions();
        this.allParts.clear();
        this.build();
    }
    
    /**
     * Builds the object.
     * The different sections of split up for ease of reading.
     */
    protected abstract void build();
    
    /**
     * Creates a hashmap of partNames to sizes.
     * Hashmap is stored in this.sizes
     */
    protected abstract void getSizes();
    
    /**
     * Creates of hashmap of partNames to x and y positions.
     * Hashmap is stored in this.positions
     */
    protected abstract void getPositions();
    
}
