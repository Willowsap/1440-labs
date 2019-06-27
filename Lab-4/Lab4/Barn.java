import java.util.HashMap;
/**
* Constructs a beautiful barn.
*
* @author Willow Sapphire
* @version 6/20/2019
*/
public class Barn extends ComplexSceneObject
{
    private int width;
    private String wallColor;
    private String roofColor;
    private String doorColor;
    private ComplexSquare wallRight;
    private ComplexSquare wallLeft;
    private ComplexSquare doorRight;
    private ComplexSquare doorLeft;
    private ComplexTriangle roof;
    
    /**
     * Collects and calculates all required information for the barn.
     * Builds the barn but does not display it.
     * @param xPos the x coordinate at which to place the barn
     * @param yPos the y coordinate at which to place the bottom of the barn
     * @param width the width of the barn
     * @param wallColor the color of the walls of the barn
     * @param roofColor the color of the roof of the barn
     * @param doorColor the color of the doors of the barn
     */
    public Barn(int xPos, int yPos, int width, String wallColor, 
        String roofColor, String doorColor) 
    {
        super(xPos, yPos);
        this.width = width;
        this.wallColor = wallColor;
        this.roofColor = roofColor;
        this.doorColor = doorColor;
        this.getSizes();
        this.getPositions();
        this.build();
    }
    
    /**
     * Builds the shapes for the barn.
     */
    protected void build()
    {
       
        this.wallRight = new ComplexSquare(
            this.positions.get("wallRightX"),
            this.positions.get("wallRightY"),
            this.sizes.get("wall"),
            this.wallColor);
        this.wallLeft = new ComplexSquare(
            this.positions.get("wallLeftX"),
            this.positions.get("wallLeftY"),
            this.sizes.get("wall"),
            this.wallColor);
        this.doorRight = new ComplexSquare(
            this.positions.get("doorRightX"),
            this.positions.get("doorRightY"),
            this.sizes.get("door"),
            this.doorColor);
        this.doorLeft = new ComplexSquare(
            this.positions.get("doorLeftX"),
            this.positions.get("doorLeftY"),
            this.sizes.get("door"),
            this.doorColor);
        this.roof = new ComplexTriangle(
            this.positions.get("roofX"), 
            this.positions.get("roofY"),
            this.sizes.get("roofHeight"),
            this.sizes.get("roofWidth"),
            this.roofColor); 
        this.allParts.add(wallRight);
        this.allParts.add(wallLeft);
        this.allParts.add(doorRight);
        this.allParts.add(doorLeft);
        this.allParts.add(roof);
    }
    
    /**
     * Creates a hashmap of barn parts to their sizes.
     * { String barnPart : int size }
     */
    protected void getSizes()
    {
        this.sizes = new HashMap<String, Integer>();
        this.sizes.put("width", this.width);
        this.sizes.put("wall", this.width / 2);
        this.sizes.put("door", this.width / 4);
        this.sizes.put("roofWidth", (int) (this.width * 1.2));
        this.sizes.put("roofHeight", (int) (this.width * 0.6));
    }
    
    /**
     * Creates a hashmap of barn parts to their coordinates.
     * { String barnPartX : int xCoordinate,
     *   String barnPartY : int yCoordinate }
     */
    protected void getPositions()
    {
        this.positions = new HashMap<String, Integer>();
        this.positions.put("wallRightX", this.xPos 
            - this.sizes.get("width") / 2 
            + this.sizes.get("wall") / 2 + 1);
        this.positions.put("wallRightY", this.yPos);
        this.positions.put("wallLeftX", this.xPos 
            + this.sizes.get("width") / 2 
            - this.sizes.get("wall") / 2);
        this.positions.put("wallLeftY", this.yPos);
        this.positions.put("doorRightX", this.xPos 
            - this.sizes.get("width") / 4 
            + this.sizes.get("door") / 2 + 1);
        this.positions.put("doorRightY", this.yPos);
        this.positions.put("doorLeftX", this.xPos 
            + this.sizes.get("width") / 4 
            - this.sizes.get("door") / 2);
        this.positions.put("doorLeftY", this.yPos);
        this.positions.put("roofX", this.xPos);
        this.positions.put("roofY", this.yPos 
            - this.sizes.get("width") / 2);
    }
}
