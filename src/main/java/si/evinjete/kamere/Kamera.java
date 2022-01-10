package si.evinjete.kamere;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "kamera")
@NamedQueries({
        @NamedQuery(
                name = "Kamera.findKamere",
                query = "SELECT k " +
                        "FROM Kamera k"
        )
})
public class Kamera implements Serializable {

    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "password", nullable = false, updatable = false)
    private String password;
    @Column(name = "location", nullable = false, updatable = false)
    private String location;
    @Column(name = "timestamp", nullable = false, updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date timestamp;
    @Column(name = "direction", nullable = false, updatable = false)
    private String direction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getLocation() {
        return location;
    }

    public void  setLocation(String location) {
        this.location = location;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate = formatter.format(timestamp);
        return "ID: " + id + "\n" +
               "Lokacija: " + location + "\n" +
               "Smer: " + direction + "\n" +
               "Čas dodajanja:" + strDate + "\n";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
