package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.palette.Palette;
import be.atc.warehousemgmt.model.repository.PaletteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Vaio on 18/09/2016.
 */


@Service
@Transactional

public class PaletteServiceImpl implements PaletteService {

    @Inject
    private PaletteRepository paletteRepository;

    @Override
    public List<Palette> getPaletteByType(String type) {
        return paletteRepository.findAllByType(type);
    }

    @Override
    public List<Palette> getAllPalette() {
        return paletteRepository.findAll();
    }

    @Override
    public Palette findPaletteById(Long paletteId) {
        return paletteRepository.findOne(paletteId);
    }

    @Override
    public boolean exists(Long paletteId) {
        return paletteRepository.exists(paletteId);
    }

    @Override
    public Palette savePalette(Palette palette) {
        return paletteRepository.save(palette);
    }
}
