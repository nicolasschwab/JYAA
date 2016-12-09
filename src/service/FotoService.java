package service;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import model.Foto;

public class FotoService {
	
	private Foto foto;
	
	public Foto crear(Part partFoto) throws IOException{
		foto = new Foto();
		foto.setContenido(IOUtils.toByteArray(partFoto.getInputStream()));
		return foto;
	}

}
