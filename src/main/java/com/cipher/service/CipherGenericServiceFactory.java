package com.cipher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cipher.model.CipherModel;

@Component
public class CipherGenericServiceFactory {

	@Autowired
	private List<CipherGenericService> cipherGenericService;

	public CipherGenericService getCipherObject(CipherModel cipherModel) {
		for (CipherGenericService service : this.cipherGenericService) {
			if (service.cypherType().equalsIgnoreCase(cipherModel.getCipherType())) {
				return service;
			}
		}
		return null;
	}
}
