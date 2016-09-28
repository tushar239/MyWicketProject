package com.mysticcoders.refcardmaker;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.mysticcoders.refcardmaker.models.Person;

public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;

    private int counter = 0;

    public HomePage(final PageParameters parameters) {
        
    }
    @Override
    protected void onInitialize() {
        super.onInitialize();
        WebMarkupContainer container = new WebMarkupContainer("m1");
        container.add(new Label("message", "If you see this message wicket is properly configured and running"));
        add(container);
        
        
        add(new Link("link") {
            @Override
            public void onClick() {
                counter++;
            }
        });
        add(new Label("label", new PropertyModel<HomePage>(this, "counter")));
        add(new BookmarkablePageLink<String>("bookmarkableLink", ResponsePage.class));
        createForm();
    }
    private TextField<String> nameField;

    private Label nameOutputLabel;

    private void createForm() {
        Form<Object> form1 = new Form<Object>("form1");
        nameOutputLabel = new Label("nameOutputLabel", new Model<String>(""));
        nameField = new TextField<String>("nameField", new Model<String>(""));
        form1.add(nameOutputLabel);
        form1.add(nameField);
        add(form1);
        form1.add(new Button("submitButton") {
            @Override
            public void onSubmit() {
                String value = (String) nameField.getModelObject();
                nameOutputLabel.setDefaultModelObject(value);
                nameField.setDefaultModelObject(""); // or field1.setModelObject("");
                // set response page.
                Person person = new Person();
                person.setName(value);
                ResponsePage responsePage = new ResponsePage(person);
                setResponsePage(responsePage);
            }
        });

    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

}
