package com.example.station.repositeries;

import com.example.station.entities.Cour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourRepo extends JpaRepository<Cour,Long> {

    @Query(value ="SELECT *" +   //@Query: Indique que la méthode annotée est une requête personnalisée.
            "From cour c " +
            "JOIN moniteur_cours mc ON C.numCour = mc.cour_num_cour"+
            "JOIN moniteur m ON m.numMoniteur = mc.moniteur_num_moniteur" +
            "WHERE m.nom= nameMonit",nativeQuery = true) //nativeQuery = true: Indique que la requête spécifiée est une requête SQL native.
    List<Cour>GetCoursByMoniteurSql(@Param("nameMon") String nameMon);//nameMon nom de la variable que je veux utliser qans la request




}
