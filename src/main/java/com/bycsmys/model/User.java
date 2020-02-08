package com.bycsmys.model;

import lombok.*;

/**
 * @Author wangqd
 * @DATE 2020-02-06
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {

    private String userName;

    private int age;
}
