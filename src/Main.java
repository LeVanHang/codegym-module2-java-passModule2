//import storage.ReadWriteData;
//import storage.ReadWriteDataInterface;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {
    static ProductManager productManager = new ProductManager();
    //static ReadWriteDataInterface readWrite = (ReadWriteDataInterface) ReadWriteData.getInstance();

    public static void main(String[] args) {
        menuOfProduct();
    }

    public static void menuOfProduct() {
        try {
            do {

                System.out.println("---- PRODUCT MANNAGER ----");
                System.out.println("|choose                  |");
                System.out.println("|1. Display List         |");
                System.out.println("|2. Add                  |");
                System.out.println("|3. Update               |");
                System.out.println("|4. Delete               |");
                System.out.println("|5. Sort                 |");
                System.out.println("|6. Find price hight     |");
               // System.out.println("|7. Write file           |");
               // System.out.println("|8. Read file            |");
                System.out.println("|9. Exip                 |");
                System.out.println("--------------------------");
                System.out.println("Pleace Choose: ");
                Scanner scanner = new Scanner(System.in);
                Scanner scanner1 = new Scanner(System.in);
                int num = scanner1.nextInt();
                switch (num) {
                    case 1:
                        productManager.display();
                        break;
                    case 2:
                        try {
                            System.out.print("Enter ID: ");
                            String ID = scanner.nextLine();
                            System.out.print("Enter Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter Price: ");
                            double price = scanner1.nextDouble();
                            System.out.print("Enter Quantity: ");
                            int quantity = scanner1.nextInt();
                            System.out.print("Enter Description: ");
                            String dsecription = scanner.nextLine();
                            Product product = new Product(ID, name, price, quantity, dsecription);
                            productManager.addProduct(product);
                        } catch (InputMismatchException e) {
                            System.out.println("Sai kiểu dữ liệu");
                            System.out.println("-------------------------------");
                        }
                        break;
                    case 3:
                        try {
                            System.out.println("Enter ID");
                            String id = scanner.nextLine();
                            int check = productManager.checkID(id);
                            if (check == -1) {
                                System.out.println("No Product By ID");
                            } else {
                                System.out.println("Enter New ID");
                                String newID = scanner1.nextLine();
                                System.out.println("Enter New Name");
                                String newName = scanner.nextLine();
                                System.out.println("Enter New Price");
                                double newPrice = scanner1.nextDouble();
                                System.out.println("Enter New Quantity");
                                int newQuantity = scanner.nextInt();
                                System.out.println("Enter New Description");
                                String newDes = scanner1.nextLine();
                                Product product = new Product(newID, newName, newPrice, newQuantity, newDes);
                                productManager.editProduct(check, product);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Bạn đã nhập sai dữ liệu");
                            System.out.println("------------------------------");
                        }
                        break;
                    case 4:
                        try {
                            System.out.print("Enter ID: ");
                            String id = scanner.nextLine();
                            int check = productManager.checkID(id);
                            if (check == -1) {
                                System.out.println("No product By ID");
                                System.out.println("----------------------------------");
                            } else {
                                productManager.deleteProduct(check);
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Bạn đã nhập sai dữ liệu");
                            System.out.println("------------------------------");
                        }
                        break;
                    case 5:
                        try {
                            System.out.println("1. Sort");
                            System.out.println("2. Display List Sort");
                            System.out.println("3. Trở về menu chính");
                            int case5 = scanner.nextInt();
                            switch (case5){
                                case 1:
                                    productManager.sortByPriceLowtoHight();
                                    break;
                                case 2:
                                    productManager.display();
                                    break;
                                case 3:
                                    menuOfProduct();
                                    break;
                            }
                        } catch (InputMismatchException e){
                            System.out.println("Bạn đã nhập sai dữ liệu");
                            System.out.println("------------------------------");
                        }
                        break;
                    case 6:
                        productManager.sortByPriceLowtoHight();
                        List<Product> productsListInMain = productManager.productList;
                        System.out.println(productsListInMain.get(productsListInMain.size()-1));
                        break;
                    //case 7:
                        //ReadWriteData.writeData(ProductManager.productList);
                       // break;
                   // case 8:
                        //ProductManager.productList = readWrite.readData();
                       // break;
                    case 9:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Lựa chọn không tồn tại, mời bạn nhập lại !!!");
                        break;
                }
            } while (true);
        } catch (Exception e) {
            System.out.println("Bạn nhập sai dữ liệu");
            System.out.println("------------------------------");
            menuOfProduct();
        }
    }
}