public class Point extends Shape{

  private int[][] point = new int[1][2];

  public Point(int[][] coordinates) {
    this.point[0][0] = coordinates[0][0];
    this.point[0][1] = coordinates[0][1];
  }

  public int[][] getCoordinates() {
    return this.point;
  }

}
