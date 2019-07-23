import java.util.*;

class Restaurant {
    private String name;
    private String unitNumber;
    public static HashMap<String, String> imgHash;

    Restaurant (String name, String unitNumber) {
        this.name = name;
        this.unitNumber = unitNumber;
    }

    public boolean hasDash() {
        Boolean containsFlag = false;
        for (String merchant : Main.dashArray) {
            if (name.compareToIgnoreCase(merchant) == 0) {
                containsFlag = true;
            }
        }
        return containsFlag;
    }

    public boolean hasGrab() {
        Boolean containsFlag = false;
        for (String merchant : Main.grabArray) {
            if (name.compareToIgnoreCase(merchant) == 0) {
                containsFlag = true;
            }
        }
        return containsFlag;
    }

    public boolean hasNets() {
        Boolean containsFlag = false;
        for (String merchant : Main.netsArray) {
            if (name.compareToIgnoreCase(merchant) == 0) {
                containsFlag = true;
            }
        }
        return containsFlag;
    }

    public String getPayment() {
        if (hasDash() && hasGrab() && hasNets()) {
            return "            \"payment\" : " + "\"Dash, GrabPay, NetsQR\"";
        } else if (hasDash() && hasGrab()) {
            return "            \"payment\" : " + "\"Dash, GrabPay\"";
        } else if (hasDash() && hasNets()) {
            return "            \"payment\" : " + "\"Dash, NetsQR\"";
        } else if (hasGrab() && hasNets()) {
            return "            \"payment\" : " + "\"GrabPay, NetsQR\"";
        } else if (hasGrab()) {
            return "            \"payment\" : " + "\"GrabPay\"";
        } else if (hasNets()) {
            return "            \"payment\" : " + "\"NetsQR\"";
        } else if (hasDash()) {
            return "            \"payment\" : " + "\"Dash\"";
        } else {
            return "            \"payment\" : " + "\"" + "\"";
        }
    }

    public static void makeHash() {
        imgHash = new HashMap<String, String>();
        imgHash.put("2it & Drink", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/2it_%26_Drink.png?alt=media&token=5e9b5ad8-7f77-460c-9c59-cd99c1776419");
        imgHash.put("2nd Bread セールス", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/2nd_Bread.png?alt=media&token=7a4407bf-eae5-452f-a773-153e37dcfb27");
        imgHash.put("3 Sweets", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/3_Sweets.png?alt=media&token=333cb674-02fd-4840-bade-f07e6819c1e7");
        imgHash.put("300 BC Bakery", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/300_BC_Bakery.png?alt=media&token=f7316e2b-e8cf-4291-9585-2524d3a367ec");
        imgHash.put("328 Katong Laksa", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/328_Katong_Laksa.png?alt=media&token=3d633de0-d2fd-4994-b8ed-2f03316bfa87");
        imgHash.put("365 Fruit Juice & Smoothies", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/365_Fruit_Juice_%26_Smoothies.png?alt=media&token=2e6d3101-b0e4-4793-b1ff-580ab2855117");
        imgHash.put("49 Seats", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/49_Seats.png?alt=media&token=a19fab31-47f3-480d-b6aa-f440cc85bcdf");
        imgHash.put("4Fingers Crispy Chicken", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/4Fingers_Crispy_Chicken.png?alt=media&token=5ebf6a39-9b11-4938-be52-bf22af4ede61");
        imgHash.put("5 SENSES BISTRO", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/5_SENSES_BISTRO.png?alt=media&token=dc5e2789-61e2-4fe9-90f4-882095e2627c");
        imgHash.put("52 Sandwich Shack", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/52_Sandwich_Shack.png?alt=media&token=92436ad3-6f07-43e5-b7f4-b5ae72e1df2f");
        imgHash.put("7-Eleven", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/7-Eleven.png?alt=media&token=1e65bf32-b54e-4abd-8191-f2575d147d59");
        imgHash.put("7th Mile Claypot Curry Fish Head", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/7th_Mile_Claypot_Curry_Fish_Head.png?alt=media&token=5b4e52e2-414f-48c1-8e12-cbeb94d0a840");
        imgHash.put("85 Redhill Teochew Fishball Noodles", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/85_Redhill_Teochew_Fishball_Noodles.png?alt=media&token=aa200410-8154-4380-92ef-a014c5a34a81");
        imgHash.put("A Gan Guo Kui", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/A_Gan_Guo_Kui.png?alt=media&token=9afa6d77-c576-45e5-8b9e-90a41cd7b0c8");
        imgHash.put("A-One Claypot House", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/A-One_Claypot_House.png?alt=media&token=a01afdd3-74ed-4567-a5a2-1fb35436915e");
        imgHash.put("A-One Signature", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/A-One_Signature.png?alt=media&token=159db7de-85f7-45c1-af0c-b980d5d52a66");
        imgHash.put("A&W", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/A%26W.png?alt=media&token=5446045a-e4d4-4d5c-aa75-be3f60728234");
        imgHash.put("ABC Cooking Studio", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/ABC_Cooking_Studio.png?alt=media&token=c811794b-0958-4634-b781-49cd896894dc");
        imgHash.put("Ac Kafe", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Ac_Kafe.png?alt=media&token=bff81499-9177-4bd5-90e8-e5ddebae6049");
        imgHash.put("Acai Beach Club", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Acai_Beach_Club.png?alt=media&token=9100f5e7-5c19-4d4a-a352-13016f984745");
        imgHash.put("Afuri", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Afuri.png?alt=media&token=f14c9c4b-1a32-48e0-af9d-ea1b6e6aea1e");
        imgHash.put("Ah Khoo Kopi Toast", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Ah_Khoo_Kopi_Toast.png?alt=media&token=91e5b7ff-5064-4532-b260-0e172197c2a5");
        imgHash.put("Ah Mah Homemade Cake", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Ah_Mah_Homemade_Cake.png?alt=media&token=d51dea2d-eba9-4442-ba1b-1286d62aee3a");
        imgHash.put("AJI ICHI", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/AJI_ICHI.png?alt=media&token=ef18a334-5b2c-4318-8379-cb9258825565");
        imgHash.put("Ajisen Ramen", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Ajisen_Ramen.png?alt=media&token=12fcc664-2efb-454e-be9b-4531985ba313");
        imgHash.put("Ajisen Ramen x Osaka Ohsho", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Ajisen_Ramen_x_Osaka_Ohsho.png?alt=media&token=23731ec4-0e68-4c0c-b799-9ba2395e7bf6");
        imgHash.put("Ajumma's", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Ajummas.png?alt=media&token=a0345574-a32f-43d5-8e32-4f95dd62efa6");
        imgHash.put("Aki Sushi & Grill", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Aki_Sushi_%26_Grill.png?alt=media&token=97fe77c8-ccc9-4eaf-8162-c070ade1dcfc");
        imgHash.put("Akimitsu", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Akimitsu.png?alt=media&token=1179ea9b-0072-4704-b26b-1d337baf131e");
        imgHash.put("Akimitsu Don", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Akimitsu.png?alt=media&token=1179ea9b-0072-4704-b26b-1d337baf131e");
        imgHash.put("Alegro Churros Bar", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Alegro_Churros_Bar.png?alt=media&token=25026674-423c-4c1d-a0e9-d98e0c7b4f31");
        imgHash.put("All The Batter - Avocado & Natural Foods", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/All_The_Batter_-_Avocado_%26_Natural_Foods.png?alt=media&token=9cf345f9-49b0-4484-a818-91693ec1e0d8");
        imgHash.put("Allgood Gourmet", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Allgood_Gourmet.png?alt=media&token=5850bae2-73c1-46a3-9cd4-64837b23abe4");
        imgHash.put("Alligator Pear", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Alligator_Pear.png?alt=media&token=3e14ecee-c0c4-4d7e-b8f5-18d3dbc5fa2e");
        imgHash.put("Aloha Poké", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Aloha_Poke.png?alt=media&token=4e12568d-3cdc-4dff-965a-6e8f4d89a1fb");
        imgHash.put("Ambush", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Ambush.png?alt=media&token=82abe048-d728-4de7-9d92-4382528e1760");
        imgHash.put("An Acai Affair", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/An_Acai_Affair.png?alt=media&token=8a8f6fc9-8fea-4100-8d50-a605cd970c74");
        imgHash.put("Andersen's Of Denmark", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Andersens_Of_Denmark.png?alt=media&token=ddb6dd0c-e9d7-494b-bf8b-749adfe46fdf");
        imgHash.put("Andes by Astons", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Andes_by_Astons.png?alt=media&token=4e3a5f22-a9a6-44d5-bbd0-6d423c576ae5");
        imgHash.put("Angus House", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Angus_House.png?alt=media&token=777bade8-e7e2-4fbb-8df3-88fd567e9097");
        imgHash.put("Anjappar", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Anjappar.png?alt=media&token=06b14753-ff35-4c2f-a443-f613372a4ca4");
        imgHash.put("Anti:dote", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Antidote.png?alt=media&token=13bfcc95-43b0-4231-bd97-99196434c67e");
        imgHash.put("Arnold's Fried Chicken", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Arnolds_Fried_Chicken.png?alt=media&token=063f7565-f90b-4418-b768-3bb8c77fbab5");
        imgHash.put("Arteastiq", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Arteastiq.png?alt=media&token=2ff0f8ad-c8fe-414d-89fa-0de7b4b63296");
        imgHash.put("Asian Market Cafe ", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Asian_Market_Cafe.png?alt=media&token=3b752033-a4ae-469f-b9af-bfbac92d9ffa");
        imgHash.put("Astons Specialties", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Astons_Specialties.png?alt=media&token=c41c7670-5902-4249-88fe-f2fd24a6a671");
        imgHash.put("Astons Steak & Salad", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Astons_Steak_%26_Salad.png?alt=media&token=c382eb77-f9db-40f4-8e73-d788baccc69c");
        imgHash.put("Auntie Anne's", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Auntie_Annes.png?alt=media&token=518399e4-3800-4320-8922-694af1825bac");
        imgHash.put("avobites", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/avobites.png?alt=media&token=c457d4d6-256d-4f97-970d-8f7a2e60723e");
        imgHash.put("Awesome Coffee", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Awesome_Coffee.png?alt=media&token=3a57c840-ce72-453e-818e-a25b04f1edd1");
        imgHash.put("Awfully Chocolate", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Awfully_Chocolate.png?alt=media&token=ada87196-8a9e-4e9e-954d-9060caaaf4af");
        imgHash.put("Ayam Penyet President", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Ayam_Penyet_President.png?alt=media&token=4686163c-abb6-44d1-8294-c3ff47af1e3c");
        imgHash.put("Bacha Coffee", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Bacha_Coffee.png?alt=media&token=1d1275e1-a277-44b1-9d27-43b17303273b");
        imgHash.put("Bagus", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Bagus.png?alt=media&token=a6adc40a-16fc-4b03-ab73-4f3e2df9f5fe");
        imgHash.put("Bake Cheese Tart", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Bake_Cheese_Tart.png?alt=media&token=c9c4b1cc-e53f-4601-96a8-def01d839bd2");
        imgHash.put("Bali Thai", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Bali_Thai.png?alt=media&token=be514561-6983-49d8-bb4f-0f7f956bc7b3");
        imgHash.put("Ban Heng Teochew Porridge", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Ban_Heng_Teochew_Porridge.png?alt=media&token=887fcac3-b90a-4379-a9ef-ec67bf034c07");
        imgHash.put("Bangkok Jam", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Bangkok_Jam.png?alt=media&token=f339ce7b-d9f2-474b-b114-f67bc328c8d1");
        imgHash.put("BaoBao", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/BaoBao.png?alt=media&token=3027f0bf-edac-4047-a60a-8ab685fe6c05");
        imgHash.put("Bar Rouge Singapore", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Bar_Rouge_Singapore.png?alt=media&token=731da375-a0b8-4c8e-8b9c-edb94c2a955b");
        imgHash.put("Barcook", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Barcook.png?alt=media&token=ecd24a18-6423-4281-91d3-1d8ea99ff3e9");
        imgHash.put("Barcook Bakery", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Barcook.png?alt=media&token=ecd24a18-6423-4281-91d3-1d8ea99ff3e9");
        imgHash.put("Baskin Robbins", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Baskin_Robbins.png?alt=media&token=a71afa9e-62dc-4fe3-a834-497de16e6c81");
        imgHash.put("Bayang", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Bayang.png?alt=media&token=3260fdc7-fa78-474f-a614-84a6b54d340a");
        imgHash.put("BBQ Express", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/BBQ_Express.png?alt=media&token=98e1a3d9-eaf4-400f-9c69-c3d27519e647");
        imgHash.put("Beard Papa's", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Beard_Papas.png?alt=media&token=44d40d27-98ff-45f4-a3de-a4d7017e376b");
        imgHash.put("Beauty In The Pot", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Beauty_In_The_Pot.png?alt=media&token=c49b6c50-8637-47c4-9fce-6fa28535c86b");
        imgHash.put("Bebek Goreng Pak Ndut", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Bebek_Goreng_Pak_Ndut.png?alt=media&token=f5598937-a02b-4a45-93f2-a0c256b07928");
        imgHash.put("Bee Cheng Hiang", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Bee_Cheng_Hiang.png?alt=media&token=34479ed7-cb04-49f8-8d8d-11a20a190b23");
        imgHash.put("Beef Bro Concept Bento", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Beef_Bro_Concept_Bento.png?alt=media&token=1bcb04e6-ccf4-4f3c-b9af-c88e0903ef6c");
        imgHash.put("Ben's Cookies", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Bens_Cookies.png?alt=media&token=34814f6d-5a5c-4965-b783-b0dd9d70eb66");
        imgHash.put("Bengawan Solo", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Bengawan_Solo.png?alt=media&token=19ed400e-e254-4e3d-975f-8719fe37df74");
        imgHash.put("Big Bird", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Big_Bird.png?alt=media&token=a8cfe887-adfc-41b5-8411-140060cadf6e");
        imgHash.put("Big Fish Small Fish", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Big_Fish_Small_Fish.png?alt=media&token=144763c1-8b33-4115-b7a4-ae91307c653a");
        imgHash.put("Big O", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Big_O.png?alt=media&token=95dfb21d-89d1-474d-b9b1-462b0a4d81dd");
        imgHash.put("Birds Of Paradise (In Good Company)", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Birds_Of_Paradise.png?alt=media&token=0dd2f79f-bc7e-42bd-aa9b-5e7ee3fe9c23");
        imgHash.put("Bizen Okayama Wagyu Steakhouse", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Bizen_Okayama_Wagyu_Steakhouse.png?alt=media&token=c1218008-45c1-4bc5-964b-53e0fccc1fb2");
        imgHash.put("Blackball", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Blackball.png?alt=media&token=adc34d70-0245-4f5e-a06b-61d561c5ef94");
        imgHash.put("BONCHON Chicken", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/BONCHON_Chicken.png?alt=media&token=d3e38830-d717-4e3f-9c40-c8edbe9680d5");
        imgHash.put("Bonheur Patisserie", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Bonheur_Patisserie.png?alt=media&token=a7f9bcea-2f7b-40ec-ac69-f0c4ed7bd5c9");
        imgHash.put("Boon Tong Kee Happy Nest", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Boon_Tong_Kee_Happy_Nest.png?alt=media&token=03f62c2b-7f86-4524-9dc4-d44023f12818");
        imgHash.put("Boost Juice Bars", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Boost_Juice_Bars.png?alt=media&token=a75a9122-d57f-408f-a176-7896f89941d0");
        imgHash.put("Bottles & Bottles", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Bottles_%26_Bottles.png?alt=media&token=58989233-7a75-4634-9341-8ab7517f8bc7");
        imgHash.put("Boulevard", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Boulevard.png?alt=media&token=083178f2-5f53-48a2-8a11-6a3e077b280f");
        imgHash.put("Bowl Thai", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Bowl_Thai.png?alt=media&token=fcb1d12f-981b-4181-82af-66f5c29b674f");
        imgHash.put("Bread Society By Breadtalk", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Bread_Society_By_Breadtalk.png?alt=media&token=482c5550-b17a-42e8-b936-eed7d1edc9f9");
        imgHash.put("BreadTalk", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/BreadTalk.png?alt=media&token=4b7943ea-4f12-471b-a0a6-19b47b81b9e7");
        imgHash.put("Brotzeit", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Brotzeit.png?alt=media&token=4af0d657-ddaa-41c7-9b9a-4ee947f9924d");
        imgHash.put("Brown Cow", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Brown_Cow.png?alt=media&token=e8937ffc-51cf-429e-8a1e-bd180c567dce");
        imgHash.put("Buddy Hoagies", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Buddy_Hoagies.png?alt=media&token=6dfd5235-650d-4a9c-8c86-6deb4f6c5d2c");
        imgHash.put("Buddy Hoagies Café & Grill", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Buddy_Hoagies.png?alt=media&token=6dfd5235-650d-4a9c-8c86-6deb4f6c5d2c");
        imgHash.put("Buffet Town International Buffet Restaurant", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Buffet_Town_International_Buffet_Restaurant.png?alt=media&token=8671f7c1-f295-4ba8-8fea-8d50d541492a");
        imgHash.put("Bun Times", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Bun_Times.png?alt=media&token=05edb57a-ee5c-4af1-bcfb-226420c88141");
        imgHash.put("Burger & Lobster", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Burger_%26_Lobster.png?alt=media&token=d2c7de0a-30f4-4d76-8908-e8ab8e50e9f0");
        imgHash.put("BURGER KING", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/BURGER_KING.png?alt=media&token=e373dd3c-5075-4c50-b012-d95084c5edd6");
        imgHash.put("BUTTER STUDIO", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/BUTTER_STUDIO.png?alt=media&token=cdabb516-479b-4c59-8027-be84f2c1679e");
        imgHash.put("Butterknife Folk", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Butterknife_Folk.png?alt=media&token=1a191b35-6b7e-43a3-9cd0-27855e6f1452");
        imgHash.put("Café&Meal Muji", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Cafe%26Meal_Muji.png?alt=media&token=5e85eed7-1c05-4d95-b681-e603a2448291");
        imgHash.put("Café Amazon", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Cafe_Amazon.png?alt=media&token=c326affa-a844-4226-b0c7-962c50dfd28c");
        imgHash.put("Café Morozoff", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Cafe_Morozoff.png?alt=media&token=ca050b02-6565-4722-b0fd-10aaabd545f5");
        imgHash.put("Cafe O", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Cafe_O.png?alt=media&token=619ff732-61f0-4fc6-9de8-2fe010fd597d");
        imgHash.put("Cajun On Wheels", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Cajun_On_Wheels.png?alt=media&token=01ea1638-eda0-4ab0-aafd-f6c2deff8501");
        imgHash.put("Canton Paradise", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Canton_Paradise.png?alt=media&token=de0721e0-6589-4065-b0c1-d041fc0feb3c");
        imgHash.put("Capital", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Capital.png?alt=media&token=a5d3dec6-1f26-4d12-9dd4-d34f5264efa7");
        imgHash.put("Carl's Jr", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Carls_Jr.png?alt=media&token=535dd93a-bf24-4202-9c99-1f1e87917b83");
        imgHash.put("Cedele", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Cedele.png?alt=media&token=1c5e27d3-f9a6-41db-9ebb-04f661ba539e");
        imgHash.put("Cedele Bakery Kitchen", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Cedele.png?alt=media&token=1c5e27d3-f9a6-41db-9ebb-04f661ba539e");
        imgHash.put("Central Hong Kong Café", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Central_Hong_Kong_Cafe.png?alt=media&token=5c333968-73dc-43ba-99b3-9dde82b2ba33");
        imgHash.put("Central Thai Kitchen", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Central_Thai_Kitchen.png?alt=media&token=c9e47197-0fa5-4461-97fe-76af01684338");
        imgHash.put("Cha Tra Mue", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Cha_Tra_Mue.png?alt=media&token=01676d8a-bcb3-486f-9f8b-8cd7c3e64e07");
        imgHash.put("Char Grill Western", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Char_Grill_Western.png?alt=media&token=ce555f11-2f16-40c0-8485-ac8241ada36d");
        imgHash.put("Chateraise", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Chateraise.png?alt=media&token=c0ecd8a6-37e4-4280-a54d-1f14ba079e36");
        imgHash.put("Cheese Addiction", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Cheese_Addiction.png?alt=media&token=346a7e84-f7e2-41e3-bf86-1d9812ea9eb6");
        imgHash.put("Chewy Junior", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Chewy_Junior.png?alt=media&token=f4e61415-f43b-4ecf-ac85-0e6aae18e8d5");
        imgHash.put("Chi-Bing", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Chi-Bing.png?alt=media&token=4f1de967-a52d-4c1c-b47c-bf49f88d680e");
        imgHash.put("Chic-A-Boo Chicken Specialty", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Chic-A-Boo_Chicken_Specialty.png?alt=media&token=04d8a36a-2ab7-4a8b-afeb-6e0e590e80d3");
        imgHash.put("CHIPPY - British Take Away", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/CHIPPY_-_British_Take_Away.png?alt=media&token=62787447-d336-4093-8154-3f5fa2891966");
        imgHash.put("Chir Chir Fusion Chicken Factory & Kogane Yama", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Chir_Chir_Fusion_Chicken_Factory.png?alt=media&token=eacc17fe-5a95-42c0-ab37-96b9d102dfdf");
        imgHash.put("Choc Spot", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Choc_Spot.png?alt=media&token=170d192b-68eb-4261-a0b4-692484e7b9c0");
        imgHash.put("Choco Express", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Choco_Express.png?alt=media&token=a9a105c5-8f00-414c-926b-0db90a65fb85");
        imgHash.put("Chocolate Origin", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Chocolate_Origin.png?alt=media&token=b5b58388-0f08-4c2e-854a-580fde185e79");
        imgHash.put("Chuan Grill & Noodle Bar (川串面)", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Chuan_Grill_%26_Noodle_Bar.png?alt=media&token=7231b5b5-561a-437a-a03e-b729a0e9bbc5");
        imgHash.put("Chupitos Shots Bar", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Chupitos_Shots_Bar.png?alt=media&token=72ce7832-e3f1-4f60-af04-d30c58c709d9");
        imgHash.put("Club Illusion Singapore", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Club_Illusion_Singapore.png?alt=media&token=5af59460-52e1-4996-821d-3b46b1c50687");
        imgHash.put("Coca", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Coca.png?alt=media&token=927a60d7-adf4-4830-83e6-74b4a14cfeda");
        imgHash.put("Coco & Frank", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Coco_%26_Frank.png?alt=media&token=389959e5-fb59-49dd-a945-abe7ae64a251");
        imgHash.put("CoCo ICHIBANYA", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/CoCo_ICHIBANYA.png?alt=media&token=ccacf07b-e21a-49f4-8d1f-1f0ef0f7536e");
        imgHash.put("CocoCane", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/CocoCane.png?alt=media&token=9d6ead60-a32a-453f-86db-fd0e3efe434c");
        imgHash.put("Coffee Boy", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Coffee_Boy.png?alt=media&token=6da92ad0-acc1-4144-adc3-1e664745b574");
        imgHash.put("Coffee@Works", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Coffee_Works.png?alt=media&token=e8c54669-c8c4-4c0a-887b-e7bff30e941b");
        imgHash.put("Coffeemin", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Coffeemin.png?alt=media&token=8e8e5abe-8ac5-4583-b7eb-0ce9b46426d1");
        imgHash.put("Coffeesmith", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Coffeesmith.png?alt=media&token=1c98f073-402a-4f9a-ac9a-941f8c196f4a");
        imgHash.put("Cold Stone Creamery", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Cold_Stone_Creamery.png?alt=media&token=43f5c201-1309-409a-9179-129ddc177ddd");
        imgHash.put("COLLIN'S", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/COLLINS.png?alt=media&token=f77dd777-ba40-4014-9195-b6554e26ec98");
    }

    public void printRest() {
        System.out.println("        \"" + name + "\" : {");
        System.out.println("            \"name\" : " + "\"" + name + "\",");
        System.out.println("            \"address\" : " + "\"" + unitNumber+ "\",");
        System.out.println(getPayment() + ",");
        if (imgHash.containsKey(name)) {
            System.out.println("            \"image\" : " + "\"" + imgHash.get(name) + "\"");
        } else {
            System.out.println("            \"image\" : " + "\"\"");
        }
        System.out.println("        " + "},");
    }

    public void printRestLast() {
        System.out.println("        \"" + name + "\" : {");
        System.out.println("            \"name\" : " + "\"" + name + "\",");
        System.out.println("            \"address\" : " + "\"" + unitNumber + "\",");
        System.out.println(getPayment() + ",");
        if (imgHash.containsKey(name)) {
            System.out.println("            \"image\" : " + "\"" + imgHash.get(name) + "\"");
        } else {
            System.out.println("            \"image\" : " + "\"\"");
        }
        System.out.println("        " + "}");
    }
}
