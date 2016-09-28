package com.mysticcoders.refcardmaker.borders;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class CwickPageBorder extends Border {
    public CwickPageBorder(String id) {
        super(id);
        //onInitialize();
    }

    public CwickPageBorder(String id, IModel model) {
        super(id, model);
        //onInitialize();
    }
    @Override
    protected void onInitialize() {
        super.onInitialize();
        Label headerLabel = new Label("headerLabel", new Model<String>("Header Label"));
        addToBorder(headerLabel);
        Label footerLabel = new Label("footerLabel", new Model<String>("Footer Label"));
        addToBorder(footerLabel);
    }
}
