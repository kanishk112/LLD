public class IdleState implements VendingMachineState{

    public final VendingMachine vendingMachine;
    
    public IdleState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
        System.out.println("Vending Machine is in Idle State");
    }

    @Override
    public void selectProduct(Product product){
        if(vendingMachine.inventory.hasProduct(product)){
            vendingMachine.setCurrentProduct(product);
            vendingMachine.setCurrentState(vendingMachine.getReadyState());
            System.out.println("Product selected: " + product.getName());
        }else{
            System.out.println(product.getName() +" Product is out of stock");
        }
    }

    @Override
    public void insertCoins(Coins coins){
        System.out.println("Please select product first");
    }

    @Override
    public void insertNotes(Notes notes){
        System.out.println("Please select product first");
    }

    @Override
    public void dispenseProduct(){
        System.out.println("Please select product first and then insert coins or notes");
    }

    @Override
    public void returnChange(){
        System.out.println("No change to return");
    }
}