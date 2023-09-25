package com.UserRole.Service;


import java.util.Map;

public interface PermissionService {
    Map<Object, Map<String, Boolean>> getResourcePermissions();
}
