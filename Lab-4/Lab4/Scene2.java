import java.util.ArrayList;
import java.util.Random;
/**
 * Postlab for Lab 4.
 * Creates a fun scene out of basic shapes.
 * 
 * @author Willow Sapphire
 * @version 5/20/2019
 */
public class Scene2
{
    public static final int GROUND = 300;
    public static final int VERTICAL_CENT = 150;
    public static final int TOP = 0;
    public static final int FAR_LEFT = 0;
    public static final int HORIZONTAL_CENTER = 150;
    public static final int FAR_RIGHT = 300;
    public static final int SNOWPERSON_SIZE = 100;
    public static final int FLOWER_HEAD_SIZE = 30;
    public static final int FLOWER_STEM_HEIGHT = 40;
    public static final int BARN_WIDTH = 150;
    public static final String[] COLORS = { "blue", "red", "magenta", "yellow" };
    
    private Random rand;;
    private Picture picture;
    
    public Scene2()
    {
        this.rand = new Random(System.currentTimeMillis());
        this.picture = new Picture(100, "black", "white");
        //this.addFlowers(0, 50, 250, 120, 230);
        //this.addBarns(1, 50, 250, 120, 230);
        this.picture.addItem(new SnowPerson(150, 200, 100, "white", 
        "black", "black", "black"), true);
        picture.render();
    }
    
    public void animate()
    {
        
    }
    
    private void addSnowPeople(int numSnowPeople, int minX, int maxX, int minY, int maxY)
    {
        
    }
    private void addBarns(int numBarns, int minX, int maxX, int minY, int maxY)
    {
        String roofColor, wallColor, doorColor;
        for (int i = 0; i < numBarns; i++)
        {
            wallColor = COLORS[rand.nextInt(4)];
            do
            {
                roofColor = COLORS[rand.nextInt(4)];
            }
            while (roofColor.equals(wallColor));
            do
            {
                doorColor = COLORS[rand.nextInt(4)];
            }
            while (doorColor.equals(wallColor));
            this.picture.addItem(new Barn(
                rand.nextInt(maxX) + minX,
                rand.nextInt(maxY) + minY,
                BARN_WIDTH,
                wallColor,
                roofColor,
                doorColor
            ), true);
        }
    }
    
    private void addFlowers(int numFlowers, int minX, int maxX, int minY, int maxY)
    {
        for (int i = 0; i < numFlowers; i++)
        {
            this.picture.addItem(new Flower(
                rand.nextInt(maxX) + minX,
                rand.nextInt(maxY) + minY,
                FLOWER_HEAD_SIZE,
                FLOWER_STEM_HEIGHT,
                COLORS[rand.nextInt(4)],
                "green"
            ), false);
        }
    }
    
    /**
     * It all starts here.
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) 
    {
        Scene2 scene2 = new Scene2();
    }
}
