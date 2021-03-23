package sn.isi.dao;

import sn.isi.entities.Client;

import java.util.List;

public interface IClient {
    public int creation (Client client) throws Exception;
    public int edition (Client client)throws Exception;
    public List<Client> visualisation()throws Exception;
    public Client rechercheParMail (String email)throws Exception;
}
