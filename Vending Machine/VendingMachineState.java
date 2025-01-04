public interface  VendingMachineState{
    void selectProduct(Product product);
    void insertCoins(Coins coins);
    void insertNotes(Notes notes);
    void dispenseProduct();
    void returnChange();
}