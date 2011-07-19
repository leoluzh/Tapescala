package org.tapescala.poso

import java.util.Date
import javax.persistence.{Column,Entity,FetchType,GeneratedValue,Id,JoinColumn,JoinTable,Table,Temporal,TemporalType}
import reflect.BeanProperty

object Group {
  
}//end klass

@Entity
@Table(name="group")
@serializable
class Group {

  @Id
  @BeanProperty
  @Column(name="id",unique=true,updatable=false,insertable=false)
  var id : Long = _
  
  @BeanProperty
  @Column(name="name",unique=true,nullable=false)
  var name : String = _
  
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
  
  @BeanProperty
  var users : List[User] = _
  
}//end klass