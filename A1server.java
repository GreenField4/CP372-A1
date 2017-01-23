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
	// Process HTTP service requests in an infinite loop.
	while (true) {
	    // Listen for a TCP connection request.
	    Socket connection = socket.accept();
	    
	    System.out.println(connection.getInetAddress());
	    OutputStream output = connection.getOutputStream();
	    String hello = "hello";
	    output.write(hello.getBytes());
	}
    }
}
