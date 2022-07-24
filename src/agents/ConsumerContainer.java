package agents;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;

public class ConsumerContainer {

	public static void main(String[] args) throws Exception {
		Runtime runtime = Runtime.instance();
		ProfileImpl profileImpl = new ProfileImpl();
		profileImpl.setParameter(Profile.MAIN_HOST, "localhost");
		AgentContainer consumerContainer = runtime.createAgentContainer(profileImpl);
		
		AgentController consumerAgent = consumerContainer.createNewAgent("consumer", "agents.ConsumerAgent", new Object[] {"Java"});
		consumerAgent.start();
	}
}
