import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class InformationImpl extends UnicastRemoteObject implements Information{
	private String Message = "";
	private static final long serialVersionUID = 2674880711467464646L;
	protected InformationImpl() throws RemoteException{
		super();
	}
	public void SendMessage(String message) throws RemoteException {
		System.out.println(message);
		this.Message = message;
	}
	public String GetMessage() throws RemoteException {
		String message = this.Message;
		this.Message = "";
		return message;
	}
	
}
