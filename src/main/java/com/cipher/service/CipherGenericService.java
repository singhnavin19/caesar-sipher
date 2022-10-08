package com.cipher.service;

import org.springframework.stereotype.Component;

import com.cipher.model.CipherModel;

@Component
public abstract class CipherGenericService {

	public abstract String cypherType();

	public abstract CipherModel process(CipherModel cipherModel);

}