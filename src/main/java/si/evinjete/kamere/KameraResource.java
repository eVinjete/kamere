package si.evinjete.kamere;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;

@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("kamere")
public class KameraResource {

    @Inject
    private KameraService kameraBean;

    @GET
    public Response getAllKamere() {
        List<Kamera> kamere = kameraBean.getKamere();
        return Response.ok(kamere).build();
    }

    @GET
    @Path("{kameraId}")
    public Response getKamera(@PathParam("kameraId") String kameraId) {
        Kamera kamera = kameraBean.getKamera(kameraId);
        return kamera != null
                ? Response.ok(kamera).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response addNewKamera(Kamera kamera) {

        if (kamera.getDirection() == null || kamera.getLocation() == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            kamera.setTimestamp(new Date());
            kameraBean.addNewKamera(kamera);
        }

        return Response.ok(kamera).build();
    }

    @DELETE
    @Path("{kameraId}")
    public Response deleteKamera(@PathParam("kameraId") String kameraId) {
        kameraBean.deleteKamera(kameraId);
        return Response.noContent().build();
    }
}
