package br.com.petasoft.controllers;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import java.io.File;
import org.apache.log4j.Logger;

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
	public void novaDenuncia(String descricao, String anonima, String mensagem, String fotos, String cidadao, String vereador){
		String listaDeFotos[] = fotos.split(",");
		for(int i = 0; i<listaDeFotos.length; i++){
			byte[] decoded = org.apache.commons.codec.binary.Base64.decodeBase64(listaDeFotos[i].getBytes());
			try {
				InputStream in = new ByteArrayInputStream(decoded);
				BufferedImage bImageFromConvert = ImageIO.read(in);
				ImageIO.write(bImageFromConvert, "png", new File("d:/imageFromServer" + i + ".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		LOGGER.info("Terminado");
		this.success("Sucesso!");
	}

}
