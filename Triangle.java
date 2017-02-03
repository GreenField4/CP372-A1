public class Triangle extends Shape{

  private int[][] points = new int[3][2];
  private String type;


  public void setCoordinates(int[][] coordinates) {
    for(int i=0;i<3;i++) {
      for(int j=0;j<2;j++) {
        this.points[i][j] = coordinates[i][j];
      }
    }
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getType() {
    return this.type;
  }

  public int[][] getCoordinates() {
    return this.points;
  }

}
