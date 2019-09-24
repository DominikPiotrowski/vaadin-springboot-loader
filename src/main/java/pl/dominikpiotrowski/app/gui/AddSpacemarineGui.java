package pl.dominikpiotrowski.app.gui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.dominikpiotrowski.app.models.Chapter;
import pl.dominikpiotrowski.app.models.Rank;
import pl.dominikpiotrowski.app.models.Spacemarine;
import pl.dominikpiotrowski.app.repos.SpacemarineRepo;

@Route("add")
public class AddSpacemarineGui extends VerticalLayout {

    @Autowired
    public AddSpacemarineGui(SpacemarineRepo spacemarineRepo) {

        H3 header = new H3("Please add character: ");
        TextField textFieldName = new TextField("name: ");
        TextField textFieldImage = new TextField("image: ");
        ComboBox<Chapter> comboBoxChapter = new ComboBox<>("Spacemarine chapter: ", Chapter.values());
        ComboBox<Rank> comboBoxRank = new ComboBox<>("Spacemarine rank: ", Rank.values());

        Button buttonAddMarine = new Button("Add Marine", new Icon(VaadinIcon.CHECK));
        buttonAddMarine.addClickListener(buttonClickEvent -> {
            Spacemarine spacemarine = new Spacemarine();

            spacemarine.setName(textFieldName.getValue());
            spacemarine.setChapter(comboBoxChapter.getValue());
            spacemarine.setRank(comboBoxRank.getValue());
            spacemarine.setImage(textFieldImage.getValue());

            spacemarineRepo.getSpacemarines().add(spacemarine);

            Notification marineAddedNotification = new Notification("Character added!", 3000);
            marineAddedNotification.open();
        });

        Button buttonClearFields = new Button("Clear", new Icon(VaadinIcon.CLOSE_SMALL));
        buttonClearFields.addClickListener(buttonClickEvent -> {
            textFieldName.setValue("");
            textFieldImage.setValue("");
            comboBoxChapter.setValue(Chapter.BLOOD_RAVENS);
            comboBoxRank.setValue(Rank.BROTHER);
        });

        Button buttonBackToHomepage= new Button("Back to homepage", new Icon(VaadinIcon.ANGLE_DOUBLE_LEFT));
        buttonBackToHomepage.addClickListener(e -> {
            UI.getCurrent().navigate(HomeGui.class);
        });

        VerticalLayout fields = new VerticalLayout(header, textFieldName, textFieldImage, comboBoxChapter, comboBoxRank);
        HorizontalLayout buttons = new HorizontalLayout(buttonAddMarine, buttonClearFields, buttonBackToHomepage);

        add(fields, buttons);
    }
}