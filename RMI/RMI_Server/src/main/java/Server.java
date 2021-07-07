import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			InformationImpl infoImpl = new InformationImpl();
			String url = "rmi://localhost/TP_RMI";
			Naming.rebind(url, infoImpl);
			System.out.println("Serveur lancé");
		} catch (RemoteException e) {
		    e.printStackTrace();
		  } catch (MalformedURLException e) {
		    e.printStackTrace();
		  }
	}
}
