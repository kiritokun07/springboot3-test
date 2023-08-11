package com.kirito.test.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParamBO implements Serializable {

    private Integer a;

    private String b;

    private Date c;

}
