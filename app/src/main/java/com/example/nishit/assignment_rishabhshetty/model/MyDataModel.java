package com.example.nishit.assignment_rishabhshetty.model;

public class MyDataModel {

    private String NAME;
//STAFF_NO.":216127,"STATION":"BHOPAL","E_MAIL_ID":"bho.sm@airindia.in","TEL_NO.":9826078434,
    private String DESIGNATION;
    private String STAFF_NO;


    public String getSTATION() {
        return STATION;
    }

    public void setSTATION(String STATION) {
        this.STATION = STATION;
    }

    private String STATION;

    public String getSTAFF_NO() {
        return STAFF_NO;
    }

    public void setSTAFF_NO(String STAFF_NO) {
        this.STAFF_NO = STAFF_NO;
    }

    public String getE_MAIL_ID() {
        return E_MAIL_ID;
    }

    public void setE_MAIL_ID(String e_MAIL_ID) {
        E_MAIL_ID = e_MAIL_ID;
    }

    public String getTEL_NO() {
        return TEL_NO;
    }

    public void setTEL_NO(String TEL_NO) {
        this.TEL_NO = TEL_NO;
    }

    private String E_MAIL_ID;
    private String TEL_NO;


    public String getName() {
        return NAME;
    }

    public void setName(String NAME) {
        this.NAME = NAME;
    }

    public String getCountry() {
        return DESIGNATION;
    }

    public void setCountry(String DESIGNATION) {
        this.DESIGNATION = DESIGNATION;
    }

}