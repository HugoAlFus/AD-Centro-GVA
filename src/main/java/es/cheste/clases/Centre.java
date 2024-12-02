package es.cheste.clases;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "codi")})
public class Centre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "regim_id", nullable = false)
    private Regim regim;

    @ManyToOne
    @JoinColumn(name = "provincia_id", nullable = false)
    private Provincia provincia;

    private String codi;
    private String centre;
    private String direccio;
    private String localitat;
    private String telefon;
    private String query;

    public Centre() {
        super();
    }

    public Centre(int id, Regim regim, Provincia provincia, String codi, String centre, String direccio, String localitat, String telefon, String query) {
        this.id = id;
        this.regim = regim;
        this.provincia = provincia;
        this.codi = codi;
        this.centre = centre;
        this.direccio = direccio;
        this.localitat = localitat;
        this.telefon = telefon;
        this.query = query;
    }

    public Centre(Regim regim, Provincia provincia, String codi, String centre, String direccio, String localitat, String telefon, String query) {
        this.regim = regim;
        this.provincia = provincia;
        this.codi = codi;
        this.centre = centre;
        this.direccio = direccio;
        this.localitat = localitat;
        this.telefon = telefon;
        this.query = query;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Regim getRegim() {
        return regim;
    }

    public void setRegim(Regim regim) {
        this.regim = regim;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getCentre() {
        return centre;
    }

    public void setCentre(String centre) {
        this.centre = centre;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(String direccio) {
        this.direccio = direccio;
    }

    public String getLocalitat() {
        return localitat;
    }

    public void setLocalitat(String localitat) {
        this.localitat = localitat;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Centre centre1 = (Centre) o;
        return id == centre1.id && provincia == centre1.provincia && Objects.equals(regim, centre1.regim) && Objects.equals(codi, centre1.codi) && Objects.equals(centre, centre1.centre) && Objects.equals(direccio, centre1.direccio) && Objects.equals(localitat, centre1.localitat) && Objects.equals(telefon, centre1.telefon) && Objects.equals(query, centre1.query);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, regim, provincia, codi, centre, direccio, localitat, telefon, query);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Centre{");
        sb.append("id=").append(id);
        sb.append(", regim=").append(regim);
        sb.append(", provincia=").append(provincia);
        sb.append(", codi='").append(codi).append('\'');
        sb.append(", centre='").append(centre).append('\'');
        sb.append(", direccio='").append(direccio).append('\'');
        sb.append(", localitat='").append(localitat).append('\'');
        sb.append(", telefon='").append(telefon).append('\'');
        sb.append(", query='").append(query).append('\'');
        sb.append('}');
        return sb.toString();
    }
}