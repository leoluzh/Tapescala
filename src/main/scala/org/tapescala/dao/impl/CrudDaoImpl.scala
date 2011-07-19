package org.tapescala.dao.impl


import java.io.{Serializable=>JSerializable}

import org.tapescala.dao.{CrudDao}

import org.hibernate.{Criteria,Session,SessionFactory}
import org.hibernate.criterion.{Example,MatchMode,Order,Projections,Restrictions}

//TIP AND TRICK:
//Convert java collections to scala collections
import scala.collection.JavaConversions._
//Used to get the shadown type -> we need this because jvm do not retified type. (CRL/.NET uses)
import scala.reflect.Manifest

/**
 * @author: Leonardo Luz Fernandes ( leonardo.l.fernandes<at>gmail.com )
 * @version: 0.1
 * @since: 14/07/2011 (dd/MM/yyyy) 
 * */

//EXPLAIN CODE:
// T <: JSerializable -> Java code : ? extends java.io.Serializable
//classOf[ T ] -> Java code: T.class.getClass() 
//toList -> convert java collection to scala collection

//Java Convention to type parameters
//T -> means type
//K -> means key

class CrudDaoImpl[ T , K <: JSerializable ] 
	( sessionFactory : SessionFactory ) 
	( implicit entityClass : Manifest[ T ] )
    extends CrudDao[ T , K ] {
  
    require( sessionFactory != null , "Session Factory cannot be null" )
    
    //Access/Import to crud class statics fields 
	import org.hibernate.criterion.CriteriaSpecification._                       
	
	def session() : Session = {
	  sessionFactory.getCurrentSession()
	}//end method
		
	def findAll() : List[ T ] = {	  
	  var criteria : Criteria = session().createCriteria( entityClass.erasure ) 
	  criteria.setResultTransformer( DISTINCT_ROOT_ENTITY )
	  criteria.list().toList.asInstanceOf[ List[ T ] ]
	}//end method
	
	def findAll( firstResult : Int , maxResults : Int ) : List[ T ] = {
	  var criteria : Criteria = session().createCriteria( entityClass.erasure )
	  criteria.setFirstResult( firstResult )
	  criteria.setMaxResults( maxResults )
	  criteria.setResultTransformer( DISTINCT_ROOT_ENTITY )
	  criteria.list().toList.asInstanceOf[ List[ T ] ]
	}//end method 
	
	def findAll( firstResult : Int , maxResults : Int , propertyName : String , ascending : Boolean ) : List[ T ] = {
	  var criteria : Criteria = session().createCriteria( entityClass.erasure )
	  criteria.setFirstResult( firstResult )
	  criteria.setMaxResults( maxResults )
	  criteria.setResultTransformer( DISTINCT_ROOT_ENTITY )
	  if( propertyName != null ){
	    if( ascending ){
	      criteria.addOrder( Order.asc( propertyName ) )
	    }else{
	      criteria.addOrder( Order.desc( propertyName ) )
	    }//end else
	  }//end if
	  criteria.list().toList.asInstanceOf[ List[ T ] ]
	}//end method
	
	def count() : Int = {
	  var criteria : Criteria = session().createCriteria( entityClass.erasure )
	  criteria.setProjection( Projections.rowCount() )
	  criteria.uniqueResult().asInstanceOf[ Int ]
	}//end method
	
	def load( key : K ) : T = {
	  if( key == null ){
	    throw new IllegalArgumentException("Parameter key cannot be null.")
	  }else{
	    session().get( entityClass.erasure , key ).asInstanceOf[ T ]
	  }//end else
	}//end method 
	
	def evict( entity : T ) : Unit = {
	  session().evict( entity )
	}//end method
	
	def merge( entity : T ) : T = {
	  session().merge( entity )
	  entity
	}//end method
	
	def refresh( entity : T ) : Unit = {
	  session().refresh( entity )
	  entity
	}//end method
	
	def save( entity : T ) : T = {
	  session().save( entity )
	  entity
	}//end method
	
	def update( entity : T ) : T = {
	  session().update( entity )
	  entity
	}//end method
	
	def saveOrUpdate( entity : T ) : T = {
	  session().saveOrUpdate( entity )
	  entity
	}//end method
	
	def delete( entity : T ) : Boolean = {
	  if( entity == null ){
	    throw new IllegalArgumentException("Parameter entity cannot be null.")
	  }//end if
	  session().delete( entity )
	  true
	}//end method
	
	def delete( key : K ) : Boolean = {	  
	  if( key == null ){
	    throw new IllegalArgumentException("Parameter keu cannot be null")
	  }//end if  
	  var entity : T = load( key )
	  if( entity == null ){
	    throw new IllegalArgumentException("There is no entity of this type with key " + key )
	  }//end if
	  delete( entity )
	  true
	}//end method
	
}//end klass