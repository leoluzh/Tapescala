package org.tapescala.dao.user.impl

import org.tapescala.poso.Group
import org.tapescala.dao.user.GroupDao
import org.tapescala.dao.impl.CrudDaoImpl
import org.hibernate.{SessionFactory}
import java.lang.{Long=>JLong}

class GroupDaoImpl( val sessionFactory : SessionFactory ) 
		extends CrudDaoImpl[ Group , JLong ]( sessionFactory ) 
		with GroupDao {
	
	require( sessionFactory != null , "Session Factory cannot be null." )
  
  
}//end klass