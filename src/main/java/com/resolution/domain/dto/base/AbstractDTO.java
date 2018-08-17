package com.resolution.domain.dto.base;

import lombok.Data;

import javax.persistence.MappedSuperclass;

/**
 * @author maxima - 30.07.2018
 */

@MappedSuperclass
@Data
public abstract class AbstractDTO {
    private long id;
}
