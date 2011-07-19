package org.tapescala.dao.user

import org.tapescala.poso.{Group}
import org.tapescala.dao.{CrudDao}
import java.lang.{Long=>JLong}

trait GroupDao extends CrudDao[ Group , JLong ] {

}//end trait