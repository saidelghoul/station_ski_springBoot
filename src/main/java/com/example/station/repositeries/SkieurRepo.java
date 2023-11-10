package com.example.station.repositeries;

import com.example.station.entities.Skieur;
import com.example.station.entities.enums.Couleur;
import com.example.station.entities.enums.Support;
import com.example.station.entities.enums.TypeAbonnement;
import com.example.station.entities.enums.TypeCours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SkieurRepo extends JpaRepository<Skieur,Long> {


    List<Skieur> findByAbonnement_TypeAbonnement(TypeAbonnement abonnement_typeAbonnement);
    List<Skieur> findByAbonnement_TypeAbonnementAndPistesCouleurAndInscriptionsCoursSupportAndInscriptionsCoursTypeCours(TypeAbonnement abonnement_typeAbonnement, Couleur pistes_couleur, Support inscriptions_cours_support, TypeCours inscriptions_cours_typeCours);

    @Query(value = "SELECT * " +
            "FROM skieur s " +
            "JOIN inscription i ON s.num_skieur = i.skieur_num_skieur " +
            "JOIN moniteur_cours mc ON i.cour_num_cours = mc.cours_num_cours " +
            "JOIN moniteur m ON m.num_moniteur = mc.moniteur_num_moniteur " +
            "WHERE m.nomm= :MoniteurName", nativeQuery = true )
    List<Skieur> GetSkieurByMoniteurNameSql (@Param("MoniteurName")String MoniteurName );
    @Query("select i.skieurs " +
            "from Inscrption i " +
            "join Moniteur m on i.cours member m.cours " +
            "where m.nomM = :MoniteurName  "+
            "GROUP BY i.skieurs "+
                "order by i.skieurs.pistes.size")  //ordonnés selon le nombre des pistes affectés aux skieurs
    List<Skieur> GetSkieurByMoniteurNameJpql (@Param("MoniteurName") String MoniteurName);

    @Query(value = "SELECT *, COUNT(ps.skieurs_num_skieur) AS nombrePistes " +
            "FROM skieur s " +
            "JOIN piste_skieurs ps ON s.num_skieur = ps.skieurs_num_skieur " +
            "GROUP BY s.num_skieur " +
            "ORDER BY nombrePistes DESC", nativeQuery = true)
    List<Skieur> GetSkieurOrdredByPisteNumberSQL();

    @Query(value ="SELECT s  FROM Skieur s " +
            "JOIN s.pistes p " +
            "group by s" +
            " ORDER BY count(p) DESC ")
    List<Skieur> GetSkieurPisteCountJPQL();

}
