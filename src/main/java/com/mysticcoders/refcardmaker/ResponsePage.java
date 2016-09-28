package com.mysticcoders.refcardmaker;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

import com.mysticcoders.refcardmaker.models.Person;

public class ResponsePage extends WebPage {
    public ResponsePage() {
        this(new Person());
    }

    public ResponsePage(final Person person) {
        render1(person);
    }
    
    private void render1(final Person person) {

        // To consider <h1> as an html element instead of string, you need to set EscapeModleStrings as false.
        add(new Label("name1", new PropertyModel<Person>(person, "name")) {
            @Override
            public boolean isVisible() {
                return true;
              }
        });
        
        add(new Label("name", "<h1>" + person.getName() + "</h1>") {
            @Override
            public boolean isVisible() {
                return true;
              }
        }).setEscapeModelStrings(false);
        
        add(new ExternalLink("externalLink", "http://www.google.com", "go to google"));
        add(new Link<String>("link") {
            @Override
            public void onClick() {
                person.setName("changed name");
            }
        });
        
        final Label ajaxifiedLabel = new Label("ajaxifiedLabel", "Waiting for Ajax");
        // True if the component will out the id attribute into markup.
        // It has to be set to true, if you want to find this component by ajax component using target.addComponent(ajaxifieldLabel) as shown below
        ajaxifiedLabel.setOutputMarkupId(true);
        add(ajaxifiedLabel);
        
        add(new AjaxFallbackLink<String>("ajaxLink") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                ajaxifiedLabel.setDefaultModelObject("Waiting for Ajax Response");
          
                //page1.renderComponent();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ajaxifiedLabel.setDefaultModelObject("Ajax Response is populated here");
                //render1(person);
                //setResponsePage(page1);
                target.add(ajaxifiedLabel);
                // target.addComponent(new Label("ajaxifiedLabel","I am an Ajaxified Label"));
            }
        });
        
       
        
    
    }
}
