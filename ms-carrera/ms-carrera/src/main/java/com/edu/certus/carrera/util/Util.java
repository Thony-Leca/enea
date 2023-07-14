package com.edu.certus.carrera.util;

import com.edu.certus.carrera.dto.ResponseDto;

public class Util {
	public static ResponseDto getResponse(boolean success, String mensaje, Object data) {
		ResponseDto response = new ResponseDto();
		String cod = (!success) ? Constantes.CODE_FAILED : Constantes.CODE_SUCESS;
		response.setCodigo(cod);
		response.setMensaje(mensaje);
		response.setData(data);
		return response;
	}
}
