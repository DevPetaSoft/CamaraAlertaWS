package br.com.petasoft.controllers;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import java.io.File;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;

import br.com.petasoft.dao.DenunciaDAO;
import br.com.petasoft.model.Denuncia;
import br.com.petasoft.dto.DenunciaDTO;


@Controller
@Path("/denuncia")
public class DenunciaController extends br.com.caelum.vraptor.boilerplate.AbstractController {
	final static Logger logger = Logger.getLogger(DenunciaController.class);
	
	public static DenunciaDAO dDao = new DenunciaDAO();
	
	@Post("/novaDenuncia")
	public void novaDenuncia(String dDTOString){
		Gson gson = new Gson();
		DenunciaDTO dDTO = gson.fromJson(dDTOString, DenunciaDTO.class);
		ArrayList<String> listaDeFotos = (ArrayList<String>) dDTO.getListaFotos();
		ArrayList<String> photoPaths = new ArrayList<String>();
		for(int i = 0; i<listaDeFotos.size(); i++){
			byte[] decoded = org.apache.commons.codec.binary.Base64.decodeBase64(listaDeFotos.get(i).getBytes());
			try {
				InputStream in2 = new ByteArrayInputStream(decoded);
				BufferedImage bImageFromConvert = ImageIO.read(in2);
				ImageIO.write(bImageFromConvert, "png", new File("d:/imageFromServer" + i + ".png"));
				photoPaths.add("d:/imageFromServer" + i + ".png");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Denuncia d = dDTO.getDenuncia();
		d.setFotos(photoPaths);
		
		dDao.salvarNovaDenuncia(d);

		LOGGER.info("Sucesso incluindo denuncia!");
		this.success("Sucesso!");
	}

}
