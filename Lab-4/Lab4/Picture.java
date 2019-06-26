import java.util.ArrayList;
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
    private ArrayList<ComplexSceneObject> pictureItems;
    
    public Picture(int horizon, String skyColor, String groundColor)
    {
        this.skyColor = skyColor;
        this.horizon = horizon;
        this.groundColor = groundColor;
        this.pictureItems = new ArrayList<ComplexSceneObject>();
        this.sky = new Background(skyColor);
        this.ground = new Foreground(groundColor, horizon);
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
        for(ComplexSceneObject o : this.pictureItems)
        {
            o.makeVisible();
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
            ComplexSceneObject closerItem = this.pictureItems.get(index);   
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
      return Math.tan((yCoord - 100) / 4) / Math.tan(50);
    }
}
