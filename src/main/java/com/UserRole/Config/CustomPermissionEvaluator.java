package com.UserRole.Config;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.UserRole.Entity.User;
import com.UserRole.Service.PermissionService;

@Service
public class CustomPermissionEvaluator {
	@Autowired
	private PermissionService permissionService;
	
	
	public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
	    if (authentication.getPrincipal() instanceof User) {
	        User user = (User) authentication.getPrincipal();
	        String requiredPermission = (String) permission;

	        // Check the required permission
	        if ("READ".equals(requiredPermission) || "WRITE".equals(requiredPermission) || "DELETE".equals(requiredPermission)) {
	            // Users with the "ADMIN" role have "READ," "WRITE," and "DELETE" permissions for all resources
	            if (user.getRoles().contains("ADMIN")) {
	                return true;
	            }

	            // Users with the "USER" role can have permissions based on the resource and admin grants
	            if (user.getRoles().contains("USER")) {
                    Map<String, Boolean> permissions = permissionService.getResourcePermissions().get(targetDomainObject);
	                if (permissions != null) {
	                    Boolean granted = permissions.get(requiredPermission);
	                    if (granted != null && granted) {
	                        return true;
	                    }
	                }
	            }
	        }
	    }

	    return false;
	}
}
