package project1;
//Written by Felix Agene agene001
import java.awt.Color;
public class Triangle {
    //initializes (x,y) coordinate, color, and width and height of triangle
    double xPos;
    double yPos;
    double width;
    double height;
    Color triangleColor;
    //constructor
    public Triangle(double initX, double initY,double initWidth,double initHeight){
        xPos = initX;
        yPos = initY;
        width = initWidth;
        height = initHeight;
    }
    //getter and setter methods for color, (x,y) position, height and width
    //also method to calculate perimeter and area
    public double calculatePerimeter(){
        double fac = width/2;
        double cSqr = Math.pow(fac,2) + Math.pow(height,2);
        double c = Math.sqrt(cSqr);
        return (c * 2) + width;
    }
    public double calculateArea(){
        return (width * height) / 2.0;
    }
    public void setColor(Color newColor){
        triangleColor = newColor;
    }
    public Color getColor(){
        return triangleColor;
    }
    public void setPos(double newXPos,double newYPos){
        xPos = newXPos;
        yPos = newYPos;
    }
    public void setHeight(double newHeight){
        height = newHeight;

    }
    public void setWidth(double newWidth){
        width = newWidth;
    }
    public double getXPos(){
        return xPos;
    }
    public double getYPos(){
        return yPos;
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
  
}

