package es.cheste;

import es.cheste.clases.Centre;
import es.cheste.clases.Cicle;
import es.cheste.clases.Provincia;
import es.cheste.clases.Regim;
import jakarta.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

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
        System.out.println("---------------------------------------------------------------");
        System.out.println(listarCentroID(em));
        System.out.println("---------------------------------------------------------------");
        System.out.println(crearEntidad(em));

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
        query.setParameter("provinciaNom", "Prov. de València");

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
        query.setParameter("cicleCodi", "DAM");

        List<Centre> listCentres = query.getResultList();

        listCentres.forEach(centre -> sb.append(centre.toString()).append("\n"));

        return sb.toString();
    }

    private static String listarCentroID(EntityManager em) {

        StringBuilder sb = new StringBuilder("--La lista del centro con la id = 18--\n");

        Query query = em.createQuery("SELECT c FROM Centre c where c.id = :id");
        query.setParameter("id", 18);

        Centre centre = (Centre) query.getSingleResultOrNull();

        sb.append(centre.toString()).append("\n");

        return sb.toString();
    }

    private static String crearEntidad(EntityManager em) {

        StringBuilder sb = new StringBuilder("--Se va a intentar introducir un dato nuevo a la base de datos--\n");

        Regim regim = (Regim) obtenerEntidadBD(em, "Regim", "nom", "Públic");
        Provincia provincia = (Provincia) obtenerEntidadBD(em, "Provincia", "nom", "Prov. d'Alacant");
        Cicle dam = (Cicle) obtenerEntidadBD(em, "Cicle", "codi", "DAM");
        Cicle daw = (Cicle) obtenerEntidadBD(em, "Cicle", "codi", "DAW");
        Cicle smx = (Cicle) obtenerEntidadBD(em, "Cicle", "codi", "SMX");

        if (regim != null && provincia != null && dam != null && daw != null && smx != null) {

            em.getTransaction().begin();

            Centre centre = new Centre(regim, provincia, "03013339", "IES LA MAR", "Av. AUGUSTA, 2", "03730 - XÀBIA", "966428205");
            centre.agregarCiclos(dam, daw, smx);
            em.persist(centre);

            em.getTransaction().commit();

            sb.append("Se ha introducido correctamente a la base de datos ").append(centre.toString()).append("\n");
        } else {
            sb.append("No se pudo insertar a la base de datos\n");
            LOGGER.error("Se introdujo un valor null regim={}, provincia={}, dam={}, daw={}, smx={}", regim, provincia, dam, daw, smx);
        }
        return sb.toString();
    }

    private static Object obtenerEntidadBD(EntityManager em, String entidad, String campo, String datoBuscar) {

        String sqlBusqueda = "SELECT e FROM " + entidad + " e " + " WHERE e." + campo + " = :" + campo;

        Query query = em.createQuery(sqlBusqueda);
        query.setParameter(campo, datoBuscar);

        return query.getSingleResultOrNull();
    }

    //TODO queda hacer actualización de teléfono
    //Todo queda borrar centro IES LA MAR, comprobar como borrar

}