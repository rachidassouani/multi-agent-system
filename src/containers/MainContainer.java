package containers;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;

public class MainContainer {

	public static void main(String[] args) throws Exception {
		Runtime runtime = Runtime.instance();
		ProfileImpl profileImpl = new ProfileImpl();
		profileImpl.setParameter(Profile.GUI, "true");
		AgentContainer agentContainer = runtime.createMainContainer(profileImpl);
		agentContainer.start();
	}
}
