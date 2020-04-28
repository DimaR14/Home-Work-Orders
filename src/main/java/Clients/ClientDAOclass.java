package Clients;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOclass implements  ClientDAO {
    private final Connection conn;

    public ClientDAOclass(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void addClient(String name) {

        try {
            try (PreparedStatement st = conn.prepareStatement("INSERT INTO clients (client_name) VALUE (?)")) {
                st.setString(1, name);
                st.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Client getClient() {
        List<Client> list = new ArrayList();
        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT * FROM clients")) {
                    while (rs.next()) {
                        Client cl = new Client();
                        cl.setClientId(rs.getInt(1));
                        cl.setClientName(rs.getString(2));
                        list.add(cl);
                    }
                }
            }
            String clname = "";
            int x = 0;
            for(Client cl : list){
                if(x < cl.getClientId()){
                    x = cl.getClientId();
                    clname = cl.getClientName();
                }
            }Client client = new Client(x,clname);
            return  client;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}