import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.lang.Thread;
/**
 * Constructs a beautiful snowperson.
 * 
 * @author Willow
 * @version 6/20/2019
 */
public class SnowPerson extends ComplexSceneObject
{
    private int size;
    private String bodyColor;
    private String faceColor;
    private String clothesColor;
    private String outlineColor;
    private ComplexCircle abdomenOutline;
    private ComplexCircle thoraxOutline;
    private ComplexCircle headOutline;
    private ComplexCircle abdomen;
    private ComplexCircle thorax;
    private ComplexCircle head;
    private ComplexCircle mouth;
    private ComplexCircle mouthNegative;
    private ComplexSquare mouthNegative2;
    private ComplexCircle eye1;
    private ComplexCircle eye2;
    private ComplexTriangle arm1;
    private ComplexTriangle arm1Negative;
    private ComplexTriangle arm2;
    private ComplexTriangle arm2Negative;
    private ComplexTriangle foreArm1;
    private ComplexTriangle foreArm1Negative;
    private ComplexTriangle foreArm2;
    private ComplexTriangle foreArm2Negative;
    private ComplexCircle hand1;
    private ComplexCircle hand2;
    private ComplexCircle button1;
    private ComplexCircle button2;
    private ComplexCircle button3;
    
    /**
     * Collects and calculates all the information for the snowperson.
     * Builds the snowperson but does not display it.
     * @param xPos the x coordinate to place the center of the snowperson
     * @param yPos the y coordinate to place the bottom of the snowperson
     * @param size the size of the snowperson (diameter of abdomen)
     * @param bodyColor the color for the body of the snowperson
     * @param faceColor the color for the facial features of the snowperson
     * @param clothesColor the color for the clothes of the snowperson
     * 
     */
    public SnowPerson(int xPos, int yPos, int size, String bodyColor, 
        String faceColor, String clothesColor, String outlineColor)
    {
        super(xPos, yPos);
        this.size = size;
        this.bodyColor = bodyColor;
        this.faceColor = faceColor;
        this.clothesColor = clothesColor;
        this.outlineColor = outlineColor;
        this.getSizes();
        this.getPositions();
        this.build();
    }
    
    public void walk(int distance)
    {
        int finalX = distance + this.xPos;
        int step = finalX > this.xPos ? 10 : -10;
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
                Thread.sleep(250);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    /**
     * Builds the shapes for the snowperson.
     * The different sections of split up for ease of reading.
     */
    protected void build()
    {
        this.makeBody();
        this.makeFace();
        this.makeClothes();
    }
    
    /**
     * Constructs the shapes for the body of the snowperson.
     */
    private void makeBody()
    {
        this.abdomenOutline = new ComplexCircle(
            this.positions.get("abdomenOutlineX"), 
            this.positions.get("abdomenOutlineY"), 
            this.sizes.get("abdomenOutline") , 
            this.outlineColor);
        this.thoraxOutline = new ComplexCircle(
            this.positions.get("thoraxOutlineX"),
            this.positions.get("thoraxOutlineY"),
            this.sizes.get("thoraxOutline"), 
            this.outlineColor);
        this.headOutline = new ComplexCircle(
            this.positions.get("headOutlineX"), 
            this.positions.get("headOutlineY"),
            this.sizes.get("headOutline"), 
            this.outlineColor);
        this.abdomen = new ComplexCircle(
            this.positions.get("abdomenX"), 
            this.positions.get("abdomenY"), 
            this.sizes.get("abdomen") , 
            this.bodyColor);
        this.thorax = new ComplexCircle(
            this.positions.get("thoraxX"),
            this.positions.get("thoraxY"),
            this.sizes.get("thorax"), 
            this.bodyColor);
        this.head = new ComplexCircle(
            this.positions.get("headX"), 
            this.positions.get("headY"),
            this.sizes.get("head"), 
            this.bodyColor);
        allParts.add(this.abdomenOutline);
        allParts.add(this.thoraxOutline);
        allParts.add(this.headOutline);
        allParts.add(this.abdomen);
        allParts.add(this.thorax);
        allParts.add(this.head);
    }
    
    /**
     * Constructs the shapes for the face of the snowperson.
     */
    private void makeFace()
    {
        this.mouth = new ComplexCircle(
            this.positions.get("mouthX"),
            this.positions.get("mouthY"),
            this.sizes.get("mouth"),
            this.faceColor);
        this.mouthNegative = new ComplexCircle(
            this.positions.get("mouthNegative1X"), 
            this.positions.get("mouthNegative1Y"),
            this.sizes.get("mouth"),
            this.bodyColor);
        this.mouthNegative2 = new ComplexSquare(
            this.positions.get("mouthNegative2X"), 
            this.positions.get("mouthNegative2Y"),
            this.sizes.get("mouth"),
            this.bodyColor);
        this.eye1 = new ComplexCircle(
            this.positions.get("eye1X"),
            this.positions.get("eye1Y"), 
            this.sizes.get("eye"),
            this.faceColor);
        this.eye2 = new ComplexCircle(
            this.positions.get("eye2X"), 
            this.positions.get("eye2Y"),
            this.sizes.get("eye"),
            this.faceColor);
        allParts.add(this.mouth);
        allParts.add(this.mouthNegative);
        allParts.add(this.mouthNegative2);
        allParts.add(this.eye1);
        allParts.add(this.eye2);
    }
    
    /**
     * Constructs the shapes for the clothes of the snowperson.
     */
    private void makeClothes()
    {
        this.button1 = new ComplexCircle(
            this.positions.get("button1X"), 
            this.positions.get("button1Y"),
            this.sizes.get("button1"), 
            this.clothesColor);
        this.button2 = new ComplexCircle(
            this.positions.get("button2X"), 
            this.positions.get("button2Y"),
            this.sizes.get("button2"), 
            this.clothesColor);
        this.button3 = new ComplexCircle(
            this.positions.get("button3X"), 
            this.positions.get("button3Y"),
            this.sizes.get("button3"), 
            this.clothesColor);
        allParts.add(this.button1);
        allParts.add(this.button2);
        allParts.add(this.button3);
    }
    
    /**
     * Constructs a hashmap of snowperson parts to their sizes.
     * { String part : int size }
     * @param size the size of the snowperson (abdomen diameter)
     *      used to proportion the sizes of the parts.
     * @return the hashmap
     */
    protected void getSizes()
    {
        this.sizes = new HashMap<String, Integer>();
        // Body sizes
        sizes.put("abdomen", (int) (1.0 * size));
        sizes.put("thorax", (int) (0.70 * size));
        sizes.put("head", (int) (0.50 * size));
        int outlineWidth = (int) (.05 * sizes.get("abdomen"));
        sizes.put("abdomenOutline", sizes.get("abdomen") + outlineWidth);
        sizes.put("thoraxOutline", sizes.get("thorax") + outlineWidth);
        sizes.put("headOutline", sizes.get("head") + outlineWidth);
        
        // face sizes
        sizes.put("mouth", (int) (0.26 * size));
        sizes.put("eye", (int) (0.10 * size));
        
        // arm sizes
        sizes.put("hand", (int) (0.20 * size));
        sizes.put("arm1Height", (int) (0.48 * size));
        sizes.put("arm1Width", (int) (0.88 * size));
        sizes.put("forearm1Height", (int) (0.58 * size));
        sizes.put("forearm1Width", (int) (0.88 * size));
        sizes.put("arm2Height", (int) (0.38 * size));
        sizes.put("arm2Width", (int) (1.0 * size));
        sizes.put("forearm2Height", (int) (0.38 * size));
        sizes.put("forearm2Width", (int) (1.0 * size));
        
        // clothes sizes
        sizes.put("button1", (int) (0.12 * size));
        sizes.put("button2", (int) (0.12 * size));
        sizes.put("button3", (int) (0.12 * size));
        
        for (Map.Entry<String, Integer> entry : this.sizes.entrySet()) 
        {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value <= 0)
            {
                this.sizes.put(key, 1);
            }
        }
    }
    
    /**
     * Constructs a hashmap of snowperson parts to their coordinate locations.
     * { String partX : int xCoordinate,
     *   String partY : int yCoordinate }
     * @param size the size of the snowperson (abdomen diameter)
     *      used to proportion the positions of the parts.
     * @param x the x coordinate for the center of the snowperson
     * @param y the y coordinate for the bottom of the snowperson
     * @return the hashmap
     */
    protected void getPositions()
    {
        positions = new HashMap<String, Integer>();
        int x = this.xPos;
        int y = this.yPos;
            
        // Body positions
        positions.put("abdomenX", x);
        positions.put("abdomenY", y);
        positions.put("thoraxX", x);
        positions.put("thoraxY", positions.get("abdomenY") 
            - (int) (this.sizes.get("abdomen") * 0.9));
        positions.put("headX", x);
        positions.put("headY", positions.get("thoraxY") 
            - (int) (this.sizes.get("thorax") * 0.9));
        positions.put("abdomenOutlineX", x);
        positions.put("abdomenOutlineY", positions.get("abdomenY") 
            + ((this.sizes.get("abdomenOutline") - this.sizes.get("abdomen")) / 2));
        positions.put("thoraxOutlineX", x);
        positions.put("thoraxOutlineY", positions.get("thoraxY") 
            + ((this.sizes.get("thoraxOutline") - this.sizes.get("thorax")) / 2));
        positions.put("headOutlineX", x);
        positions.put("headOutlineY", positions.get("headY") 
            + ((this.sizes.get("headOutline") - this.sizes.get("head")) / 2));
        
        // face positions
        positions.put("mouthX", x);
        positions.put("mouthY", positions.get("headY") 
            - (int) (this.sizes.get("head") * 0.16));
        positions.put("mouthNegative1X", x);
        positions.put("mouthNegative1Y", positions.get("mouthY") 
            - (int) (this.sizes.get("head") * 0.12));
        positions.put("mouthNegative2X", x);
        positions.put("mouthNegative2Y", positions.get("mouthY") 
            - (int) (this.sizes.get("head") * 0.2));
        positions.put("eye1X", x - (int) (this.sizes.get("head") * 0.18));
        positions.put("eye1Y", positions.get("headY") 
            - (int) (this.sizes.get("head") * 0.55));
        positions.put("eye2X", x + (int) (this.sizes.get("head") * 0.18));
        positions.put("eye2Y", positions.get("headY") 
            - (int) (this.sizes.get("head") * 0.55));
        // clothes positions
        positions.put("button1X", positions.get("abdomenX"));
        positions.put("button1Y", positions.get("thoraxY"));
        positions.put("button2X", positions.get("abdomenX"));
        positions.put("button2Y", positions.get("thoraxY") 
            - (int) (this.sizes.get("thorax") * 0.3));
        positions.put("button3X", positions.get("abdomenX"));
        positions.put("button3Y", positions.get("thoraxY") 
            - (int) (this.sizes.get("thorax") * 0.6));
    }
}
