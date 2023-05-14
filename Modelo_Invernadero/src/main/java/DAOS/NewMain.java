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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tonyd
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sensor sen = new Sensor("A15", "Sensor Humedad B18A");
        IConexionBD conexion = new ConexionBD();
        MongoDatabase baseDatos = conexion.crearConexion();
        MongoCollection<Alarma> dao = baseDatos.getCollection("alarmas", Alarma.class);
        MongoCollection<Sensor> dao2 = baseDatos.getCollection("sensores", Sensor.class);
        AlarmaDAO sensorDAO = new AlarmaDAO(conexion);
        dao2.insertOne(sen);
        Alarma alarma = new Alarma("PIT", (float) 5.0, (float) 45.0, sen.getId());
        Alarma alarma1 = new Alarma("SUEN",  (float) 5.0, (float) 45.0, sen.getId());
        Alarma alarma2 = new Alarma("dI ALG",  (float) 5.0, (float) 45.0, sen.getId());
        Alarma alarma3 = new Alarma("E",  (float) 5.0, (float) 45.0, sen.getId());
        List<Alarma> alarmas = new ArrayList();
        alarmas.add(alarma);
        alarmas.add(alarma1);
        alarmas.add(alarma2);
        alarmas.add(alarma3);

        dao.insertMany(alarmas);
        
        System.out.println(sensorDAO.consultarAlarmasByIdSensor(sen.getId()));
        //sen = sensorDAO.consultarSensor(sen.getId());
        //System.out.println(sen.getId());
        //dao.insertMany(alarmas);
    }

}
