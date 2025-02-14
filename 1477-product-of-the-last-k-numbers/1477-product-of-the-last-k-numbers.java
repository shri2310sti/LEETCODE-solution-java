import java.util.*;

class ProductOfNumbers {
    private List<Integer> prefixProducts;

    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        prefixProducts.add(1); // Initialize with 1 to handle multiplication correctly
    }
    
    public void add(int num) {
        if (num == 0) {
            prefixProducts.clear();
            prefixProducts.add(1); // Reset on zero
        } else {
            prefixProducts.add(prefixProducts.get(prefixProducts.size() - 1) * num);
        }
    }
    
    public int getProduct(int k) {
        int size = prefixProducts.size();
        if (k >= size) return 0; // Zero was encountered, return 0
        return prefixProducts.get(size - 1) / prefixProducts.get(size - 1 - k);
    }
}
