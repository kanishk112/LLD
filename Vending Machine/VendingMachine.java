public class VendingMachine{
    private static VendingMachine instance;
    Inventory inventory;
    private final VendingMachineState idleState;
    private final VendingMachineState readyState;
    private final VendingMachineState returnChangeState;
    private final VendingMachineState dispenseState;
    private VendingMachineState currentState;
    private Product currentProduct;
    private double totalPayment;

    private VendingMachine(){
        inventory = new Inventory();
        idleState = new IdleState(this);
        readyState = new ReadyState(this);
        returnChangeState = new ReturnChangeState(this);
        dispenseState = new DispenseState(this);
        currentState = idleState;
        currentProduct = null;
        totalPayment = 0.0;
    }

    public static synchronized VendingMachine getInstance(){
        if(instance == null){
            instance = new VendingMachine();
        }
        return instance;
    }

    public void selectProduct(Product product){
        currentState.selectProduct(product);
    }

    public void insertCoin(Coins coins){
        currentState.insertCoins(coins);
    }

    public void insertNotes(Notes notes){
        currentState.insertNotes(notes);
    }

    public void dispenseProduct(){
        currentState.dispenseProduct();
    }

    public void returnChange(){
        currentState.returnChange();
    }

    void setCurrentState(VendingMachineState state){
        currentState = state;
    }

    VendingMachineState getIdleState(){
        return idleState;
    }

    VendingMachineState getReadyState(){
        return readyState;
    }

    VendingMachineState getReturnChangeState(){
        return returnChangeState;
    }

    VendingMachineState getDispenseState(){
        return dispenseState;
    }

    Product getCurrentProduct(){
        return currentProduct;
    }

    void setCurrentProduct(Product product){
        currentProduct = product;
    }

    double getTotalPayment(){
        return totalPayment;
    }

    void reselectProduct(){
        currentProduct = null;
    }

    void addCoin(Coins coins){
        totalPayment += coins.getValue();
    }

    void addNotes(Notes notes){
        totalPayment += notes.getValue();
    }

    void resetPayment(){
        totalPayment = 0.0;
    }
}