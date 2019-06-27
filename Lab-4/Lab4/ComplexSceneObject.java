import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/**
 * Blueprint for creating complex scene objects.
 * 
 * @author Willow Sapphire
 * @version 6/20/2019
 */
 
 //Put imports below this line.

/**
 *  Describe the ComplexSceneObject class here.
 */
public abstract class ComplexSceneObject extends SceneObject
{
    protected HashMap<String, Integer> sizes;
    protected HashMap<String, Integer> positions;
    
    public ComplexSceneObject(int xPos, int yPos)
    {
        super(xPos, yPos);
    }
    
    public void resize(double sizeMultiplier)
    {
        for (Map.Entry<String, Integer> entry : this.sizes.entrySet()) 
        {
            String key = entry.getKey();
            Integer value = entry.getValue();
            this.sizes.put(key, (int)(value * sizeMultiplier) <= 0 ? 1 : (int)(value * sizeMultiplier));
        }
        this.getPositions();
        this.allParts.clear();
        this.build();
    }
    
    /**
     * Builds the shapes for the snowperson.
     * The different sections of split up for ease of reading.
     */
    protected abstract void build();
    
    protected abstract void getSizes();
    
    protected abstract void getPositions();
    
}
