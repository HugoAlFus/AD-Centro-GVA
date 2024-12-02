package es.cheste.clases;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Cicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String codi;
    private String nom;
    @ManyToMany
    @JoinTable(
            name = "Cicle_Centre",
            joinColumns = @JoinColumn(name = "cicle_id"),
            inverseJoinColumns = @JoinColumn(name = "centre_id")
    )
    private List<Centre> centres = new ArrayList<>();

    public Cicle() {
        super();
    }

    public Cicle(int id, String codi, String nom) {
        this.id = id;
        this.codi = codi;
        this.nom = nom;
    }

    public Cicle(String codi, String nom) {
        this.codi = codi;
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cicle cicle = (Cicle) o;
        return id == cicle.id && Objects.equals(codi, cicle.codi) && Objects.equals(nom, cicle.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codi, nom);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cicle{");
        sb.append("id=").append(id);
        sb.append(", codi='").append(codi).append('\'');
        sb.append(", nom='").append(nom).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
