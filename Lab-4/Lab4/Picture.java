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
    private int horizon;
    private String skyColor;
    private String groundColor;
    private Background sky;
    private Foreground ground;
    private ArrayList<SceneObject> pictureItems;
    
    public Picture(int horizon, String skyColor, String groundColor)
    {
        this.skyColor = skyColor;
        this.horizon = horizon;
        this.groundColor = groundColor;
        this.pictureItems = new ArrayList<SceneObject>();
        this.sky = new Background(skyColor);
        this.ground = new Foreground(groundColor, horizon);
    }
    
    public SceneObject getItem(int index)
    {
        return this.pictureItems.get(index);
    }
    
    public void addSimpleItem(SceneObject newItem)
    {
        this.pictureItems.add(newItem);
    }
    
    public void addItem(ComplexSceneObject newItem, boolean usePerspective)
    {
        if (usePerspective)
        {
            addPerspective(newItem);
        }
        this.pictureItems.add(newItem);
    }
    
    public void render()
    {
        this.sky.makeVisible();
        this.ground.makeVisible();
        this.orderList();
        for(SceneObject o : this.pictureItems)
        {
            o.makeVisible();
        }
    }
    
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
    
    private void orderList()
    {
        for (int i = 0; i < this.pictureItems.size() - 1; i++)  
        {  
            int index = i;  
            for (int j = i + 1; j < this.pictureItems.size(); j++)
            {  
                if (this.pictureItems.get(j).getY() < this.pictureItems.get(index).getY())
                {  
                    index = j;
                }  
            }  
            SceneObject closerItem = this.pictureItems.get(index);   
            this.pictureItems.set(index, this.pictureItems.get(i)); 
            this.pictureItems.set(i, closerItem);  
        }  
    }
    
    private void addPerspective(ComplexSceneObject object)
    {
        System.out.println("ycoord " + object.getY());
        System.out.println("multiplier: " + this.getPerspectiveSizeMultiplier(object.getY()));
        object.resize(this.getPerspectiveSizeMultiplier(object.getY()));
    }
    
    private double getPerspectiveSizeMultiplier(int yCoord)
    {
      return Math.tan(Math.toRadians((yCoord - 100) / 4.0)) / Math.tan(Math.toRadians(50.0));
    }
}
