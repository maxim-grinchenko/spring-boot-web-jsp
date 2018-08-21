package com.resolution.domain.entity.dto;

/**
 * @author maxima - 21.08.2018
 */

public class CodeDto {
    public String code;

    public CodeDto() {
    }

    public CodeDto(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CodeDto{" +
            "code='" + code + '\'' +
            '}';
    }
}
