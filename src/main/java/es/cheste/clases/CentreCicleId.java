package es.cheste.clases;

import java.io.Serializable;
import java.util.Objects;

public class CentreCicleId implements Serializable {

    private Long centre;
    private Long cicle;

    public CentreCicleId() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CentreCicleId that = (CentreCicleId) o;
        return Objects.equals(centre, that.centre) && Objects.equals(cicle, that.cicle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(centre, cicle);
    }

    public Long getCentre() {
        return centre;
    }

    public void setCentre(Long centre) {
        this.centre = centre;
    }

    public Long getCicle() {
        return cicle;
    }

    public void setCicle(Long cicle) {
        this.cicle = cicle;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CentreCicleId{");
        sb.append("centre=").append(centre);
        sb.append(", cicle=").append(cicle);
        sb.append('}');
        return sb.toString();
    }
}
