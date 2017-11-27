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
                "Thank you for your interest in my art! Name and watermark will not be on your print. Please note this is a print - not an original painting. This stunning print of my original painting entitled \"van Gogh Never Saw Another Dimension\" utilizes all silver traditional photo processing. It is printed on high quality Kodak Professional Endura Premier Paper, which will last over 60 years without fading. The print is not on canvas and it is not framed. 8x8, 10x10, 12x12, 20x20, and 24x24 inch sizes - please choose from the drop down menu. *Please note colors may vary from monitor to monitor due to individual settings and limitations in digital photography - every effort is made to come as close to actual colors in each painting as possible.",
                "$14.00",
                "https://www.amazon.com/gp/product/B01N7W8YCF/ref=s9u_wsim_gw_i3?ie=UTF8&fpl=fresh&pd_rd_i=B01N7W8YCF&pd_rd_r=10656c64-cb1a-11e7-a665-8f20d473311a&pd_rd_w=9doqf&pd_rd_wg=FVUiz&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=&pf_rd_r=AVR9DP2PD0SF43FMRDCY&pf_rd_t=36701&pf_rd_p=d9f78c36-24d5-402e-866f-a50358a0504c&pf_rd_i=desktop",
                "rick_and_morty_starry_night_sky.jpg");
        this.products.put(1, product1);

        Product product2 = new Product(
                2,
                "Splendor",
                "Cities of splendor introduces four complete expansions to the splendor base game, each accentuating and highlighting a different aspect of the original game. Towers allow players to reserve additional cards, special powers introduce a new layer of engine building, cities give players a new goal to strive towards, and a range of exciting development cards add spice to any game. Each of these four expansions offers a completely unique approach to the game of splendor without compromising the game’s original elegance.",
                "$34.96",
                "https://www.amazon.com/gp/product/B075LQLQ3H/ref=s9u_qpp_gw_i4?ie=UTF8&fpl=fresh&pd_rd_i=B075LQLQ3H&pd_rd_r=64158739-cb1a-11e7-a665-8f20d473311a&pd_rd_w=5xqnK&pd_rd_wg=i8aJO&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=&pf_rd_r=6GG3HXZQPMQAVNTSYE40&pf_rd_t=36701&pf_rd_p=0411ffec-c026-40ae-aac5-2cd3d48aeeac&pf_rd_i=desktop",
                "splendor.jpg");
        this.products.put(2, product2);

        Product product3 = new Product(
                3,
                "Programming Languages ABC++",
                "It's an alphabet book that aims to help us share what we do with the kids in our life, and spark children's interest in coding.",
                "$11.95",
                "https://www.amazon.com/dp/194275504X/_encoding=UTF8?coliid=I2T29PPS4GSI6G&colid=14ZOGJKJRK9Z4",
                "abc++.jpg");
        this.products.put(3, product3);

        Product product4 = new Product(
                4,
                "Funko Pop Animation Morty-Pickle Rick with Laser Collectible Figure",
                "From Rick and morty, pickle Rick with laser, as a stylized pop vinyl from Funko! figure stands 3 3/4 inches and comes in a window display box. Check out the other Rick and morty figures from Funko! collect them all!",
                "$10.99",
                "https://www.amazon.com/Funko-Animation-Morty-Pickle-Collectible-Figure/dp/B07569HX5Z/ref=sr_1_7?s=toys-and-games&ie=UTF8&qid=1510870569&sr=1-7&keywords=rick+and+morty",
                "pick_rick.jpg");
        this.products.put(4, product4);

        Product product5 = new Product(
                5,
                "CSS for Babies (Code Babies)",
                "Coding and web-design skills are becoming more and more important in our technological world. These concept books will familiarize young ones with the kind of shapes and colors that make up web-based programming language and give them the head start they need.\n Show your little ones how to display HTML elements properly with CSS (Cascading Style Sheets) and familiarize them with the visual patterns and symbols that make up the essential building blocks of the web. This beautiful book is a colorful introduction to coding and the web, and is the perfect gift for any technologically minded family.",
                "$1.73",
                "https://www.amazon.com/CSS-Babies-Code-Sterling-Childrens/dp/1454921560/ref=pd_sbs_14_3?_encoding=UTF8&psc=1&refRID=G418P95R3TCRP1G0AQ2T",
                "css_for_babies.jpg");
        this.products.put(5, product5);

        Product product6 = new Product(
                6,
                "Photosynthesis",
                "Welcome to the world of Photosynthesis, the green strategy board game! Plant and shape the ever-changing forest as you cultivate your seeds and your strategy. Take your trees through their life-cycle, from seedling to full bloom to rebirth, and earn points as their leaves collect energy from the revolving sun’s rays. Carefully pick where you sow and when you grow, as trees in the shadows are blocked from light, and from points. This game features realistic gameplay and beautiful graphics.",
                "$31.95",
                "https://www.amazon.com/gp/product/B074K5W5N5/ref=s9u_simh_gw_i7?ie=UTF8&fpl=fresh&pd_rd_i=B074K5W5N5&pd_rd_r=64158739-cb1a-11e7-a665-8f20d473311a&pd_rd_w=zcFgH&pd_rd_wg=i8aJO&pf_rd_m=ATVPDKIKX0DER&pf_rd_s=&pf_rd_r=6GG3HXZQPMQAVNTSYE40&pf_rd_t=36701&pf_rd_p=f719e185-4825-42a4-9507-9df1a19229d6&pf_rd_i=desktop",
                "photosynthesis.jpg");
        this.products.put(6, product6);

        Product product7 = new Product(
                7,
                "Unearth",
                "Lead your tribe of delvers to victory as they explore forests, deserts, islands, caverns, and mountains to find the lost ruins of your ancient civilization. Unearth is a dice placement game where players roll different dice to claim ruins, Salvage stones that are used to rebuild ancient wonders, and play powerful delivery cards to find the best path to victory.",
                "$24.88",
                "https://www.amazon.com/Brotherwise-Games-Unearth-Board/dp/B06XHM4NZQ/ref=pd_sbs_21_3?_encoding=UTF8&psc=1&refRID=H1VWTG61KVBZ08BF7W8Q",
                "unearth.jpg");
        this.products.put(7, product7);

        Product product8 = new Product(
                8,
                "Ideal 100-Trick Spectacular Magic Show Suitcase",
                "Share some holiday magic\n" +
                        "Children will wow their audiences and amaze even themselves, learning the great secrets of illusion with one of the most complete magic sets ever made. The set comes with 'Secrets of 100 Magic Tricks' book and instructional magic trick DVD starring magician Ryan Oakes.\n" +
                        "\n" +
                        "Everyone Loves magic\n" +
                        "Boys and Girls alike enjoy surprising their friends and family with sleight of hand illusions. Magic bolsters confidence in kids so even the shyest child will come out of his or her shell to show off their new found skills.\n" +
                        "\n" +
                        "Performance essentials included\n" +
                        "Start performing as soon as you open the box. The set come with your own Magic Hat, Magic Wand, Performance Table and props.",
                "$19.33",
                "https://www.amazon.com/Ideal-100-Trick-Spectacular-Magic-Suitcase/dp/B000PWNGV8/ref=lp_17440033011_1_7?s=toys-and-games&ie=UTF8&qid=1510870732&sr=1-7",
                "magic_show_case.jpg");
        this.products.put(8, product8);

        Product product9 = new Product(
                9,
                "1byone Christmas Outdoor Laser Light Projector with Wireless Remote Controller, Aluminum Alloy Red and Green Stars Laser Show for Xmas, Halloween, Parties, Landscape or Garden Decoration, Black",
                "A laser light projector. Not sure what else to tell you, the product page may have disappeared after realizing I needed a description",
                "$41.99",
                "https://www.amazon.com/1byone-Christmas-Projector-Controller-Decoration/dp/B01EV4OGAU/ref=gbps_img_s-3_0ee9_7158591b?smid=A26IMHULYH7PHY&pf_rd_p=30c09623-33cf-4469-be4c-3e8293ae0ee9&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=ME4QGVKRVKR5RPQNWKJ4",
                "light_show.jpg");
        this.products.put(9, product9);

        Product product10 = new Product(
                10,
                "Etekcity Wireless Remote Control Electrical Outlet Switch for Household Appliances, Wireless Remote Light Switch, White (Learning Code, 5Rx-2Tx)",
                "A New Way to Control Your Appliances\n" +
                        "The Remote Control Outlets revolutionize the way you power your electrical appliances with a wireless range 100 feet.\n" +
                        "\n" +
                        "Outlets are easily programmable to meet your needs.\n" +
                        "\n" +
                        "Reduce your energy bill by turning up appliances that use up standby power.",
                "$29.98",
                "https://www.amazon.com/Etekcity-Wireless-Electrical-Household-Appliances/dp/B00DQELHBS/ref=gbps_img_s-3_0ee9_26218ecd?smid=A99MZGWBBIGK9&pf_rd_p=30c09623-33cf-4469-be4c-3e8293ae0ee9&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=ME4QGVKRVKR5RPQNWKJ4",
                "smart_outlet.jpg");
        this.products.put(10, product10);

        Product product11 = new Product(
                11,
                "[20 Pack] 32 Oz. 2 Compartment Meal Prep Containers Durable BPA Free Plastic Reusable Food Storage Container Microwave & Dishwasher Safe w/ Airtight Lid For Portion Control & Bento Box Lunch Box",
                "Stay Organized During Your Fitness Journey\n" +
                        "\n" +
                        "Plan your meals ahead of time for your health and meal prep with confidence. Stop buying unhealthy foods at expensive prices and start packing smart lunch boxes and portion control containers!\n" +
                        "\n" +
                        "Perfect for preparing many meals at once, portion control, and managing your macronutrients",
                "$15.29",
                "https://www.amazon.com/Compartment-Containers-Container-Microwave-Dishwasher/dp/B01BYA4H1W/ref=gbps_img_s-3_0ee9_da0714cd?smid=A1KIF3FW378WHB&pf_rd_p=30c09623-33cf-4469-be4c-3e8293ae0ee9&pf_rd_s=slot-3&pf_rd_t=701&pf_rd_i=gb_main&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=ME4QGVKRVKR5RPQNWKJ4",
                "food_containers.jpg");
        this.products.put(11, product11);
    }
}
