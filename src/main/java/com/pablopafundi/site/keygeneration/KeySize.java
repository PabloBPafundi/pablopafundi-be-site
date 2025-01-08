package com.pablopafundi.site.keygeneration;

public enum KeySize {

    BITS_256(256), BITS_384(384), BITS_512(512);

    private final int bitLength;

    KeySize(int bitLength) {
        this.bitLength = bitLength;
    }

    public int getBitLength() {
        return bitLength;
    }

}

