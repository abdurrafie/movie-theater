package com.smk.bi.views.report;

import com.smk.bi.model.Category;
import com.smk.bi.repository.categoryRepository;
import com.smk.bi.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@PageTitle("pembuatan Pengaduan Layanan Masyarakat")
@Route(value = "create-report", layout = MainLayout.class)
public class CreateReportFrormView extends VerticalLayout {
    
    private categoryRepository categoryRepository;
    
    public CreateReportFrormView(categoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
        createform();
    }

    private void createform(){
        setAlignItems(Alignment.STRETCH);
        EmailField emailField = new EmailField();
        emailField.setLabel("Email Address");
        emailField.setErrorMessage("Enter a valid email address");
        emailField.setPrefixComponent(VaadinIcon.ENVELOPE.create());

        ComboBox<Category> category = new ComboBox<>("Categiry");
        category.setItems(categoryRepository.findAll());
        category.setItemLabelGenerator(Category::getCategoryName);

        TextArea textArea = new TextArea("Laporan");

        Button submitButton = new Button("Submit");
        
        add(emailField, category, textArea, submitButton);
    }
}
