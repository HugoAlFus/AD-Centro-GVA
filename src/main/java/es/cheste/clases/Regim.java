package es.cheste.clases;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

//TODO queda comprobar si todos los parámetos de la clase son nulls y retocar contructores
@Entity
public class Regim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;

    @OneToMany(mappedBy = "regim", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Centre> centres;

    public Regim() {
        super();
    }

    public Regim(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Regim{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append('}');
        return sb.toString();
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
}
