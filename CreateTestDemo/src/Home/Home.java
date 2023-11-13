
package Home;

import Process.HomeCommandLine;
import java.io.IOException;

/**
 *
 * @author ahmedshuman
 */
public class Home {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println("How are you " );
        System.out.println("I hope you have a nice day" );
        //System.out.println("Please specify your identity:");
        HomeCommandLine instance = HomeCommandLine.getInstance();
        String String = null;
       
        instance.commandline(String);
    } 
}
