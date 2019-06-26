/**
 * Adds utility to the basic shape classes provided.
 * Additionally makes all the shapes share an abstract type,
 * which allows for creating lists containing different types.
 * 
 * NOTE: All display and animate functions are still from
 * the original shapes.
 * I would consider it cheating to add new functionality there.
 * 
 * @author Willow Sapphire
 * @version 6/20/2019
 */
public abstract class ComplexShape
{
    protected int priorityLevel;
    protected int height;
    protected int width;
    protected int xPos;
    protected int yPos;
    
    /**
     * Gathers x and y coordinate for the shape.
     * @param xPos the x position for the center of the shape
     * @param yPos the y position for the bottom of the shape
     */
    public ComplexShape(int xPos, int yPos)
    {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    /**
     * The accessor for getting this object's priority level.
     * @return Returns the priority level
     */
    public int getPriority()
    {
        return this.priorityLevel;
    }
    
    /**
     * The accessor for getting this object's height.
     * @return Returns the height
     */
    public int getHeight()
    {
        return this.height;
    }
    
    /**
     * The accessor for getting this object's width.
     * @return Returns the width
     */
    public int getWidth()
    {
        return this.width;
    }
    
    /**
     * The accessor for getting this object's x position.
     * @return Returns the x coordinate
     */
    public int getX()
    {
        return this.xPos;
    }
    
    /**
     * The accessor for getting this object's y position.
     * @return Returns the y coordinate
     */
    public int getY()
    {
        return this.yPos;
    }
    
    /**
     * The mutator for setting this object's priority level.
     * @param priorityLevel the new priority level for the object
     */
    public void setPriority(int priorityLevel)
    {
        this.priorityLevel = priorityLevel;
    }

    /**
     * The mutator for setting this object's height.
     * @param height the new height for the object
     */
    public void setHeight(int height)
    {
        this.height = height;
    }
    
    /**
     * The mutator for setting this object's width.
     * @param width the new width for the object
     */
    public void setWidth(int width)
    {
        this.width = width;
    }
    
    /**
     * The mutator for setting this object's x position.
     * Places the object with its horizontal center at the given position.
     * @param xPos the new x coordinate for the object
     */
    public void setX(int xPos)
    {
        this.xPos = xPos;
    }
    
    /**
     * The mutator for setting this object's y position.
     * Places the object with its bottom at the given position.
     * @param yPos the new y coordinate for the object
     */
    public void setY(int yPos)
    {
        this.yPos = yPos;
    }
    
    // Methods below this are from the original shapes
    /**
     * Make this object visible.
     */
    public abstract void makeVisible();
    
    /**
     * Make this object invisible.
     */
    public abstract void makeInvisible();
    
    /**
     * Move this object a few pixels to the right.
     */
    public abstract void moveRight();

    /**
     * Move this object a few pixels to the left.
     */
    public abstract void moveLeft();

    /**
     * Move this object a few pixels up.
     */
    public abstract void moveUp();

    /**
     * Move this object a few pixels down.
     */
    public abstract void moveDown();

    /**
     * Move this object horizontally.
     * @param distance The distance in pixels to move this object horizontally.
     */
    public abstract void moveHorizontal(int distance);

    /**
     * Move this object vertically.
     * @param distance The distance in pixels to move this object vertically.
     */
    public abstract void moveVertical(int distance);

    /**
     * SLOWLY move this object horizontally.
     * @param distance The distance in pixels to move this object horizontally.
     */
    public abstract void slowMoveHorizontal(int distance);

    /**
     * SLOWLY move this object vertically.
     * @param distance The distance in pixels to move this object vertically.
     */
    public abstract void slowMoveVertical(int distance);

    /**
     * Change the color of this object. 
     * Valid colors are "red", "yellow", "blue", "green", "magenta", 
     * "black" and "white".
     * If an unknown color is used the object will be black.
     * @param newColor The new color of this object.
     */
    public abstract void changeColor(String newColor);

    /**
     * The accessor for getting this object's color.
     * @return Returns this object's color as a String.
     */
    public abstract String getColor();

    /**
     * The mutator for setting this object's color.
     * Valid colors are "red", "yellow", "blue", "green", "magenta", 
     * "black" and "white".
     * @param color The new color for this object.
     */
    public abstract void setColor(String color);
    
    /**
     * The accessor for getting this object's visiblility.
     * @return Returns this object's isVisible field as a boolean.
     * True means this object is visible.
     * False means this object is not visible. 
     */
    public abstract boolean getIsVisible();

    /**
     * The mutator for setting this object's visiblility.
     * @param isVisible True means draw this object to the screen.
     * False means erase this object from the screen.
     */
    public abstract void setIsVisible(boolean isVisible);
}
