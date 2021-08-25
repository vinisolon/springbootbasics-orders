package com.vinisolon.orders.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class User implements Serializable {

    private static final long serialVersionUID = -2244715368275881723L;

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

}
