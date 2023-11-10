package project1;
//Written by Felix Agene agene001
import java.awt.Color;
public class Circle {
    //initializes (x,y) coordinate, color, and radius of circle
    double pi = 3.14159265358979323;
    double xPos;
    double yPos;
    double radius;
    Color circleColor;
    //constructor
    public Circle(double initX, double initY, double initRadius) {
        xPos = initX;
        yPos = initY;
        radius = initRadius;

    }
    //getter and setter methods for color, (x,y) position, and radius
    //also method to calculate perimeter and area
    
    public double calculatePerimeter() {
        return (2 * pi * radius);
    }

    public double calculateArea() {
        return (pi * Math.pow(radius, 2));
    }
    public void setColor(Color newColor){
        circleColor = newColor;
    }
    public void setPos(double newXpos, double newYpos){
        xPos = newXpos;
        yPos = newYpos;
    }
    public void setRadius(double newRadius){
        radius = newRadius;
    }
    public Color getColor(){
        return circleColor;
    }
    public double getXPos(){
        return xPos;
    }
    public double getYPos(){
        return yPos;
    }
    public double getRadius(){
        return radius;
    }
}
