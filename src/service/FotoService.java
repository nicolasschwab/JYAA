package service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.StreamedContent;

import model.Foto;

public class FotoService {
	
	private Foto foto;
	
	public Foto crear(Part partFoto) throws IOException{
		foto = new Foto();
		foto.setContenido(IOUtils.toByteArray(partFoto.getInputStream()));
		return foto;
	}
	
	public Foto crearFromInputStream(StreamedContent showFoto) throws IOException{
		foto = new Foto();
		foto.setContenido(IOUtils.toByteArray(showFoto.getStream()));
		return foto;
	}

}
