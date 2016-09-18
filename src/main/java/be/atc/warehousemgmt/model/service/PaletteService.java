package be.atc.warehousemgmt.model.service;

import be.atc.warehousemgmt.model.entity.palette.Palette;

import java.util.List;

/**
 * Created by Wéry Lionel on 18/09/2016.
 */
public interface PaletteService {

    List<Palette> getPaletteByType(String type);

    List<Palette> getAllPalette();

    Palette findPaletteById(Long paletteId);

    boolean exists(Long paletteId);

    Palette savePalette(Palette palette);

}
