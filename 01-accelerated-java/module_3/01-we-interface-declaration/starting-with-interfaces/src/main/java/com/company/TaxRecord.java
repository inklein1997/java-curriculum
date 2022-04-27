package com.company;

import com.company.interfaces.Auditable;

public class TaxRecord implements Auditable {
    public String nameOfTaxedPerson;

    public String getNameOfTaxedPerson() {
        return nameOfTaxedPerson;
    }

    public void setNameOfTaxedPerson(String nameOfTaxedPerson) {
        this.nameOfTaxedPerson = nameOfTaxedPerson;
    }

    @Override
    public void runAudit() {
        System.out.println("The IRS wants to meet you.  Auditing.");
    }
    @Override
    public void sendAuditToState() {
        System.out.println("E-filing! Sending audit to state");
    }
    public void addW2Information(String companyName) {
        System.out.println("Adding a W2 for " + nameOfTaxedPerson + " for " + companyName);
    }
}
