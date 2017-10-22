package com.cs.mapper;

import com.cs.model.CsUser;
import com.cs.util.MyMapper;

public interface UserService extends MyMapper<CsUser> {

	CsUser getByNickname(String username);

	
}
