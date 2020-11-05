package org.nerdcoding.sample.quarkus.controller;

import org.nerdcoding.sample.quarkus.service.PersonService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/person")
public class PersonResource {

    private final PersonService personService;

    @Inject
    public PersonResource(final PersonService personService) {
        this.personService = personService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllPersons() {
        return Response
                .status(Response.Status.OK)
                .entity(personService.findAllPersons())
                .build();
    }

    @GET
    @Path("/{lastName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findPersonByLastName(@PathParam("lastName") final String lastName) {
        return personService.findPersonByLastName(lastName)
                .map(person -> Response
                        .status(Response.Status.OK)
                        .entity(person)
                        .build()
                ).orElse(Response
                        .status(Response.Status.NOT_FOUND)
                        .build()
                );

    }

}
