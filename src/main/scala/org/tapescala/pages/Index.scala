package org.tapescala.pages

import java.util.Date

import org.apache.tapestry5.annotations._

class Index {

  @Property
  val currentTime : Date = new Date()
  
  
}//end klass