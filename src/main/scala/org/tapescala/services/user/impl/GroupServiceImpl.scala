package org.tapescala.services.user.impl

import org.tapescala.poso.Group
import org.tapescala.dao.user.GroupDao
import org.tapescala.services.user.GroupService
import org.tapescala.services.impl.TransactionalCrudServiceImpl
import java.lang.{Long=>JLong}

class GroupServiceImpl ( val dao : GroupDao ) 
					extends TransactionalCrudServiceImpl[ Group , JLong ]( dao ) 
					with GroupService {
  
	require( dao != null , "Group dao cannot be null" )

}//end klass