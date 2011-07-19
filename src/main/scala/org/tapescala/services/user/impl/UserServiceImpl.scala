package org.tapescala.services.user.impl

import org.tapescala.poso.User
import org.tapescala.dao.user.UserDao
import org.tapescala.services.user.UserService
import org.tapescala.services.impl.TransactionalCrudServiceImpl
import java.lang.{Long=>JLong}

//poso - plain old scala object -> User

class UserServiceImpl( dao : UserDao ) 
                       extends TransactionalCrudServiceImpl[ User , JLong ] ( dao )
                       with UserService {
  
  require( dao != null , "Dao cannot be null")
  
}//end klass