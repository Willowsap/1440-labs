/**
 * Creates a square.
 *
 * @author Willow Sapphire
 * @version 6/20/2019
 */
public class ComplexSquare extends ComplexShape
{
    private Square simpleSquare;
    
    /**
     * Gathers information for the square and constructs it.
     * Does not display it.
     * @param xPos the x coordinate for the center of the square.
     * @param yPos the y coordinate for the bottom of the square.
     * @param size the height & width of the square.
     * @param color the color of the square.
     */
    public ComplexSquare(int xPos, int yPos, int size, String color)
    {
        super(xPos, yPos);
        this.height = size;
        this.width = size;
        this.simpleSquare = new Square();
        this.simpleSquare.setSize(size);
        this.simpleSquare.setxPosition(xPos - this.width / 2);
        this.simpleSquare.setyPosition(yPos - this.height);
        this.simpleSquare.setColor(color);
    }
    
    // Methods below this are from the original shapes
    
    /**
     * Make this square visible.
     */
    public void makeVisible()
    {
        simpleSquare.makeVisible();
    }
    
    /**
     * Make this square invisible.
     */
    public void makeInvisible()
    {
        simpleSquare.makeInvisible();
    }
    
    /**
     * Move this square a few pixels to the right.
     */
    public void moveRight()
    {
        this.simpleSquare.moveRight();
    }

    /**
     * Move this square a few pixels to the left.
     */
    public void moveLeft()
    {
        this.simpleSquare.moveLeft();
    }

    /**
     * Move this square a few pixels up.
     */
    public void moveUp()
    {
        this.simpleSquare.moveUp();
    }

    /**
     * Move this square a few pixels down.
     */
    public void moveDown()
    {
        this.simpleSquare.moveDown();
    }


    /**
     * Move this square horizontally.
     * @param distance The distance in pixels to move this square horizontally.
     */
    public void moveHorizontal(int distance)
    {
        this.simpleSquare.moveHorizontal(distance);
    }


    /**
     * Move this square vertically.
     * @param distance The distance in pixels to move this square vertically.
     */
    public void moveVertical(int distance)
    {
        this.simpleSquare.moveVertical(distance);
    }


    /**
     * SLOWLY move this square horizontally.
     * @param distance The distance in pixels to move this square horizontally.
     */
    public void slowMoveHorizontal(int distance)
    {
        this.simpleSquare.slowMoveHorizontal(distance);
    }


    /**
     * SLOWLY move this square vertically.
     * @param distance The distance in pixels to move this square vertically.
     */
    public void slowMoveVertical(int distance)
    {
        this.simpleSquare.slowMoveVertical(distance);
    }

    
    /**
     * Change the size of this square. 
     * If the newDiameter is less than zero, the square will not be visible.
     * @param newDiameter Change this square's diameter to this given value.
     */
    public void changeSize(int newDiameter)
    {
        this.simpleSquare.changeSize(newDiameter);
    }


    /**
     * Change the color of this square. 
     * Valid colors are "red", "yellow", "blue", "green", "magenta", 
     * "black" and "white".
     * If an unknown color is used the square will be black.
     * @param newColor The new color of this square.
     */
    public void changeColor(String newColor)
    {
        this.simpleSquare.changeColor(newColor);
    }
    
    /**
     * The accessor for getting this square's color.
     * @return Returns this square's color as a String.
     */
    public String getColor()
    {
        return this.simpleSquare.getColor();
    }


    /**
     * The mutator for setting this square's color.
     * Valid colors are "red", "yellow", "blue", "green", "magenta", 
     * "black" and "white".
     * @param color The new color for this square.
     */
    public void setColor(String color)
    {
        this.simpleSquare.setColor(color);
    }

    
    /**
     * The accessor for getting this square's visiblility.
     * @return Returns this square's isVisible field as a boolean.
     * True means this square is visible.
     * False means this square is not visible. 
     */
    public boolean getIsVisible()
    {
        return this.simpleSquare.getIsVisible();
    }


    /**
     * The mutator for setting this square's visiblility.
     * @param isVisible True means draw this square to the screen.
     * False means erase this square from the screen.
     */
    public void setIsVisible(boolean isVisible)
    {
        this.simpleSquare.setIsVisible(isVisible);
    }

}
