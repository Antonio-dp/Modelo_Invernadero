/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DAOS;

import Entidades.Alarma;
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
        Alarma alarma = new Alarma("JOTO", (float) 50.0, sen);
        IConexionBD conexion = new ConexionBD();
        MongoDatabase baseDatos = conexion.crearConexion();
        MongoCollection<Alarma> dao = baseDatos.getCollection("alarmas", Alarma.class);
        MongoCollection<Sensor> dao2 = baseDatos.getCollection("sensores", Sensor.class);
        SensorDAO sensorDAO = new SensorDAO(conexion);
        dao2.insertOne(sen);
        sen = sensorDAO.consultarSensor(sen.getId());
        System.out.println(sensorDAO.consultarTodos().get(0).getId());
        dao.insertOne(alarma);
    }

}
