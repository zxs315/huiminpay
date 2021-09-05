package com.huiminpay.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stu implements Serializable {

    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private String address;
    private Integer math;
    private Integer english;
}
