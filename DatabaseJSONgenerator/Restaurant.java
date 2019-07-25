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
        imgHash.put("BreadTalk & Toast Box", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/breadtalk_and_toastbox.png?alt=media&token=c8ffb85a-6710-4233-9813-a7346e82228d");
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
        imgHash.put("Chuan Xiang", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Chuan_Xiang.png?alt=media&token=26b61f03-a268-4374-81d0-3c399e819076");
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
        imgHash.put("Saap Saap Thai", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Saap_Saap_Thai.png?alt=media&token=3ca8f0b5-ba1a-4b3d-ab6e-48bdcb745ba4");
        imgHash.put("Saboten Express", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Saboten_Express.png?alt=media&token=8eb91acc-4d53-4b4e-a892-71b2c10f2f57");
        imgHash.put("Saint-Louis House", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Saint-Louis_House.png?alt=media&token=2a00e293-d1b2-43c5-8082-3628a47c1edc");
        imgHash.put("Saizeriya", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Saizeriya.png?alt=media&token=19b776f9-c97d-4ea9-97e7-496b67593bf0");
        imgHash.put("Sakae Sushi", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Sakae_Sushi.png?alt=media&token=2ceeab09-444e-4c0f-8474-03874bfe5ba8");
        imgHash.put("Sake Inn", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Sake_Inn.png?alt=media&token=ff6c12fb-b5ff-4ea1-813d-b0b725d011da");
        imgHash.put("Sakon Thai", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Sakon_Thai.png?alt=media&token=894805f6-b2f5-4cee-96f6-8f68e14033d5");
        imgHash.put("Sakura", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Sakura.png?alt=media&token=3e08ed6c-49c0-4009-8f12-cf48bd9e55d2");
        imgHash.put("Salt Grill & Sky Bar", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Salt_Grill_%26_Sky_Bar.png?alt=media&token=bbdc359f-b999-40ff-8b95-0600acb169d7");
        imgHash.put("Sama Curry", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Sama_Curry.png?alt=media&token=0d82ea83-c760-4461-962f-37499fd6a8b6");
        imgHash.put("Sama Sama By Tok Tok", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Sama_Sama_By_Tok_Tok.png?alt=media&token=3f708a8c-b549-4763-80a6-921141abddc4");
        imgHash.put("Samsui", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Samsui.png?alt=media&token=e5c16289-acfe-460a-b5bc-d1a40c5888c0");
        imgHash.put("SAMURICE", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/SAMURICE.png?alt=media&token=867ef990-7d2a-408e-bb05-bf7de28f453f");
        imgHash.put("San Yuan Ge", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/San_Yuan_Ge.png?alt=media&token=c96efe5c-51e6-4a66-9795-fbbda22196f2");
        imgHash.put("Sankranti", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Sankranti.png?alt=media&token=a28ab556-4eba-4361-b335-191e5e2837da");
        imgHash.put("Sanook Kitchen", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Sanook_Kitchen.png?alt=media&token=83221af9-5031-4a23-98e1-e74dccc86608");
        imgHash.put("Sauce It", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Sauce_It.png?alt=media&token=c2f3bd16-8ed1-46c5-a89e-b1193c6141c3");
        imgHash.put("Saveur", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Saveur.png?alt=media&token=7db012bb-82cd-4c82-a557-76e5f4ef2e8c");
        imgHash.put("Say Chiizu", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Say_Chiizu.png?alt=media&token=b0d6ba03-400c-49c0-aa88-39d879867e35");
        imgHash.put("Saybons French Food Factory", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Saybons_French_Food_Factory.png?alt=media&token=d406f4b8-7dd3-4ccc-b614-0362234a4c16");
        imgHash.put("Secret Recipe", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Secret_Recipe.png?alt=media&token=1ed00b7b-0164-40c9-975d-9f13cc15af95");
        imgHash.put("Segar Restaurant", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Segar_Restaurant.png?alt=media&token=80fdc9ba-7a1b-49ab-8fed-a3e34d644b70");
        imgHash.put("Senor Taco", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Senor_Taco.png?alt=media&token=582ae075-0ca3-4ac3-95ec-b1738947c462");
        imgHash.put("SEORAE", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/SEORAE.png?alt=media&token=2b9cc29c-e2f4-4a31-a1ac-f9936a2b9bb6");
        imgHash.put("Seoul Garden", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Seoul_Garden.png?alt=media&token=9b27a377-097a-413d-83e6-f79fb48a6e3e");
        imgHash.put("Seoul Garden Hotpot", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Seoul_Garden_Hotpot.png?alt=media&token=7cbe49b9-76ca-45e8-a756-9ed520ea7f40");
        imgHash.put("Seoul Yummy", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Seoul_Yummy.png?alt=media&token=f16b6762-4953-40ab-abab-4c3203d2d813");
        imgHash.put("SF FRUITS", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/SF_FRUITS.png?alt=media&token=8ce4478a-a8bd-4bc7-845b-c58052f8fabf");
        imgHash.put("Shabu Sai", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Shabu_Sai.png?alt=media&token=7488a5af-ecca-4fd6-acf0-c9e0ad4ac63b");
        imgHash.put("Shahi Maharani North Indian Restaurant", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Shahi_Maharani_North_Indian_Restaurant.png?alt=media&token=bfb99895-953b-4d5d-890f-456d434ee9ae");
        imgHash.put("Shake Shack", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Shake_Shack.png?alt=media&token=97a89067-6f96-4afb-9d02-e964f1dbdaa8");
        imgHash.put("Shan Cheng", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Shan_Cheng.png?alt=media&token=4db44dd1-9cba-4fb5-aa02-ffc14e930e2f");
        imgHash.put("Shang Social", "");
        imgHash.put("Sharetea", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Sharetea.png?alt=media&token=77d65d3d-85b9-4fa5-bb79-4178a5d95f6e");
        imgHash.put("Sharetea Premium", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Sharetea_Premium.png?alt=media&token=4098acf4-41bb-4702-9908-9fd61059e6e4");
        imgHash.put("Shen Xi Lao Huo Tang", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Shen_Xi_Lao_Huo_Tang.png?alt=media&token=0011ad15-5588-46e1-9935-52358dc4e8b7");
        imgHash.put("Shi Li Fang Hot Pot", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Shi_Li_Fang.png?alt=media&token=4ce57ad8-428b-430c-9889-ca77a711f2af");
        imgHash.put("Shihlin Taiwan Street Snacks", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Shihlin_Taiwan_Street_Snacks.png?alt=media&token=3eb263f4-309d-4a7b-862c-96c312c08415");
        imgHash.put("Shiki Hototogitsu Ramen", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Shiki_Hototogitsu_Ramen.png?alt=media&token=7d0260d8-b999-48ef-a02d-204b46ffa298");
        imgHash.put("Shiraz Mazzeh (Iranian Takeaway)", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Shiraz_Mazzeh.png?alt=media&token=86e6141c-33b7-43d6-a4ed-1bcb8159d457");
        imgHash.put("Shirokane Tori-Tama Yakitori", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Shirokane_Tori-Tama_Yakitori.png?alt=media&token=d52f859c-496b-4064-94ad-1976f58fe191");
        imgHash.put("Shuffle Bistro Bar", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Shuffle_Bistro_Bar.png?alt=media&token=1d9da539-8e9b-4e3e-9b39-ea832fae263b");
        imgHash.put("Siam Kitchen", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Siam_Kitchen.png?alt=media&token=3fcad80e-bd3a-420d-8b0f-a8f868d7c009");
        imgHash.put("Sichuan Chef", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Sichuan_Chef.png?alt=media&token=dbc108cb-bb91-4eb5-9abe-7a6d602f046b");
        imgHash.put("Signature Koi", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Signature_Koi.png?alt=media&token=2c4ee413-f83c-42c4-9e83-a6f6e44b9e9e");
        imgHash.put("Simply Wrapps", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Simply_Wrapps.png?alt=media&token=bf71c758-d4ef-4150-ab62-8864b043f7d3");
        imgHash.put("Sin Gan Tian", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Sin_Gan_Tian.png?alt=media&token=7b8a2a53-78d5-4b74-bf58-db7999b826b8");
        imgHash.put("Sin Song Kee", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Sin_Song_Kee.png?alt=media&token=70c1a6f5-b501-4b36-b3d1-ca510fc9d7f8");
        imgHash.put("Singa Goody", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Singa_Goody.png?alt=media&token=9b41afc5-ca56-4fd6-9aa3-603b9b051ea5");
        imgHash.put("Singapore Straits Emporium", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Singapore_Straits_Emporium.png?alt=media&token=bd2d9c87-c4b8-4731-b76e-72483ecfdca7");
        imgHash.put("Sinpopo Brand", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Sinpopo_Brand.png?alt=media&token=3f617f60-9f8a-4aad-8b43-275b2262a305");
        imgHash.put("SKAI", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/SKAI.png?alt=media&token=27cd5dde-a70f-4ebd-8c34-8c710071a2a5");
        imgHash.put("Slappy Cakes", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Slappy_Cakes.png?alt=media&token=66429472-b017-42ad-a53f-32d082bd40ed");
        imgHash.put("SMA - Super Makan Asia", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/SMA_-_Super_Makan_Asia.png?alt=media&token=4ec9e9cd-af1e-4eef-821c-283c3a84289d");
        imgHash.put("Snackz It! 可口味", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Snackz_It.png?alt=media&token=ee137f40-1128-4a26-9314-716a2846f602");
        imgHash.put("Sō (Breadtalk Family)", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/So.png?alt=media&token=fbe166eb-7b1b-441f-9c68-44c449d0e40c");        
        imgHash.put("T2", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/T2.png?alt=media&token=6721dc88-62d7-4795-a813-9863956ba548");
        imgHash.put("Table Manners", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Table_Manners.png?alt=media&token=7bb02421-2c4e-4586-9e6d-2533806ee372");
        imgHash.put("Tai Chong Kok", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tai_Chong_Kok.png?alt=media&token=cb8902c8-1903-40a4-b120-b5361490430b");
        imgHash.put("Tai Croissant", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tai_Croissant.png?alt=media&token=4acaf357-b46a-43d1-9637-54ffb9f2d110");
        imgHash.put("Tai Lei Loi Kei", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tai_Lei_Loi_Kei.png?alt=media&token=11ddfd75-98d1-4eb2-a4b7-74a5a1133013");
        imgHash.put("Taigai", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Taigai.png?alt=media&token=8404eae5-3536-481d-9ac0-178a8d27abe6");
        imgHash.put("Take-Out", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Take-Out.png?alt=media&token=9a06f7a5-fe80-411c-b374-9e4b241ff2c6");
        imgHash.put("Takezo Ramen", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Takezo_Ramen.png?alt=media&token=b1d1215f-db7a-4d32-bf52-df620acc5d62");
        imgHash.put("Talay Thai", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Talay_Thai.png?alt=media&token=d15595f1-2e95-4d34-b1de-000cde561190");
        imgHash.put("Tamago-En", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tamago-En.png?alt=media&token=4fb61e3b-0b99-41c0-9b0f-9924b91c3aea");
        imgHash.put("Tampopo Grand Sushi & Shabu Shabu", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tampopo_Grand_Sushi_%26_Shabu_Shabu.png?alt=media&token=2863bda7-1d7b-4b5f-a83f-e8a037b59d1b");
        imgHash.put("Tampopo Ramen", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tampopo_Ramen.png?alt=media&token=99712f17-f46b-452f-aff2-aabbaf6a70ef");
        imgHash.put("Tan Ngan Lo Herbal Tea", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tan_Ngan_Lo_Herbal_Tea.png?alt=media&token=65b5e925-5b3b-4c1d-b3b0-86dbf9889bd3");
        imgHash.put("Tanuki Raw", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tanuki_Raw.png?alt=media&token=8efc806d-7545-4c14-a7b8-adb77bf809de");
        imgHash.put("Tapas Club", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tapas_Club.png?alt=media&token=45a63707-8d94-457e-8434-1b2260e65ee4");
        imgHash.put("Taste Paradise", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Taste_Paradise.png?alt=media&token=75880ce2-3ede-44bf-a84a-4ed0a0930c57");
        imgHash.put("tcc - The Connoisseur Concerto", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/tcc_-_The_Connoisseur_Concerto.png?alt=media&token=1b465ae5-d768-4dcb-858f-eb57d44b552d");
        imgHash.put("Tea Valley", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tea_Valley.png?alt=media&token=3400ba71-9a9a-440b-af63-7119089123fa");
        imgHash.put("Teafolia", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Teafolia.png?alt=media&token=0c552927-0e2a-4651-b7f7-02d759ccafb6");
        imgHash.put("Teahouse by Soup Restaurant", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Teahouse_by_Soup_Restaurant.png?alt=media&token=ff90b0d7-cba8-46d2-85f4-fd99087fb076");
        imgHash.put("Tempura TENTEN", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tempura_TENTEN.png?alt=media&token=9e6fca23-97f3-4992-a5d6-b911cd770182");
        imgHash.put("Tenderfresh Classic", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tenderfresh_Classic.png?alt=media&token=44aa814f-2eb3-4e32-aebf-5f73eebe6387");
        imgHash.put("Tenderfresh Xpress", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tenderfresh_Xpress.png?alt=media&token=32c9d07b-9950-4499-9066-00e59adcca5b");
        imgHash.put("TenRen Tea", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tenderfresh_Xpress.png?alt=media&token=32c9d07b-9950-4499-9066-00e59adcca5b");
        imgHash.put("Tensho by MOF", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tensho_by_MOF.png?alt=media&token=bbeae92a-0293-452c-b168-16e1fe356338");
        imgHash.put("Teppan Bar Q", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Teppan_Bar_Q.png?alt=media&token=29392bfc-a65b-4f90-ac7f-5a85ac813684");
        imgHash.put("Teppan-Yaki", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Teppan-Yaki.png?alt=media&token=38632c3e-e05a-480c-9157-bbc261e14ff0");
        imgHash.put("Teppei Syokudo", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Teppei_Syokudo.png?alt=media&token=6c931e72-8264-46f9-903d-fa1a2e03ca8c");
        imgHash.put("Texas Chicken", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Texas_Chicken.png?alt=media&token=1217dc47-3bcf-4c5a-846a-e6edada307fa");
        imgHash.put("ThaiExpress", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/ThaiExpress.png?alt=media&token=59827ef0-1551-4607-bc69-969e39d96dfc");
        imgHash.put("ThaiExpress Signature", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/ThaiExpress_Signature.png?alt=media&token=efcdbf52-f515-4948-b49a-b5ec62144d03");
        imgHash.put("The 1872 Clipper Tea Co", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_1872_Clipper_Tea_Co.png?alt=media&token=3db38d76-351a-400a-aba5-615e9bfa5eef");
        imgHash.put("The Alley", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Alley.png?alt=media&token=d64cc267-d4fd-4a77-80ae-44d255408b33");
        imgHash.put("The Botanic", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Botanic.png?alt=media&token=192ec925-6713-4102-bec7-244feb2f49e2");
        imgHash.put("The Bread Club", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Bread_Club.png?alt=media&token=b899672e-6100-4098-b08c-15ddc5eeb970");
        imgHash.put("The Caffeine Experience", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Caffeine_Experience.png?alt=media&token=5d3ce61f-142e-47f1-a1ed-37796d00e8b4");
        imgHash.put("The Chamber", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Chamber.png?alt=media&token=3dcc24c1-56be-4f8f-bc02-c9b6b80e659f");
        imgHash.put("The Cocoa Trees", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Cocoa_Trees.png?alt=media&token=c6b837a3-de34-452e-bdd8-ff7a7c913de3");
        imgHash.put("The Coffee Academics", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Coffee_Academics.png?alt=media&token=3dd755aa-6eb8-4ebc-af44-216bed1a2e10");
        imgHash.put("The Coffee Bean & Tea Leaf", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Coffee_Bean_%26_Tea_Leaf.png?alt=media&token=e510303e-83a8-4729-bd1c-4355eb2a7528");
        imgHash.put("The Coffee Xpress", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Coffee_Xpress.png?alt=media&token=81b3a43a-fca7-464b-a346-e8206f14547d");
        imgHash.put("The Cookie Museum", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Cookie_Museum.png?alt=media&token=2054190f-ae7e-416b-822a-57f68d7e6832");
        imgHash.put("The Dark Gallery", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Dark_Gallery.png?alt=media&token=98eabdce-00b7-4aa7-beb8-8163eedc6702");
        imgHash.put("The Food Market by Food Junction", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Food_Market_by_Food_Junction.png?alt=media&token=2f395869-5fbe-4eac-9022-94bb46dfd463");
        imgHash.put("The Food Place by Food Junction", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Food_Place_by_Food_Junction.png?alt=media&token=3b3176be-ceed-4a3a-9986-9ac06e7d0ffc");
        imgHash.put("The Golden Duck", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Golden_Duck.png?alt=media&token=94367a99-fa1f-4407-b9c8-6fe182a6c36c");
        imgHash.put("The Golden Duck Co Snack Bar", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Golden_Duck.png?alt=media&token=94367a99-fa1f-4407-b9c8-6fe182a6c36c");
        imgHash.put("The Grande Whisky Collection", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Grande_Whisky_Collection.png?alt=media&token=7e480f7c-5aa9-4573-9275-a95ff701144a");
        imgHash.put("The Highlander Bar & Restaurant", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Highlander_Bar_%26_Restaurant.png?alt=media&token=83012203-cecf-44d4-8773-e73374ae6a20");
        imgHash.put("The Icing Room (Breadtalk Family)", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Highlander_Bar_%26_Restaurant.png?alt=media&token=83012203-cecf-44d4-8773-e73374ae6a20");
        imgHash.put("The Manhattan Fish Market", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Highlander_Bar_%26_Restaurant.png?alt=media&token=83012203-cecf-44d4-8773-e73374ae6a20");
        imgHash.put("The Marmalade Pantry", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Marmalade_Pantry.png?alt=media&token=761089d0-a3e3-4e0a-b8cb-425bb13dc372");
        imgHash.put("The MeatHouse by 18 Chefs", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_MeatHouse_by_18_Chefs.png?alt=media&token=ab4a339b-1f8a-430c-b525-991912c77306");
        imgHash.put("The miniBar", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_MeatHouse_by_18_Chefs.png?alt=media&token=ab4a339b-1f8a-430c-b525-991912c77306");
        imgHash.put("The Mix", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Mix.png?alt=media&token=e73ae5df-b6f7-4e1c-8e67-e0689f3c9775");
        imgHash.put("The Oaks Cellar", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Oaks_Cellar.png?alt=media&token=60df5641-3ad4-4e94-908a-7ddf27c6f3bf");
        imgHash.put("The Old Malaya Cafe", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Old_Malaya_Cafe.png?alt=media&token=257ee109-af57-4ff6-a315-451c36b3e4e9");
        imgHash.put("The Old Pontian Cafe", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Old_Pontian_Cafe.png?alt=media&token=e875ab04-a7f0-419f-9c28-159874fb5a9e");
        imgHash.put("The Open Grill", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Open_Grill.png?alt=media&token=544d359c-f610-411e-bda9-2f2f580f8289");
        imgHash.put("The Original Boat Noodle", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Original_Boat_Noodle.png?alt=media&token=5cf77220-30c4-467a-9c2a-e0460b0ef0f7");
        imgHash.put("The Oyster Bank", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Oyster_Bank.png?alt=media&token=9ff643e4-2381-44ea-a197-34be4002fbc2");
        imgHash.put("The Pine Garden", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Oyster_Bank.png?alt=media&token=9ff643e4-2381-44ea-a197-34be4002fbc2");    
        imgHash.put("The Pump Room Microbrewery + Bistro + Club", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Pump_Room_Microbrewery.png?alt=media&token=20dfb601-fbe5-4b68-8d22-186bc4405213");
        imgHash.put("The RANCH Steakhouse By ASTONS", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_RANCH_Steakhouse_By_ASTONS.png?alt=media&token=40ca43aa-a546-4355-b57d-0a6d93e36345");
        imgHash.put("The Seafood Market Place by Song Fish", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Seafood_Market_Place_by_Song_Fish.png?alt=media&token=7e3ab957-524e-47ca-9c87-ff17b159741a");
        imgHash.put("The Ship Restaurant", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Ship_Restaurant.png?alt=media&token=a9cd15f9-91eb-4164-9ede-2d159ed7a5d7");
        imgHash.put("The Soup Spoon", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Soup_Spoon.png?alt=media&token=cc906e39-1aed-4c5c-b2c7-2163d676bcfd");
        imgHash.put("The Soup Spoon Union", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Soup_Spoon_Union.png?alt=media&token=9e16a395-e839-4a0e-b3d1-607cd8c37200");
        imgHash.put("The Stamford Brasserie", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Stamford_Brasserie.png?alt=media&token=63d3d743-4352-4fd1-839c-f9858fc1cc6b");
        imgHash.put("The Sushi Bar", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Sushi_Bar.png?alt=media&token=3ea5761f-1238-4395-b323-5f9064fd52b7");
        imgHash.put("The Sushi Bar Dining", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Sushi_Bar.png?alt=media&token=3ea5761f-1238-4395-b323-5f9064fd52b7");
        imgHash.put("The Tree Cafe", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Tree_Cafe.png?alt=media&token=4cc42ecb-3bbc-4e44-a62f-b3bfab18335b");
        imgHash.put("The Whisky Distillery", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/The_Whisky_Distillery.png?alt=media&token=f497a8f3-b225-47cc-9940-57151c264310");
        imgHash.put("TheJellyHearts", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/TheJellyHearts.png?alt=media&token=06c23fd7-998a-4c27-a0ce-8368362a9b68");
        imgHash.put("Thirsty Beer Shop", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Thirsty_Beer_Shop.png?alt=media&token=21358db0-0ca2-482f-86e8-37e8b3311499");
        imgHash.put("Thunderbird", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Thunderbird.png?alt=media&token=0508abed-d961-4100-a99e-990e34f111d5");
        imgHash.put("Tiger Street Lab", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tiger_Street_Lab.png?alt=media&token=ae509320-ce25-4b2d-bbc6-e825ffe3ec61");
        imgHash.put("Tiger Sugar", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tiger_Sugar.png?alt=media&token=967ea9ed-3501-4265-9161-040784cbb71e");
        imgHash.put("Tim Ho Wan", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tim_Ho_Wan.png?alt=media&token=d0636d71-4c4b-4645-b0b4-d2708dd53826");
        imgHash.put("Tino's Pizza Cafe", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tinos_Pizza_Cafe.png?alt=media&token=81836d74-d4f0-4569-8bfa-28108775937d");
        imgHash.put("Tiong Bahru Bakery", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tiong_Bahru_Bakery.png?alt=media&token=7fb93d9c-6968-46f6-a6c3-e74b744289df");
        imgHash.put("Tiong Bahru Jian Bo Shui Kueh", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tiong_Bahru_Jian_Bo_Shui_Kueh.png?alt=media&token=0a631e1d-f82b-44d4-8f4d-7f173c40a9ba");
        imgHash.put("Tip Top", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tip_Top.png?alt=media&token=198c59fd-3de4-4ec4-8497-80742f8a6dfc");
        imgHash.put("Tip Top Curry Puff", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tip_Top_Curry_Puff.png?alt=media&token=5f504954-9187-4ccc-a449-6dddc6911872");
        imgHash.put("Toast Box", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Toast_Box.png?alt=media&token=55357427-0328-4400-ab67-1685854fe430");
        imgHash.put("Toast Box (Breadtalk Family)", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Toast_Box.png?alt=media&token=55357427-0328-4400-ab67-1685854fe430");
        imgHash.put("TOKUTOKUYA", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/TOKUTOKUYA.png?alt=media&token=d4f810fd-c52b-4435-bfac-e3a1a2e44bcf");
        imgHash.put("Tokyo Eater (Shokutsu Ten)", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tokyo-Eater.png?alt=media&token=a0c144bb-7f85-41cf-9fa9-c02118c34e9a");
        imgHash.put("Tokyo Milk Cheese Factory", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tokyo_Milk_Cheese_Factory.png?alt=media&token=c36e6a3d-3247-4399-80d0-f9624a8afacb");
        imgHash.put("Tokyo Milk Cheese Factory & Cow Cow Kitchen", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tokyo_Milk_Cheese_Factory.png?alt=media&token=c36e6a3d-3247-4399-80d0-f9624a8afacb");
        imgHash.put("Tokyo Sundubu", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tokyo_Sundubu.png?alt=media&token=2697257c-b993-495d-a504-4c37b575f9fb");
        imgHash.put("Tomo Izakaya", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tomo_Izakaya.png?alt=media&token=26d607c1-9d39-47aa-8c77-b75813edcec2");
        imgHash.put("TongKang Riverboat Dining", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/TongKang_Riverboat_Dining.png?alt=media&token=b9629461-4a33-4478-aabe-f589f44dce69");
        imgHash.put("Tongue Tip Lan Zhou Beef Noodles", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tongue_Tip_Lan_Zhou_Beef_Noodles.png?alt=media&token=838c982d-b891-42eb-b339-abd8f452e5c5");
        imgHash.put("Tonito", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tonito.png?alt=media&token=b4408688-1dca-495a-ba3b-0fe959220534");
        imgHash.put("Tonkatsu Bistro by Ma Maison", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tonkatsu_By_Ma_Maison.png?alt=media&token=5fb5ffa1-4e5d-44c6-96cc-69d85cc258bb");
        imgHash.put("Tonkatsu By Ma Maison", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tonkatsu_By_Ma_Maison.png?alt=media&token=5fb5ffa1-4e5d-44c6-96cc-69d85cc258bb");
        imgHash.put("Tonkichi", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tonkichi.png?alt=media&token=125abd85-3485-4a57-a69a-d2e6c94740c0");
        imgHash.put("Tonkotsu Kazan", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tonkotsu_Kazan.png?alt=media&token=d1e10b6f-7086-48d3-8d96-031590d6e3a3");
        imgHash.put("Tontei Pork Restaurant (Shokutsu Ten)", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tontei_Pork_Restaurant.png?alt=media&token=dda2bbf7-58ea-4009-a222-420f6f6931cc");
        imgHash.put("Took Lae Dee", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Took_Lae_Dee.png?alt=media&token=87ee38e3-2817-41dd-a5c7-51fb2d2499e1");
        imgHash.put("Tori-Q", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tori-Q.png?alt=media&token=45d1e735-c316-4f73-a524-c9e14950f91a");
        imgHash.put("Torigo!", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Torigo!.png?alt=media&token=cfdf833a-87ca-46bc-abe3-f6726d0c4db6");
        imgHash.put("Toss & Turn", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Toss_%26_Turn.png?alt=media&token=d237c1ca-333b-4741-b93a-27ca4a4f9a7c");
        imgHash.put("Treasures Noodle & Congee House", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Treasures_Noodle_%26_Congee_House.png?alt=media&token=c8cac500-b2ef-4507-b77a-f981ee0d864f");
        imgHash.put("Treasures Yi Dian Xin", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Treasures_Yi_Dian_Xin.png?alt=media&token=f662c031-5aca-4a7f-b407-8fb51fad960f");
        imgHash.put("Trufflelicious by The Travelling COW", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Trufflelicious_by_The_Travelling_COW.png?alt=media&token=814337ba-7c53-4819-929d-f791eb037ae2");
        imgHash.put("TSUI WAH 翠華", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/TSUI_WAH.png?alt=media&token=df356ae0-df30-4088-b46e-aa755b643e28");
        imgHash.put("TSUJIRI", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/TSUJIRI.png?alt=media&token=b8f891a8-d6b5-49b1-87ec-d4d2feafd4d5");
        imgHash.put("Tsukada Nojo", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tsukada_Nojo.png?alt=media&token=2febff81-088e-434f-9aef-87aa7004f429");
        imgHash.put("Tsuta Japanese Soba Noodles", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tsuta_Japanese_Soba_Noodles.png?alt=media&token=805c5767-9559-468d-86d8-d5cd2838875b");
        imgHash.put("Tuk Tuk Cha", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tuk_Tuk_Cha.png?alt=media&token=33cdfdf1-e711-44a9-b14d-0e0fd872f89e");
        imgHash.put("Tung Lok Signatures", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tung_Lok_Signatures.png?alt=media&token=a68bdb96-bea2-45fa-b804-5e8f82adfb0c");
        imgHash.put("Turkish Kebab House", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Turkish_Kebab_House.png?alt=media&token=694e7569-29f1-436d-94db-8d49ac9d97d3");
        imgHash.put("Twelve Cupcakes", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Twelve_Cupcakes.png?alt=media&token=e2996a40-4d58-4170-9d34-366201bb013a");
        imgHash.put("TWG Tea Salon & Boutique", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/TWG_Tea_Salon_%26_Boutique.png?alt=media&token=2fd6addf-814a-44d7-b2aa-41e4358c9fb3");
        imgHash.put("Two Hana", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Two_Hana.png?alt=media&token=854bcf7f-cffc-4f30-85b1-f6c9b5bb9714");
        imgHash.put("Two Wings Express", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Two_Wings_Express.png?alt=media&token=493b8d63-9961-43e3-914b-457209025b7b");
        imgHash.put("Typhoon Cafe", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Typhoon_Cafe.png?alt=media&token=f3ed7563-bf32-42ea-8cea-da08f2b130d1");
        imgHash.put("Tysan", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Tysan.png?alt=media&token=b35d4165-da95-4ba2-952c-e7a9da1cd75d");
        imgHash.put("umisushi", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/umisushi.png?alt=media&token=9b533de8-f1ef-4736-801a-c24fed261d58");
        imgHash.put("umisushi Teishoku", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/umisushi_Teishoku.png?alt=media&token=6685095b-919c-4a73-8f46-879d269ad1bf");
        imgHash.put("Uncle Leong Seafood", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Uncle_Leong_Seafood.png?alt=media&token=face4ad9-940a-44e4-bf81-c612b1ae741e");
        imgHash.put("Uncle Leong Signatures", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Uncle_Leong_Signatures.png?alt=media&token=74347023-12cc-4474-ae7e-e77cf5eef136");
        imgHash.put("UNICE", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/UNICE.png?alt=media&token=d94b0c56-50f0-4fac-bfd6-28d057ba00fc");
        imgHash.put("Upin Hot Pot 優品火鍋", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Upin_Hot_Pot.png?alt=media&token=e069e5cb-ef14-43e8-8655-8624c7162375");
        imgHash.put("UPOT", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/UPOT.png?alt=media&token=d506d2df-b143-4439-abf2-66530c9b2efc");
        imgHash.put("Verve Pizza Bar", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Verve_Pizza_Bar.png?alt=media&token=8ec595cb-b493-47dc-8d38-5568b36c9082");
        imgHash.put("Violet Oon Satay Bar & Grill", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Violet_Oon_Satay_Bar_%26_Grill.png?alt=media&token=6d9959b8-2c77-429a-b672-43e91f9561bc");
        imgHash.put("Violet Oon Singapore", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Violet_Oon_Singapore.png?alt=media&token=dea1d1d6-4414-44d2-90e5-6718bcc3a49b");
        imgHash.put("Vom Fass", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Vom_Fass.png?alt=media&token=49c1f89a-3510-478b-baa6-7b91419176d3");
        imgHash.put("Wan Chai Hong Kong Tea Room", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Vom_Fass.png?alt=media&token=49c1f89a-3510-478b-baa6-7b91419176d3");
        imgHash.put("Wan Tan Kia", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Wan_Tan_Kia.png?alt=media&token=2e6ee4da-687f-4820-a682-385c5eed7b25");
        imgHash.put("Wang Cafe", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Wang_Cafe.png?alt=media&token=8d3e6481-422e-43ae-b3d2-6e7c77e3b5f7");
        imgHash.put("WAREHOUSE", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/WAREHOUSE.png?alt=media&token=23954a48-b882-40d2-8ad4-5c22eb77372e");
        imgHash.put("WATAMI Japanese Casual Restaurant", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/WATAMI_Japanese_Casual_Restaurant.png?alt=media&token=67ce3781-0fa2-4894-88b3-2286cb7251b4");
        imgHash.put("Wee Nam Kee Chicken Rice", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Wee_Nam_Kee_Chicken_Rice.png?alt=media&token=d24cdc86-f4b1-4fff-90b1-d6e6f18d31b9");
        imgHash.put("West Co'z Café", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/West_Coz_Cafe.png?alt=media&token=23574926-0f2f-4661-bb86-7ecaa70e2c70");
        imgHash.put("WHEAT", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/WHEAT.png?alt=media&token=d86ecffd-0172-4ca8-b9c7-6a268b38d502");
        imgHash.put("White Restaurant", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/White_Restaurant.png?alt=media&token=83d7c35b-69e5-48cb-a59d-971996580d16");
        imgHash.put("Wine Connection", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Wine_Connection.png?alt=media&token=4b002355-37a8-4765-a498-a600dca2ed6f");
        imgHash.put("Wine Connection Cheese Bar", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Wine_Connection_Cheese_Bar.png?alt=media&token=9f5cd794-8a96-4a6a-9335-1c8b74b1f6e0");
        imgHash.put("Wine Connection Tapas Bar & Bistro", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Wine_Connection_Tapas_Bar_%26_Bistro.png?alt=media&token=47e55356-ea95-412a-80c6-ccb1fa9e5cea");
        imgHash.put("WING ZONE", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/WING_ZONE.png?alt=media&token=5e1135ec-4fbd-4a82-ab2a-e9e6729e2329");
        imgHash.put("Wings Bar", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Wings_Bar.png?alt=media&token=2352062a-f55f-445b-8493-0e29f2c0fc2a");
        imgHash.put("WINGSTOP", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/WINGSTOP.png?alt=media&token=ead250e0-5523-4c4d-b741-d93d5c3051b6");
        imgHash.put("Wok Hey", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Wok_Hey.png?alt=media&token=647d0c70-4b12-4349-8247-8f31080efde9");
        imgHash.put("Wok Master", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Wok_Master.png?alt=media&token=1b98c83c-6d57-471f-88fa-397f8e95eef3");
        imgHash.put("WOLF Burgers", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/WOLF_Burgers.png?alt=media&token=21c7fb30-aafc-4213-8623-d103623ea6f9");
        imgHash.put("Wong Kee Wanton Noodles", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Wong_Kee_Wanton_Noodles.png?alt=media&token=a4ac622e-bb05-4041-bd7d-8aed3cad4555");
        imgHash.put("Workspace espresso Bar", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Workspace_espresso_Bar.png?alt=media&token=37734b72-7db9-4599-b15d-f9ec26dcb30a");
        imgHash.put("Wow Tako", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Wow_Tako.png?alt=media&token=39b75f23-74ca-4ab6-9398-4b1695416fa9");
        imgHash.put("XI DE LI (西得利)", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/XI_DE_LI.png?alt=media&token=f23ab03d-e043-451b-8568-44ba55931d79");
        imgHash.put("Xiao Bin Lou 小滨楼", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Xiao_Bin_Lou.png?alt=media&token=ee387fbd-44c6-4f7c-b269-b274c7eafbc1");
        imgHash.put("Xiao Chen Gu Shi", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Xiao_Chen_Gu_Shi.png?alt=media&token=60d2961c-e1c4-49f5-82bb-2b8f5e0610d1");
        imgHash.put("Xiao Man Niu", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Xiao_Man_Niu.png?alt=media&token=59f07463-2651-4a18-b100-23e18fcfc688");
        imgHash.put("Xiao Yang Guo Kui", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Xiao_Yang_Guo_Kui.png?alt=media&token=7fc56be5-3e19-4ed9-8b88-2b07c2835bc7");
        imgHash.put("XiaoLongKan Hotpot", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/XiaoLongKan_Hotpot.png?alt=media&token=02120957-951e-49ca-a475-137f93be50a0");
        imgHash.put("Ximenjie Tastes of Taiwan", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Ximenjie_Tastes_of_Taiwan.png?alt=media&token=08cdae7d-ca15-4865-892b-c1aa461e448b");
        imgHash.put("Xin Wang Hong Kong Café", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Xin_Wang.png?alt=media&token=a2230074-cc1a-4130-9065-c9b1b5469354");
        imgHash.put("XING FU TANG 幸福堂", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/XING_FU_TANG.png?alt=media&token=73da8d8b-decc-4d5b-87fe-f700063d8094");
        imgHash.put("XYCD", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/XYCD.png?alt=media&token=28b66c8f-8d0e-4bff-bdbf-99567ff2d476");
        imgHash.put("Ya Hua Bak Kut Teh", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Ya_Hua_Bak_Kut_Teh.png?alt=media&token=2a02d190-1ccd-478d-9737-c168132b51b4");
        imgHash.put("Ya Kun Family Cafe", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Ya_Kun_Kaya_Toast.png?alt=media&token=92212267-9c4b-4350-ab1b-99ea6f0f2f8e");
        imgHash.put("Ya Kun Kaya Toast", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Ya_Kun_Kaya_Toast.png?alt=media&token=92212267-9c4b-4350-ab1b-99ea6f0f2f8e");
        imgHash.put("Yaki Yaki Bo (Shokutsu Ten)", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Yaki_Yaki_Bo_(Shokutsu_Ten).png?alt=media&token=d2643658-9f6b-415c-99c7-657f5f3ed08d");
        imgHash.put("Yakiniku Yazawa", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Yakiniku_Yazawa.png?alt=media&token=22e2f2be-ec82-49ff-955f-769db91e5c5e");
        imgHash.put("Yamazaki Boulangerie Chaude", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Yamazaki.png?alt=media&token=63ae306d-60e7-4931-aba1-8b3f02e876e6");
        imgHash.put("Yami Yogurt", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Yami_Yogurt.png?alt=media&token=3020d9fd-e1a2-42ca-9d3a-d4176f5a1ee9");
        imgHash.put("Yamrice Yoghurt", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Yamrice_Yoghurt.png?alt=media&token=2f573bf4-ec4a-4771-9bf3-62db97a1beff");
        imgHash.put("Yan Ji Seafood Soup", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Yan_Ji_Seafood_Soup.png?alt=media&token=8258ba8f-5190-4f27-8cef-068a1fae2af6");
        imgHash.put("YAYOI", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/YAYOI.png?alt=media&token=6683762b-32c4-4979-9dba-feccf2dd7a20");
        imgHash.put("Yi Fang", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Yi_Fang.png?alt=media&token=e35e1d9e-f999-44b1-9022-07229d973688");
        imgHash.put("Yi Qian Ling Yi Ye", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Yi_Qian_Ling_Yi_Ye.png?alt=media&token=0c38f149-11b4-464d-bcd7-e345b1b74fb1");
        imgHash.put("YOKU MOKU", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/YOKU_MOKU.png?alt=media&token=cc460b48-e192-4e48-b109-9c4a45357b1b");
        imgHash.put("Yoku Moku | Four Leaves", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/YOKU_MOKU.png?alt=media&token=cc460b48-e192-4e48-b109-9c4a45357b1b");
        imgHash.put("Yolé", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Yole.png?alt=media&token=ef5b4c78-66fc-42d3-9142-2dd7f9d4edc5");
        imgHash.put("YOLO", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/YOLO.png?alt=media&token=7501d4b9-0040-40ae-8c27-bad164924291");
        imgHash.put("Yomenya Goemon", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Yomenya_Goemon.png?alt=media&token=d76e7d0b-56da-408f-9013-f1391aee3c8c");
        imgHash.put("Yoogane", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Yoogane.png?alt=media&token=c75aa909-0303-4e8e-a3d9-cbdfd9287496");
        imgHash.put("YOSHINOYA", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/YOSHINOYA.png?alt=media&token=1a5a1eec-95cd-45ed-ad7b-86ca8a57ecf1");
        imgHash.put("Yu Kee Specialities", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Yu_Kee_Specialities.png?alt=media&token=038b2dca-d2e5-4704-82e4-7660fcf2f157");
        imgHash.put("Yu's Kitchen 巴渝粮宅", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Yus_Kitchen.png?alt=media&token=75b6b762-13fb-4b36-a962-b140f106cd88");
        imgHash.put("Yuan Cha", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Yuan_Cha.png?alt=media&token=4d7dddd6-2501-4021-9664-29b127328f7f");
        imgHash.put("YuBa Hut", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/YuBa_Hut.png?alt=media&token=16b90d83-f512-47e1-8b97-a66124a0e2e7");
        imgHash.put("Yun Nans 云海肴", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Yun_Nans.png?alt=media&token=67ab8657-14c7-4a69-8716-d1c39c755812");
        imgHash.put("Zaffron Kitchen", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Zaffron_Kitchen.png?alt=media&token=7d7995d7-faf9-4a31-afdd-0466f5c05278");
        imgHash.put("Zouk", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/Zouk.png?alt=media&token=df485f94-75be-470b-9299-d0238fbc1fca");
        imgHash.put("ZTP Herbal Tea", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/ZTP_Herbal_Tea.png?alt=media&token=8cd21551-83a7-42c5-9148-27ab429d5d1a");
        imgHash.put("牛一嘴 Núodle", "https://firebasestorage.googleapis.com/v0/b/paywhere2019.appspot.com/o/nuodle.png?alt=media&token=5bec26de-f96b-4462-820f-a57b951e31b9");    
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
