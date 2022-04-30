package com.company;

import com.company.interfaces.Auditable;
import com.company.interfaces.Storable;

public class SchoolRecord implements Storable, Auditable {
    public void storeData() {
        System.out.println("Storing that data!");
    }
    public void retrieveData() {
        System.out.println("Retrieving that data!");
    }
    public void runAudit() {
        System.out.println("Running the audit!");
    }
    public void sendAuditToState() {
        System.out.println("Sending the Audit");
    }
}
