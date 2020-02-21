package be.belfius.javafx.controller;

import be.belfius.javafx.services.MissionsService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DetailTabController {

    @FXML
    private TextArea missionOverviewText;
    @FXML private ListView<String> missionsList;

//    @Autowired
//    @Qualifier("stringPrintWriter")
//    private PrintWriter stackTraceWriter;

    @Autowired
    MissionsService service;
    private fisrv1Controller tabManager;

    public void initialize() {
        ObservableList<String> missions = FXCollections.observableArrayList("Aandeel", "Obligatie", "SPOT", "Andere");
        missionsList.setItems(missions);
    }

    @FXML
    private void onMouseClicked(MouseEvent event) {
        missionOverviewText.clear();
        final String selectedItem = missionsList.getSelectionModel().getSelectedItem();
        missionOverviewText.positionCaret(0);
        missionOverviewText.appendText(getInfo(selectedItem));
    }

    @Autowired
    private void setTabManager(fisrv1Controller tabManager){
        this.tabManager = tabManager;
    }

    public String getInfo(String selectedItem) {
        String missionInfo = null ;

//        try {
//            missionInfo = service.getMissionInfo(selectedItem);
//            getLog().appendText("Sucessfully retrieved mission info for " + selectedItem + "\n");
//        } catch (IOException exception) {
//            exception.printStackTrace (stackTraceWriter);
//            getLog().appendText(stackTraceWriter.toString() + "\n");
//        }

        return missionInfo;
    }

    public TextArea getMissionOverviewText() {
        return missionOverviewText;
    }

    public ListView<String> getMissionsList() {
        return missionsList;
    }

//    private TextArea getLog(){
//        return fisrv1Controller.getVisualLog();
//    }
//
//    public TextArea overviewTxtArea() {
//    }
}
