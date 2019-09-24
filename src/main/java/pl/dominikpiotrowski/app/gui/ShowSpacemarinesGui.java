package pl.dominikpiotrowski.app.gui;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.dominikpiotrowski.app.models.Spacemarine;
import pl.dominikpiotrowski.app.repos.SpacemarineRepo;

@Route("show")
public class ShowSpacemarinesGui extends VerticalLayout {

    @Autowired
    public ShowSpacemarinesGui(SpacemarineRepo spacemarineRepo) {

        Button buttonBackToHomepage = new Button("Back to homepage", new Icon(VaadinIcon.ANGLE_DOUBLE_LEFT));
        buttonBackToHomepage.addClickListener(e -> {
            UI.getCurrent().navigate(HomeGui.class);
        });

        Grid<Spacemarine> spacemarineGrid = new Grid<>(Spacemarine.class);
        spacemarineGrid.setItems(spacemarineRepo.getSpacemarines());

        spacemarineGrid.removeColumnByKey("image");
        spacemarineGrid.addColumn(new ComponentRenderer<>(marine -> {
            Image image = new Image(marine.getImage(), "no image");
            image.setMaxWidth("20");
            return image;
        })).setHeader("Picture");

        add(buttonBackToHomepage, spacemarineGrid);
    }
}