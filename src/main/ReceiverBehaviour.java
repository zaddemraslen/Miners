package main;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.core.behaviours.SimpleBehaviour;


public class ReceiverBehaviour extends SimpleBehaviour {
    private static final MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.INFORM);
    private String receivedContent;
    public ReceiverBehaviour(Agent agent) {
        super(agent);
        receivedContent = null;

        }
    public void action() {
        ACLMessage msg = myAgent.receive(mt);
        if (msg!=null) {
        receivedContent = msg.getContent();
        System.out.println(myAgent.getLocalName()+":Ireceived "
        		+ "message.\n"
        +msg.toString());
        }
        else {
        this.block();
        }
    }
    public boolean done() {
        return false;
    }
    
    public String getReceivedContent() {
        return receivedContent;
    }
}