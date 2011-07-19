package org.tapescala.poso

import java.util.Date
import javax.persistence.{Column,Entity,FetchType,GeneratedValue,Id,JoinColumn,JoinTable,Table,Temporal,TemporalType}
import javax.persistence.{OneToMany}
import reflect.BeanProperty

object User {
  
}//end object

@Entity
@Table(name="user")
@serializable
class User {

  @Id
  @GeneratedValue
  @BeanProperty
  @Column(name="id",unique=true,insertable=false,updatable=false)
  var id : Long = _
  
  @BeanProperty
  @Column(name="username",unique=true)
  var username : String = _
  
  @BeanProperty
  @Column(name="password",nullable=false)
  var password : String = _
  
  @BeanProperty
  @Column(name="email",unique=true)
  var email : String = _
  
  @BeanProperty
  @Column(name="phone")
  var phone : String = _
  
  @BeanProperty
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name="created_at",nullable=false,updatable=false)
  var createdAt : Date = _
  
  @BeanProperty
  @Temporal(TemporalType.TIMESTAMP)  
  @Column(name="updated_at")
  var updatedAt : Date = _
  
  @BeanProperty
  @Temporal(TemporalType.TIMESTAMP)  
  @Column(name="deleted_at")
  var deletedAt : Date = _
  
  //@BeanProperty
  //@OneToMany(fetch=FetchType.EAGER)
  //@JoinTable(name="user_group",joinColumns=@JoinColunm(name="user_id"),inverseJoinColumns=@JoinColumn(name="group_id"))
  //var groups : List[Group] = _ ;
  
}//end klass