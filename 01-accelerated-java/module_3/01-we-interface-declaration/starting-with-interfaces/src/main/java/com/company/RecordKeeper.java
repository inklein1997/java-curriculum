package com.company;

import com.company.interfaces.Auditable;

public class RecordKeeper {
    public static void main(String[] args) {
        SchoolRecord schoolRecord = new SchoolRecord();
        TaxRecord taxRecord = new TaxRecord();

        System.out.println("school record:");
        schoolRecord.storeData();
        schoolRecord.retrieveData();
        schoolRecord.runAudit();


        System.out.println("+===========+");
        taxRecord.setNameOfTaxedPerson("Michael");
        taxRecord.getNameOfTaxedPerson();
        taxRecord.addW2Information("Cognizant");
        System.out.println("tax record");
        taxRecord.runAudit();
        taxRecord.sendAuditToState();

        Auditable schoolRecord2 = new SchoolRecord();
        Auditable taxRecord2 = new TaxRecord();
        schoolRecord2.runAudit();
        schoolRecord2.sendAuditToState();
//        schoolRecord2.storeData();

        Auditable[] auditableRecords = new Auditable[4];
        auditableRecords[0] = schoolRecord2;
        auditableRecords[1] = taxRecord2;
        auditableRecords[2] = schoolRecord;
        auditableRecords[3] = taxRecord;

        for (Auditable a : auditableRecords) {
            System.out.println("======================NEXT======================");
            a.runAudit();
            a.sendAuditToState();
        }
    }
}
