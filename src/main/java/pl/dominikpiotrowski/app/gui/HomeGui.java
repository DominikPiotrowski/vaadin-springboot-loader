package pl.dominikpiotrowski.app.gui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("home")
public class HomeGui extends HorizontalLayout {

    @Autowired
    public HomeGui() {

        Button buttonGoToAddPage = new Button("Add Spacemarine", new Icon(VaadinIcon.ANGLE_DOUBLE_RIGHT));
        buttonGoToAddPage.addClickListener(e -> {
            UI.getCurrent().navigate(AddSpacemarineGui.class);
        });

        Button buttonGoToShowPage = new Button("Show Spacemarines", new Icon(VaadinIcon.ANGLE_DOUBLE_RIGHT));
        buttonGoToShowPage.addClickListener(e -> {
            UI.getCurrent().navigate(ShowSpacemarinesGui.class);
        });

        add(buttonGoToAddPage, buttonGoToShowPage);
    }
}