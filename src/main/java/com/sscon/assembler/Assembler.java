package com.sscon.assembler;

public abstract class Assembler <D, T> {

    public abstract T toEntity(D dto);

    public abstract D toDTO(T entity);
}
