package ec.edu.espe.mantenimientoapi.service;

import ec.edu.espe.mantenimientoapi.model.CatalogoActividad;
import ec.edu.espe.mantenimientoapi.repository.CatalogoActividadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogoActividadService {
    private final CatalogoActividadRepository catalogoActividadRepository;

    public CatalogoActividadService(CatalogoActividadRepository catalogoActividadRepository) {this.catalogoActividadRepository = catalogoActividadRepository;}

    public List<CatalogoActividad> getAllCatalogoActividades() {
        try{
            List<CatalogoActividad> catalogoActividadList = this.catalogoActividadRepository.findAll();
            return catalogoActividadList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<CatalogoActividad> getAllCatalogoActividadesByNombre(String nombrecatalogoactividad) {
        try{
            List<CatalogoActividad> catalogoActividadList =
                    this.catalogoActividadRepository.findAllByNombrecatactividad(nombrecatalogoactividad);
            return catalogoActividadList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Optional<CatalogoActividad> getCatalogoActividadById(Integer id) {
        try{
            Optional<CatalogoActividad> catalogoActividad = this.catalogoActividadRepository.findById(id);
            return catalogoActividad;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void addCatalogoActividad(CatalogoActividad catalogoActividad) {
        try{
            catalogoActividad.setIdcatactividad(null);
            this.catalogoActividadRepository.save(catalogoActividad);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateCatalogoActividad(CatalogoActividad catalogoActividad,Integer id) {
        Optional<CatalogoActividad> catalogoActividadData = this.catalogoActividadRepository.findById(id);
        if(catalogoActividadData.isPresent()){
            try {
                catalogoActividadData.get().setNombrecatactividad(catalogoActividad.getNombrecatactividad());
                catalogoActividadData.get().setDescripcioncatactividad(catalogoActividad.getDescripcioncatactividad());
                this.catalogoActividadRepository.save(catalogoActividadData.get());
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("CatalogoActividad NO encontrado");
        }
    }

    public void deleteCatalogoActividad(Integer id) {
        Optional<CatalogoActividad> catalogoActividadData = this.catalogoActividadRepository.findById(id);
        if(catalogoActividadData.isPresent()){
            this.catalogoActividadRepository.deleteById(id);
        }else{
            System.out.println("CatalogoActividad NO encontrado");
        }
    }
}
