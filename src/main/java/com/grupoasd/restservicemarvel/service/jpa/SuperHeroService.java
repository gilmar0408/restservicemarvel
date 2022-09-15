package com.grupoasd.restservicemarvel.service.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupoasd.restservicemarvel.entity.PlaceOfOperation;
import com.grupoasd.restservicemarvel.entity.ResponseSuperHero;
import com.grupoasd.restservicemarvel.entity.SuperHero;
import com.grupoasd.restservicemarvel.repository.SuperHeroRepository;
import com.grupoasd.restservicemarvel.service.ISuperHeroService;


@Service
public class SuperHeroService implements ISuperHeroService {

	@Autowired
	SuperHeroRepository repoSuperHero;

	@Override
	public ResponseSuperHero create(SuperHero superHero) {

		boolean isPresent = false;

		ResponseSuperHero response = new ResponseSuperHero();

		List<SuperHero> superHeros = repoSuperHero.findAll();

		for (SuperHero s : superHeros) {

			if (s.getIdentificationNumber().equalsIgnoreCase(superHero.getIdentificationNumber())
					|| s.getFirstName().equalsIgnoreCase(superHero.getFirstName())) {

				isPresent = true;
				break;

			}
		}

		if (!isPresent) {

			repoSuperHero.save(superHero);
			response.setSuperHero(superHero);
			response.setMessage("SuperHeroe registrado exitosamente!");

		} else {

			response.setMessage("El super Heore ya se encuentra registrado.");
		}

		return response;
	}

	@Override
	public void update(SuperHero superHero) {
		
		repoSuperHero.save(superHero);
		

	}

	@Override
	public SuperHero searchById(int id) {

		Optional<SuperHero> superHero = repoSuperHero.findById(id);

		if (superHero.isPresent()) {

			return superHero.get();

		} else {

			return null;

		}

	}

	@Override
	public ResponseSuperHero searchByName(String name) {

		ResponseSuperHero response = new ResponseSuperHero();

		List<SuperHero> s = repoSuperHero.searchByName(name);

		if (s.isEmpty()) {

			response.setMessage("No se ha encontrado ningun super herore por el nombre indicado.");

		} else {

			response.setSuperHero(s.get(0));
			response.setMessage("Super Heroe encontrado.");

		}

		return response;
	}

	@Override
	public List<SuperHero> list() {

		return repoSuperHero.findAll();
	}

	@Override
	public List<SuperHero> listByPlaceOfOp(int idPlace) {

		return repoSuperHero.searchByPlace(idPlace);
	}

}
