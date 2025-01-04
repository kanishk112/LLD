public class ReadyState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
        System.out.println("Vending Machine is in Ready State");
    }

    @Override
    public void selectProduct(Product product){
        System.out.println("Product "+ product.getName()+ " already selected. Please make payment.");
    }

    @Override
    public void insertCoins(Coins coins){
        vendingMachine.addCoin(coins);
        System.out.println("Coins inserted: " + coins.getValue());
        checkPaymentStatus();
    }

    @Override
    public void insertNotes(Notes notes){
        vendingMachine.addNotes(notes);
        System.out.println("Notes inserted: " + notes.getValue());
        checkPaymentStatus();
    }

    @Override
    public void dispenseProduct(){
        System.out.println("Please make payment first.");
    }

    @Override
    public void returnChange(){
        System.out.println("Please make payment first.");
    }

    private void checkPaymentStatus(){
        if(vendingMachine.getTotalPayment() >= vendingMachine.getCurrentProduct().getPrice()){
            vendingMachine.setCurrentState(vendingMachine.getDispenseState());
        }
    }

}