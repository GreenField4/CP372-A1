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
		    	
		    } else {
		    	
		    }
		    
		    
		}
    }
    public int[][]  stringToPoints(String[] points) {
		return null;
    	
    }

    public String getT (String in) {
    	return in;
    }
    
    public String getP (String in) {
    	return in;
    }
    
    public String getQ (String in) {
    	return in;
    }
    
    public String getALL (String in) {
    	return in;
    }
    
    public static boolean isNumeric(String str)  
    {  
      try  
      {  
        double d = Double.parseDouble(str);  
      }  
      catch(NumberFormatException nfe)  
      {  
        return false;  
      }  
      return true;  
    }
}
