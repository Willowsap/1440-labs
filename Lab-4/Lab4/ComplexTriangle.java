/**
 * Creates a triangle.
 *
 * @author Willow Sapphire
 * @version 6/20/2019
 */
public class ComplexTriangle extends ComplexShape
{
    private Triangle simpleTriangle;
    
    /**
     * Gathers information for the triangle and constructs it.
     * Does not display it.
     * @param xPos the x coordinate for the center of the triangle.
     * @param yPos the y coordinate for the bottom of the triangle.
     * @param height the height of the triangle.
     * @param width the width of the triangle.
     * @param color the color of the triangle.
     */
    public ComplexTriangle(int xPos, int yPos, 
        int height, int width, String color)
    {
        super(xPos, yPos);
        this.height = height;
        this.width = width;
        this.simpleTriangle = new Triangle();
        this.simpleTriangle.setHeight(height);
        this.simpleTriangle.setWidth(width);
        this.simpleTriangle.setxPosition(xPos);
        this.simpleTriangle.setyPosition(yPos - height);
        this.simpleTriangle.setColor(color);
    }
    
    // Methods below this are from the original shapes
    
    /**
     * Make this triangle visible.
     */
    public void makeVisible()
    {
        simpleTriangle.makeVisible();
    }
    
    /**
     * Make this triangle invisible.
     */
    public void makeInvisible()
    {
        simpleTriangle.makeInvisible();
    }
    
    /**
     * Move this triangle a few pixels to the right.
     */
    public void moveRight()
    {
        this.simpleTriangle.moveRight();
    }

    /**
     * Move this triangle a few pixels to the left.
     */
    public void moveLeft()
    {
        this.simpleTriangle.moveLeft();
    }

    /**
     * Move this triangle a few pixels up.
     */
    public void moveUp()
    {
        this.simpleTriangle.moveUp();
    }

    /**
     * Move this triangle a few pixels down.
     */
    public void moveDown()
    {
        this.simpleTriangle.moveDown();
    }


    /**
     * Move this triangle horizontally.
     * @param distance
     *      The distance to move this triangle horizontally.
     */
    public void moveHorizontal(int distance)
    {
        this.simpleTriangle.moveHorizontal(distance);
    }


    /**
     * Move this triangle vertically.
     * @param distance The distance  to move this triangle vertically.
     */
    public void moveVertical(int distance)
    {
        this.simpleTriangle.moveVertical(distance);
    }


    /**
     * SLOWLY move this triangle horizontally.
     * @param distance The distance to move this triangle horizontally.
     */
    public void slowMoveHorizontal(int distance)
    {
        this.simpleTriangle.slowMoveHorizontal(distance);
    }


    /**
     * SLOWLY move this triangle vertically.
     * @param distance The distance to move this triangle vertically.
     */
    public void slowMoveVertical(int distance)
    {
        this.simpleTriangle.slowMoveVertical(distance);
    }

    /**
     * Change the color of this triangle. 
     * Valid colors are "red", "yellow", "blue", "green", "magenta", 
     * "black" and "white".
     * If an unknown color is used the triangle will be black.
     * @param newColor The new color of this triangle.
     */
    public void changeColor(String newColor)
    {
        this.simpleTriangle.changeColor(newColor);
    }
    
    /**
     * The accessor for getting this triangle's color.
     * @return Returns this triangle's color as a String.
     */
    public String getColor()
    {
        return this.simpleTriangle.getColor();
    }


    /**
     * The mutator for setting this triangle's color.
     * Valid colors are "red", "yellow", "blue", "green", "magenta", 
     * "black" and "white".
     * @param color The new color for this triangle.
     */
    public void setColor(String color)
    {
        this.simpleTriangle.setColor(color);
    }

    
    /**
     * The accessor for getting this triangle's visiblility.
     * @return Returns this triangle's isVisible field as a boolean.
     * True means this triangle is visible.
     * False means this triangle is not visible. 
     */
    public boolean getIsVisible()
    {
        return this.simpleTriangle.getIsVisible();
    }


    /**
     * The mutator for setting this triangle's visiblility.
     * @param isVisible True means draw this triangle to the screen.
     * False means erase this triangle from the screen.
     */
    public void setIsVisible(boolean isVisible)
    {
        this.simpleTriangle.setIsVisible(isVisible);
    }

}
