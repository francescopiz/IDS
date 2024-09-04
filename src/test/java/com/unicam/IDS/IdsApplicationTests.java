package com.unicam.IDS;


import com.unicam.IDS.models.approvabili.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

@SpringBootTest
class IdsApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	void InserimentoPOITest() {
		ApprovabileBuilder approvabileBuilder = new ApprovabileBuilder();
		approvabileBuilder.setNome("poi");
		approvabileBuilder.setDescrizione("poi descrizione");
		approvabileBuilder.setPosizione(new Posizione(10, 20));
		approvabileBuilder.addElencoContenuti(new ArrayList<Contenuto>() {
		});
		assertEquals(approvabileBuilder.build(), new POI("poi", "poi descrizione", new Posizione(10, 20), new ArrayList<Contenuto>() {
		}));
	}

	@Test
		//TODO non si può ancora testare
	void InserimentoEventoTest() {
		ApprovabileBuilder approvabileBuilder = new ApprovabileBuilder();
		approvabileBuilder.setNome("poi");
		approvabileBuilder.setDescrizione("poi descrizione");
		approvabileBuilder.setPosizione(new Posizione(10, 20));
		approvabileBuilder.addElencoContenuti(new ArrayList<Contenuto>() {
		});
		//approvabileBuilder.setTempo(new AbstractTime() {});
		//assertEquals();
	}

	@Test
	void InserimentoGruppoPOITest() {
		ApprovabileBuilder approvabileBuilder = new ApprovabileBuilder();
		approvabileBuilder.setNome("gruppo poi");
		approvabileBuilder.setDescrizione("gruppo poi descrizione");
		approvabileBuilder.addListaPOI(new ArrayList<>());
		assertEquals(approvabileBuilder.build(), new GruppoPOI("gruppo poi", "gruppo poi descrizione", new ArrayList<>()));
	}

	@Test
	void InserimentoContenutoTest() {
		ApprovabileBuilder approvabileBuilder = new ApprovabileBuilder();
		approvabileBuilder.setNome("contenuto");
		approvabileBuilder.setDescrizione("contenuto descrizione");
		POI poi = new POI("x", "y", new Posizione(0, 0));
		approvabileBuilder.setPOI(poi);
		ArrayList<MultipartFile> listaContenuti = new ArrayList<>();
		approvabileBuilder.addFileMultimediali(listaContenuti);
		assertEquals(approvabileBuilder.build(), new Contenuto("contenuto", "contenuto descrizione", listaContenuti, poi));
	}


}