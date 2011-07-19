package org.tapescala.services

import java.io.{Serializable=>JSerializable}

trait ReadableService[ T , K <: JSerializable ]{
  
  def findAll() : List[ T ] 
  def findAll( firstResult : Int , maxResults : Int ) : List[ T ]
  def findAll( firstResult : Int , maxResults : Int , orderByProperty : String , ascending : Boolean ) : List[ T ]
  
  def count() : Int 
  
  def load( key : K ) : T 
  def evict( entity : T ) : Unit 
  def refresh( entity : T ) : Unit
  def merge( entity : T ) : T
  
}//end trait

trait WriteableService[ T , K <: JSerializable ]{
  
  def save( entity : T ) : T
  def update( entity : T ) : T
  def saveOrUpdate( entity : T ) : T
  def delete( key : K ) : Boolean
  def delete( entity : T ) : Boolean
  
}//end trait

trait CrudService[ T , K <: JSerializable ] 
                    extends ReadableService[ T , K ]
                    with WriteableService[ T , K ] {
  
}//end trait