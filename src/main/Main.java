package main;

import sn.isi.dao.ClientImpl;
import sn.isi.dao.IClient;
import sn.isi.entities.Client;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        //Creation
        IClient clientdao = new ClientImpl();
        Client client = new Client();
        client.setNom("sarr");
        client.setPrenom("Serigne Saliou");
        client.setEmail("sssarr@gmail.com");
        client.setTel("773442456");
        //Appel de la fonction creation
        int ok = clientdao.creation(client);

        //Edition
        //client.setId(1);
        //int ok = clientdao.edition(client);

        //Visualisation
        List<Client> clients = clientdao.visualisation();
        for (Client c : clients){
            System.out.println("ID : " + c.getId() + ", NOM : " + c.getNom() + ", PRENOM : " + c.getPrenom() + ", EMAIL : " + c.getEmail() + ", TEL : " + c.getTel());
        }

        //Recherche

    }
}

