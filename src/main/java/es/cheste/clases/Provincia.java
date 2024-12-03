package es.cheste.clases;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

/**
 * Clase que representa una provincia.
 */
@Entity
public class Provincia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    @OneToMany(mappedBy = "provincia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Centre> centres;

    /**
     * Constructor por defecto.
     */
    public Provincia() {
        super();
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param id   Identificador de la provincia.
     * @param nom  Nombre de la provincia.
     */
    public Provincia(int id, String nom) {
        this(nom);
        this.id = id;
    }

    /**
     * Constructor sin el identificador.
     *
     * @param nom  Nombre de la provincia.
     */
    public Provincia(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Provincia provincia = (Provincia) o;
        return id == provincia.id && Objects.equals(nom, provincia.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
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
        final StringBuilder sb = new StringBuilder("Provincia{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append('}');
        return sb.toString();
    }
}