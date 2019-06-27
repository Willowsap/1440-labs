import java.util.HashMap;
import java.util.ArrayList;
/**
 * Constructs a bird.
 *
 * @author Willow Sapphire
 * @version 6/20/2019
 */
public class Bird extends SceneObject
{
    private int bodySize;
    private String color;
    private String beakColor;
    private String eyeColor;
    private ComplexCircle body;
    private ComplexCircle head;
    private ComplexCircle eye;
    private ComplexTriangle beak;
    private ComplexTriangle tail;
    private HashMap<String, Integer> sizes;
    private HashMap<String, Integer> positions;
    
    /**
     * Collects and calculates all required information for the bird.
     * Builds the bird but does not display it.
     * @param xPos the x coordinate at which to place the bird
     * @param yPos the y coordinate at which to place the bottom of the bird
     * @param bodySize the diameter of the body of the bird
     * @param color the color of the bird
     */
    public Bird(int xPos, int yPos, int bodySize, String color) 
    {
        super(xPos, yPos);
        this.bodySize = bodySize;
        this.xPos = xPos;
        this.yPos = yPos;
        this.color = color;
        this.beakColor = "yellow";
        this.eyeColor = "yellow";
        this.sizes = getSizes(bodySize);
        this.positions = getPositions(bodySize, xPos, yPos);
        this.buildbird();
    }
    
    public void fly(int distance)
    {
        int finalX = distance + this.xPos;
        int step = finalX > this.xPos ? 20 : -20;
        int numSteps = distance / step;
        for (int i = 0; i < numSteps; i++)
        {
            this.makeInvisible();
            for (ComplexShape part : this.allParts)
            {
                part.moveHorizontal(step);
            }
            this.makeVisible();
            try
            {
                Thread.sleep(150);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    /**
     * Builds the shapes for the bird.
     */
    private void buildbird()
    {
        this.body = new ComplexCircle(
            this.positions.get("bodyX"), 
            this.positions.get("bodyY"),
            this.sizes.get("body"),
            this.color); 
        this.head = new ComplexCircle(
            this.positions.get("headX"), 
            this.positions.get("headY"),
            this.sizes.get("head"),
            this.color); 
        this.eye = new ComplexCircle(
            this.positions.get("eyeX"), 
            this.positions.get("eyeY"),
            this.sizes.get("eye"),
            this.eyeColor); 
        this.beak = new ComplexTriangle(
            this.positions.get("beakX"), 
            this.positions.get("beakY"),
            this.sizes.get("beakHeight"),
            this.sizes.get("beakWidth"),
            this.beakColor); 
        this.tail = new ComplexTriangle(
            this.positions.get("tailX"), 
            this.positions.get("tailY"),
            this.sizes.get("tailHeight"),
            this.sizes.get("tailWidth"),
            this.color);
        this.allParts.add(this.body);
        this.allParts.add(this.head);
        this.allParts.add(this.eye);
        this.allParts.add(this.tail);
        this.allParts.add(this.beak);
    }
    
    /**
     * Creates a hashmap of bird parts to their sizes.
     * { String birdPart : int size }
     * @param bodySize the size of the head of the bird.
     *      used to correctly proportion the other bird parts.
     * @return the hashmap
     */
    private HashMap<String, Integer> getSizes(int bodySize)
    {
        HashMap<String, Integer> sizes = new HashMap<String, Integer>();
        sizes.put("body", bodySize);
        sizes.put("head", (int) (bodySize * 0.7));
        sizes.put("eye", (int) (bodySize * 0.2));
        sizes.put("beakHeight", (int) (bodySize * 0.3));
        sizes.put("beakWidth", (int) (bodySize * 0.3));
        sizes.put("tailHeight", (int) (bodySize * 0.9));
        sizes.put("tailWidth", (int) (bodySize * 0.9));
        return sizes;
    }
    
    /**
     * Creates a hashmap of bird parts to their coordinates.
     * { String birdPartX : int xCoordinate,
     *   String birdPartY : int yCoordinate }
     * @param bodySize the size of the body of the bird.
     *      used to correctly position the bird parts.
     * @param x the x coordinate for the center of the bird
     * @param y the y coordinate for the bottom of the bird
     * @return the hashmap
     */
    private HashMap<String, Integer> getPositions(int bodySize, int x, int y)
    {
        HashMap<String, Integer> positions = new HashMap<String, Integer>();
        positions.put("bodyX", x);
        positions.put("bodyY", y);
        positions.put("headX", x + (int) (this.sizes.get("body") * 0.5));
        positions.put("headY", y - (int) (this.sizes.get("body") * 0.5));
        positions.put("eyeX", positions.get("headX"));
        positions.put("eyeY", (int) (positions.get("headY") 
            - this.sizes.get("head") * 0.5));
        positions.put("beakX", (int) (positions.get("headX") 
            + this.sizes.get("head") * 0.7));
        positions.put("beakY", (int) (positions.get("headY") 
            - this.sizes.get("head") * 0.34));
        positions.put("tailX", x - (int) (this.sizes.get("body") * 0.3));
        positions.put("tailY", y - (int) (this.sizes.get("body") * 0.4));
        return positions;
    }
}
