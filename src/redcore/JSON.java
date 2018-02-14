import org.json.simple.JSONObject;
import java.io.*;

public class HelloWorld {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
	
	JSONObject RiotoVis = new JSONObject();
	RiotoVis.put("Command","Wake Up");
	
	JSONObject sub = new JSONObject();
	sub.put("X", 123.4);
	sub.put("y", 4.56);
	
	RiotoVis.put("Coords", sub);
	
	String jsonToRio = RiotoVis.toJSONString();
	System.out.println("Out on the network: " + jsonToRio);
	
	JSONObject VisToRio = new JSONObject();
	VisToRio.put("Respond", "I'm Awake!");
	
	String jsonToVis = VisToRio.toJSONString();
	System.out.println("Out to the network: " + jsonToVis);
	
	 try {
         File newTextFile = new File("C:\\Users\\Katey\\Documents\\test.json");

         FileWriter fw = new FileWriter(newTextFile);
         fw.write(jsonToRio);
         fw.close();

     } catch (IOException iox) {
         //do stuff with exception
         iox.printStackTrace();
     }
	}
}