/**
 * Creates a scene using simple shapes.
 *
 * @author Willow Sapphire
 * @version 6/20/2019
 */
public class Scene
{
    public static final int CANVAS_CENTER = 150;
    public static final int HOUSE1_CENTER = 75;
    public static final int HOUSE2_CENTER = 225;
    public static final int HOUSE1_X_OFFSET = HOUSE1_CENTER - CANVAS_CENTER;
    public static final int HOUSE1_Y_OFFSET = -15;
    public static final int HOUSE2_X_OFFSET = HOUSE2_CENTER - CANVAS_CENTER;
    public static final int HOUSE2_Y_OFFSET = -45;
    public static final int SUN_CENTER = 45;
    public static final int SUN_DIAMETER = 50;
    public static final int SUN_X_POS = SUN_CENTER - SUN_DIAMETER / 2;
    public static final int SUN_Y_POS = 10;
    public static final int SUN_MOVE_AMOUNT = 300;
    public static final int MOON_DIAMETER = 50;
    public static final int MOON_X_POS = -MOON_DIAMETER;
    public static final int MOON_Y_POS = 10;
    public static final int MOON_MOVE_AMOUNT = -MOON_X_POS 
        + HOUSE2_CENTER - MOON_DIAMETER / 2;
    private House house1;
    private House house2;
    private Circle sun;
    private Circle moon;
    
    /**
     * Constructs the scene.
     */
    public Scene()
    {
        house1 = new House();
        house2 = new House();
        sun = new Circle();
        moon = new Circle();
        
        house1.changeWallColor("red");
        house1.changeRoofColor("green");
        house1.changeWindowColor("blue");
        house2.changeWallColor("blue");
        house2.changeRoofColor("black");
        house2.changeWindowColor("yellow");
        sun.setColor("yellow");
        
        house1.moveHorizontal(HOUSE1_X_OFFSET);
        house1.moveVertical(HOUSE1_Y_OFFSET);
        house2.moveHorizontal(HOUSE2_X_OFFSET);
        house2.moveVertical(HOUSE2_Y_OFFSET);
        
        sun.setDiameter(SUN_DIAMETER);
        sun.setxPosition(SUN_X_POS);
        sun.setyPosition(SUN_Y_POS);
        moon.setDiameter(MOON_DIAMETER);
        moon.setxPosition(MOON_X_POS);
        moon.setyPosition(MOON_Y_POS);
        
        house1.makeVisible();
        house2.makeVisible();
        sun.makeVisible();
        moon.makeVisible();
    }
    
    /**
     * Animates the scene.
     */
    public void animate()
    {
        sun.slowMoveHorizontal(SUN_MOVE_AMOUNT);
        moon.slowMoveHorizontal(MOON_MOVE_AMOUNT);
    }
    
    /**
     * It all starts here.
     * 
     * @param args command line arguments (unused).
     */
    public static void main(String[] args)
    {
        Scene scene = new Scene();
        scene.animate();
    }
}
