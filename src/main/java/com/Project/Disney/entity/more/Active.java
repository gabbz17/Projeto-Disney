package com.Project.Disney.entity.more;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Active {

    YES,
    NO;

    @JsonCreator
    public static Active fromString(String value) {
        if (value != null) {
            switch (value.toUpperCase()) {
                case "Y":
                    return YES;

                case "N":
                    return NO;

            }
        }
        throw new RuntimeException("Valor inválido para informação: " + value);
    }
}
