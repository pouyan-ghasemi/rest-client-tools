/**
 *    Copyright 2014 Opower, Inc.
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 **/
package com.opower.rest.test.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * The JAX-RS Resource interface we use to exercise the various JAX-RS implementations with
 * the various client configurations.
 */
@Path("/frob")
@Produces(MediaType.APPLICATION_JSON)
public interface FrobResource {

    /**
     * This method makes sure that @FormParam and POST methods work.
     * @param frobId frobId to use
     * @param name a param to test the @FormParam with
     * @return a Frob
     */
    @POST
    @Path("{frobId}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Frob updateFrob(@PathParam("frobId")String frobId, @FormParam("name") String name);

    /**
     * This method makes sure that GET with @PathParam works.
     * @param frobId the frob id to use
     * @return the Frob you were looking for
     */
    @GET
    @Path("{frobId}")
    Frob findFrob(@PathParam("frobId") String frobId);


    /**
     * This method tests @PUT methods and returning
     * Response objects from methods.
     * @param frob the frob to create
     * @return the Response object.
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    Response createFrob(Frob frob);

    /**
     * Makes sure we can return simple strings.
     * @param echo the string to echo
     * @return String.format("You sent %s", echo)
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String frobString(@QueryParam("echo")String echo);

    /**
     * Used for testing logic in ClientErrorHandler.
     * @return a dummy Frob
     */
    @GET
    @Path("jsonerror")
    Frob frobJsonError();

    /**
     * Used for testing logic in ClientErrorHandler.
     * @param status the status code you want on the response
     * @return a dummy Frob
     */
    @GET
    @Path("errorcode")
    Frob frobErrorResponse(@QueryParam("status")int status);
}
