public class Quadrilateral extends Shape {

  private int[][] points = new int[4][2];

  public Quadrilateral (int[][] coordinates) {
    for(int i=0;i<4;i++) {
      for(int j=0;j<2;j++) {
        this.points[i][j] = coordinates[i][j];
      }
    }
  }


}
