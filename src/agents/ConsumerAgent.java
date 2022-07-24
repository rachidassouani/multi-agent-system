package agents;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.ControllerException;

public class ConsumerAgent extends Agent {

	@Override
	protected void setup() {
		ParallelBehaviour parallelBehaviour = new ParallelBehaviour();
		addBehaviour(parallelBehaviour);
		
		String name = null;
		if (this.getArguments().length == 1) {
			name = (String) getArguments()[0];
		}
		System.out.println("Init agent ..." + this.getAID().getName());
		System.out.println("First Args is " + name);
	/*
		addBehaviour(new CyclicBehaviour() {
			private int counter = 0;
			@Override
			public void action() {
				System.out.println("counter : " + counter);
				++counter;
			}
		});
	*/	
		parallelBehaviour.addSubBehaviour(new CyclicBehaviour() {
			
			@Override
			public void action() {
				ACLMessage aclMessage = receive();
				if (aclMessage != null) {
					System.out.println("Sender : " + aclMessage.getSender().getName());
					System.out.println("Content : " + aclMessage.getContent());
					System.out.println("SpeechAct : " + ACLMessage.getPerformative(aclMessage.getPerformative()));

					ACLMessage reply = new ACLMessage(ACLMessage.CONFIRM);
					reply.addReceiver(aclMessage.getSender());
					reply.setContent("Price is : " + 50000);
					send(reply);
					
				} else {
					block();
				}
			}
		});
		
	}
	
	@Override
	protected void beforeMove() {
		try {
			System.out.println("Before Move from " + this.getContainerController().getContainerName());
		} catch (ControllerException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void afterMove() {
		try {
			System.out.println("After Move to " + this.getContainerController().getContainerName());
		} catch (ControllerException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void takeDown() {
		System.out.println("Diying ...");
	}
}
