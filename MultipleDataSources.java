import java.util.LinkedList;

public class MultipleDataSources {
	
	public static void main(String[] args) {
		MessageLoader[] loader = new MessageLoader[2];
		loader[0] = new LocalMessageLoader();
		loader[1] = new RemoteMessageLoader();		
		
		LinkedList<Message> messages = new LinkedList<Message>();		
		
		for (int i = 0; i < loader.length; i++) {
			Message[] tempMessages = loader[i].loadMessages();
			
			for (int j = 0; j < tempMessages.length; j++) {
				messages.add(tempMessages[j]);
			}
		}
		
		for (int i = 0; i < messages.size(); i++) {
			System.out.println(messages.get(i));
		}
	}
	
}

class Message {
	String fromUserID;
	String toUserID;
	String message;
	
	public Message(String fromUserID, String toUserID, String message) {
		this.fromUserID = fromUserID;
		this.toUserID = toUserID;
		this.message = message;
	}
	
	@Override
	public String toString() { 
		return "From " + this.fromUserID + " to " + this.toUserID + ":\t" + this.message; 
	}
}

interface MessageLoader {
	Message[] loadMessages();
}

class LocalMessageLoader implements MessageLoader {

	@Override
	public Message[] loadMessages() {
		// load message from the local storage
		Message[] messages = new Message[] { new Message("0", "1", "Hey!") };
		return messages;
	}
	
}

class RemoteMessageLoader implements MessageLoader {

	@Override
	public Message[] loadMessages() {
		// load message from the remote cloud storage
		Message[] messages = new Message[] { new Message("1", "0", "Hallo") };
		return messages;
	}
	
}
