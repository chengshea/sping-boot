package com.cs.mapper;

import java.util.List;
import java.util.Map;

import com.cs.model.CsPermission;
import com.cs.util.MyMapper;

public interface PermissionService extends MyMapper<CsPermission>{

	List<CsPermission> queryAll();

	List<CsPermission> queryUserResources(Map<String, Object> map);

}
