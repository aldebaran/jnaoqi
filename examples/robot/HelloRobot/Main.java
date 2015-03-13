import com.aldebaran.qi.Session;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

public class Main {

    public static void main(String[] args) throws Exception {

        System.out.println("Starting...");
	// Create a new session
        Session session = new Session();
	// Connect your session to your localhost and wait for it to be ready
	session.connect("localhost").get();
	// Create an instance of ALTextToSpeech using the already created session
        ALTextToSpeech tts = new ALTextToSpeech(session);
	// Make the robot say "Hello World!" using ALTextToSpeech
        tts.say("Hello World!");
    }
}
