package es.cheste.clases;

import jakarta.persistence.*;

@Entity
@Table(name = "cicle_centre")
@IdClass(CentreCicleId.class)
public class CicleCentre {

    @Id
    @ManyToOne
    @JoinColumn(name = "centre_id")
    private Centre centre;

    @Id
    @ManyToOne
    @JoinColumn(name = "cicle_id")
    private Cicle cicle;



}
