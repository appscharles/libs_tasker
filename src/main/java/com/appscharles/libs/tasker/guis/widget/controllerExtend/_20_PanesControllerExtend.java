package com.appscharles.libs.tasker.guis.widget.controllerExtend;


import com.appscharles.libs.fxer.hidders.PaneAutoHidder;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.function.Consumer;

/**
 * The type 20 panes controller extend.
 */
public class _20_PanesControllerExtend extends _12_AppInfoControllerExtend {

    /**
     * The Container pane.
     */
    @FXML
    protected HBox containerPane;

    protected Consumer<Pane> consumerContainerPane;

    protected _20_PanesControllerExtend() {
        this.addOnInitializeWithSneakyThrow(() -> {
            PaneAutoHidder.autoHide(this.containerPane);
            if (this.consumerContainerPane != null){
                this.consumerContainerPane.accept(this.containerPane);
            }
        });
    }
}
