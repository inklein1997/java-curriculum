package com.company.composition;

public class AccountApplication {
    public static void main(String[] args) {
        BetterAccount betterAccount = new BetterAccount();
        betterAccount.setFirstName("Michael");
        betterAccount.setLastName("Klein");
        betterAccount.setUsername("inklein1997");

        Address homeAddress = new Address();
        homeAddress.setStreet("12917 Quinn Trail");
        homeAddress.setCity("Austin");
        homeAddress.setState("Texas");
        homeAddress.setZipcode(78727);

        betterAccount.setHomeAddress(homeAddress);

        Address shippingAddress = new Address();
        shippingAddress.setStreet("12917 Quinn Trail");
        shippingAddress.setCity("Austin");
        shippingAddress.setState("Texas");
        shippingAddress.setZipcode(78727);

        betterAccount.setShippingAddress(shippingAddress);

        GiftCard giftCard = new GiftCard("Macy's","1234567891023456", 50.00);

        betterAccount.setGiftCard(giftCard);

        System.out.println(betterAccount);



    }
}
