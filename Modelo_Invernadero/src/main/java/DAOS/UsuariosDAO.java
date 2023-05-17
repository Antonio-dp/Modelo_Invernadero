/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import Entidades.Usuario;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import interfaces.IConexionBD;
import interfaces.IUsuariosDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;


/**
 *
 * @author tonyd
 */
public class UsuariosDAO implements IUsuariosDAO{
    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    public UsuariosDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }

    private MongoCollection<Usuario> getCollection() {
        return baseDatos.getCollection("usuarios", Usuario.class);
    }
    @Override
    public void agregarUsuario(Usuario usuario) {
        this.getCollection().insertOne(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        Document filtro = new Document("_id", usuario.getId());
        Document cambios = new Document()
                .append("nombre", usuario.getNombre())
                .append("correo", usuario.getCorreo());
        this.getCollection().updateOne(filtro, new Document("$set", cambios));
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        this.getCollection().deleteOne(new Document("_id", usuario.getId()));
    }

    @Override
    public List<Usuario> consultarTodos() {
        return this.getCollection().find().into(new ArrayList());
    }

    @Override
    public Usuario consultarSensor(ObjectId idUsuario) {
        List<Usuario> usuarios = this.getCollection().find(new Document("_id", idUsuario)).into(new ArrayList());
        if(usuarios.isEmpty()){
            return null;
        }
        return usuarios.get(0);    
    }
    
}
