/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Entidades.Alarma;
import Entidades.Registro;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import interfaces.IConexionBD;
import interfaces.IRegistrosDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tonyd
 */
public class RegistrosDAO implements IRegistrosDAO {

    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    public RegistrosDAO(IConexionBD conexion, MongoDatabase baseDatos) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }
    
    

    private MongoCollection<Registro> getCollection() {
        return baseDatos.getCollection("registros", Registro.class);
    }

    @Override
    public void agregarRegistro(Registro registro) {
        this.getCollection().insertOne(registro);
    }

    @Override
    public List<Registro> consultarTodos() {
        return this.getCollection().find().into(new ArrayList());
    }

}
