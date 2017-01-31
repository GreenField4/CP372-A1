package A1net;

import java.io.* ;
import java.net.* ;
import java.util.* ;

public final class A1server {
    public static void main(String argv[]) throws Exception {
		// Get the port number from the command line.
		int port = 8080;// new Integer(argv[0]).intValue();
		//	System.out.println(sss.charAt(0));
		// Establish the listen socket.
		ServerSocket socket = new ServerSocket(port);
		Dictionary dict = new Hashtable();
		String out = "";
		// Process HTTP service requests in an infinite loop.
		while (true) {
		    // Listen for a TCP connection request.
		    Socket connection = socket.accept();
		    System.out.println(connection.getInetAddress());
		    OutputStream output = connection.getOutputStream();
		    String hello = "hello";
		    output.write(hello.getBytes());
		    InputStream input = connection.getInputStream();
		    BufferedReader in = new BufferedReader(new InputStreamReader(input));
		    String clientin = in.readLine();
		    System.out.println(clientin);
		    clientin = clientin.trim();
		    if (clientin.startsWith("T")) {
		    	out = getT(clientin);
		    } else if (clientin.startsWith("Q")) {
		    	out = getQ(clientin);
		    } else if (clientin.startsWith("P")) {
		    	out = getQ(clientin);
		    } else if (clientin.startsWith("ALL")){
		    	out = getALL(clientin);
		    } else if (isNumeric(clientin.replace(" ",""))== false){
		    	out = "Sorry Invalid input";
		    	output.write(out.getBytes());
		    } else {
		    	if ((clientin.split(" ").length % 2) == 1){
		    		out = "Sorry Invalid input";
			    	output.write(out.getBytes());
		    	}else {
		    		int[][] points = stringToPoints(clientin.split(" "));
		    		out = pointsToShape(points);
		    		output.write(out.getBytes());
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
		
    	return null;
    }
    
    public static String quadToString (int[][] points){
		
    	return null;
    }

    public static String getT (String in) {
    	return in;
    }
    
    public static String getP (String in) {
    	return in;
    }
    
    public static String getQ (String in) {
    	return in;
    }
    
    public static String getALL (String in) {
    	return in;
    }
    
    public static boolean isNumeric(String str)  
    {  
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
}
