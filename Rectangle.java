package project1;
//Written by Felix Agene agene001
import java.awt.Color;
public class Rectangle {
    //initializes (x,y) coordinate, color, and width and height of rectangle
    double xPos;
    double yPos;
    double width;
    double height;
    Color rectangleColor;
    //constructor
    public Rectangle(double initX, double initY, double initWidth, double initHeight){
        xPos = initX;
        yPos = initY;
        width = initWidth; 
        height = initHeight;
    }
    //getter and setter methods for color, (x,y) position, height and width
    //also method to calculate perimeter and area
    public double calculatePerimeter(){
        return (2 * width) + (2 * height);
    }
    public double calculateArea(){
        return width * height;
    }
    public void setColor(Color newColor){
        rectangleColor = newColor;
    }
    public void setPos(double newX, double newY){
        xPos = newX;
        yPos = newY;
    }
    public void setWidth(double newWidth){
        width = newWidth;
    }
    public void setHeight(double newHeight){
        height = newHeight;
    }
    public Color getColor(){
        return rectangleColor;
    }
    public double getXPos(){
        return xPos;
    }
    public double getYPos(){
        return yPos;
    }
    public double getHeight(){
        return height;
    }
    public double getWidth(){
        return width;
    }
}
