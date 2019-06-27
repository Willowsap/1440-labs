import java.util.ArrayList;
import java.util.Random;
/**
 * Constructs a picture using various scene objects.
 *
 * @author Willow Sapphire
 * @version 6/21/2019
 */
public class Picture
{
    public static final int GROUND = 300;
    public static final int HORIZONTAL_CENTER = 150;
    
    private int horizon;
    private String skyColor;
    private String groundColor;
    private Background sky;
    private Foreground ground;
    private ArrayList<SceneObject> pictureItems;
    
    /**
     * Constructs a picture.
     * Initially takes the information to create sky and ground.
     * @param horizon the y coordinate at which to seperate ground and sky
     * @param skyColor the color of the sky
     * @param groundColor the color of the ground
     */
    public Picture(int horizon, String skyColor, String groundColor)
    {
        this.skyColor = skyColor;
        this.horizon = horizon;
        this.groundColor = groundColor;
        this.pictureItems = new ArrayList<SceneObject>();
        this.sky = new Background(skyColor);
        this.ground = new Foreground(groundColor, horizon);
    }
    
    /**
     * Adds an item to the picture without scaling it.
     * @param newItem the item to add
     */
    public void addSimpleItem(SceneObject newItem)
    {
        this.pictureItems.add(newItem);
    }
    
    /**
     * Adds an item to the picture and scales it based on position.
     * @param newItem the item to add
     */
    public void addComplexItem(ComplexSceneObject newItem)
    {
        addPerspective(newItem);
        this.pictureItems.add(newItem);
    }
    
    /**
     * Makes the picture visible.
     */
    public void render()
    {
        this.sky.makeVisible();
        this.ground.makeVisible();
        this.orderList();
        for (SceneObject o : this.pictureItems)
        {
            o.makeVisible();
        }
    }
    
    /**
     * Makes it snow in the picture.
     * @param numFlakes how many snowflakes to fall.
     */
    public void snow(int numFlakes)
    {
        Random rand = new Random(System.currentTimeMillis());
        Circle snowFlake = new Circle();
        snowFlake.changeColor("white");
        snowFlake.changeSize(10);
        for (int i = 0; i < numFlakes; i++)
        {
            snowFlake.setxPosition(rand.nextInt(280) + 10);
            snowFlake.setyPosition(-10);
            snowFlake.makeVisible();
            snowFlake.slowMoveVertical(100);
            snowFlake.makeInvisible();
        }
    }
    
    /**
     * Orders the list by y coordinate.
     * items with a lower y (further back) are rendered before
     * items with a higher y (closer)
     * This causes items that are closer to appear on top of items
     * that are further away
     */
    private void orderList()
    {
        for (int i = 0; i < this.pictureItems.size() - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < this.pictureItems.size(); j++)
            {  
                if (this.pictureItems.get(j).getY() 
                    < this.pictureItems.get(index).getY())
                {  
                    index = j;
                }  
            }  
            SceneObject closerItem = this.pictureItems.get(index);   
            this.pictureItems.set(index, this.pictureItems.get(i)); 
            this.pictureItems.set(i, closerItem);  
        }  
    }
    
    /**&
     * Alters the size of an item based on its y coordinate.
     * the lower the y coordinate, the further away it is
     * and therefore the smaller it is
     * @param object the item to alter
     */
    private void addPerspective(ComplexSceneObject object)
    {
        object.resize(this.getPerspectiveSizeMultiplier(object.getY()));
    }
    
    /**
     * Creates a size multiplier for an item base on its y coordinate.
     * @param yCoord the y coordinate on which to base the multiplier.
     * @return the size multiplier
     */
    private double getPerspectiveSizeMultiplier(int yCoord)
    {
        return Math.tan(Math.toRadians((yCoord - this.horizon) / 4.0)) 
            / Math.tan(Math.toRadians(50.0));
    }
}
