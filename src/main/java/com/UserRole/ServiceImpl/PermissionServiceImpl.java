package com.UserRole.ServiceImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.UserRole.Service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
	
	 private Map<Object, Map<String, Boolean>> resourcePermissions = new HashMap<>();

	    @Override
	    public Map<Object, Map<String, Boolean>> getResourcePermissions() {
	        return resourcePermissions;
	    }
	}


