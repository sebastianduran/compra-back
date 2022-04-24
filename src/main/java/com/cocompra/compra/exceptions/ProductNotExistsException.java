package com.cocompra.compra.exceptions;

public class ProductNotExistsException extends IllegalArgumentException{
    public ProductNotExistsException(String msg) {
        super(msg);
    }
}
