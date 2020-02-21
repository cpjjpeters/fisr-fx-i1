package be.belfius.javafx.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class fisrv1Controller {
    private final OverviewTabController overviewTabController;
    private final DetailTabController detailTabController;

    @Autowired
    public fisrv1Controller(OverviewTabController overviewTabController, DetailTabController detailTabController){
        this.overviewTabController = overviewTabController;
        this.detailTabController = detailTabController;
    }
//    public TextArea getVisualLog(){
//        return detailTabController.overviewTxtArea();
//    }

    @FXML
    private Label lblOne;
    @FXML
    private Button btnExit;
    @FXML
    private void handleBtnExitAction(ActionEvent event){
        Platform.exit();
    }
}
