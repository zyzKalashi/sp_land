package com.kailash.land.entity;

import java.io.Serializable;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class RoleMenuEntity implements Serializable {
    private Integer pkid;

    private Integer roleId;

    private Integer menuId;

	
    
}