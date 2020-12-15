/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * This is the EMEX51 Restful web Services application class.
 * @author Xabier carnero, Endika Ubierna, Markel Uralde.
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    //Este aplicación es una aplicación web no hay main. Se basa en servicios restful, reciben peticiones HTTP
    //y a partir de ahí hacen cosas. Esta clase contiene dos métodos. En addRest resources se cargan los restful
    //de todas las entities y en setclasses se añanen a un set (una coleccion) para almacenarlas.
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    //Este metodo es el que carga todos los Restful de las entities. Si viene una peticion HTTP sobre una entity
    //y no está en este método no hace nada. Da error.
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.ArmyFacadeREST.class);
        resources.add(service.BossFacadeREST.class);
        resources.add(service.CreatureFacadeREST.class);
        resources.add(service.EmployeeFacadeREST.class);
        resources.add(service.EmployeeSectorManagementFacadeREST.class);
        resources.add(service.SectorContentFacadeREST.class);
        resources.add(service.SectorFacadeREST.class);
        resources.add(service.UserFacadeREST.class);
        resources.add(service.VisitorFacadeREST.class);
    }
    
}
