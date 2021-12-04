package com.example.distrubutedsystem.entity;

import lombok.*;

import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    @NotNull
    private int id;
    private String name;
}
