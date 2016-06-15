package dao.impl;

import model.Foto;
import dao.FotoDAO;

public class FotoDAOImpl extends GenericDAOImpl<Foto> implements FotoDAO {
	public FotoDAOImpl() {
		super(Foto.class);
	}
}
