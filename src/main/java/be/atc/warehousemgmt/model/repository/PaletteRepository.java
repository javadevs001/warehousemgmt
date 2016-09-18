package be.atc.warehousemgmt.model.repository;

import be.atc.warehousemgmt.model.entity.palette.Palette;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Wéry Lionel on 18/09/2016.
 */
public interface PaletteRepository extends JpaRepository<Palette, Long> {

    List<Palette> findAllByType(String type);

}
