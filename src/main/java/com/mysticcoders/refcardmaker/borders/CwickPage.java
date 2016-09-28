package com.mysticcoders.refcardmaker.borders;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class CwickPage extends WebPage {

    public CwickPage(final PageParameters parameters)
    {
        super(parameters);
        //onInitialize();
    }
    @Override
    protected void onInitialize() {
        super.onInitialize();
        CwickPageBorder border = new CwickPageBorder("border");
        border.add(new Label("pageLabel", "I am a page Label"));
        add(border);
    }
}
