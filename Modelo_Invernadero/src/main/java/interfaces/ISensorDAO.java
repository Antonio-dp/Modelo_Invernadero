/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Sensor;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author tonyd
 */
public interface ISensorDAO {
    public void agregarSensor(Sensor sensor);
    public void actualizarSensor(Sensor sensor);
    public void eliminarSensor(Sensor sensor);
    public List<Sensor> consultarTodos();
    public Sensor consultarSensor(String idSensor);
}
