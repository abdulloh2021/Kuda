package com.kuda.model.obj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginObj {
    private String email;
    private String password;
    private String device_name;
}
