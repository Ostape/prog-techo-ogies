package com.robosh.model.lector;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JavaLector implements Lector {
    private String name;
    private String surname;

    @Override
    public String giveLecture() {
        return "Give a lecture for students. Show code samples ";
    }
}
