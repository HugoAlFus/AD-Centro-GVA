package es.cheste.clases;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

/**
 * Clase que representa un régimen educativo.
 */
@Entity
public class Regim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;

    @OneToMany(mappedBy = "regim", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Centre> centres;

    /**
     * Constructor por defecto.
     */
    public Regim() {
        super();
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param id   Identificador del régimen.
     * @param nom  Nombre del régimen.
     */
    public Regim(int id, String nom) {
        this(nom);
        this.id = id;
    }

    /**
     * Constructor sin el identificador.
     *
     * @param nom  Nombre del régimen.
     */
    public Regim(String nom) {
        this.nom = nom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Regim regim = (Regim) o;
        return id == regim.id && Objects.equals(nom, regim.nom);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Regim{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append('}');
        return sb.toString();
    }
}