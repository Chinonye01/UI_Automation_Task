package setup;

import org.testng.annotations.Test;
import setUp.setUps;

public class setupTests extends setUps {

    @Test
    public void testSetUp() {

        String pageURL = "https://www.konga.com/";
        if (pageURL.equalsIgnoreCase("https://www.konga.com/")) {
            System.out.println("The webpage URL is "+ pageURL);
        } else {
            System.out.println("invalid URL. Correct URL is"+pageURL);
        }

    }

}
