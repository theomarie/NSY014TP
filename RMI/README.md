# TP NSY14
Application dans le cadre de la licence STS
## Contenu
Ce repository contient 5 projets Java différents :
- RMI (Lancer le serveur avant de lancer le client. Il suffit de taper les actions données pour effectuer les transmissions.)
- SOAP (cf. https://github.com/theomarie/NSY014)
- REST (Damien) (Pour pouvoir utiliser ce service il vous faut d'abord importer les deux projets dans votre IDE favori.
Ensuite rentrez dans le dossier du **serveur** : 
`cd /home/user/rest-service-server`
Effectuer la commande :
`./mvnw clean package`
Pour construire un fichier **JAR** éxécutable.
Démarrer le avec la commande :
`java -jar /home/user/rest-service/target/rest-service-0.0.1-SNAPSHOT.jar`
Le serveur **REST** est maintenant en cours d'éxécution sur le port **8080** ([À cette adresse](http://localhost:8080/))
Côté client il n'y a rien à faire mise à part exécuter la classe **Main()** et constater les résultats en console. Il est aussi possible d'effectuer les requêtes HTTP via postman / insomnia / php etc ... cf. https://github.com/Nemoo0/Java_RestFull_Service)
- REST (Corentin) (Pour lancer l'application il suffit de soit créer un executable soit lancer le fichier Application.java.
Ensuite il faut se rendre sur http://localhost:9093/employe pour voir le message. cf. https://github.com/CLemarechal/NSY014)
- MOM (Aller dans le bin d'activemq. Executer la commande activemq start. Lancer le projet dans eclipse / intelliJ. Run la classe Mom et observer la console cf. https://github.com/AlexisL2607/TP_NSY014)
- SOCKET (Lancer le serveur avant le client.)
