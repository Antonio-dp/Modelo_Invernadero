/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Entidades.Alarma;
import Entidades.Sensor;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import interfaces.IAlarmaDAO;
import interfaces.IConexionBD;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author tonyd
 */
public class AlarmaDAO implements IAlarmaDAO {

    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    public AlarmaDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }

    private MongoCollection<Alarma> getCollection() {
        return baseDatos.getCollection("alarmas", Alarma.class);
    }

    @Override
    public void agregarAlarma(Alarma alarma) {
        this.getCollection().insertOne(alarma);
    }

    @Override
    public void actualizarAlarma(Alarma alarma) {
        Document filtro = new Document("_id", alarma.getId());
        Document cambios = new Document()
                .append("limiteInferior", alarma.getLimiteInferior())
                .append("limiteSuperior", alarma.getLimiteSuperior())
                .append("tipo", alarma.getTipo())
                .append("correo", alarma.getCorreo());
        this.getCollection().updateOne(filtro, new Document("$set", cambios));

    }

    @Override
    public void eliminarAlarma(Alarma alarma) {
        this.getCollection().deleteOne(new Document("_id", alarma.getId()));
    }

    @Override
    public List<Alarma> consultarTodos() {
        return this.getCollection().find().into(new ArrayList());
    }

}
