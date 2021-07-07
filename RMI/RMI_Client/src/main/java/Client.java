import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class Client {
	private static Remote r;
	private static boolean close = false;
	public static void main(String[] args) {
		System.out.println("Lancement du client");
		try {
			r = Naming.lookup("rmi://localhost/TP_RMI");
			System.out.println(r);
			while(!close) {
			    System.out.println("Action (tape) : 1 Send message; 2 Get message; 3 Close console");
			    System.out.print("Action : ");
			    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			    String input = reader.readLine();
			    if(input.equals("1")) {
			    	if (r instanceof Information) {
			            ((Information) r).SendMessage("RMI message transmission test.");
			            System.out.println("Message \"RMI message transmission test.\" envoyé.");
			        }
			    }
			    else if(input.equals("2")) {
			    	if (r instanceof Information) {
			            String s = ((Information) r).GetMessage();
			            if(s.equals("")){
			            	System.out.println("Aucun message n'est contenu sur le serveur.");
			            }
			            else {
			            	System.out.println(s);
			            	System.out.println("Suppression du message sur le serveur.");
			            }
			        }
			    }
			    else if(input.equals("3")) {
			    	close = true;
			    }
			    else {
			    	System.out.println("Erreur action. Taper 1, 2 ou 3.");
			    }
		    }
		} catch (MalformedURLException e) {
		      e.printStackTrace();
		    } catch (RemoteException e) {
		      e.printStackTrace();
		    } catch (NotBoundException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
				e.printStackTrace();
			}
		    System.out.println("Ainsi s'achève la fin de transmission RMI.");
		    System.out.println("Développé par TRUDELLE Florian.");
		    System.out.println("Fin du client");
	}
}
