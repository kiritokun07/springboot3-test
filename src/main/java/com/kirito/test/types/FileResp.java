package com.kirito.test.types;

import lombok.Data;

import java.io.Serializable;

@Data
public class FileResp implements Serializable {
    private String name;
}
