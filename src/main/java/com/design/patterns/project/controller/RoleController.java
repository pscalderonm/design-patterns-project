package com.design.patterns.project.controller;

import com.design.patterns.project.dto.RoleDTO;
import com.design.patterns.project.models.Response;
import com.design.patterns.project.service.impl.RoleServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleServiceImpl;

    private static HttpStatus status;

    private static Response response;


    @GetMapping("/")
    @Operation(summary = "Returns a role list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns a Role List"),
            @ApiResponse(responseCode = "400", description = "Role List can not be returned"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {@Content()}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content()})
    }
    )
    public ResponseEntity<Response> findAll() {
        List<RoleDTO> roles = roleServiceImpl.findAll();
        if(roles.isEmpty()){
            status = HttpStatus.BAD_REQUEST;
            response =  Response.builder().status(status.toString()).data("No data found").build();
        }else{
            status = HttpStatus.OK;
            response = Response.builder().status(status.toString()).data(roles).build();
        }
        return new ResponseEntity<>(response,status);
    }

    @GetMapping("/{roleName}")
    @Operation(summary = "Returns a role")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns a Role"),
            @ApiResponse(responseCode = "400", description = "Role can not be returned"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {@Content()}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content()})
    }
    )
    public ResponseEntity<Response> findByRoleName(@PathVariable String roleName){
        RoleDTO role = roleServiceImpl.findByRole(roleName);
        if(role != null){
            status = HttpStatus.OK;
            response = Response.builder().status(status.toString()).data(role).build();
        }else{
            status = HttpStatus.BAD_REQUEST;
            response = Response.builder().status(status.toString()).data("No role found").build();
        }
        return new ResponseEntity<>(response,status);
    }

    @PostMapping("/")
    @Operation(summary = "Save role")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Role saved"),
            @ApiResponse(responseCode = "400", description = "Role can not be saved"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {@Content()}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content()})
    }
    )
    public ResponseEntity<Response> save(@RequestBody RoleDTO roleDTO){
        boolean role = roleServiceImpl.save(roleDTO);
        if(role){
            status = HttpStatus.OK;
            response = Response.builder().status(status.toString()).data(roleDTO).build();
        }else {
            status = HttpStatus.BAD_REQUEST;
            response = Response.builder().status(status.toString()).data("role not save").build();
        }
        return new ResponseEntity<>(response,status);
    }

    @PutMapping("/{roleName}")
    @Operation(summary = "Update role")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Role updated"),
            @ApiResponse(responseCode = "400", description = "Role can not be updated"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {@Content()}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content()})
    }
    )
    public ResponseEntity<Response>  update(@PathVariable String roleName, @RequestBody RoleDTO roleDTO){
        RoleDTO role = roleServiceImpl.update(roleName.toUpperCase(),roleDTO);
        if(role!=null){
            status = HttpStatus.OK;
            response = Response.builder().status(status.toString()).data(role).build();
        }else{
            status = HttpStatus.BAD_REQUEST;
            response = Response.builder().status(status.toString()).data("user not update").build();
        }
        return new ResponseEntity<>(response,status);
    }

    @DeleteMapping("/{roleName}")
    @Operation(summary = "Delete role")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Role deleted"),
            @ApiResponse(responseCode = "400", description = "Role can not be deleted"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {@Content()}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = {@Content()})
    }
    )
    public ResponseEntity<Response> delete(@PathVariable String roleName){
        boolean role = roleServiceImpl.deleteByRole(roleName);
        if(role){
            status = HttpStatus.OK;
            response = Response.builder().status(status.toString()).data("role delete success").build();
        }else {
            status = HttpStatus.BAD_REQUEST;
            response = Response.builder().status(status.toString()).data("role not delete").build();
        }
        return new ResponseEntity<>(response,status);
    }
}
