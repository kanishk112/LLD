public class Main{
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();
        // Add products to the inventory
        Product coke = new Product("Coke", 1.5);
        Product pepsi = new Product("Pepsi", 1.5);
        Product water = new Product("Water", 1.0);

        vendingMachine.inventory.addProduct(coke, 5);
        vendingMachine.inventory.addProduct(pepsi, 3);
        vendingMachine.inventory.addProduct(water, 2);

        // Select a product
        vendingMachine.selectProduct(coke);

        // Insert coins
        vendingMachine.insertCoin(Coins.TEN);
        vendingMachine.insertCoin(Coins.TEN);
        vendingMachine.insertCoin(Coins.TEN);
        vendingMachine.insertCoin(Coins.TEN);

        // Insert a note
        vendingMachine.insertNotes(Notes.FIVE);

        // Dispense the product
        vendingMachine.dispenseProduct();

        // Return change
        vendingMachine.returnChange();

        // Select another product
        vendingMachine.selectProduct(pepsi);

        // Insert insufficient payment
        vendingMachine.insertCoin(Coins.TEN);

        // Try to dispense the product
        vendingMachine.dispenseProduct();

        // Insert more coins
        vendingMachine.insertCoin(Coins.TEN);
        vendingMachine.insertCoin(Coins.TEN);
        vendingMachine.insertCoin(Coins.TEN);
        vendingMachine.insertCoin(Coins.TEN);

        // Dispense the product
        vendingMachine.dispenseProduct();

        // Return change
        vendingMachine.returnChange();
    }
}