package UtilsPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CertificatesQueries {
    
    public CertificatesQueries()
    {
        super();
    }
    
    public static int getMaxId(Connection conn)
    {
        final String query = "SELECT  MAX(cer_id) FROM certificates";
        int result = 0;
        try (Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                result = rs.getInt(1) ;
            }

        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
            result = -1;
        }
        return result;   
    }
    
     public static String getPrivateKey(Connection conn, String id) {
        final String query = "SELECT DISTINCT private_exponent,modulus FROM certificates WHERE cer_id = '"+id+"'";
        String result = "";
        try (Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                result += rs.getString(1) + ";" + rs.getString(2);
            }

        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
            result = null;
        }

        return result;
    }
     
      public static String getPublicKey(Connection conn, String id) {
        final String query = "SELECT DISTINCT public_exponent,modulus FROM certificates WHERE cer_id = '"+id+"'";
        String result = "";
        try (Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                result += rs.getString(1) + ";" + rs.getString(2);
            }

        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
            result = null;
        }

        return result;
    }
    
    
    
}
