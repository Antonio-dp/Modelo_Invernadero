/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DAOS;

import Entidades.Sensor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import conexiones.ConexionBD;
import interfaces.IConexionBD;
import interfaces.ISensorDAO;

/**
 *
 * @author tonyd
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sensor sen = new Sensor("A15", "Sensor TEMPERATURA B18A");
        IConexionBD conexion = new ConexionBD();
        MongoDatabase baseDatos = conexion.crearConexion();
        MongoCollection<Sensor> dao = baseDatos.getCollection("sensores", Sensor.class);
        
        dao.insertOne(sen);
    }

}
