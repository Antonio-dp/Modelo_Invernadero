/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Entidades.Sensor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import interfaces.IConexionBD;
import interfaces.ISensorDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author tonyd
 */
public class SensorDAO implements ISensorDAO{
    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    public SensorDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }
    
    private MongoCollection<Sensor> getCollection(){
        return baseDatos.getCollection("sensores", Sensor.class);
    }
    
    @Override
    public void agregarSensor(Sensor sensor) {
        this.getCollection().insertOne(sensor);
    }

    @Override
    public void actualizarSensor(Sensor sensor) {

    }

    @Override
    public void eliminarSensor(Sensor sensor) {
        this.getCollection().deleteOne(new Document("_id",sensor.getIdSensor()));
    }

    @Override
    public List<Sensor> consultarTodos() {
        return this.getCollection().find().into(new ArrayList());
    }
    
}
