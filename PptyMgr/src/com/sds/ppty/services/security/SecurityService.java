package com.sds.ppty.services.security;

import com.sds.ppty.common.exception.ServiceException;
import com.sds.ppty.entities.common.UserVO;

public interface SecurityService {

	public void registerUser(UserVO user)throws ServiceException;
}
