package com.company.composition;

public class GiftCard {

    private String cardNumber;
    private float originalAmount;
    private float currentBalance;

    public GiftCard(String cardNumber, float originalAmount) {
        this.cardNumber = cardNumber;
        this.originalAmount = originalAmount;
        this.currentBalance = originalAmount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public float getOriginalAmount() {
        return originalAmount;
    }

    public float getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(float currentBalance) {
        this.currentBalance = currentBalance;
    }
}
