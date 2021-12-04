package com.example.distrubutedsystem.entity;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {
    @NotNull
    private int id;
    private String name;
}
