package com.li.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: li he
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    private String password;

    private String email;

    private String role;

    private String fullName;
}
