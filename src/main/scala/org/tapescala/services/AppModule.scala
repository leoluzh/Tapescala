package org.tapescala.services

import java.io.IOException

import org.apache.tapestry5._
import org.apache.tapestry5.ioc.MappedConfiguration
import org.apache.tapestry5.ioc.OrderedConfiguration
import org.apache.tapestry5.ioc.ServiceBinder
import org.apache.tapestry5.ioc.annotations.Local
import org.apache.tapestry5.services.Request
import org.apache.tapestry5.services.RequestFilter
import org.apache.tapestry5.services.RequestHandler
import org.apache.tapestry5.services.Response
import org.slf4j.Logger

object AppModule {
  
    def bind( binder : ServiceBinder ) {
        
      // binder.bind(MyServiceInterface.class, MyServiceImpl.class);
        
        // Make bind() calls on the binder object to define most IoC services.
        // Use service builder methods (example below) when the implementation
        // is provided inline, or requires more initialization than simply
        // invoking the constructor.
    
    }//end method
    
    
    def contributeApplicationDefaults( configuration : MappedConfiguration[String, String] ) {
        // Contributions to ApplicationDefaults will override any contributions to
        // FactoryDefaults (with the same key). Here we're restricting the supported
        // locales to just "en" (English). As you add localised message catalogs and other assets,
        // you can extend this list of locales (it's a comma separated series of locale names;
        // the first locale name is the default when there's no reasonable match).
        
        configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en")

        // The factory default is true but during the early stages of an application
        // overriding to false is a good idea. In addition, this is often overridden
        // on the command line as -Dtapestry.production-mode=false
        configuration.add(SymbolConstants.PRODUCTION_MODE, "false")

        // The application version number is incorprated into URLs for some
        // assets. Web browsers will cache assets because of the far future expires
        // header. If existing assets are changed, the version number should also
        // change, to force the browser to download new versions.
        configuration.add(SymbolConstants.APPLICATION_VERSION, "1.0-SNAPSHOT")
    
    }//end method  
  
    
     /**
     * This is a service definition, the service will be named "TimingFilter". The interface,
     * RequestFilter, is used within the RequestHandler service pipeline, which is built from the
     * RequestHandler service configuration. Tapestry IoC is responsible for passing in an
     * appropriate Logger instance. Requests for static resources are handled at a higher level, so
     * this filter will only be invoked for Tapestry related requests.
     * 
     * <p>
     * Service builder methods are useful when the implementation is inline as an inner class
     * (as here) or require some other kind of special initialization. In most cases,
     * use the static bind() method instead. 
     * 
     * <p>
     * If this method was named "build", then the service id would be taken from the 
     * service interface and would be "RequestFilter".  Since Tapestry already defines
     * a service named "RequestFilter" we use an explicit service id that we can reference
     * inside the contribution method.
     */  
  
    def buildTimingFilter( log : Logger ) = {
        new RequestFilter(){
           override def service( request : Request , response : Response , handler : RequestHandler ) : Boolean = {
                val startTime = System.currentTimeMillis()
                try{
                    handler.service(request, response)
                }finally{
                    val elapsed = System.currentTimeMillis() - startTime
                    log.info("Request time: %d ms".format(elapsed))
                }//end finally
            }//end method
        }//end new    
    }//end method

    /**
     * This is a contribution to the RequestHandler service configuration. This is how we extend
     * Tapestry using the timing filter. A common use for this kind of filter is transaction
     * management or security. The @Local annotation selects the desired service by type, but only
     * from the same module.  Without @Local, there would be an error due to the other service(s)
     * that implement RequestFilter (defined in other modules).
     */
    def contributeRequestHandler( configuration : OrderedConfiguration[RequestFilter] ,
            @Local
            filter : RequestFilter) {
      
        // Each contribution to an ordered configuration has a name, When necessary, you may
        // set constraints to precisely control the invocation order of the contributed filter
        // within the pipeline.
        
        configuration.add("Timing", filter)
        
    }//end method    
    
    //def contributeRequestHandler( configuration : OrderedConfiguration[RequestFilter] , 
    //							  locator : ObjectLocator ) {
    //	configuration.add("Timing",locator.getService("timingService",classOf[RequestFilter]))
    //}//end method
  
}//end object 

