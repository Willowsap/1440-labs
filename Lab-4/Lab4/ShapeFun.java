/**
 * Playing with shapes for activity 1 of Lab 4.
 * CS 1440.
 *
 * @author Willow Sapphire
 * @version 6/20/2019
 */
public class ShapeFun
{   
    // added in case magic numbers were the issue
    private static final int SQUARE_HORZ_MOVE = -60;
    private static final int SQUARE_VERT_MOVE = -50;
    private static final int SQUARE_SIZE_CHANGE = 300;
        
    /**
     * It's all right here.
     * 
     * @param args command line arguments (unused).
     */
    public static void main(String[] args) 
    {
        
        Square square = new Square();
        Circle circle = new Circle();
        Triangle triangle = new Triangle();
        
        square.moveHorizontal(SQUARE_HORZ_MOVE);
        square.moveVertical(SQUARE_VERT_MOVE);
        square.changeSize(SQUARE_SIZE_CHANGE);
        square.changeColor("green");
        
        square.makeVisible();
        circle.makeVisible();
        triangle.makeVisible();

    }
}
