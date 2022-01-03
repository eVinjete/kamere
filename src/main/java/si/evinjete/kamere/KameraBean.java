package si.evinjete.kamere;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ManagedBean
@SessionScoped
public class KameraBean implements Serializable {

    @Inject
    private KameraService kameraBean;

    public KameraBean(){}

    public KameraBean(Integer id, String location, String direction){
        this.id = id;
        this.location = location;
        this.timestamp = new Date();
        this.direction = direction;
    }

    private Integer id;
    private String location;
    private Date timestamp;
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

    public void addKamera() {
        Kamera kamera = new Kamera();
        kamera.setId(this.id);
        kamera.setDirection(this.direction);
        kamera.setTimestamp(this.timestamp);
        kamera.setLocation(this.location);

        //kameraBean.addNewKamera(kamera);

        this.setId(null);
        this.setDirection(null);
        this.setTimestamp(null);
        this.setLocation(null);
    }

//    public List<Kamera> getKamere() {
//        return kameraBean.getKamere();
//    }

    @Override
    public String toString() {
        return "Kamera {\n" +
                "  id='" + id + "',\n" +
                "  location='" + location + "',\n" +
                "  direction='" + direction + "'\n" +
                "  timestamp='" + timestamp + "'\n" +
                "}";
    }
}
