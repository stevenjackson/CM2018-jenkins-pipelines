package com.congo.service;
import com.congo.domain.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    protected Map<Integer, Product> products;

    public ProductService(){
        initializeProducts();
    }

    public Map<Integer, Product> getAllProducts(){
        if(this.products == null){
            this.products = new HashMap<Integer, Product>();
        }
        return this.products;
    }

    public Product getProduct(Integer id) {
        return getAllProducts().get(id);
    }

    public List<Product> productHistory(Integer userId){
        List<Product> products = new ArrayList<Product>();
        products.add(this.products.get(1));
        products.add(this.products.get(2));
        products.add(this.products.get(3));
        return products;
    }

    public List<Product> relatedProducts(Integer userId){
        List<Product> products = new ArrayList<Product>();
        products.add(this.products.get(4));
        products.add(this.products.get(5));
        products.add(this.products.get(6));
        products.add(this.products.get(7));
        return products;
    }

    public List<Product> trendingProducts(){
        List<Product> products = new ArrayList<Product>();
        products.add(this.products.get(8));
        products.add(this.products.get(9));
        products.add(this.products.get(10));
        products.add(this.products.get(11));
        return products;
    }

    private void initializeProducts(){
        this.products = new HashMap<Integer, Product>();
        Product product1 = new Product(
                1,
                "Rick and Morty Art - Starry Night print van Gogh Never Saw Another Dimension by Aja 8x8, 10x10, 12x12, 20x20, and 24x24 inches choose",
                "$14.00",
                "https://www.amazon.com/gp/product/B01N7W8YCF/ref=s9u_wsim_gw_i3?ie=UTF8&fpl=fresh&pd_rd_i=B01N7W8YCF&pd_rd_r=10656c64-cb1a-11e7-a665-8f20d473311a&pd_rd_w=9doqf&pd_rd_wg=FVUiz&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=&pf_rd_r=AVR9DP2PD0SF43FMRDCY&pf_rd_t=36701&pf_rd_p=d9f78c36-24d5-402e-866f-a50358a0504c&pf_rd_i=desktop",
                "rick_and_morty_starry_night_sky.jpg");
        this.products.put(1, product1);

        Product product2 = new Product(
                2,
                "Splendor",
                "$34.96",
                "https://www.amazon.com/gp/product/B075LQLQ3H/ref=s9u_qpp_gw_i4?ie=UTF8&fpl=fresh&pd_rd_i=B075LQLQ3H&pd_rd_r=64158739-cb1a-11e7-a665-8f20d473311a&pd_rd_w=5xqnK&pd_rd_wg=i8aJO&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=&pf_rd_r=6GG3HXZQPMQAVNTSYE40&pf_rd_t=36701&pf_rd_p=0411ffec-c026-40ae-aac5-2cd3d48aeeac&pf_rd_i=desktop",
                "splendor.jpg");
        this.products.put(2, product2);

        Product product3 = new Product(
                3,
                "Programming Languages ABC++",
                "$11.95",
                "https://www.amazon.com/dp/194275504X/_encoding=UTF8?coliid=I2T29PPS4GSI6G&colid=14ZOGJKJRK9Z4",
                "abc++.jpg");
        this.products.put(3, product3);

        Product product4 = new Product(
                4,
                "Funko Pop Animation Morty-Pickle Rick with Laser Collectible Figure",
                "$10.99",
                "https://www.amazon.com/Funko-Animation-Morty-Pickle-Collectible-Figure/dp/B07569HX5Z/ref=sr_1_7?s=toys-and-games&ie=UTF8&qid=1510870569&sr=1-7&keywords=rick+and+morty",
                "abc++.jpg");
        this.products.put(4, product4);

        Product product5 = new Product(
                5,
                "CSS for Babies (Code Babies)",
                "$1.73",
                "https://www.amazon.com/CSS-Babies-Code-Sterling-Childrens/dp/1454921560/ref=pd_sbs_14_3?_encoding=UTF8&psc=1&refRID=G418P95R3TCRP1G0AQ2T",
                "css_for_babies.jpg");
        this.products.put(5, product5);

        Product product6 = new Product(
                6,
                "Photosynthesis",
                "$31.95",
                "https://www.amazon.com/gp/product/B074K5W5N5/ref=s9u_simh_gw_i7?ie=UTF8&fpl=fresh&pd_rd_i=B074K5W5N5&pd_rd_r=64158739-cb1a-11e7-a665-8f20d473311a&pd_rd_w=zcFgH&pd_rd_wg=i8aJO&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=&pf_rd_r=6GG3HXZQPMQAVNTSYE40&pf_rd_t=36701&pf_rd_p=f719e185-4825-42a4-9507-9df1a19229d6&pf_rd_i=desktop",
                "photosynthesis.jpg");
        this.products.put(6, product6);

        Product product7 = new Product(
                7,
                "Unearth",
                "$24.88",
                "https://www.amazon.com/Brotherwise-Games-Unearth-Board/dp/B06XHM4NZQ/ref=pd_sbs_21_3?_encoding=UTF8&psc=1&refRID=H1VWTG61KVBZ08BF7W8Q",
                "unearth.jpg");
        this.products.put(7, product7);

        Product product8 = new Product(
                8,
                "Ideal 100-Trick Spectacular Magic Show Suitcase",
                "$19.33",
                "https://www.amazon.com/Ideal-100-Trick-Spectacular-Magic-Suitcase/dp/B000PWNGV8/ref=lp_17440033011_1_7?s=toys-and-games&ie=UTF8&qid=1510870732&sr=1-7",
                "magic_show_case.jpg");
        this.products.put(8, product8);

        Product product9 = new Product(
                9,
                "1byone Christmas Outdoor Laser Light Projector with Wireless Remote Controller, Aluminum Alloy Red and Green Stars Laser Show for Xmas, Halloween, Parties, Landscape or Garden Decoration, Black",
                "$41.99",
                "https://www.amazon.com/1byone-Christmas-Projector-Controller-Decoration/dp/B01EV4OGAU/ref=gbps_img_s-3_0ee9_7158591b?smid=A26IMHULYH7PHY&pf_rd_p=30c09623-33cf-4469-be4c-3e8293ae0ee9&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=ME4QGVKRVKR5RPQNWKJ4",
                "light_show.jpg");
        this.products.put(9, product9);

        Product product10 = new Product(
                10,
                "Etekcity Wireless Remote Control Electrical Outlet Switch for Household Appliances, Wireless Remote Light Switch, White (Learning Code, 5Rx-2Tx)",
                "$29.98",
                "https://www.amazon.com/Etekcity-Wireless-Electrical-Household-Appliances/dp/B00DQELHBS/ref=gbps_img_s-3_0ee9_26218ecd?smid=A99MZGWBBIGK9&pf_rd_p=30c09623-33cf-4469-be4c-3e8293ae0ee9&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=ME4QGVKRVKR5RPQNWKJ4",
                "smart_outlet.jpg");
        this.products.put(10, product10);

        Product product11 = new Product(
                11,
                "[20 Pack] 32 Oz. 2 Compartment Meal Prep Containers Durable BPA Free Plastic Reusable Food Storage Container Microwave & Dishwasher Safe w/ Airtight Lid For Portion Control & Bento Box Lunch Box",
                "$15.29",
                "https://www.amazon.com/Compartment-Containers-Container-Microwave-Dishwasher/dp/B01BYA4H1W/ref=gbps_img_s-3_0ee9_da0714cd?smid=A1KIF3FW378WHB&pf_rd_p=30c09623-33cf-4469-be4c-3e8293ae0ee9&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=ME4QGVKRVKR5RPQNWKJ4",
                "food_containers.jpg");
        this.products.put(11, product11);
    }
}
