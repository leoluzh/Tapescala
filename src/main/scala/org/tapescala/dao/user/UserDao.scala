package org.tapescala.dao.user

import org.tapescala.poso.{User}
import org.tapescala.dao.CrudDao
//TRICK: Rename java type
import java.lang.{Long=>JLong}

trait UserDao extends CrudDao[ User , JLong ] {

}//end trait