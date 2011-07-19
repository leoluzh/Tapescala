package org.tapescala.services.user

import org.tapescala.poso.User
import org.tapescala.services.CrudService
import java.lang.{Long=>JLong}

trait UserService extends CrudService[ User , JLong ] {

}//end trait