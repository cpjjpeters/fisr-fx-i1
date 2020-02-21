package be.belfius.javafx.domain;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
//@AllArgsConstructor
//@Getter
@Setter
//public class Tagfile {
//    private String boDealnumber;
//    private String instrument;
//}
public class Tagfile {
    private final StringProperty boDealnumber;
    private final StringProperty foDealnumber;
    private final StringProperty product;
    private final StringProperty event;
    private final StringProperty snarb;
    private final StringProperty instrument;
    private final StringProperty arrivalTime;
    private final StringProperty tradeDate;
    private final StringProperty maturityDate;
    private final StringProperty book;

public Tagfile(String boDealnumber, String foDealnumber, String product, String event, String snarb, String instrument, String arrivalTime, String tradeDate, String maturityDate, String book) {
    this.boDealnumber = new SimpleStringProperty(boDealnumber);
    this.foDealnumber = new SimpleStringProperty(foDealnumber);
    this.product = new SimpleStringProperty(product);
    this.event = new SimpleStringProperty(event);
    this.instrument = new SimpleStringProperty(instrument);
    this.snarb = new SimpleStringProperty(snarb);
    this.arrivalTime = new SimpleStringProperty(arrivalTime);
    this.tradeDate = new SimpleStringProperty(tradeDate);
    this.maturityDate = new SimpleStringProperty(maturityDate);
    this.book = new SimpleStringProperty(book);
}

//    public Tagfile(StringProperty boDealnumber, StringProperty foDealnumber, StringProperty product, StringProperty event, StringProperty snarb, StringProperty instrument, StringProperty arrivalTime, StringProperty tradeDate, StringProperty maturityDate, StringProperty book) {
//        this.boDealnumber = boDealnumber;
//        this.foDealnumber = foDealnumber;
//        this.product = product;
//        this.event = event;
//        this.snarb = snarb;
//        this.instrument = instrument;
//        this.arrivalTime = arrivalTime;
//        this.tradeDate = tradeDate;
//        this.maturityDate = maturityDate;
//        this.book = book;
//    }

    public String getMaturityDate() {
        return maturityDate.get();
    }

    public void setMaturityDate(String maturityDate) {
        this.maturityDate.set(maturityDate);
    }

    public String getProduct() {
        return product.get();
    }

    public void setProduct(String product) {
        this.product.set(product);
    }

    public String getEvent() {
        return event.get();
    }

    public void setEvent(String event) {
        this.event.set(event);
    }

    public String getSnarb() {
        return snarb.get();
    }

    public void setSnarb(String snarb) {
        this.snarb.set(snarb);
    }

    public String getArrivalTime() {
        return arrivalTime.get();
    }

    public StringProperty arrivalTimeProperty() {
        return arrivalTime;
    }

    public String getTradeDate() {
        return tradeDate.get();
    }

    public StringProperty tradeDateProperty() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate.set(tradeDate);
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime.set(arrivalTime);
    }

    public String getBook() {
        return book.get();
    }

    public void setBook(String book) {
        this.book.set(book);
    }
    public String getBoDealnumber(){
    return boDealnumber.get();
}
    public String getFoDealnumber(){
        return foDealnumber.get();
    }
public String getInstrument(){
    return instrument.get();
}

    public void setBoDealnumber(String value){
        boDealnumber.set(value);
    }
    public void setFoDealnumber(String value){
        foDealnumber.set(value);
    }
public void setInstrument(String value){
    instrument.set(value);
}
// property values
    public StringProperty boDealnumberProperty(){return boDealnumber;};
    public StringProperty foDealnumberProperty(){return foDealnumber;};
    public StringProperty productProperty(){return product;};
    public StringProperty eventProperty(){return event;};
    public StringProperty snarbProperty(){return snarb;};
    public StringProperty instrumentProperty(){return instrument;};
    public StringProperty maturityDateProperty(){return maturityDate;};
    public StringProperty bookProperty(){return book;};
}