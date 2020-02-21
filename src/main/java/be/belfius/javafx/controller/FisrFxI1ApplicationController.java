package be.belfius.javafx.controller;

import org.springframework.stereotype.Component;

@Component
public class FisrFxI1ApplicationController {
    private final BootFxView view;

    public FisrFxI1ApplicationController(BootFxView view) {
        this.view = view;
    }

    public BootFxView getView() {
        return view;
    }
}
