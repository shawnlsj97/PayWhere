Milestone 2: Prototype
======================

**Group:** Team Marshmallow (1775)

**Members:** Dominique Ng and Shawn Lee

**Advisor:** Kyle Timothy Chu

**Proposed Level of Achievement:** Gemini

<img src="./READMEmedia/media/image7.png" width="602"
height="338.66666667" />

# 1    Reflection on Milestone 1 Feedback

Login features are necessary when we want to provide a highly-customised
service to each individual user. However, we decided not to enable any
login features on PayWhere because its fundamental purpose is simply to
display mobile payment options among dining outlets in shopping malls.
For refinement, users can use our filter option to see their preferred
mobile payment option. Since PayWhere does not have many user-specific
functions (eg. bookmarking certain shopping malls or leaving reviews),
we chose not to add friction to the use of our app by necessitating
membership. Moreover, as [one in four mobile apps are opened only
once](https://www.statista.com/statistics/271628/percentage-of-apps-used-once-in-the-us/),
we feel that it is important to simplify the onboarding process as much
as possible.

As pointed out in the feedback, including pictures, ratings and price
ranges are useful but out of the scope of our project. This would
require implementing Google’s Places API and possibly another set of
webscrapers, and we might embark on this for Milestone 3 instead.

# 2 Core Features

## 2.1  Splash Screen

When users open our app, they will be greeted with a simple splash
screen displaying our app’s logo. This is programmed to last as long as
it takes to load the main home page.

<img src="./READMEmedia/media/image4.png" width="120"
height="212">

## 2.2  User On-boarding


When users open PayWhere for the first time after installation, we will
provide them with an introduction and how to use our app.

Our onboarding has 4 steps that describe the purpose of PayWhere in a
clear and concise manner. We make use of relevant icons to convey the
aim of every step. At the last step, users will click ‘Get Started’ and
be directed to the search activity.

<img src="./READMEmedia/media/image6.png" width="120"
height="212"><img src="./READMEmedia/media/image10.png" width="120"
height="212"><img src="./READMEmedia/media/image12.png" width="120"
height="212"><img src="./READMEmedia/media/image1.png" width="120"
height="212">

After completing the user onboarding, on subsequent app launches, users
will be directed to the home page immediately after viewing the splash
screen.

## 2.3  Search Function

On the home page, users will be prompted to enter their mall of
interest. Upon entering the first letter of their search term, users
will be greeted with a list of search suggestions, which is continuously
filtered as they continue to enter their text. Upon tapping the
suggestion that matches their mall of interest, search will immediately
commence and the results will populate the page.

<img src="./READMEmedia/media/image16.png" width="120"
height="212"><img src="./READMEmedia/media/image5.png" width="120"
height="212"><img src="./READMEmedia/media/image8.png" width="120"
height="212">

Users can also type the name of the mall themselves and hit the search
button. Upon inputting a valid query, users will be directed to a page
displaying all the food and beverage outlets in the mall they have
selected. We have included the outlet name, unit number and mobile
payments accepted as part of the outlet details, which we feel are the
most essential information required. From this results page, users can
also immediately search for another mall of interest without going back
to the previous search page.

If users input an invalid search term, they will instead be directed to
a page informing them to try using another search term. Users will be
allowed to search immediately using the search bar on this page without
having to go back to the previous search page.

<img src="./READMEmedia/media/image3.png" width="120"
height="212">

We have made our search function more user-friendly by implementing
search suggestions as well as case-insensitive search.

# 3 Problems Encountered

## 3.1  Webscraping

### 3.1.1   Data Categorisation by Malls

Unfortunately, dining outlets are not easily accessible on the websites
of malls. Firstly, some malls split their dining outlets into different
categories. [NEX](https://www.nex.com.sg/Directory/Category), for
example, splits it the following way the moment one clicks on the
directory:

-   Baking & Confectionery

-   Food Court

-   Restaurant, Cafe & Fast Food

-   Snacks & Specialties

<img src="./READMEmedia/media/image31.png" width="602"
height="289.33333333">

This is compared to other malls that group their dining outlets by a
broad ‘Food & Beverage’ category first, before allowing users to filter
by the dining type.

<img src="./READMEmedia/media/image26.png" width="602"
height="273.33333333">

### 3.1.2   Difficulty in Retrieving Unit Numbers

Another slight problem encountered would be the difficulty in retrieving
dining directory information from certain websites. Most CapitaLand
malls’ websites (eg. [Tampines
Mall](https://www.capitaland.com/sg/malls/tampinesmall/en/stores.html?category=foodandbeverage),
[Raffles
City](https://www.capitaland.com/sg/malls/rafflescity/en/stores.html?category=foodandbeverage))
have their dining outlets listed in a way such that the user has to
click on the individual outlet to get the unit number.

<img src="./READMEmedia/media/image23.png" width="269.33333333"
height="180"><img src="./READMEmedia/media/image30.png" width="269.33333333"
height="180">

Other malls have the unit number listed alongside the store name which
makes for easier for us to get the information we need. An example of
the [Ngee Ann City](http://www.ngeeanncity.com.sg/shopdirectory/)
website is shown below.

<img src="./READMEmedia/media/image25.png" width="269.33333333"
height="180">

### 3.1.3   Hidden Data on Page

Another issue that we encountered would be the issue of hidden elements
on certain interactive websites. In the example from Tampines Mall’s
website below, only 16 list items can be found in the HTML code
initially. We are required to click on the “Load More” button in order
to populate the HTML code with more items.

<img src="./READMEmedia/media/image28.png" width="602"
height="284">

As seen, the number of list items have increased in the HTML code after
clicking “Load More”. Given that our webscrapers extract data by
searching HTML tags, we had to find a way to click on multiple “Load
More” buttons until all list items are displayed.

<img src="./READMEmedia/media/image27.png" width="602"
height="249.33333333">

The issue here was that the “Load More” button was constantly hidden
behind a spinner icon. We eventually overcame this by making our code
sleep for a period of time to wait for the page to load before
attempting to click the button again in our loop.

```
time.sleep(5)
see_more = browser.find_element_by_class_name('cta-see-more')
browser.execute_script("arguments[0].click();", see_more)
```

## 3.2  Database

### 3.2.1   Duplication and Confusion of Names

We expected the data collection to be almost fully-automated as we did
not foresee the discrepancies in naming dining outlets across different
malls. While looking through the list of names that we have gathered
from the mall websites, we noticed a few exact duplicates (eg. Mos
Burger vs MOS BURGER). Such duplicates were easily resolved by running a
programme to compare and remove replicated names. However, there were
other kinds of duplicates like:

-   *LiHo* @ Tampines Mall vs *liho tea 里喝* @ Orchard Gateway

-   *Old Street Bah Kut Teh* @ Nex vs *Old Street Bak Kut Teh* @ Tampines Mall

-   *Royce* @ Tampines Mall vs *Royce’* @ NEX

These ambiguous duplicates cannot be resolved by code and required us to
manually look through the list of names to resolve these duplicates. We
had to find out whether the naming differences were due to them being
different outlets altogether or just different naming conventions across
the shopping malls.

### 3.2.2 JSON Format Restrictions

A minor issue would be the restriction of the .JSON format. According to
the [Realtime Database
guide](https://firebase.google.com/docs/database/android/structure-data)
provided by Firebase,
> “If you create your own keys, they must be UTF-8
> encoded, can be a maximum of 768 bytes, and cannot contain ., \$, \#,
> \[, \], /, or ASCII control characters 0-31 or 127. You cannot use ASCII
> control characters in the values themselves, either.”

Since the format we chose made the dining outlet the key name, we had to
make changes to some names listed as ‘*EAT.*’ and ‘*OLD STREET BAH KUT
TEH. YOU TIAO. SOYA MILK.*’ in NEX mall. Hence, the integrity of some
names cannot be preserved when uploading our data.

### 3.2.3 Offline vs. Online Database

We opted for an online database as opposed to an offline database due to
the ever-changing nature of our data. Between malls and the dining
outlets, there may be new outlets opening in the mall, or outlets
closing. Additionally, between dining outlets and mobile payment
providers, there may be dining outlets joining or leaving their
partnership. The need for constant updates for this context (as opposed
to a dictionary app for example that requires less frequent updates)
thus led us to choose an online database instead as we can alter data
without needing users to update their app to receive these updates.

## 3.3 Android App

### 3.3.1 Steep Learning Curve

Although we are proficient in Java prior to embarking on this project,
the learning curve for developing an Android app has been steep. Despite
the numerous tutorials available online, we found that most tutorials
were either too basic or too complicated.

For example, many tutorials focused on teaching widgets individually,
then proceeded to touch on one or two functions associated with it. On
the other hand, some tutorials were too advanced as the terms used were
extremely technical, especially when adapters were involved.

Thankfully, as we fiddled around in Android Studio over time, we
discovered things on our own and the practice helped us to become
comfortable with the workflow. This also enabled us to source for better
tutorials online, with aided our learning greatly.

Once the initial steep learning curve was overcome, our pace of learning
picked up sufficiently.

### 3.3.2 Optimizing App for Different Screen Sizes

Initially, we programmed elements to work only on the emulator device we
were using. Our approach was: As long as it looked fine on the emulator,
we are doing things right. Unfortunately, when we tested the app on our
actual phones, we found that many elements were not where we wanted them
to be.

We eventually had to re-adjust all of our elements individually. From
here on, we were much more meticulous when working with our activity
layouts, and made sure to be precise with our measurements. For example,
we standardised a padding of 8dp around all elements.

Additionally, for our distances and text sizes, we used the units dp
(density-independent pixels) and sp (scale-independent pixels)
respectively. This allows the appearance of our app to adjust to
different screen densities.

# 4 Planning for Milestone 3: Extensions

## 4.1 Inclusion of More Malls

It was initially difficult for us to scrape data from mall websites as
we did not expect the format of their directories to translate to more
hassle in using Selenium. As we now have a better idea of how to scrape
data from CapitaLand malls’ websites, it will be much easier for us to
include more malls by Milestone 3 since CapitaLand has 18 malls across
Singapore. Should time permit, we hope to also scrape from Frasers and
AsiaMall malls.

Since our current pool of malls is small, it is not easy to see how
PayWhere can help people decide on where to eat. The inclusion of more
malls and thus more dining outlets can give users a more wholesome image
on what PayWhere intend to provide.

## 4.2 Inclusion of More Payment Options

Currently, we only have Singtel Dash included. We hope to include more
widely used payment options like GrabPay and PayLah! by Milestone 3
which is an achievable goal given that their merchants are listed on
their website.

It could be a challenge for other payment options like FavePay that
neither publicly list their merchants nor have responded to our email
requests for their list of merchants.

## 4.3 Search by Restaurant Name

We also intend to allow users to search by restaurant name in the event
users already know what they would like to eat but simply would just
want to find out the mobile payment options available at the restaurant.

## 4.4 Filter Results by Payment Options

Users will be able to select their preferred mobile payment options in
order to filter the list of restaurants. This would enable users to
search for options they want faster instead of having to scroll through
the huge list of F&B outlets manually.

## 4.5 User Experience

Finally, we also hope to provide a smoother user experience through the
use of transition animations between the pages of our app. We are also
looking at incorporating outlet pictures as part of our store data if
time permits.

# 5 Project Workflow Process

## 5.1 Gathering the Data

We scraped [Dash merchants](https://www.dash.com.sg/where-to-dash/)
listed on their website using Selenium, followed by a simple Java
programme to remove duplicate names (for stores with multiple outlets).
For dining outlets that support Dash payment, instead of being empty,
their ‘payment’ value will be “Dash”.

We have chosen to focus on the following malls:

-   Tampines Mall

-   Ngee Ann City

-   Orchard Gateway

-   NEX

We use Selenium to scrape the name and unit number of dining outlets
from mall websites. This is obtained in .csv format. After that, we use
Java to convert the data into a .json file. Currently, our Java
programme takes in the following input:

```
number of Dash merchants (eg. x)
Dash merchant 1
Dash merchant 2
.
.
.
Dash merchant x
number of malls (eg. y)
Mall 1
number of dining outlets in Mall 1 (eg. z)
Outlet 1, Unit 1
Outlet 2, Unit 2
.
.
.
Outlet z, Unit z
Mall 2
.
.
.
Mall y
```

and produces the following output:

```
{
    “Mall 1” : {
        “Dining 1” : {
            “name” : “Dining 1”,
            “address” : “Unit 1”,
            “payment” : “”

        “Dining 2” : {
            “name” : “Dining 2”,
            “address” : “Unit 2”,
            “payment” : “Dash”

    },
    “Mall 2” : {
        “Dining 1” : {
            “name” : “Dining 1”,
            “address” : “Unit 1”,
            “payment”: “Dash”


}
```

After which, we import the .json file into Firebase’s Realtime Database.

# Milestone 1: Ideation

# 1 Motivation

As Singapore transitions into a cashless society, besides the usual
mobile payment options that we are familiar with such as PayLah and
GrabPay, there are also other options such as FavePay and SingtelDash.

With each mobile payment option having their **own set of merchants**,
it is impossible for people to remember whether a particular store
accepts their preferred mobile payment option. Currently, people can
visit the websites of the mobile payment platforms **individually**, but
this is **inefficient** as we have to visit several websites to find out
which payment options a particular store accepts. Most people end up
enquiring about the available options only when they are making payment
at the counter. As a result of this **uncertainty**, people still end up
carrying cash around as a backup.

This led us to ponder: Are we truly on our way to a cashless society if
we still have to bring out cash in case the place we are visiting does
not accept our preferred cashless payment platform?

# 2 Aim

We aspire to help mobile payment users to find suitable dining outlets
in shopping centres by displaying those that accept their preferred
mobile payment option(s) through an Android application.

# 3 User Stories

-   As a consumer who prefers to make transactions through a specific mobile payment option (for convenience or loyalty points eg. GrabRewards), I want to be clear if my preferred option is accepted in the place I am going to eat

-   As a consumer who is clueless on where to eat and is looking to make a transaction with mobile payment(s), I want to know the options I have

-   As an administrator who wants to ensure that users have sufficient information about food outlets, I want to provide a platform for users to provide feedback/submit queries and be able to respond to them personally

# 4 Scope of Project and Development Plan

The **Android application** provides an interface for mobile payment
users to find out which dining outlets accept their preferred mobile
payment platforms.


***Features to be completed by the middle of June:***

-   Allow users to select their mall of interest from all malls in Singapore

-   Incorporate data from SingtelDash (one platform first to achieve minimum viable product)

-   Allow users to **filter by** mobile payment platforms

-   For each dining outlet, we will display:

    -   Name, address, pictures, rating and price

-   Allow users to **sort by** alphabetical order, rating and price


***Features to be completed by middle of July:***

-   Incorporate data from PayLah! and GrabPay as well

-   Refinement to create a smoother user interface

    -   Material design by Google

    -   Animations

# 5 How are we different from similar platforms?

-   Burpple

    -   Our app will be less cluttered than Burpple as Burpple offers reviews on the restaurants as well as their subscription plan, Burpple Beyond. We will simply display the necessary information of the dining outlet and include the mobile payment accepted there as well.

-   eatigo

    -   Similar to Burpple, eatigo has many features and allows users to get discounts at specified times. It also allows users make reservations. However, it does not specify whether mobile payments are accepted.

# 6 Program Flow

<img src="./READMEmedia/media/image11.png" width="602"
height="338.66666667">

> Note: for stores that do not accept mobile payment, they will still be
> displayed in our app but we indicate that they do not do so in order to
> reduce ambiguity.

# 7 Technologies Used

-   Retrieval of data

    -   We intend to use **Selenium** Webdriver written in **Python** to scrape the web pages of GrabPay, DBS PayLah and SingtelDash to generate a list of dining merchants. We will scrape the name and address of these dining outlets.
    -   As for photos, price and ratings, we intend to use **Google places API** to obtain these information.

-   Android App

    -   The actual app itself will be 100% written in native Java code.

-   Backend (Database)

    -   We intend to use SQLite for storage of data of food outlets and their respective payment options.

# 8 Wireframing and Prototypes

## 8.1  Storyboarding

<img src="./READMEmedia/media/image22.jpg" width="602"
height="434.66666667">

## 8.2  Paper Sketches

<img src="./READMEmedia/media/image29.jpg" width="290.88545932"
height="406.50005249">
<img src="./READMEmedia/media/image20.jpg" width="290.88545932"
height="406.50005249">

<img src="./READMEmedia/media/image21.jpg" width="290.88545932"
height="406.50005249">
<img src="./READMEmedia/media/image19.jpg" width="290.88545932"
height="406.50005249">

## 8.3  Prototypes on Adobe XD

<img src="./READMEmedia/media/image2.png" width="186.96734908"
height="250.50005249"><img src="./READMEmedia/media/image33.png" width="186.96734908"
height="250.50005249"><img src="./READMEmedia/media/image36.png" width="186.96734908"
height="250.50005249">

<img src="./READMEmedia/media/image38.png" width="186.96734908"
height="250.50005249"><img src="./READMEmedia/media/image40.png" width="186.96734908"
height="250.50005249"><img src="./READMEmedia/media/image34.png" width="186.96734908"
height="250.50005249">

<img src="./READMEmedia/media/image39.png" width="186.96734908"
height="250.50005249"><img src="./READMEmedia/media/image32.png" width="186.96734908"
height="250.50005249">

<img src="./READMEmedia/media/image35.png" width="186.96734908"
height="250.50005249"><img src="./READMEmedia/media/image37.png" width="186.96734908"
height="250.50005249"><img src="./READMEmedia/media/image13.png" width="186.96734908"
height="250.50005249">

<img src="./READMEmedia/media/image14.png" width="186.96734908"
height="250.50005249"><img src="./READMEmedia/media/image9.png" width="186.96734908"
height="250.50005249">

<img src="./READMEmedia/media/image17.png" width="186.96734908"
height="250.50005249"><img src="./READMEmedia/media/image15.png" width="186.96734908"
height="250.50005249">

<img src="./READMEmedia/media/image24.png" width="186.96734908"
height="250.50005249"><img src="./READMEmedia/media/image18.png" width="186.96734908"
height="250.50005249">
