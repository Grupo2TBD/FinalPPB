/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import ejb.AlbumEJBLocal;
import ejb.CamaraEJBLocal;
import ejb.ExifEJBLocal;
import ejb.FotografiaEJBLocal;
import ejb.TagEJBLocal;
import ejb.UsuarioEJBLocal;
import facade.UsuarioEJBFacade;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Camara;
import model.Usuario;
import weka.ClassifyComment;

/**
 *
 * @author ian
 */
@Path("/prueba")
//@ApplicationPath("/")
public class prueba {
    @EJB
    AlbumEJBLocal albumEJB;
           
    @EJB
    FotografiaEJBLocal fotografiaEJB;
    
    @EJB
    ExifEJBLocal exifEJB;
    
    @EJB
    TagEJBLocal tagEJB;
    
    @EJB
    UsuarioEJBLocal usuarioEJB;
    
    @EJB
    CamaraEJBLocal camaraEJB;
    
    @EJB
    UsuarioEJBFacade userFacade;
    
  
 
    
    //CU4--------->Arreglar ruta
    @GET
    @Path("/insertaAlbum")
    public void crearAlbum(){
        int idUsuario=3;
        String nombre="Vacaciones de Sac";
        String descripcion="Y asi termine en el hospital";
        int privacidad=0;
        int permisos=1;
        String fotoPortada="direccion";
        albumEJB.crearAlbum(idUsuario,nombre,descripcion,privacidad,permisos,fotoPortada);
    }
    
    //CU5
    @GET
    @Path("/editarAlbum")
    public void editarAlbum(){
        
        int idAlbum=1;
        String nombre="album editado";
        String descripcion="descripcion";
        int idPrivacidad=1;
        int idPermiso=2;
        albumEJB.editarAlbum(idAlbum,nombre,descripcion,idPrivacidad,idPermiso);
    }
    
    

    
    
    //CU18
    @GET
    @Path("/editarFoto")
    public void editPhotoService() {
        int idPhoto=1;
        int idPrivacidad=1;
        int idPermiso=2;
        String titulo="Titulo editado";
        String descripcion="Descripcion editada";
        fotografiaEJB.editPhoto(idPhoto, idPrivacidad, idPermiso, titulo, descripcion);
        
    }
    
   
    @GET
    @Path("/users")
    @Produces({"application/json"})
    public List<Usuario> todoUsuarios(){

        return usuarioEJB.usuarios();
    }
    
    @GET
    @Path("/usuario")
    @Produces({"application/json"})
    public Usuario Usuariox(){

        return userFacade.find(3);
    }
    
    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMethod(){
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add("message", "true");
        
        JsonObject jsonObj = jsonObjBuilder.build();
        //Usuario usuario = this.userFacade.find(15);
        return Response.status(Response.Status.OK).entity(jsonObj.toString()).build();
        //return usuario;
    }
    
    @POST
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postMethod() {
        Usuario user=new Usuario();
        user.setAliasUser("wat");
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        jsonObjBuilder.add( "message", "post method ok" );
 
        JsonObject jsonObj = jsonObjBuilder.build();
 
        return Response.status( Response.Status.CREATED ).entity( jsonObj ).build();
    }
    
    @GET
    @Path("/testWEKA")
    @Produces("application/json")
    public Response weka() throws Exception{
        JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        String palabra = "muy buen trabajo";
        ClassifyComment cc = new ClassifyComment();
        String clasif = cc.classify(palabra);
        jsonObjBuilder.add( "message", clasif );
 
        JsonObject jsonObj = jsonObjBuilder.build();
 
        return Response.status( Response.Status.CREATED ).entity( jsonObj ).build();
    }
}
