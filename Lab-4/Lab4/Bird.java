import java.util.HashMap;

/**
 * Constructs a bird.
 *
 * @author Willow Sapphire
 * @version 6/20/2019
 */
public class Bird extends ComplexSceneObject
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
        this.getSizes();
        this.getPositions();
        this.build();
    }
    
    /**
     * Makes the bird fly across the screen.
     * @param distance the distance (in pixels) to fly
     */
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
            catch (InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    /**
     * Builds the shapes for the bird.
     */
    protected void build()
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
     */
    protected void getSizes()
    {
        this.sizes = new HashMap<String, Integer>();
        this.sizes.put("body", this.bodySize);
        this.sizes.put("head", (int) (this.bodySize * 0.7));
        this.sizes.put("eye", (int) (this.bodySize * 0.2));
        this.sizes.put("beakHeight", (int) (this.bodySize * 0.3));
        this.sizes.put("beakWidth", (int) (this.bodySize * 0.3));
        this.sizes.put("tailHeight", (int) (this.bodySize * 0.9));
        this.sizes.put("tailWidth", (int) (this.bodySize * 0.9));
    }
    
    /**
     * Creates a hashmap of bird parts to their coordinates.
     * { String birdPartX : int xCoordinate,
     *   String birdPartY : int yCoordinate }
     */
    protected void getPositions()
    {
        this.positions = new HashMap<String, Integer>();
        this.positions.put("bodyX", this.xPos);
        this.positions.put("bodyY", this.yPos);
        this.positions.put("headX", this.xPos 
            + (int) (this.sizes.get("body") * 0.5));
        this.positions.put("headY", this.yPos 
            - (int) (this.sizes.get("body") * 0.5));
        this.positions.put("eyeX", this.positions.get("headX"));
        this.positions.put("eyeY", (int) (this.positions.get("headY") 
            - this.sizes.get("head") * 0.5));
        this.positions.put("beakX", (int) (this.positions.get("headX") 
            + this.sizes.get("head") * 0.7));
        this.positions.put("beakY", (int) (this.positions.get("headY") 
            - this.sizes.get("head") * 0.34));
        this.positions.put("tailX", this.xPos 
            - (int) (this.sizes.get("body") * 0.3));
        this.positions.put("tailY", this.yPos 
            - (int) (this.sizes.get("body") * 0.4));
    }
}
