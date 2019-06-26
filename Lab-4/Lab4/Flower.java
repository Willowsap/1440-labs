import java.util.HashMap;

/**
 * Constructs a beautiful flower using basic shapes.
 *
 * @author Willow Sapphire
 * @version 6/20/2019
 */
public class Flower extends ComplexSceneObject 
{
    private int headSize;
    private int stemHeight;
    private String stemColor;
    private String headColor;
    private ComplexCircle top;
    private ComplexSquare[] stem;
    
    /**
     * Collects and calculates all required information for the flower.
     * Builds the flower but does not display it.
     * @param xPos the x coordinate at which to place the flower
     * @param yPos the y coordinate at which to place the bottom of the flower
     * @param headSize the diameter of the head (top) of the flower
     * @param stemHeight the height for the stem of the flower
     * @param headColor the color for the head of the flower
     * @param stemColor the color for the stem of the flower
     */
    public Flower(int xPos, int yPos, int headSize, int stemHeight, 
        String headColor, String stemColor) 
    {
        super(xPos, yPos);
        this.headSize = headSize;
        this.stemHeight = stemHeight;
        this.xPos = xPos;
        this.yPos = yPos;
        this.headColor = headColor;
        this.stemColor = stemColor;
        this.getSizes();
        this.getPositions();
        this.build();
    }
    
    /**
     * Builds the different parts of the flower.
     * The different sections are split up so that
     * one method does not need to be responsible for all.
     */
    protected void build()
    {
        this.makeStem();
        this.makeTop();
    }
    
    /**
     * Creates the shapes for the stem of the flower.
     */
    private void makeStem()
    {
        int numParts = this.stemHeight / this.sizes.get("stem");
        this.stem = new ComplexSquare[numParts];
        for (int i = 0; i < numParts; i++)
        {
            stem[i] = new ComplexSquare(
                this.positions.get("stemX"),
                this.positions.get("stemY") - this.sizes.get("stem") * i,
                this.sizes.get("stem"),
                this.stemColor);
            this.allParts.add(stem[i]);
        }
    }
    
    /**
     * Creates the shapes for the top of the flower.
     */
    private void makeTop()
    {
        this.top = new ComplexCircle(
            this.positions.get("topX"), 
            this.positions.get("topY"),
            this.sizes.get("top"),
            this.headColor);   
        this.allParts.add(top);
    }
    
    /**
     * Creates a hashmap of flower parts to their sizes.
     * { String flowerPart : int size }
     * @param headSize the size of the head of the flower.
     *      used to correctly proportion the other flower parts.
     * @return the hashmap
     */
    protected void getSizes()
    {
        this.sizes = new HashMap<String, Integer>();
        sizes.put("top", headSize);
        sizes.put("stem", (int) (this.headSize * 0.1) <= 0 ? 1 : (int) (headSize * 0.1));
    }
    
    /**
     * Creates a hashmap of flower parts to their coordinates.
     * { String flowerPartX : int xCoordinate,
     *   String flowerPartY : int yCoordinate }
     * @param headSize the size of the head of the flower.
     *      used to correctly position the flower parts.
     * @param height the height of the stem.
     *      used to correctly position the flower parts.
     * @param x the x coordinate for the center of the flower
     * @param y the y coordinate for the bottom of the flower
     * @return the hashmap
     */
    protected void getPositions()
    {
        int x = this.xPos;
        int y = this.yPos;
        this.positions = new HashMap<String, Integer>();
        positions.put("topX", x);
        positions.put("topY", y - stemHeight);
        positions.put("stemX", x);
        positions.put("stemY", y);
    }
}
