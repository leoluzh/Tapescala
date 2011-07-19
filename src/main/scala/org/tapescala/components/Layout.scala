package org.tapescala.components

import org.apache.tapestry5._
import org.apache.tapestry5.annotations.{Import} 
import org.apache.tapestry5.annotations._
import org.apache.tapestry5.ioc.annotations.{Inject}
import org.apache.tapestry5.ioc.annotations._

@Import(stylesheet=Array("context:layout/layout.css"))
class Layout {
  
  @Property
  @Parameter(required=true,defaultPrefix=BindingConstants.LITERAL)
  var title : String = _
  
  @Property
  var pageName : String = _
  
  @Property
  @Parameter(defaultPrefix=BindingConstants.LITERAL)
  var sidebarTitle : String = _
  
  @Property
  @Parameter(defaultPrefix=BindingConstants.LITERAL)
  var sidebar : Block = _
  
  @Inject
  var resources : ComponentResources = _
  
  def getClassForPageName() : String = {
    if(resources.getPageName.equalsIgnoreCase(pageName)){
      "current_page_item"
    }else{
      ""
    } 
  }//end method 
  
  def getPageNames() : Array[String] = {
    Array("Index","About","Contact")
  }//end method
    
}//end klass