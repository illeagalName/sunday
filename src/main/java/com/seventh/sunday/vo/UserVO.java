package com.seventh.sunday.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ami
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO implements Serializable {
    private Long id;
    private String name;
}
