package AES;
import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
 
/**
 * Prueba para realizar conexi�n con MongoDB.
 * @author j
 *
 */
public class conexion {
    /**
     * Main del proyecto.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Prueba conexi�n MongoDB");
        MongoClient mongo = crearConexion();
 
        if (mongo != null) {
            System.out.println("Lista de bases de datos: ");
            printDatabases(mongo);
            DB db =mongo.getDB("prueba");
            insertarUsuario(db, "usuarios", "javi","12345");
 
        } else {
            System.out.println("Error: Conexi�n no establecida");
        }
    }
 
    /**
     * Clase para crear una conexi�n a MongoDB.
     * @return MongoClient conexi�n
     */
    public static MongoClient crearConexion() {
        MongoClient mongo = null;
        mongo = new MongoClient("localhost", 27017);
 
        return mongo;
    }
 
    /**
     * Clase que imprime por pantalla todas las bases de datos MongoDB.
     * @param mongo conexi�n a MongoDB
     */
    private static void printDatabases(MongoClient mongo) {
        List dbs = mongo.getDatabaseNames();
        for (Object db : dbs) {
            System.out.println(" - " + db);
        }
    }
    
    private static void insertarUsuario(DB db, String tabla, String usuario, String password) {
    	DBCollection table = db.getCollection(tabla);
    	BasicDBObject document = new BasicDBObject();
    	document.put("usuario",usuario);
    	document.put("password",password);
    	//insertar datos a Mongodb
    	table.insert(document);
    }
}

