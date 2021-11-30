package es.ubu.asi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




/**
 * Root resource (exposed at "textos" path)
 */
@Path("textos")
public class MyResource {
	
	@Produces Set<MyResource> dummyServices() {
	  return new HashSet<MyResource>();
	}
	
	private HashMap<Integer, String> listadoTextos = new HashMap<Integer, String>();
	
	public MyResource() {
		listadoTextos.put(1, "Berlin");
		listadoTextos.put(2, "Oslo");
		listadoTextos.put(3, "Washington DC");
	}
	
	private String listadoTextosString() {
	    StringBuilder mapAsString = new StringBuilder("{");
	    for (Integer key : listadoTextos.keySet()) {
	        mapAsString.append(key + "=" + listadoTextos.get(key) + ", ");
	    }
	    mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("}");
	    return mapAsString.toString();
	}

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getListaTextos() {
        return listadoTextosString();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    public String getTexto(@PathParam("id") String id) {
        return listadoTextos.get(Integer.parseInt(id));
    }
}
