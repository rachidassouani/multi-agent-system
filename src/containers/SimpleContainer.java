package containers;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;

public class SimpleContainer {

	public static void main(String[] args) throws Exception {
		Runtime runtime = Runtime.instance();
		ProfileImpl profileImpl = new ProfileImpl();
		profileImpl.setParameter(Profile.MAIN_HOST, "localhost");
		AgentContainer simpleContainer = runtime.createAgentContainer(profileImpl);
		simpleContainer.start();
	}
}
