public class ShapeTest {
  public static void main(String[] args) {
    Shape[] shapes = { new Circle(1.2),
                       new Rectangle(2.3, 3.4),
                       new Square(4.5) };
    System.out.println("Sum of areas: " +
                       ShapeUtils.sumAreas(shapes));
  }
}