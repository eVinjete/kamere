package si.evinjete.kamere;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class KameraService {
    @PersistenceContext(unitName = "evinjete-kamere")
    private EntityManager em;

    public Kamera getKamera(String kameraId) {
        return em.find(Kamera.class, kameraId);
    }

    public List<Kamera> getKamere() {
        List<Kamera> kamere = em
                .createNamedQuery("Kamera.findKamere", Kamera.class)
                .getResultList();

        return kamere;
    }

    @Transactional
    public void saveKamera(Kamera kamera) {
        if (kamera != null) {
            em.persist(kamera);
        }
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void deleteKamera(String kameraId) {
        Kamera kamera = em.find(Kamera.class, kameraId);
        if (kamera != null) {
            em.remove(kamera);
        }
    }

    @Transactional
    public Kamera addNewKamera(Kamera kamera) {
        if (kamera != null) {
            em.persist(kamera);
        }
        return kamera;
    }
}
