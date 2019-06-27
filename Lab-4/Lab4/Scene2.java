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
    public static final int BARN_WIDTH = 250;
    public static final int MOON_SIZE = 50;
    public static final int BIRD_SIZE = 25;
    public static final String[] COLORS = { "blue", "red", "magenta", "yellow" };
    
    private Random rand;
    private Picture picture;
    private ArrayList<Flower> flowers;
    private ArrayList<Barn> barns;
    private ArrayList<SnowPerson> snowPeople;
    private Bird bird;
    
    public Scene2()
    {
        this.rand = new Random(System.currentTimeMillis());
        int numSnowPeople = rand.nextInt(10) + 2;
        int numFlowers = rand.nextInt(10) + 20;
        int numBarns = rand.nextInt(3) + 1;
        this.picture = new Picture(100, "black", "white");
        this.addFlowers(numFlowers, 0, 300, 100, 300);
        this.addSnowPeople(numSnowPeople, 70, 230, 190, 290);
        this.addBarns(numBarns, 120, 200);
        this.addMoons(1, 50, 250);
        this.addBird();
        picture.render();
        this.animate();
    }
    
    public void animate()
    {
        this.bird.fly(310 + 2 * BIRD_SIZE);
        picture.snow(10);
    }
    
    private void addBird()
    {
        this.bird = new Bird(
            -BIRD_SIZE-10,
            75,
            BIRD_SIZE,
            "blue"
        );
        picture.addSimpleItem(this.bird);
    }
    
    private void addMoons(int numMoons, int minX, int maxX)
    {
        this.picture.addSimpleItem(new Moon(
            rand.nextInt(maxX - minX) + minX,
            75,
            MOON_SIZE,
            "white",
            "black"
        ));
    }
    
    private void addSnowPeople(int numSnowPeople, int minX, int maxX, int minY, int maxY)
    {
        String clothesColor, leftOrRight;
        this.snowPeople = new ArrayList<SnowPerson>(numSnowPeople);
        for (int i = 0; i < numSnowPeople; i++)
        {
            clothesColor = COLORS[rand.nextInt(4)];
            this.snowPeople.add(new SnowPerson(
            rand.nextInt(maxX - minX) + minX,
            rand.nextInt(maxY - minY) + minY, 
            SNOWPERSON_SIZE, 
            "white", 
            "black", 
            clothesColor, 
            "black"));
            this.picture.addItem(this.snowPeople.get(i), true);
        }
    }
    private void addBarns(int numBarns, int minY, int maxY)
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
                rand.nextInt(2) > 0 ? rand.nextInt(100) : rand.nextInt(100) + 200,
                rand.nextInt(maxY - minY) + minY,
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
                rand.nextInt(maxX - minX) + minX,
                rand.nextInt(maxY - minY) + minY,
                FLOWER_HEAD_SIZE,
                FLOWER_STEM_HEIGHT,
                COLORS[rand.nextInt(4)],
                "green"
            ), true);
        }
    }
    
    /**
     * It all starts here.
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) 
    {
        Scene2 scene2 = new Scene2();
        scene2.animate();
    }
}
