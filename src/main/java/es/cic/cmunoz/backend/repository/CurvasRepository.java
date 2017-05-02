/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cic.cmunoz.backend.repository;

import es.cic.cmunoz.backend.dominio.Curvas;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CurvasRepository extends MongoRepository<Curvas, String> {

    public Curvas encontrarPorId(int idCurva);

    public List<Curvas> encontrarPorCups(String cups);

    public List<Curvas> encontrarPorFechas(String fecha);
    
    public List<Curvas> encontrarPorPatron(String campo,String valor, String patron);
}
