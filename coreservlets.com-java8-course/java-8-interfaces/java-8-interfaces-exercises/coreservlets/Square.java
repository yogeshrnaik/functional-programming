package coreservlets;

public class Square implements RegularPolygon {
  private double sideLength;
  
  public Square(double sideLength) {
    this.sideLength = Math.abs(sideLength);
  }

  @Override
  public int getNumSides() {
    return(4);
  }

  @Override
  public double getSideLength() {
    return(sideLength);
  }
  
  @Override
  public String toString() {
    return(String.format("Square with side length=%6.3f, perimeter=%6.3f, and interior angle %5.3f radians.", 
           sideLength, getPerimeter(), getInteriorAngle()));
  }
}
