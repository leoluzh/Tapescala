package org.tapescala.services.impl

import org.tapescala.services.CrudService
import org.tapescala.dao.CrudDao
import java.io.{Serializable=>JSerializable}

class CrudServiceImpl[ T , K <: JSerializable ]
        ( dao : CrudDao[ T , K ] ) 
		extends CrudService[ T , K ] {
  
  require( dao != null , "Dao cannot be null" )
  
  
  def findAll() : List[ T ] = {
    dao.findAll()
  }//end method 
  
  def findAll( firstResult : Int , maxResults : Int ) : List[ T ] = {
    dao.findAll( firstResult , maxResults )
  }//end method
  
  def findAll( firstResult : Int , maxResults : Int , orderByProperty : String , ascending : Boolean ) : List[ T ] = {
    dao.findAll( firstResult , maxResults , orderByProperty , ascending )
  }//end method
  
  def count() : Int = {
    dao.count()
  }//end method
  
  def load( key : K ) : T = {
    dao.load( key )
  }//end method 
  
  def evict( entity : T ) : Unit = {
    dao.evict( entity )
  }//end method
  
  def refresh( entity : T ) : Unit = {
    dao.refresh( entity )
  }//end method
  
  def merge( entity : T ) : T = {
    dao.merge( entity )
  }//end method
  
  def save( entity : T ) : T = {
    dao.save( entity )
  }//end method
  
  def update( entity : T ) : T = {
    dao.update( entity )
  }//end method
  
  def saveOrUpdate( entity : T ) : T = {
    dao.saveOrUpdate( entity )
  }//end method
  
  def delete( key : K ) : Boolean = {
    dao.delete( key )
  }//end method
  
  def delete( entity : T ) : Boolean = {
    dao.delete( entity )
  }//end method
  
}//end klass