/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.italika.entities.service;

import com.italika.connect.ConnectURL;
import com.italika.entities.Productos;
import com.italika.entities.Tipos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author kiaka
 */
@Stateless
@Path("com.italika.entities.productos")
public class ProductosFacadeREST extends AbstractFacade<Productos> {

    ConnectURL cURL = new ConnectURL();
    @PersistenceContext(unitName = "RESTItalikaPU")
    private EntityManager em;

    public ProductosFacadeREST() {
        super(Productos.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Productos entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Productos entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Productos find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("/modelo/{modelo}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Productos> findModelo(@PathParam("modelo") String modelo) {
        try {
            Connection con = cURL.Conectar();
            PreparedStatement st = con.prepareStatement("execute modelo ?");
            st.setString(1, modelo);
            ResultSet rs = st.executeQuery();
            List<Productos> lista= new ArrayList<>();
            while (rs.next()) {
                Productos producto= new Productos();
                producto.setId(rs.getInt(1));
                producto.setSku(rs.getString(2));
                producto.setFert(rs.getString(3));
                producto.setModelo(rs.getString(4));
                producto.setTipo(rs.getString(5));
                producto.setNumeroserie(rs.getString(6));
                producto.setFecha(rs.getDate(7));
                lista.add(producto);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Productos> findAll() {
        try {
            Connection con = cURL.Conectar();
            PreparedStatement st = con.prepareStatement("execute todos");
            //st.setString(1, "AT110");
            ResultSet rs = st.executeQuery();
            List<Productos> lista= new ArrayList<>();
            while (rs.next()) {
                Productos producto= new Productos();
                producto.setId(rs.getInt(1));
                producto.setSku(rs.getString(2));
                producto.setFert(rs.getString(3));
                producto.setModelo(rs.getString(4));
                producto.setTipo(rs.getString(5));
                producto.setNumeroserie(rs.getString(6));
                producto.setFecha(rs.getDate(7));
                lista.add(producto);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    @GET
    @Path("/sku/{sku}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Productos> findSKU(@PathParam("sku") String sku) {
        try {
            Connection con = cURL.Conectar();
            PreparedStatement st = con.prepareStatement("execute sku ?");
            st.setString(1, sku);
            ResultSet rs = st.executeQuery();
            List<Productos> lista= new ArrayList<>();
            while (rs.next()) {
                Productos producto= new Productos();
                producto.setId(rs.getInt(1));
                producto.setSku(rs.getString(2));
                producto.setFert(rs.getString(3));
                producto.setModelo(rs.getString(4));
                producto.setTipo(rs.getString(5));
                producto.setNumeroserie(rs.getString(6));
                producto.setFecha(rs.getDate(7));
                lista.add(producto);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    @GET
    @Path("/buscar/tipos/todos")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tipos> findTipos(@PathParam("sku") String sku) {
        try {
            Connection con = cURL.Conectar();
            PreparedStatement st = con.prepareStatement("execute todostipos");
            //st.setString(1, sku);
            ResultSet rs = st.executeQuery();
            List<Tipos> lista= new ArrayList<>();
            while (rs.next()) {
                Tipos tipos= new Tipos();
                tipos.setId(rs.getInt(1));
                tipos.setTipo(rs.getString(2));
                lista.add(tipos);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
