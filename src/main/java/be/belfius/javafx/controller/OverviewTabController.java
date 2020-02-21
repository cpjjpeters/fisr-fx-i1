package be.belfius.javafx.controller;

import be.belfius.javafx.domain.Tagfile;
import be.belfius.javafx.services.ConnectionManager;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

@Component
@Slf4j
public class OverviewTabController implements Initializable {
    @FXML
    private TextArea overviewTxtArea;
    @FXML
    private Button btnExit, btnReset;
    @FXML
    private TableView<Tagfile> tableView;
    @FXML
    private TableColumn<Tagfile,String> columnBoDealnumber;
    @FXML
    private TableColumn<Tagfile,String> columnFoDealnumber;
    @FXML
    private TableColumn<Tagfile,String> columnProduct;
    @FXML
    private TableColumn<Tagfile,String> columnEvent;
    @FXML
    private TableColumn<Tagfile,String> columnSnarb;
    @FXML
    private TableColumn<Tagfile,String> columnInstrument;
    @FXML
    private TableColumn<Tagfile,String> columnArrivalTime;
    @FXML
    private TableColumn<Tagfile,String> columnTradeDate;
    @FXML
    private TableColumn<Tagfile,String> columnMaturityDate;
    @FXML
    private TableColumn<Tagfile,String> columnBook;

    private ObservableList<Tagfile> data;
    private ConnectionManager dbcm;

    @FXML
    private void handleBtnExitAction(ActionEvent event){
        Platform.exit();
    }
    public TextArea getOverviewTxtArea() {
        return overviewTxtArea;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dbcm = new ConnectionManager();
    }
    @FXML
    private void loadDataFromDatabase(ActionEvent event){
        try {
            log.info("loadDataFromDatabase");
            Connection conn = dbcm.Connect();
            data= FXCollections.observableArrayList();
            // Execute query and store result in a resultset
            ResultSet rs = conn.createStatement().executeQuery("select * from tagfiles");
            while (rs.next()){
                overviewTxtArea.setText("Connected to database {}");
                data.add(new Tagfile(rs.getString("boDealNumber"), rs.getString("foDealNumber"), rs.getString("productCode"), rs.getString("tradeStatus"), rs.getString("secTypeNbbBs"), rs.getString("secName"), rs.getString("prospectusDate"), rs.getString("tradeDate"), rs.getString("valueDate"),rs.getString("book")));
//                data.add(new Tagfile(rs.getString(3),rs.getString(18)));
                log.info(rs.getString("foDealNumber"));
                log.info(rs.getString("productCode"));
            }
        } catch (SQLException ex){

            ex.printStackTrace();
            log.error("SQL PROBLEM");
        }
        // set cell value factory to tableview
        // NB propertyValue Factory must be the same
//        columnName.setCellValueFactory()
        columnBoDealnumber.setCellValueFactory(new PropertyValueFactory<Tagfile, String>("boDealnumber")); //<Tagfile, String>
        columnFoDealnumber.setCellValueFactory(new PropertyValueFactory<>("foDealnumber"));// <>
//        columnFoDealnumber.setCellValueFactory((cellData -> cellData.getValue().foDealnumberProperty()));
        columnProduct.setCellValueFactory((cellData -> cellData.getValue().productProperty())); // newer way to work
        columnEvent.setCellValueFactory((cellData -> cellData.getValue().eventProperty()));
        columnSnarb.setCellValueFactory((cellData -> cellData.getValue().snarbProperty()));
        columnInstrument.setCellValueFactory(new PropertyValueFactory<>("instrument")); // above both possible, and below also
        columnArrivalTime.setCellValueFactory(new PropertyValueFactory<>("prospectusDate"));
        columnMaturityDate.setCellValueFactory((cellData -> cellData.getValue().maturityDateProperty())); // newer way to work
        columnTradeDate.setCellValueFactory((cellData -> cellData.getValue().tradeDateProperty())); // newer way to work
        columnBook.setCellValueFactory((cellData -> cellData.getValue().bookProperty()));

//        tableView.setItems((null));
        tableView.setItems(data);
//        tableView.getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldValue, newValue) ->showDetails(newValue)
//        );


    }
}
