public class ReturnChangeState implements VendingMachineState{
    private final VendingMachine vendingMachine;

    public ReturnChangeState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
        System.out.println("Vending Machine is in Return Change State");
    }

    @Override   
    public void selectProduct(Product product){
        System.out.println("Please wait, returning change");
    }

    @Override
    public void insertCoins(Coins coins){
        System.out.println("Please wait, returning change");
    }

    @Override
    public void insertNotes(Notes notes){
        System.out.println("Please wait, returning change");
    }

    @Override
    public void dispenseProduct(){
        System.out.println("Product dispensed. Please collect the change");
    }

    @Override
    public void returnChange(){
        double change = vendingMachine.getTotalPayment() - vendingMachine.getCurrentProduct().getPrice();
        if(change > 0){
            System.out.println("Change returned: " + change);
            vendingMachine.resetPayment();
        } else {
            System.out.println("No change to return");
        }
        vendingMachine.reselectProduct();
        vendingMachine.setCurrentState(vendingMachine.getIdleState());
    }
}