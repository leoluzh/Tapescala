package org.tapescala.dao.user.impl

import org.tapescala.poso.User
import org.tapescala.dao.user.UserDao
import org.tapescala.dao.impl.CrudDaoImpl
import org.hibernate.{SessionFactory}
import java.lang.{Long=>JLong}

class UserDaoImpl( sessionFactory : SessionFactory ) 
			extends CrudDaoImpl[ User , JLong ]( sessionFactory ) 
			with UserDao {

	require( sessionFactory != null , "Session Factory cannot be null." )
  
  
}//end klass