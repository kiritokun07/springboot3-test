package com.kirito.test.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBO implements Serializable {

    private Integer key;

    private String value;

}
