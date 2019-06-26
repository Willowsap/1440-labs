/**
 * Builds a house out of resusable shapes.
 *
 * @author Willow Sapphire
 * @version 6/20/2019
 */
public class House
{
    public static final int HOUSE_CENTER = 150;
    public static final int GROUND = 300;
    
    public static final int WALL_SIZE = 100;
    public static final int ROOF_HEIGHT = 45;
    public static final int ROOF_WIDTH = 140;
    public static final int WINDOW_SIZE = 30;
    
    public static final int WALL_X_POSITION = HOUSE_CENTER - WALL_SIZE / 2;
    public static final int WALL_Y_POSITION = GROUND - WALL_SIZE;
    public static final int ROOF_X_POSITION = HOUSE_CENTER;
    public static final int ROOF_Y_POSITION = GROUND - WALL_SIZE - ROOF_HEIGHT;
    public static final int WINDOW_X_POSITION = 110;
    public static final int WINDOW_Y_POSITION = 225;
    
    private Square wall;
    private Triangle roof;
    private Square window;
    
    /**
     * Constructs a house based on default values.
     */
    public House()
    {
        wall = new Square();
        roof = new Triangle();
        window = new Square();
        
        wall.changeColor("red");
        roof.changeColor("black");
        window.changeColor("blue");
        
        wall.changeSize(WALL_SIZE);
        roof.changeSize(ROOF_HEIGHT, ROOF_WIDTH);
        window.changeSize(WINDOW_SIZE);
        
        wall.setxPosition(WALL_X_POSITION);
        wall.setyPosition(WALL_Y_POSITION);
        roof.setxPosition(ROOF_X_POSITION);
        roof.setyPosition(ROOF_Y_POSITION);
        window.setxPosition(WINDOW_X_POSITION);
        window.setyPosition(WINDOW_Y_POSITION);
        
        wall.makeVisible();
        roof.makeVisible();
        window.makeVisible();
    }
    
    /**
     * changes the roof's color.
     * @param newColor the new color to give the roof.
     */
    public void changeRoofColor(String newColor)
    {
        this.roof.changeColor(newColor);
    }
    
    /**
     * changes the wall's color.
     * @param newColor the new color to give the wall.
     */
    public void changeWallColor(String newColor)
    {
        this.wall.changeColor(newColor);
    }
    
    /**
     * changes the window's color.
     * @param newColor the new color to give the window.
     */
    public void changeWindowColor(String newColor)
    {
        this.window.changeColor(newColor);
    }
    
    /**
     * Moves the house along the x axis.
     * 
     * @param numPixelsToMove how far to move the house (in pixels).
     */
    public void moveHorizontal(int numPixelsToMove)
    {
        this.wall.moveHorizontal(numPixelsToMove);
        this.roof.moveHorizontal(numPixelsToMove);
        this.window.moveHorizontal(numPixelsToMove);
    }
    
    /**
     * Moves the house along the y axis.
     * 
     * @param numPixelsToMove how far to move the house (in pixels).
     */
    public void moveVertical(int numPixelsToMove)
    {
        this.wall.moveVertical(numPixelsToMove);
        this.roof.moveVertical(numPixelsToMove);
        this.window.moveVertical(numPixelsToMove);
    }
    
    /**
     * makes the house invisible.
     */
    public void makeInvisible()
    {
        this.wall.makeInvisible();
        this.roof.makeInvisible();
        this.window.makeInvisible();
    }
    
    /**
     * makes the house visible.
     */
    public void makeVisible()
    {
        this.wall.makeVisible();
        this.roof.makeVisible();
        this.window.makeVisible();
    }
    
    /**
     * It all starts here.
     * 
     * @param args command line arguments (unused).
     */
    public static void main(String[] args)
    {
        House house = new House();
    }
}
