
/**
 * CS 1440 - Lab 1
 * The goal of this program is to create a scene with a snowperson
 * using the classes provided
 *
 * Stored at repository: https://github.com/Willowsap/1440-labs/lab-1
 *
 * @author Willow
 */
public class PictureCreator {

	public static void main(String[] args) {
		/*
		 * Declare background objects.
		 */
		Square sky = new Square();
		Square ground = new Square();
		Circle moon = new Circle();
		Circle moonNegative = new Circle();

		/*
		 * Declare snowperson objects.
		 */
		Circle abdomen 					= new Circle();
		Circle abdomenBorder 			= new Circle();
		Circle thorax 					= new Circle();
		Circle head 					= new Circle();
		Circle mouth					= new Circle();
		Circle mouthNegative			= new Circle();
		Square mouthNegativeTwo			= new Square();
		Circle eyeOne 					= new Circle();
		Circle eyeTwo 					= new Circle();
		Triangle armOne 				= new Triangle();
		Triangle armOneNegative 		= new Triangle();
		Triangle foreArmOne 			= new Triangle();
		Triangle foreArmOneNegative 	= new Triangle();
		Circle handOne					= new Circle();
		Triangle armTwo					= new Triangle();
		Triangle armTwoNegative 		= new Triangle();
		Triangle foreArmTwo 			= new Triangle();
		Triangle foreArmTwoNegative 	= new Triangle();
		Circle handTwo					= new Circle();
		Circle buttonOne				= new Circle();
		Circle buttonTwo				= new Circle();
		Circle buttonThree				= new Circle();
		/*
		 * Assign colors to each background object.
		 */
		sky.setColor("black");
		ground.setColor("white");
		moon.setColor("white");
		moonNegative.setColor("black");
		/*
		 * Assign sizes to each background object.
		 */
		sky.setSize(300);
		ground.setSize(300);
		moon.setDiameter(60);
		moonNegative.setDiameter(60);
		/*
		 * Assign positions to each background object.
		 */
		sky.setxPosition(0);
		sky.setyPosition(-100);
		ground.setxPosition(0);
		ground.setyPosition(200);
		moon.setxPosition(40);
		moon.setyPosition(40);
		moonNegative.setxPosition(50);
		moonNegative.setyPosition(45);

		/*
		 * Assign colors to each snowperson object.
		 */
		abdomen.setColor("white");
		abdomenBorder.setColor("black");
		thorax.setColor("white");
		head.setColor("white");
		mouth.setColor("black");
		mouthNegative.setColor("white");
		mouthNegativeTwo.setColor("white");
		eyeOne.setColor("black");
		eyeTwo.setColor("black");
		armOne.setColor("white");
		armOneNegative.setColor("black");
		foreArmOne.setColor("white");
		foreArmOneNegative.setColor("black");
		handOne.setColor("white");
		armTwo.setColor("white");
		armTwoNegative.setColor("black");
		foreArmTwo.setColor("white");
		foreArmTwoNegative.setColor("black");
		handTwo.setColor("white");
		buttonOne.setColor("magenta");
		buttonTwo.setColor("magenta");
		buttonThree.setColor("magenta");
		/*
		 * Assign sizes to each snowperson object.
		 */
		abdomen.setDiameter(100);
		abdomenBorder.setDiameter(106);
		thorax.setDiameter(70);
		head.setDiameter(50);
		mouth.setDiameter(26);
		mouthNegative.setDiameter(26);
		mouthNegativeTwo.setSize(26);
		eyeOne.setDiameter(10);
		eyeTwo.setDiameter(10);
		armOne.setHeight(48);
		armOne.setWidth(88);
		armOneNegative.setHeight(48);
		armOneNegative.setWidth(88);
		foreArmOne.setHeight(58);
		foreArmOne.setWidth(88);
		foreArmOneNegative.setHeight(58);
		foreArmOneNegative.setWidth(88);
		handOne.setDiameter(20);
		armTwo.setHeight(38);
		armTwo.setWidth(100);
		armTwoNegative.setHeight(38);
		armTwoNegative.setWidth(100);
		foreArmTwo.setHeight(38);
		foreArmTwo.setWidth(100);
		foreArmTwoNegative.setHeight(38);
		foreArmTwoNegative.setWidth(100);
		handTwo.setDiameter(20);
		buttonOne.setDiameter(12);
		buttonTwo.setDiameter(12);
		buttonThree.setDiameter(12);
		/*
		 * Assign positions to each snowperson object.
		 */
		abdomen.setxPosition(150);
		abdomen.setyPosition(160);
		abdomenBorder.setxPosition(147);
		abdomenBorder.setyPosition(157);
		thorax.setxPosition(165);
		thorax.setyPosition(110);
		head.setxPosition(175);
		head.setyPosition(70);
		mouth.setxPosition(188);
		mouth.setyPosition(88);
		mouthNegative.setxPosition(188);
		mouthNegative.setyPosition(82);
		mouthNegativeTwo.setxPosition(188);
		mouthNegativeTwo.setyPosition(78);
		eyeOne.setxPosition(188);
		eyeOne.setyPosition(85);
		eyeTwo.setxPosition(204);
		eyeTwo.setyPosition(85);
		armOne.setxPosition(136);
		armOne.setyPosition(82);
		armOneNegative.setxPosition(128);
		armOneNegative.setyPosition(82);
		foreArmOne.setxPosition(176);
		foreArmOne.setyPosition(30);
		foreArmOneNegative.setxPosition(184);
		foreArmOneNegative.setyPosition(30);
		handOne.setxPosition(174);
		handOne.setyPosition(16);
		armTwo.setxPosition(228);
		armTwo.setyPosition(124);
		armTwoNegative.setxPosition(220);
		armTwoNegative.setyPosition(124);
		foreArmTwo.setxPosition(272);
		foreArmTwo.setyPosition(158);
		foreArmTwoNegative.setxPosition(280);
		foreArmTwoNegative.setyPosition(158);
		handTwo.setxPosition(232);
		handTwo.setyPosition(176);
		buttonOne.setxPosition(195);
		buttonOne.setyPosition(130);
		buttonTwo.setxPosition(195);
		buttonTwo.setyPosition(150);
		buttonThree.setxPosition(195);
		buttonThree.setyPosition(170);
		/*
		 * Make the scene visible.
		 * note: the order here is very important since objects
		 * made visible later will overlap previous objects.
		 */
		sky.makeVisible();
		ground.makeVisible();
		moon.makeVisible();
		moonNegative.makeVisible();

		armOne.makeVisible();
		armOneNegative.makeVisible();
		foreArmOne.makeVisible();
		foreArmOneNegative.makeVisible();

		armTwo.makeVisible();
		armTwoNegative.makeVisible();
		foreArmTwo.makeVisible();
		foreArmTwoNegative.makeVisible();

		abdomenBorder.makeVisible();
		abdomen.makeVisible();
		thorax.makeVisible();
		head.makeVisible();
		mouth.makeVisible();
		mouthNegative.makeVisible();
		mouthNegativeTwo.makeVisible();
		eyeOne.makeVisible();
		eyeTwo.makeVisible();
		buttonOne.makeVisible();
		buttonTwo.makeVisible();
		buttonThree.makeVisible();

		handOne.makeVisible();
		handTwo.makeVisible();
	}

}
