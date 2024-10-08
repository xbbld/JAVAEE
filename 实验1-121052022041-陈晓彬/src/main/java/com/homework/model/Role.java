package com.homework.model;

import lombok.Data;

import java.util.List;

/**
 * @desc:
 * @author: Ping
 * @date: 2024/9/17 21:38
 */

@Data
public class Role {
    private int roleId ;
    private String name ;
    private List<Permission> permissions ;
}
