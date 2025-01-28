package com.mycompany.cafeshopmanagementsystem;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class for card product display.
 */
public class cardProductController implements Initializable {

    @FXML
    private VBox card_form; // Kartın formunun bulunduğu VBox

    @FXML
    private Button prod_addBtn; // "Add" butonu

    @FXML
    private ImageView prod_imageView; // Ürün resmini gösterecek ImageView

    @FXML
    private Label prod_name; // Ürün adı için Label

    @FXML
    private Label prod_price; // Ürün fiyatı için Label

    @FXML
    private Spinner<Integer> prod_spinner; // Ürün miktarını seçecek Spinner

    private productData prodData; // Ürün verisini tutacak nesne

    private Image image; // Ürün resmi

    private String prodID; // Ürün ID'si
    private String type; // Ürün tipi
    private String prod_date; // Ürün tarihi
    private String prod_image; // Ürün resmi yolu

    private SpinnerValueFactory<Integer> spin; // Spinner için değer fabrikası

    private Connection connect; // Veritabanı bağlantısı
    private PreparedStatement prepare; // SQL sorgusu hazırlama
    private ResultSet result; // Sorgu sonucu

    private Alert alert; // Uyarı mesajları

    private int qty; // Ürün miktarı
    private double pr; // Ürün fiyatı

    private double totalP; // Toplam fiyat

    /**
     * Ürün verisini setter metodu ile alır ve ekrana yansıtır.
     */
    public void setData(productData prodData) {
        this.prodData = prodData;

        // Ürün verilerini alıp ilgili bileşenlere aktar
        prod_image = prodData.getImage();
        prod_date = String.valueOf(prodData.getDate());
        type = prodData.getType();
        prodID = prodData.getProductId();
        prod_name.setText(prodData.getProductName());
        prod_price.setText("$" + String.valueOf(prodData.getPrice()));

        // Resmi yükle
        String path = "file:" + prodData.getImage();
        image = new Image(path, 190, 94, false, true);
        prod_imageView.setImage(image);

        // Ürün fiyatını kaydet
        pr = prodData.getPrice();
    }

   
    public void setQuantity() {
        spin = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        prod_spinner.setValueFactory(spin);
    }

    
    public void addBtn() {

        mainFormController mForm = new mainFormController();
        mForm.customerID();

        qty = prod_spinner.getValue();
        String check = "";
        String checkAvailable = "SELECT status FROM product WHERE prod_id = '"
                + prodID + "'";
        String checkAvailable1 = "SELECT * FROM product WHERE prod_id = '"
                + 1 + "'";

        connect = database.connectDB();

        try {
            prepare = connect.prepareStatement(checkAvailable1);
            result = prepare.executeQuery();
             productData prodData;

            while (result.next()) {
                prodData = new productData(
                        result.getInt("id"),
                        result.getString("prod_id"),
                        result.getString("prod_name"),
                        result.getString("type"),
                        result.getInt("stock"),
                        result.getInt("price"),
                        result.getString("stock"),
                        result.getString("image"),
                        result.getDate("date"));

                setData(prodData);

            }

            int checkStck = 0;
            String checkStock = "SELECT stock FROM product WHERE prod_id = '"
                    + prodID + "'";

            prepare = connect.prepareStatement(checkStock);
            result = prepare.executeQuery();

            if (result.next()) {
                checkStck = result.getInt("stock");
            }
            
            if(checkStck == 0){
                
                String updateStock = "UPDATE product SET prod_name = '"
                            + prod_name.getText() + "', type = '"
                            + type + "', stock = 0, price = " + pr
                            + ", status = 'Unavailable', image = '"
                            + prod_image + "', date = '"
                            + prod_date + "' WHERE prod_id = '"
                            + prodID + "'";
                prepare = connect.prepareStatement(updateStock);
                prepare.executeUpdate();
                
            }

            prepare = connect.prepareStatement(checkAvailable);
            result = prepare.executeQuery();

            if (result.next()) {
                check = result.getString("status");
            }

            if (!check.equals("Avaible") || qty == 0) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Something Wrong :3");
                alert.showAndWait();
            } else {

                if (checkStck < qty) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Invalid. This product is Out of stock");
                    alert.showAndWait();
                } else {
                    prod_image = prod_image.replace("\\", "\\\\");
                    
                    String insertData = "INSERT INTO customer "
                            + "(customer_id, prod_name, type, quantity, price, date, em_username) "
                            + "VALUES(?,?,?,?,?,?,?)";
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, String.valueOf(data.cID));
                    
                    prepare.setString(2, prod_name.getText());
                    prepare.setString(3, type);
                    prepare.setString(4, String.valueOf(qty));

                    totalP = (qty * pr);
                    prepare.setInt(5, (int) totalP);

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(6, String.valueOf(sqlDate));

                   
                    prepare.setString(7, data.username);

                    prepare.executeUpdate();
                    System.out.println("Date: " + prod_date);

                    int upStock = checkStck - qty;

                    

                    System.out.println("Date: " + prod_date);
                    System.out.println("Image: " + prod_image);

                    String updateStock = "UPDATE product SET prod_name = '"
                            + prod_name.getText() + "', type = '"
                            + type + "', stock = " + upStock + ", price = " + pr
                            + ", status = '"
                            + check + "', image = '"
                            + prod_image + "', date = '"
                            + prod_date + "' WHERE prod_id = '"
                            + prodID + "'";

                    prepare = connect.prepareStatement(updateStock);
                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();
                    
                    mForm.menuGetTotal();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Uygulama başladığında yapılması gereken başlatma işlemleri burada yapılabilir.
        setQuantity(); // Spinner'ı başlat
    }
}
