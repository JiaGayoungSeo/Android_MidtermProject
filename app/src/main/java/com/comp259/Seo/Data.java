package com.comp259.Seo;

public class Data {
    private int deptNumber;
    private double netInvoice;
    private double surcharge;
    private double totalInvoice;


    public int getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(int deptNumber) {
        this.deptNumber = deptNumber;
        setSurcharge();
    }

    public double getNetInvoice() {
        return netInvoice;
    }

    public void setNetInvoice(double netInvoice) {

        this.netInvoice = netInvoice;

    }

    public double getSurcharge() {
        return surcharge;
    }

    public void setSurcharge() {
        if(deptNumber>2500){
            this.surcharge = 0.25*netInvoice;
        }else {
            this.surcharge=0;
        }
    }

    public double getTotalInvoice() {
        return netInvoice+surcharge;
    }



}
