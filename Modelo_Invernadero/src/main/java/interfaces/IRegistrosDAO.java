/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Alarma;
import Entidades.Registro;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author tonyd
 */
public interface IRegistrosDAO {
    public void agregarRegistro(Registro registro);
    public List<Registro> consultarTodos();
}
