package org.nerdcoding.sample.quarkus;

import org.jboss.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class GreetingResource {

    private static final Logger LOG = Logger.getLogger(GreetingResource.class);

    @GET
    @Path("/{message}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello(@PathParam("message") final String message) {
        return Response
                .status(Response.Status.OK)
                .entity(new GreetingResponse(message))
                .build();
    }
}