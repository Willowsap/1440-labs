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
    public static final String[] COLORS = {"blue", "red", 
        "magenta", "yellow"};
    
    private Random rand;
    private Picture picture;
    private ArrayList<Flower> flowers;
    private ArrayList<Barn> barns;
    private ArrayList<SnowPerson> snowPeople;
    private Bird bird;
    
    /**
     * Creates a pretty little scene.
     * Everything gets created in the constructor.
     */
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
    }
    
    /**
     * Makes the bird fly across the screen.
     * Then makes it snow a bit.
     */
    public void animate()
    {
        this.bird.fly(310 + 2 * BIRD_SIZE);
        picture.snow(10);
    }
    
    /**
     * Adds a bird to the scene. It starts of the left side.
     */
    private void addBird()
    {
        this.bird = new Bird(
            -BIRD_SIZE - 10,
            75,
            BIRD_SIZE,
            "blue"
        );
        picture.addSimpleItem(this.bird);
    }
    
    /**
     * Adds some moons to the sky.
     * @param numMoons the number of moons to add.
     * @param minX the minimum x coord for moons to be at
     * @param maxX the maximum x coord for moons to be at
     */
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
    
    /**
     * Adds some snow people to the scene.
     * @param numSnowPeople the number of snowpeople to add.
     * @param minX the minimum x value for snowpeople to be at
     * @param maxX the maximum x value for snowpeople to be at
     * @param minY the minimum y value for snowpeople to be at
     * @param maxY the maximum y value for snowpeople to be at
     */
    private void addSnowPeople(int numSnowPeople, int minX, 
        int maxX, int minY, int maxY)
    {
        String clothesColor;
        String leftOrRight;
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
            this.picture.addComplexItem(this.snowPeople.get(i));
        }
    }
    
    /**
     * Adds some barns to the scene.
     * Barns are only added to the far left or far right.
     * @param numBarns the number of barns to add.
     * @param minY the minimum y value for barns to be at
     * @param maxY the maximum y value for barns to be at
     */
    private void addBarns(int numBarns, int minY, int maxY)
    {
        String roofColor;
        String wallColor;
        String doorColor;
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
            this.picture.addComplexItem(new Barn(
                rand.nextInt(2) > 0 ? rand.nextInt(100) 
                    : rand.nextInt(100) + 200,
                rand.nextInt(maxY - minY) + minY,
                BARN_WIDTH,
                wallColor,
                roofColor,
                doorColor
            ));
        }
    }
    
    /**
     * Adds some flowers to the scene.
     * @param numFlowers the number of flowers to add.
     * @param minX the minimum x value for flowers to be at
     * @param maxX the maximum x value for flowers to be at
     * @param minY the minimum y value for flowers to be at
     * @param maxY the maximum y value for flowers to be at
     */
    private void addFlowers(int numFlowers, int minX, 
        int maxX, int minY, int maxY)
    {
        for (int i = 0; i < numFlowers; i++)
        {
            this.picture.addComplexItem(new Flower(
                rand.nextInt(maxX - minX) + minX,
                rand.nextInt(maxY - minY) + minY,
                FLOWER_HEAD_SIZE,
                FLOWER_STEM_HEIGHT,
                COLORS[rand.nextInt(4)],
                "green"
            ));
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
