package com.playground.playground.interface_adapter.controller.views;

public interface ViewFactory {
    DataAttributesView createDataAttributesView();
    MlParametersView createMlParametersView();
    GraphSystemView createGraphSystemView();
    FeaturesHiddenLayersView createFeaturesHiddenLayersView();

}
