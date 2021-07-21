package io.devdezyn.devlearnrest.auth;

import io.devdezyn.devlearnrest.permissions.Permission;
import io.devdezyn.devlearnrest.permissions.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/permissions")
public class AuthController {
    private final PermissionService permissionService;

    @Autowired
    public AuthController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping
    public List<Permission> getPermissions () {
        return permissionService.getPermissions();
    }
}
