
package com.mycompany.gestoreluce1;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;


@Path("GestioneLuce")
public class GestioneLuce {

    static String statoMock = "0";  // di default è a 0 ovvero spento
    Lampadina lampadina = new Lampadina(true);

    public GestioneLuce() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public JsonMap getJson() {
        JsonMap mock;
        if (statoMock.equals("0")) {
            mock = new JsonMap("001", "0", "Success! 0", "spento");
        } else {
            mock = new JsonMap("001", "1", "Success! 1", "acceso");
        }
        return mock;

    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public JsonMap postJson(JsonMap ordine) {
        try {
            if (ordine.getAction().equals("ACCENDI")) {
                System.out.println("sono nella post del progetto GestoreLUca1");
                statoMock = "1";
                String msg = lampadina.getGestione(true);
                if (msg.substring(0, 6).equals("Errore")) {
                    ordine.setMessage(msg);
                    ordine.setStatus("ERROR");
                } else {
                    ordine.setMessage(msg);
                    ordine.setStatus(msg.charAt(msg.length() - 1) + "");
                }
            } else if (ordine.getAction().equals("SPEGNI")) {
                statoMock = "0";
                
                // TODO da modificare la chiamata al rele connection
                String msg = lampadina.getGestione(false);
                if (msg.substring(0, 6).equals("Errore")) {
                    ordine.setMessage(msg);
                    ordine.setStatus("ERROR");
                } else {
                    ordine.setMessage(msg);
                    ordine.setStatus(msg.charAt(msg.length() - 1) + "");
                }
            } else {
                ordine.setMessage("Errore digitazione comando");
                ordine.setStatus("ERROR");
            }

        } catch (Exception ex) {
            ordine.setMessage(ex.toString());
        }
        return ordine;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
