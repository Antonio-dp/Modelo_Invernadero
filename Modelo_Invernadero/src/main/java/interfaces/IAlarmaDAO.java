/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Alarma;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author tonyd
 */
public interface IAlarmaDAO {

    public void agregarAlarma(Alarma alarma);
    public void actualizarAlarma(Alarma alarma);
    public void eliminarAlarma(Alarma alarma);
    public List<Alarma> consultarTodos();
    public Alarma consultarAlarma(ObjectId idAlarma);
}
