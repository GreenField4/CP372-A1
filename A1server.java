package A1net;

import java.io.* ;
import java.net.* ;
import java.util.* ;
import java.lang.Math;

public final class A1server {
	int isoright;
	static int equal;
	int iso;
	int right;
	int scale;
	int square;
	int rhom;
	int rec;
	int paral;
	int kite;
	int trap;
	int quad;
    public static void main(String argv[]) throws Exception {
		// Get the port number from the command line.
		int port = 8080;// new Integer(argv[0]).intValue();
		//	System.out.println(sss.charAt(0));
		// Establish the listen socket.
		ServerSocket socket = new ServerSocket(port);
		Dictionary<String, int[][]> type = new Hashtable<String, int[][]>();
		Dictionary<String, int[][]> point = new Hashtable<String, int[][]>();
		String out = "";
		String newline = "\n";
		// Process HTTP service requests in an infinite loop.
		while (true) {
		    // Listen for a TCP connection request.
		    Socket connection = socket.accept();
		    System.out.println(connection.getInetAddress());
		    OutputStream output = connection.getOutputStream();
		    InputStream input = connection.getInputStream();
		    BufferedReader in = new BufferedReader(new InputStreamReader(input));
		    while (true) {
			    String clientin = in.readLine();
			    System.out.println(clientin);
			    clientin = clientin.trim();
			    if (clientin.startsWith("T")) {
			    	out = getT(clientin);
			    } else if (clientin.startsWith("Q")) {
			    	out = getQ(clientin);
			    } else if (clientin.startsWith("P")) {
			    	out = getP(clientin);
			    } else if (clientin.startsWith("ALL")){
			    	out = getALL(clientin);
			    } else if (isNumeric(clientin.replace(" ",""))== false){
			    	out = "Sorry Invalid input";
			    	output.write(out.getBytes());
			    } else {
			    	if ((clientin.split(" ").length % 2) == 1){
			    		out = "Sorry Invalid input";
				    	output.write(out.getBytes());
				    	output.write(newline.getBytes());
			    	}else {
			    		int[][] points = stringToPoints(clientin.split(" "));
			    		out = pointsToShape(points);
			    		output.write(out.getBytes());
			    		output.write(newline.getBytes());
			    	}
			    }
		    }
		}
    }
    public static int[][]  stringToPoints(String[] points) {
    	int n = points.length;
    	int[][] grid = new int[n/2][2];
    	for (int i = 0; i < n/2; i++){
    		grid[i][0] = Integer.parseInt(points[2*i]);
    		grid[i][1] = Integer.parseInt(points[(2*i)+1]);
    	}
		return grid;
    }

    public static String pointsToShape (int[][] points){
    	int n = points.length;
    	String out = "";
    	if (n == 1){
    		out = pointToString(points);
    	} else if (n == 3){
    		out = triToString(points);
    	}
    	else if (n == 4){
    		out = quadToString(points);
    	} else {
    		out = "Sorry Invalid input";
    	}
    	return out;
    }

    public static String pointToString (int[][] point){
  		String out = "Point at cordinates ("+ Integer.toString(point[0][0]) +","+Integer.toString(point[0][1])+")";
  		//write to dictionary
    	return out;
    }

    public static String triToString (int[][] points){
      String out ="";
      double s0, s1 ,s2;
      s0 = (double) Math.sqrt(Math.pow(points[1][0]-points[0][0],2)+Math.pow(points[1][1]-points[0][1],2));
      s1 = (double) Math.sqrt(Math.pow(points[2][0]-points[1][0],2)+Math.pow(points[2][1]-points[1][1],2));
      s2 = (double) Math.sqrt(Math.pow(points[0][0]-points[2][0],2)+Math.pow(points[0][1]-points[2][1],2));
      if (s0 == 0 || s1 == 0 || s2 == 0){
        out = "Sorry Invalid input";
      } else {
        if(s0 == s1 && s1 == s2 && s2 == s0){
          out = "Equalateral Triangle with cordinates ("+ Integer.toString(points[0][0]) +","+Integer.toString(points[0][1])+"), ("
          + Integer.toString(points[1][0]) +","+Integer.toString(points[1][1])+"), ("
          + Integer.toString(points[2][0]) +","+Integer.toString(points[2][1])+")";
          equal++;
          //write to dictionary
        } else if (s0 == s1 || s1 == s2 || s2 == s0){
          if ((Math.pow(s0,2) + Math.pow(s1,2) -  Math.pow(s2,2) <= 0.01)|| (Math.pow(s1,2) + Math.pow(s2,2) - Math.pow(s0,2) <= 0.01) ||
          (Math.pow(s2,2) + Math.pow(s0,2) - Math.pow(s1,2) <= 0.01)){
            out = "Right angle icosolies Triangle with cordinates ("+ Integer.toString(points[0][0]) +","+Integer.toString(points[0][1])+"), ("
            + Integer.toString(points[1][0]) +","+Integer.toString(points[1][1])+"), ("
            + Integer.toString(points[2][0]) +","+Integer.toString(points[2][1])+")";
            //write to dictionary
          } else {
            out = "Icosolies Triangle with cordinates ("+ Integer.toString(points[0][0]) +","+Integer.toString(points[0][1])+"), ("
            + Integer.toString(points[1][0]) +","+Integer.toString(points[1][1])+"), ("
            + Integer.toString(points[2][0]) +","+Integer.toString(points[2][1])+")";
            //write to dictionary
          }
        } else if ((Math.pow(s0,2) + Math.pow(s1,2) -  Math.pow(s2,2) <= 0.01)|| (Math.pow(s1,2) + Math.pow(s2,2) - Math.pow(s0,2) <= 0.01) ||
          (Math.pow(s2,2) + Math.pow(s0,2) - Math.pow(s1,2) <= 0.01)) {
          out = "Right angle Triangle with cordinates ("+ Integer.toString(points[0][0]) +","+Integer.toString(points[0][1])+"), ("
          + Integer.toString(points[1][0]) +","+Integer.toString(points[1][1])+"), ("
          + Integer.toString(points[2][0]) +","+Integer.toString(points[2][1])+")";
          //write to dictionary
        } else {
          out = "Scalene Triangle with cordinates ("+ Integer.toString(points[0][0]) +","+Integer.toString(points[0][1])+"), ("
          + Integer.toString(points[1][0]) +","+Integer.toString(points[1][1])+"), ("
          + Integer.toString(points[2][0]) +","+Integer.toString(points[2][1])+")";
          //write to dictionary
        }
      }
    	return out;
    }

    public static String quadToString (int[][] points){
      String out ="";
      double s0, s1, s2, s3, m0, m1;
      s0 = (double) Math.sqrt(Math.pow(points[1][0]-points[0][0],2)+Math.pow(points[1][1]-points[0][1],2));
      s1 = (double) Math.sqrt(Math.pow(points[2][0]-points[1][0],2)+Math.pow(points[2][1]-points[1][1],2));
      s2 = (double) Math.sqrt(Math.pow(points[3][0]-points[2][0],2)+Math.pow(points[3][1]-points[2][1],2));
      s3 = (double) Math.sqrt(Math.pow(points[0][0]-points[3][0],2)+Math.pow(points[0][1]-points[3][1],2));
      m0 = (double) Math.sqrt(Math.pow(points[0][0]-points[2][0],2)+Math.pow(points[0][1]-points[2][1],2));
      m1 = (double) Math.sqrt(Math.pow(points[1][0]-points[3][0],2)+Math.pow(points[1][1]-points[3][1],2));
      int[][] vectors = findQuadVectors(points);
      if (s0 == 0 || s1 == 0 || s2 == 0 || s3 == 0|| m0 == 0 || m1 == 0){
        out = "Sorry Invalid input";
      } else{
        if(s0 == s1 && s1 == s2 && s2 == s3 && s3 == s0){
          if (m0 == m1){
            out = "Square with cordinates ("+ Integer.toString(points[0][0]) +","+Integer.toString(points[0][1])+"), ("
            + Integer.toString(points[1][0]) +","+Integer.toString(points[1][1])+"), ("
            + Integer.toString(points[2][0]) +","+Integer.toString(points[2][1])+"), ("
            + Integer.toString(points[3][0]) +","+Integer.toString(points[3][1])+")";
            //write to dictionary
          } else {
            out = "Rhombus with cordinates ("+ Integer.toString(points[0][0]) +","+Integer.toString(points[0][1])+"), ("
            + Integer.toString(points[1][0]) +","+Integer.toString(points[1][1])+"), ("
            + Integer.toString(points[2][0]) +","+Integer.toString(points[2][1])+"), ("
            + Integer.toString(points[3][0]) +","+Integer.toString(points[3][1])+")";
            //write to dictionary
          }
        } else if (s0 == s2 && s1 == s3){
          if (m0 == m1){
            out = "Rectangle with cordinates ("+ Integer.toString(points[0][0]) +","+Integer.toString(points[0][1])+"), ("
            + Integer.toString(points[1][0]) +","+Integer.toString(points[1][1])+"), ("
            + Integer.toString(points[2][0]) +","+Integer.toString(points[2][1])+"), ("
            + Integer.toString(points[3][0]) +","+Integer.toString(points[3][1])+")";
            //write to dictionary
          } else {
            out = "Parallelogram with cordinates ("+ Integer.toString(points[0][0]) +","+Integer.toString(points[0][1])+"), ("
            + Integer.toString(points[1][0]) +","+Integer.toString(points[1][1])+"), ("
            + Integer.toString(points[2][0]) +","+Integer.toString(points[2][1])+"), ("
            + Integer.toString(points[3][0]) +","+Integer.toString(points[3][1])+")";
            //write to dictionary
          }
        } else if (s0 == s1 && s2 == s3){
          out = "Kite with cordinates ("+ Integer.toString(points[0][0]) +","+Integer.toString(points[0][1])+"), ("
          + Integer.toString(points[1][0]) +","+Integer.toString(points[1][1])+"), ("
          + Integer.toString(points[2][0]) +","+Integer.toString(points[2][1])+"), ("
          + Integer.toString(points[3][0]) +","+Integer.toString(points[3][1])+")";
          //write to dictionary
        }else if (Arrays.equals(vectors[0],vectors[2]) || Arrays.equals(vectors[1],vectors[3])){
          out = "Trapizoid with cordinates ("+ Integer.toString(points[0][0]) +","+Integer.toString(points[0][1])+"), ("
          + Integer.toString(points[1][0]) +","+Integer.toString(points[1][1])+"), ("
          + Integer.toString(points[2][0]) +","+Integer.toString(points[2][1])+"), ("
          + Integer.toString(points[3][0]) +","+Integer.toString(points[3][1])+")";
          //write to dictionarys
        } else {
          out = "Quadralateral with cordinates ("+ Integer.toString(points[0][0]) +","+Integer.toString(points[0][1])+"), ("
          + Integer.toString(points[1][0]) +","+Integer.toString(points[1][1])+"), ("
          + Integer.toString(points[2][0]) +","+Integer.toString(points[2][1])+"), ("
          + Integer.toString(points[3][0]) +","+Integer.toString(points[3][1])+")";
          //write to dictionary
        }
      }
    	return out;
    }

    public static int[][] findQuadVectors(int[][] points){
      int[][] vectors = new int[4][2];
      vectors[0][0] = points[1][0] - points[0][0];
      vectors[0][1] = points[1][1] - points[0][1];
      int a = GCD(vectors[0][0],vectors[0][1]);
      vectors[0][0] = vectors[0][0]/a;
      vectors[0][1] = vectors[0][1]/a;
      vectors[1][0] = points[2][0] - points[1][0];
      vectors[1][1] = points[2][1] - points[1][1];
      a = GCD(vectors[1][0],vectors[1][1]);
      vectors[1][0] = vectors[1][0]/a;
      vectors[1][1] = vectors[1][1]/a;
      vectors[2][0] = points[2][0] - points[3][0];
      vectors[2][1] = points[2][1] - points[3][1];
      a = GCD(vectors[2][0],vectors[2][1]);
      vectors[2][0] = vectors[2][0]/a;
      vectors[2][1] = vectors[2][1]/a;
      vectors[3][0] = points[3][0] - points[0][0];
      vectors[3][1] = points[3][1] - points[0][1];
      a = GCD(vectors[3][0],vectors[3][1]);
      vectors[3][0] = vectors[3][0]/a;
      vectors[3][1] = vectors[3][1]/a;
      return vectors;
    }

    public static String getT (String in) {
    	return null;
    }

    public static String getP (String in) {
    	return null;
    }

    public static String getQ (String in) {
    	return null;
    }

    public static String getALL (String in) {
    	return null;
    }

    public static boolean isNumeric(String str){
      try
      {
        int d = Integer.parseInt(str);
      }
      catch(NumberFormatException nfe)
      {
        return false;
      }
      return true;
    }
    
    public static int GCD(int a, int b) {
    	   if (b==0) return a;
    	   return GCD(b,a%b);
    }
}
