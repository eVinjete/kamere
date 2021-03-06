package si.evinjete.kamere;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@RequestScoped
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
        kamera.setDirection(this.direction);
        kamera.setTimestamp(new Date());
        kamera.setLocation(this.location);

        kameraBean.addNewKamera(kamera);

        this.setId(null);
        this.setDirection(null);
        this.setTimestamp(null);
        this.setLocation(null);
    }

    public void removeKamera(Integer id) {
        kameraBean.deleteKamera(Integer.toString(id));
    }

    public List<Kamera> getKamere() {
        return kameraBean.getKamere();
    }
}
