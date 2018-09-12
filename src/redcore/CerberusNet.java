package redcore;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import jCerberus.EventCerberus;
import jCerberus.Transceiver;

	
public class CerberusNet extends EventCerberus {

		
		
		public CerberusNet(String Name, int Port) {
			super(Name, Port);
		}
		
		
		
		@Override
		public void HandleConsumerNonRegEventRequest(JSONObject reqJson, Transceiver consumer) {
			// echo for testing
			System.out.println("Consumer " + consumer.Port() + " send this: " + reqJson.toJSONString());
			
			// handle other stuff than events
			if (reqJson.containsKey("Req")) {
				String Req = (String) reqJson.get("Req");
				switch(Req) {
					case "SetSolenoid":
						HandleSetSolenoid(reqJson);
						break;
				}
			}
		}	
		
		
		
		public void HandleSetSolenoid(JSONObject reqJson) {
			// Expected structure
			// { 'Req':"SetSolenoid", "On":[1,2], "Off":[4] }
			// May contain "On" or "Off" or both
			// Each contains an array of solenoid ids
			
			// handle the offs first
			if (reqJson.containsKey("Off")) {
				JSONArray OffSolenoidIds = (JSONArray) reqJson.get("Off");
				if (OffSolenoidIds != null) {
					for (Object OffSolenoidId : OffSolenoidIds) {
						int SolenoidId = (int) OffSolenoidId;
						// #####################################################
						// Luke, can you add code here to turn off the intake
						// #####################################################
					}
				}
			}

			// handle the ons
			if (reqJson.containsKey("On")) {
				JSONArray OnSolenoidIds = (JSONArray) reqJson.get("On");
				if (OnSolenoidIds != null) {
					for (Object OnSolenoidId : OnSolenoidIds) {
						int SolenoidId = (int) OnSolenoidId;
						// #####################################################
						// Luke, can you add code here to turn on the intake
						// #####################################################
					}
				}
			}
			
		}
	
		
		
}
