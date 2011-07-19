package org.tapescala.services.impl

import org.tapescala.dao.CrudDao
import org.springframework.transaction.annotation.{Propagation,Transactional}
import java.io.{Serializable=>JSerializable}

/**
 * @author leonardo luz fernandes ( leonardo.l.fernandes<at>gmail.com )
 * @since 15/07/2011
 * @version 0.1
 * */

class TransactionalCrudServiceImpl[ T , K <: JSerializable ] 
		( dao : CrudDao[ T , K ] ) 
		extends CrudServiceImpl( dao ) {

  require( dao != null , "Dao cannot be null")

  @Transactional(readOnly=true)  
  override def findAll() : List[ T ] = {
    super.findAll()
  }//end method 
  
  @Transactional(readOnly=true)
  override def findAll( firstResult : Int , maxResults : Int ) : List[ T ] = {
    super.findAll( firstResult , maxResults )
  }//end method
  
  @Transactional(readOnly=true)  
  override def findAll( firstResult : Int , maxResults : Int , orderByProperty : String , ascending : Boolean ) : List[ T ] = {
    super.findAll( firstResult , maxResults , orderByProperty , ascending )
  }//end method
  
  @Transactional(readOnly=true)  
  override def count() : Int = {
    super.count()
  }//end method
  
  @Transactional(readOnly=true)  
  override def load( key : K ) : T = {
    super.load( key )
  }//end method 
  
  override def evict( entity : T ) : Unit = {
    super.evict( entity )
  }//end method
  
  @Transactional(readOnly=true)  
  override def refresh( entity : T ) : Unit = {
    super.refresh( entity )
  }//end method
  
  @Transactional  
  override def merge( entity : T ) : T = {
    super.merge( entity )
  }//end method
  
  @Transactional  
  override def save( entity : T ) : T = {
    super.save( entity )
  }//end method
  
  @Transactional  
  override def update( entity : T ) : T = {
    super.update( entity )
  }//end method
  
  @Transactional  
  override def saveOrUpdate( entity : T ) : T = {
    super.saveOrUpdate( entity )
  }//end method
  
  @Transactional  
  override def delete( key : K ) : Boolean = {
    super.delete( key )
  }//end method
  
  @Transactional  
  override def delete( entity : T ) : Boolean = {
    super.delete( entity )
  }//end method  
  
}//end klass