/**
 * Creates a circle.
 *
 * @author Willow Sapphire
 * @version 6/20/2019
 */
public class ComplexCircle extends ComplexShape
{
    private Circle simpleCircle;
    
    /**
     * Gathers information about the circle.
     * Does not display the circle.
     * @param xPos the x coordinate for the center of the circle.
     * @param yPos the y position for the bottom of the circle.
     * @param diameter the diameter of the circle.
     * @param color the color of the circle.
     */
    public ComplexCircle(int xPos, int yPos, int diameter, String color)
    {
        super(xPos, yPos);
        this.height = diameter;
        this.width = diameter;
        this.simpleCircle = new Circle();
        this.simpleCircle.setDiameter(diameter);
        this.simpleCircle.setxPosition(xPos - width / 2);
        this.simpleCircle.setyPosition(yPos - height);
        this.simpleCircle.setColor(color);
    }
    
    /**
     * Accessor method for the diameter of the circle.
     * @return the diameter of the circle.
     */
    public int getDiameter()
    {
        return this.simpleCircle.getDiameter();
    }
    
    /**
     * Mutator method for the diameter of the circle.
     * @param diameter the new diameter for the circle.
     */
    public void setDiameter(int diameter)
    {
        this.simpleCircle.setDiameter(diameter);
    }
    
    // Methods below this are from the original shapes
    
    /**
     * Make this circle visible.
     */
    public void makeVisible()
    {
        simpleCircle.makeVisible();
    }
    
    /**
     * Make this circle invisible.
     */
    public void makeInvisible()
    {
        simpleCircle.makeInvisible();
    }
    
    /**
     * Move this circle a few pixels to the right.
     */
    public void moveRight()
    {
        this.simpleCircle.moveRight();
    }

    /**
     * Move this circle a few pixels to the left.
     */
    public void moveLeft()
    {
        this.simpleCircle.moveLeft();
    }

    /**
     * Move this circle a few pixels up.
     */
    public void moveUp()
    {
        this.simpleCircle.moveUp();
    }

    /**
     * Move this circle a few pixels down.
     */
    public void moveDown()
    {
        this.simpleCircle.moveDown();
    }


    /**
     * Move this circle horizontally.
     * @param distance The distance in pixels to move this circle horizontally.
     */
    public void moveHorizontal(int distance)
    {
        this.simpleCircle.moveHorizontal(distance);
    }


    /**
     * Move this circle vertically.
     * @param distance The distance in pixels to move this circle vertically.
     */
    public void moveVertical(int distance)
    {
        this.simpleCircle.moveVertical(distance);
    }


    /**
     * SLOWLY move this circle horizontally.
     * @param distance The distance in pixels to move this circle horizontally.
     */
    public void slowMoveHorizontal(int distance)
    {
        this.simpleCircle.slowMoveHorizontal(distance);
    }


    /**
     * SLOWLY move this circle vertically.
     * @param distance The distance in pixels to move this circle vertically.
     */
    public void slowMoveVertical(int distance)
    {
        this.simpleCircle.slowMoveVertical(distance);
    }

    
    /**
     * Change the size of this circle. 
     * If the newDiameter is less than zero, the circle will not be visible.
     * @param newDiameter Change this circle's diameter to this given value.
     */
    public void changeSize(int newDiameter)
    {
        this.simpleCircle.changeSize(newDiameter);
    }


    /**
     * Change the color of this circle. 
     * Valid colors are "red", "yellow", "blue", "green", "magenta", 
     * "black" and "white".
     * If an unknown color is used the circle will be black.
     * @param newColor The new color of this circle.
     */
    public void changeColor(String newColor)
    {
        this.simpleCircle.changeColor(newColor);
    }
    
    /**
     * The accessor for getting this circle's color.
     * @return Returns this circle's color as a String.
     */
    public String getColor()
    {
        return this.simpleCircle.getColor();
    }


    /**
     * The mutator for setting this circle's color.
     * Valid colors are "red", "yellow", "blue", "green", "magenta", 
     * "black" and "white".
     * @param color The new color for this circle.
     */
    public void setColor(String color)
    {
        this.simpleCircle.setColor(color);
    }

    
    /**
     * The accessor for getting this circle's visiblility.
     * @return Returns this circle's isVisible field as a boolean.
     * True means this circle is visible.
     * False means this circle is not visible. 
     */
    public boolean getIsVisible()
    {
        return this.simpleCircle.getIsVisible();
    }


    /**
     * The mutator for setting this circle's visiblility.
     * @param isVisible True means draw this circle to the screen.
     * False means erase this circle from the screen.
     */
    public void setIsVisible(boolean isVisible)
    {
        this.simpleCircle.setIsVisible(isVisible);
    }

}
