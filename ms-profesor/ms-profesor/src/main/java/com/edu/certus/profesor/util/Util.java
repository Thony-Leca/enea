package com.edu.certus.profesor.util;

import org.springframework.stereotype.Component;

import com.edu.certus.profesor.dto.ResponseDto;

@Component
public class Util {

	public static ResponseDto getResponse(boolean success, String mensaje, Object data) {
		ResponseDto response = new ResponseDto();
		String cod = (!success) ? Constante.CODE_FAILED : Constante.CODE_SUCCES;
		response.setCodigo(cod);
		response.setMensaje(mensaje);
		response.setData(data);
		return response;
	}
}
