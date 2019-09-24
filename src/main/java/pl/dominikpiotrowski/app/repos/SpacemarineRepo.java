package pl.dominikpiotrowski.app.repos;

import lombok.Data;
import org.springframework.stereotype.Repository;
import pl.dominikpiotrowski.app.models.Spacemarine;

import java.util.ArrayList;
import java.util.List;

@Data
@Repository
public class SpacemarineRepo {
    private List<Spacemarine> spacemarines;

    public SpacemarineRepo() {
        this.spacemarines = new ArrayList<>();
    }
}