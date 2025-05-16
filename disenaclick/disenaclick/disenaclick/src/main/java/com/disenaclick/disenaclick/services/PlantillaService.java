package com.disenaclick.disenaclick.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disenaclick.disenaclick.model.Plantilla;
import com.disenaclick.disenaclick.repository.PlantillaRepository;

@Service
public class PlantillaService {
    
    @Autowired
    private PlantillaRepository plantillaRepository;

    public List<Plantilla> findAll(){
        return plantillaRepository.findAll();       
    }

    public Plantilla findById(long id){
        return plantillaRepository.getById(id);
    }

    public Plantilla save(Plantilla plantilla){
        return plantillaRepository.save(plantilla);
    }

    public void delete (Long id){
        plantillaRepository.deleteById(id);
    }

    public Plantilla updatePlantilla(Long id, Plantilla plantilla){
        Plantilla plantillaToUpdate = plantillaRepository.findById(id).orElse(null);
        if (plantillaToUpdate != null){
            plantillaToUpdate.setNombrePlantilla(plantilla.getNombrePlantilla());
            plantillaToUpdate.setColor(plantilla.getColor());
            plantillaToUpdate.setEnlace(plantilla.getEnlace());
        } else {
            return null;
        }
    }

    public Plantilla patchPlantilla(Long id, Plantilla parcialPlantilla){
        Plantilla plantillaToUpdate = plantillaRepository.findById(id).orElse(null);
        if (plantillaToUpdate != null){
            if (parcialPlantilla.getNombrePlantilla() != null){
                plantillaToUpdate.setNombrePlantilla(null);
            }
            if (parcialPlantilla.getColor() != null){
                plantillaToUpdate.setColor(parcialPlantilla.getColor());
            }
        }
    }
}
