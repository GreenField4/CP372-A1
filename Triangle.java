public class Triangle extends Shape{

  private int[][] points = new int[3][2];

  public Triangle(int[][] coordinates) {
    for(int i=0;i<3;i++) {
      for(int j=0;j<2;j++) {
        this.points[i][j] = coordinates[i][j];
      }
    }
  }

  public int[][] getCoordinates() {
    return this.points;
  }

}
