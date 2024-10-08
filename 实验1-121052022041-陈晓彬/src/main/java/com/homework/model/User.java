package com.homework.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * @desc:
 * @author: Ping
 * @date: 2024/9/17 21:12
 */

@Data
@Accessors(chain = true)
public class User {
    private int userId ;
    private String name ;
    private String password ;
    private int gender ;
    private String salt ;
    private Date createTime ;
    private List<Role> roles ;
}
