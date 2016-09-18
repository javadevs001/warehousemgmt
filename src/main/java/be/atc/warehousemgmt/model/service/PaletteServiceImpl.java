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
    public List<Palette> getAllPaletteType() {
        return paletteRepository.findAllByTypePalette();
    }
}
