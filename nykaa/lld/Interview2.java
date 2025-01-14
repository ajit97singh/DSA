package src.src.nykaa.lld;

/*
* Design the core functionalities of an online Pharmacy system similar to Healthkart or Tata 1mg.
* The system that should allow users to search, and purchase medicines. Implement the mentioned features only:
- To search and fetch medicines by name.
- Add medicine to the cart if inventory is available.
- Create order - Give details like address, phone number.

* */

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Interview2 {

    @Getter
    class User{
        private int userId;
        private String name;
        private Address address;
        private String email;
    }

//    @Service
    interface UserDbService {
        public User getUserById(String userId);
    }

    @Getter
    class Address {
        private String city;
        private String state;
        private String Country;
        private String addressLine1;
        private String addressLine2;

    }

    @Getter
    class Medicine {
        private String name;
        private Double price;
        private Boolean prescribed;
        private int stockLeft;
        private int maxQuantity;
    }

//    @Service
    interface MedicineDbService {

        List<Medicine> searchMedicine(String name);

    }

    @Getter
    class OrderItem {
        private Medicine medicine;
        private int quantity;
        private double orderItemPrice;

    }

    class Order {
        private Cart cart;
        private String userId;
        private User user;

//        @Autowrire
        UserDbService userDbService;

        public Order(Cart cart, String userId) {
            User currentUser = userDbService.getUserById(userId);
            this.user = currentUser;
            this.cart = cart;
            // reduce the medicine stock here
        }
    }

    @Getter
    class Cart {
        private String userId;
        private List<OrderItem> items;

//        @Autowire
        MedicineDbService medicineDbService;

        public Cart(String userId) {
            this.userId = userId;
            this.items = new ArrayList<>();
        }

        public List<Medicine> searchMedicines(String name) {
            List<Medicine> medicines = medicineDbService.searchMedicine(name);
            if (medicines.isEmpty()) {
                // null and empty list check

            }
            return medicines;
        }

        public void addMedicine(Medicine medicine, int quantity) {
            if (quantity <= medicine.getStockLeft() && quantity <= medicine.getMaxQuantity()) {
//                medicine.stockLeft = medicine.getStockLeft() - quantity;
                OrderItem orderItem = new OrderItem();
                orderItem.medicine = medicine;
                orderItem.quantity = quantity;
                this.items.add(orderItem);
            } else {
                if (medicine.getStockLeft() == 0){
                    System.out.println("Item out of stock, please come back later");
                // and else if for reaching threshold of medicine quantity
                }else {
                    System.out.println("Not enough Stock left, please reduce order quantity");
                }

            }
        }

        public Order createOrder() {
            Order result = new Order(this, userId);
            return result;
        }


    }

//    @Service // to be added by spring boot
    interface MedicineCrudDbService {
        public List<Medicine> searchMedicine(String name);

    }

}
