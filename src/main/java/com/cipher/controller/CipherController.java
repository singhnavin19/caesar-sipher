package com.cipher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cipher.model.CipherModel;
import com.cipher.service.CipherGenericService;
import com.cipher.service.CipherGenericServiceFactory;
import com.cipher.util.CipherConstant;

@Controller
public class CipherController {
	@Autowired
	private CipherGenericServiceFactory cipherGenericServiceFactory;

	@GetMapping("/index")
	public ModelAndView syaHello() {
		ModelAndView result = new ModelAndView("Home");
		result.addObject("listCypherType", CipherConstant.cipherTypes);

		return result;
	}

	@PostMapping("/submitRequest")
	public ModelAndView submitRequest(@ModelAttribute("cipherModel") CipherModel cipherModel) {
		ModelAndView result = new ModelAndView("Home");
		CipherGenericService service = this.cipherGenericServiceFactory.getCipherObject(cipherModel);
		service.process(cipherModel);
		result.addObject("cipherModel", cipherModel);
		result.addObject("listCypherType", CipherConstant.cipherTypes);

		return result;
	}

}
