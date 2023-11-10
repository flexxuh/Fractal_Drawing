package project1;
// Written by Felix Agene agene001
// FractalDrawer class draws a fractal of a shape indicated by user input
import java.awt.Color;
import java.util.Scanner;
public class FractalDrawer {
    private double totalArea=0;  // member variable for tracking the total area
    public FractalDrawer() {}  // contructor
    // and determines which shapes to draw a fractal by calling appropriate helper function
    // drawFractal returns the area of the fractal
    public double drawFractal(String type) {

        // drawFractal creates a new Canvas object
        Canvas drawing = new Canvas(800,1800);
        int level = 1;
        //uses input from user to determine which fractal to create(or tell them not a valid option)
        switch(type){
            //creates inital rectangle object and adds its area to total, then sets color to blue
            //then draws object and starts recursive process by calling drawRectangleFractal
            case"rectangle":;
                Rectangle myRect = new Rectangle(700,250,250,250);
                totalArea = myRect.calculateArea();
                myRect.setColor(Color.BLUE);
                drawing.drawShape(myRect);
                drawRectangleFractal(myRect.getWidth(),myRect.getHeight(),myRect.getXPos(),myRect.getYPos(),Color.GREEN,drawing,level);
                return totalArea;
            //creates inital triangle object and adds its area to total, then sets color to blue
            //then draws object and starts recursive process by calling drawTriangleFractal
            case"triangle":;
                Triangle myTri = new Triangle(650,550,250,250);
                totalArea = myTri.calculateArea();
                myTri.setColor(Color.BLUE);
                drawing.drawShape(myTri);
                drawTriangleFractal(myTri.getWidth(), myTri.getHeight(), myTri.getXPos(), myTri.getYPos(), Color.GREEN, drawing, level);
                return totalArea;
            //creates inital circle object and adds its area to total, then sets color to blue
            //then draws object and starts recursive process by calling drawCircleFractal
            case"circle":;
                Circle myCircle = new Circle(800,400,200);
                totalArea = myCircle.calculateArea();
                myCircle.setColor(Color.BLUE);
                drawing.drawShape(myCircle);
                drawCircleFractal(myCircle.getRadius(),myCircle.getXPos(),myCircle.getYPos(),Color.GREEN,drawing,level);
                return totalArea;
            //if option is not one of 3 types, prints "not valid"
            default:;
                System.out.println("not a valid option(circle, triangle, or rectangle: )");
                return totalArea;
        }
    }

    // drawTriangleFractal draws a triangle fractal using recursive techniques
    public void drawTriangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level){
        //if statements check level of recursion and implements corresponding color to match and have varying colors
        if(level == 2)
            c = Color.RED;
        else if(level ==3)
            c = Color.CYAN;
        else if(level == 4)
            c = Color.PINK;
        else if(level == 5)
            c = Color.ORANGE;
        else if(level ==6)
            c = Color.BLACK;
        //base case, checks if recursion is at the 7th level
        if (level == 7)
            return;
        //creates 3 triangle objects at corner of initial triangle object and draws them if the level is less than 7
        //all with widths and heights half of the initial object and sets color to c and adds individual triangles areas to totalArea
        else if(level < 7){
            Triangle tri1 = new Triangle(x-width/2,y,width/2,height/2);
            tri1.setColor(c);
            can.drawShape(tri1);
            totalArea += tri1.calculateArea();
            Triangle tri2 = new Triangle(x+width,y,width/2,height/2);
            can.drawShape(tri2);
            tri2.setColor(c);
            totalArea += tri2.calculateArea();
            Triangle tri3 = new Triangle(x+width/4,y-height,width/2,height/2);
            can.drawShape(tri3);
            tri3.setColor(c);
            totalArea += tri3.calculateArea();
            //adds 1 to level without changing global level by using 4 new level variables.
            int level1 = level+1;
            int level2 = level+1;
            int level3 = level+1;
            //recursive part of function
            drawTriangleFractal(tri1.getWidth(),tri1.getHeight(),tri1.getXPos(),tri1.getYPos(),c,can,level1);
            drawTriangleFractal(tri2.getWidth(),tri2.getHeight(),tri2.getXPos(),tri2.getYPos(),c,can,level2);
            drawTriangleFractal(tri3.getWidth(),tri3.getHeight(),tri3.getXPos(),tri3.getYPos(),c,can,level3);
            }
        }

    // drawCircleFractal draws a circle fractal using recursive techniques
    public void drawCircleFractal(double radius, double x, double y, Color c, Canvas can, int level) {
        //if statements check level of recursion and implements corresponding color to match and have varying colors
        if(level == 2)
            c = Color.RED;
        else if(level ==3)
            c = Color.CYAN;
        else if(level == 4)
            c = Color.PINK;
        else if(level == 5)
            c = Color.ORANGE;
        else if(level ==6)
            c = Color.BLACK;
        //base case, checks if recursion is at the 7th level
        if (level == 7)
            return;
        //creates 4 circle objects at corner of initial circle object and draws them if the level is less than 7
        //all with radii half of the initial object and sets color to c and adds individual circles areas to totalArea
        else if(level<7){
            Circle circ1 = new Circle(x+radius,y+radius,radius/2);
            circ1.setColor(c);
            can.drawShape(circ1);
            totalArea += circ1.calculateArea();
            Circle circ2 = new Circle(x-radius,y+radius,radius/2);
            circ2.setColor(c);
            can.drawShape(circ2);
            totalArea += circ2.calculateArea();
            Circle circ3 = new Circle(x+radius,y-radius,radius/2);
            circ3.setColor(c);
            can.drawShape(circ3);
            totalArea += circ3.calculateArea();
            Circle circ4 = new Circle(x-radius,y-radius,radius/2);
            circ4.setColor(c);
            can.drawShape(circ4);
            totalArea += circ4.calculateArea();
            //adds 1 to level without changing global level by using 4 new level variables.
            int level1 = level+1;
            int level2 = level+1;
            int level3 = level+1;
            int level4 = level+1;
            //recursive part of function
            drawCircleFractal(circ1.getRadius(), circ1.getXPos(), circ1.getYPos(), c, can, level1 );
            drawCircleFractal(circ2.getRadius(), circ2.getXPos(), circ2.getYPos(), c, can, level2 );
            drawCircleFractal(circ3.getRadius(), circ3.getXPos(), circ3.getYPos(), c, can, level3 );
            drawCircleFractal(circ4.getRadius(), circ4.getXPos(), circ4.getYPos(), c, can, level4 );
        }
    }

    // drawRectangleFractal draws a rectangle fractal using recursive techniques
    public void drawRectangleFractal(double width, double height, double x, double y, Color c, Canvas can, int level) {
        //if statements check level of recursion and implements corresponding color to match and have varying colors
        if(level == 2)
            c = Color.RED;
        else if(level ==3)
            c = Color.CYAN;
        else if(level == 4)
            c = Color.PINK;
        else if(level == 5)
            c = Color.ORANGE;
        else if(level ==6)
            c = Color.BLACK;
        //base case, checks if recursion is at the 7th level
        if (level == 7)
            return;
        //creates 4 rectangle objects at corner of initial rectangle object and draws them if the level is less than 7
        //all with widths and heights half of the initial object and sets color to c and adds individual rectangles areas to totalArea
        else if (level < 7){
            Rectangle rec1 = new Rectangle(x-width/2.0,y-height/2.0,width/2.0,height/2.0);
            rec1.setColor(c);
            totalArea += rec1.calculateArea();
            Rectangle rec2 = new Rectangle(x+width,y-height/2.0,width/2.0,height/2.0);
            rec2.setColor(c);
            totalArea += rec2.calculateArea();
            Rectangle rec3 = new Rectangle(x-width/2.0,y+height,width/2.0,height/2.0);
            rec3.setColor(c);
            totalArea += rec3.calculateArea();
            Rectangle rec4 = new Rectangle(x+width,y+height,width/2.0,height/2.0);
            rec4.setColor(c);
            totalArea += rec4.calculateArea();
            can.drawShape(rec1);
            // adds 1 to level without changing global level by using 4 new level variables.
            int level1 = level+1;
            can.drawShape(rec2);
            int level2 = level+1;
            can.drawShape(rec3);
            int level3 = level+1;
            can.drawShape(rec4);
            int level4 = level+1;
            //recursive part of function
            drawRectangleFractal(rec3.getWidth(),rec3.getHeight(),rec3.getXPos(),rec3.getYPos(),c,can,level3);
            drawRectangleFractal(rec4.getWidth(),rec4.getHeight(),rec4.getXPos(),rec4.getYPos(),c,can,level4);
            drawRectangleFractal(rec1.getWidth(),rec1.getHeight(),rec1.getXPos(),rec1.getYPos(),c,can,level1);
            drawRectangleFractal(rec2.getWidth(),rec2.getHeight(),rec2.getXPos(),rec2.getYPos(),c,can,level2);   
        }
    }

    // main should ask user for shape input, and then draw the corresponding fractal.
    // should print area of fractal
    //creates fractal object and scanner object to ask what type of fractal user would likes
    public static void main(String[] args){
        FractalDrawer myFract = new FractalDrawer(); 
        Scanner myScanner = new Scanner(System.in);
        while(true){
            System.out.println("What Fractal would you like to draw.");
            String input = myScanner.nextLine().toLowerCase();
            System.out.println("Fractal area is: "+myFract.drawFractal(input));
            System.out.println("Would you like to draw another?");
            String playAgain = myScanner.nextLine().toLowerCase();
            if(playAgain.startsWith("n"))
                break;
        }
        myScanner.close();
        System.exit(0);
    }
    }
