package DataStatic;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Conection {

    java.sql.Connection conexion;
    DefaultTableModel dataModel;
    ResultSet result;
    ResultSetMetaData resultSet;
    java.sql.Statement statement;
    
    private String dbhost = "localhost";
    private String dbPort = "5432";
    private String dbName = "pedidos";
    private String dbUser = "DuvalAdmin";
    private String dbPassword = "carvajal2000";

    public Conection() {
        
    }

    public boolean openConecction() {
        try {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection("jdbc:postgresql://" 
                    + this.dbhost + ":" + this.dbPort + "/" 
                    + this.dbName, this.dbUser, this.dbPassword);
            
        } catch (Exception error) {
            System.out.println("Error en la Conexión");
            System.out.println(error.getMessage());
            return false;
        }
        return true;
    }

    public boolean closeConnection() {
        try {
            statement.close();
            conexion.close();
            
        } catch (Exception error) {
            System.out.println("Error close connection: " + error.getMessage());
            return false;
        }
        return true;
    }

    public boolean closeResulSet() {
        try {
            result.close();
            
        } catch (SQLException error) {
            System.out.println("error in close resulset: " + error.getMessage());
            return false;
        }
        return true;
    }

    public DefaultTableModel returnRecord(String sql) {
        dataModel = new DefaultTableModel();
        if (openConecction()) {
            try {
                statement = conexion.createStatement();
                result = statement.executeQuery(sql);
                resultSet = result.getMetaData();
                
                int tamanio = resultSet.getColumnCount();
                
                for (int i = 1; i <= tamanio; i++) {
                    dataModel.addColumn(resultSet.getColumnName(i));
                }
                String[] row = new String[tamanio];
                while (result.next()) {
                    for (int i = 0; i < tamanio; i++) {
                        row[i] = (result.getString(resultSet.getColumnName(i + 1)) == null)
                                ? "" : result.getString(resultSet.getColumnName(i + 1));
                    }
                    dataModel.addRow(row);
                }
                
            } catch (SQLException error) {
                System.out.println("Error return Record: " + error.getMessage());
                dataModel = new DefaultTableModel();
            } finally {
                if (result != null) {
                    closeResulSet();
                }
            }
            closeConnection();
        }
        return dataModel;
    }

    public boolean modifyBD(String sql) {
        if (openConecction()) {
            try {
                statement = conexion.createStatement();
                statement.execute(sql);
            } catch (SQLException error) {
                System.out.println("Error ModifyBD: " + error.getMessage());
                return false;
            }
            closeConnection();
            return true;
        } else {
            return false;
        }
    }

    public String fillString(String sql) {
        String valor = "";
        if (openConecction()) {
            try {
                statement = conexion.createStatement();
                result = statement.executeQuery(sql);
                while (result.next()) {
                    valor = result.getString(1);
                }

            } catch (SQLException error) {
                System.out.println("Error fill string: " + error.getMessage());
                return "";
            } finally {
                if (result != null) {
                    closeResulSet();
                }
            }
            closeConnection();
        }
        return valor == null ? "" : valor;
    }

    public String getNextID(String sql) {
        String valor = "-1";
        if (openConecction()) {
            try {
                statement = conexion.createStatement();
                result = statement.executeQuery(sql);
                while (result.next()) {
                    valor = result.getString(1);
                }
                int numero = 1;
                try {
                    numero = Integer.parseInt(valor) + 1;
                } catch (NumberFormatException e) {
                    numero = 1;
                }
                valor = numero + "";

            } catch (SQLException error) {
                System.out.println("No next id: " + error.getMessage());
                valor = "1";
            } finally {
                if (result != null) {
                    closeResulSet();
                }
            }
            closeConnection();
        }
        return valor;
    }

    public String getRecordsInJson(String sql) {
        String resul = "[";
        DefaultTableModel table = returnRecord(sql);
        if (table != null) {
            int columCount = table.getColumnCount();
            for (int row = 0; row < table.getRowCount(); row++) {
                String line = "";
                for (int colum = 0; colum < columCount; colum++) {
                    line += "\"" + table.getColumnName(colum) + "\":\"" 
                            + table.getValueAt(row, colum).toString() + "\"";
                    
                    if (colum < columCount - 1) {
                        line += ",";
                    }
                }
                if (line.length() > 0) {
                    resul += "{" + line + "}";
                    if (row < table.getRowCount() - 1) {
                        resul += ",";
                    }
                }
            }
            resul += "]";
        } else {
            resul = "[]";
        }
        return resul;
    }

    public boolean testConection() {
        boolean test = openConecction();
        if (test) {
            try {
                conexion.close();
            } catch (SQLException error) {
                System.out.println("error test conection: " + error.getMessage());
            }
        }
        System.out.println("test: " + test);
        return test;
    }
}
