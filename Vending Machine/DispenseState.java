public class DispenseState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
        System.out.println("Vending Machine is in Dispense State");
    }

    @Override
    public void selectProduct(Product product){
        System.out.println("Product selected: " + product.getName()+ ". Please collect the dispensed product.");
    }

    @Override
    public void insertCoins(Coins coins){
        System.out.println("Payment already done. Please collect the dispensed product.");
    }

    @Override
    public void insertNotes(Notes notes){
        System.out.println("Payment already done. Please collect the dispensed product.");
    }

    @Override
    public void dispenseProduct(){
        vendingMachine.setCurrentState(vendingMachine.getReadyState());
        Product product = vendingMachine.getCurrentProduct();
        vendingMachine.inventory.updateQuantity(product, vendingMachine.inventory.getQuantity(product) - 1);
        System.out.println("Product dispensed: "+ product.getName());
        vendingMachine.setCurrentState(vendingMachine.getReturnChangeState());
    }

    @Override
    public void returnChange() {
        throw new UnsupportedOperationException("Please collect the dispensed product first.");
    }
}