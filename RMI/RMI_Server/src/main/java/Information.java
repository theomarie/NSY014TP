import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Information extends Remote{
	void SendMessage(String message) throws RemoteException;
	String GetMessage() throws RemoteException;
}
