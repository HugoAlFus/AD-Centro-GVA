package es.cheste;

import es.cheste.clases.Centre;
import es.cheste.clases.Cicle;
import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Centros");

        EntityManager em = emf.createEntityManager();

        System.out.println(listarNombresCentro(em));
        System.out.println("---------------------------------------------------------------");
        System.out.println(listarNombreCentroProvincia(em));
        System.out.println("---------------------------------------------------------------");
        System.out.println(listarNomCodiCicle(em));
        System.out.println("---------------------------------------------------------------");
        System.out.println(listarCentrosPorCicle(em));

        em.close();
        emf.close();
    }

    @SuppressWarnings("unchecked")
    private static String listarNombresCentro(EntityManager em) {

        StringBuilder sb = new StringBuilder("--La lista de todos los nombres de los centros--\n");

        Query query = em.createNamedQuery("Centre.findAll.nombres");

        List<String> listNombres = query.getResultList();

        listNombres.forEach(nombre -> sb.append(nombre).append("\n"));

        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private static String listarNombreCentroProvincia(EntityManager em) {

        StringBuilder sb = new StringBuilder("--La lista de todos los nombres de los centros de la provincia de Valencia--\n");

        Query query = em.createQuery("SELECT c.centre FROM Centre c WHERE c.provincia.nom = :provinciaNom");
        query.setParameter("provinciaNom","Prov. de València");

        List<String> listNombres = query.getResultList();

        listNombres.forEach(nombre -> sb.append(nombre).append("\n"));

        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private static String listarNomCodiCicle(EntityManager em) {

        StringBuilder sb = new StringBuilder("--La lista de todos los nombres y códigos de los ciclos--\n");

        Query query = em.createQuery("SELECT c FROM Cicle c");

        List<Cicle> listCicles = query.getResultList();

        String resultado = listCicles.stream()
                .map(cicle -> "Nombre: " + cicle.getNom() + " - Código: " + cicle.getCodi())
                .collect(Collectors.joining("\n"));

        sb.append(resultado).append("\n");

        return sb.toString();
    }

    private static String listarCentrosPorCicle(EntityManager em) {

        StringBuilder sb = new StringBuilder("--La lista de todos los centros donde se imparte DAM--\n");

        TypedQuery<Centre> query = em.createQuery("SELECT c FROM Centre c JOIN c.cicles ci WHERE ci.codi = :cicleCodi", Centre.class);
        query.setParameter("cicleCodi","DAM");

        List<Centre> listCentres = query.getResultList();

        listCentres.forEach(centre -> sb.append(centre.toString()).append("\n"));

        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private static String listarCentroID(EntityManager em) {

        StringBuilder sb = new StringBuilder("--La lista del centro con la id = 18--\n");

        Query query = em.createQuery("SELECT c FROM Cicle c where c.id = :id");
        query.setParameter("id",18);

        List<Cicle> listCicles = query.getResultList();

        String resultado = listCicles.stream()
                .map(cicle -> "Nombre: " + cicle.getNom() + " - Código: " + cicle.getCodi())
                .collect(Collectors.joining("\n"));

        sb.append(resultado).append("\n");

        return sb.toString();
    }
}