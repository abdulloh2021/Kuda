package com.kuda.model.obj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpObj {

    private String name;
    private String email;
    private String password;
    private String password_confirmation;
    private String question;
    private String answer;
    private String device_name;

}
