package sn.isi.dao;

import sn.isi.entities.Client;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClientImpl implements IClient{
    DB db = new DB();

    @Override
    public int creation(Client client) throws Exception {
        db.open();
        String sql = "INSERT INTO client VALUES(NULL, ?, ?, ?, ?)";
        db.init(sql);
        db.getPstm().setString(1, client.getNom());
        db.getPstm().setString(2, client.getPrenom());
        db.getPstm().setString(3, client.getEmail());
        db.getPstm().setString(4, client.getTel());
        int ok = db.executeUpdate();
        return ok;
    }

    @Override
    public int edition(Client client) throws Exception {
        db.open();
        String sql = "UPDATE client SET nom = ?,prenom = ?, email = ?, tel = ? WHERE id = ?";
        db.init(sql);
        db.getPstm().setString(1, client.getNom());
        db.getPstm().setString(2, client.getPrenom());
        db.getPstm().setString(3, client.getEmail());
        db.getPstm().setString(4, client.getTel());
        db.getPstm().setInt(5, client.getId());
        int ok = db.executeUpdate();
        return ok;
    }

    @Override
    public List<Client> visualisation() throws Exception {
        List<Client> clients = new ArrayList<Client>();
        db.open();
        String sql = "SELECT * FROM client";
        db.init(sql);
        ResultSet rs = db.executeSelect();
        while (rs.next()){
            Client client = new Client();
            client.setId(rs.getInt(1));
            client.setNom(rs.getString(2));
            client.setPrenom(rs.getString(3));
            client.setEmail(rs.getString(4));
            client.setTel(rs.getString(5));

            clients.add(client);
        }
        return clients;
    }

    @Override
    public Client rechercheParMail(String email) throws Exception {
        Client client = null;
        db.open();
        String sql = "SELECT * FROM client WHERE email = ?";
        db.init(sql);
        db.getPstm().setString(1,email );
        ResultSet rs = db.executeSelect();
        if (rs.next()){
            client = new Client();
            client.setId(rs.getInt(1));
            client.setNom(rs.getString(2));
            client.setPrenom(rs.getString(3));
            client.setEmail(rs.getString(4));
            client.setTel(rs.getString(5));

        }
        return client;
    }
}
