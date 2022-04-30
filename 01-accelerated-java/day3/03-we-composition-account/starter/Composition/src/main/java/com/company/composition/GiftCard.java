package com.company.composition;

public class GiftCard {
    private String storeName;
    private String accountNumber;
    private double cardAmount;

    public GiftCard(String storeName, String accountNumber, double cardAmount) {
        this.storeName = storeName;
        this.accountNumber = accountNumber;
        this.cardAmount = cardAmount;
    }

    public GiftCard() {
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getCardAmount() {
        return cardAmount;
    }

    public void setCardAmount(double cardAmount) {
        this.cardAmount = cardAmount;
    }

    @Override
    public String toString() {
        return "GiftCard{" +
                "storeName='" + storeName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", cardAmount=" + cardAmount +
                '}';
    }
}
