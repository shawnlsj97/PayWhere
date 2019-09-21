# Project Portfolio
## Project: PayWhere
PayWhere is an Android application that helps mobile payment users to find suitable dining outlets in shopping centres by displaying those that accept their preferred mobile payment platforms.

PayWhere contains all the information you need to dine and make payment easily, so you don't have to trawl through multiple websites. We have included the F&B outlet name, unit number and mobile payment platforms accepted in an easy-to-use and elegant interface.

This project is the result of a summer-long Independent Software Development module, [CP2106](https://orbital.comp.nus.edu.sg/), in NUS. The backend is written in Java, with web scraping done in python, while the frontend is written in xml.

We were awarded *Apollo 11*, which is the highest level of achievement in this module for displaying strong evidence of project management, user testing and or source code control.

Source code can be found [here](https://github.com/shawnlsj97/PayWhere).

Project showcase video can be found [here](https://www.youtube.com/watch?v=Q_dLFeYTJmc).

## Program Flow
<img src="media/program_flow.png" width="700" height="393" />

## Technologies Used
<img src="media/tech_stack.png" width="700" height="393" />

## Features Added
### 1. User Onboarding
When users open PayWhere for the first time after installation, we will provide them with an introduction and how to use our app. Our user onboarding has 3 steps that describe the purpose of PayWhere in a clear and concise manner, with relevant icons to convey the aim of every step. At the last step, users will click ‘Get Started’ and be directed to the home page of PayWhere. 

<img src="media/onboarding1.png" width="130" height="232" /> <img src="media/onboarding2.png" width="130" height="232" /> <img src="media/onboarding3.png" width="130" height="232" /> <img src="media/onboarding4.png" width="130" height="232" />

### 2. Search Suggestions & Case Insensitive Search
On the home page, users will be prompted to enter their mall of interest. Upon entering the first letter of their search term, users will be greeted with a list of search suggestions, which is continuously filtered as they continue to enter their text. Upon tapping the suggestion that matches their mall of interest, search will immediately commence and the results will populate the page.

We have made our search function more user-friendly by implementing *case-insensitive search* as well.

<img src="media/searchsuggestions.png" width="130" height="232" /> <img src="media/caseinsensitive.png" width="130" height="232" />

### 3. Elegant Display of Outlet Information
Upon inputting a valid query, users will be directed to a page displaying all the food and beverage outlets in the mall they have selected. We have included the outlet name, unit number and mobile payments accepted as part of the outlet details, which we feel are the most essential information required. From this results page, users can search for another mall of interest without going back to the previous search page.

<img src="media/searchresults.png" width="130" height="232" />

### 4. Filtering by Mobile Payment Platforms
From the results page, users can choose to filter the search results by clicking on the ‘Filter’ button. Users can then choose to filter by the mobile payment option they use, and can select as many options as they want.

<img src="media/filter.png" width="130" height="232" />

Once they click the ‘Apply’ button, the search results will be immediately updated to display only the stores that match the filtering.

### 5. Adding Malls to Favourites
To add a touch of personalisation for users, we have included “Add to Favourites” functionalities in PayWhere. After searching for a certain mall, users can add the mall to their favourites list by clicking on the ‘star’ icon in the top-right hand corner of the screen. A toast message will pop up informing the user that the mall has been added to their favourites list.

<img src="media/favourites1.png" width="130" height="232" />

Subsequently, users can access their favourite malls from the home page by clicking on the star icon. From here, users can simply tap on their mall of interest and immediately access its respective page.

<img src="media/favourites2.png" width="130" height="232" /> <img src="media/favourites3.png" width="130" height="232" />

### 6. Internet Connectivity Detection
PayWhere is able to detect if users have a working internet connection. When users attempt to make a search query but do not have internet access, they will be directed to our ‘No Internet’ error page, where they will be prompted to check their internet connection.

<img src="media/nointernet.png" width="130" height="232" />

A useful feature we implemented here would be that PayWhere is able to **listen for changes in internet connectivity**. When a valid internet connection is detected, PayWhere would inform users they are back online and **automatically redirect** users to the search results page without any user input.

### 7. Day / Night Mode
To add more user personalisation, we have also implemented “Night Mode” for PayWhere. In recent times, dark themes have been extremely popular, with OS Mojave and other popular apps such as YouTube and Telegram implementing a dark variant of their software.

Users can access this feature by clicking on the ‘cogwheel’ icon on the home page to access the app settings. From here, a simple tap on the switch to enable night mode would cause the app to switch to it via a fade transition effect.

<img src="media/night1.png" width="130" height="232" /> <img src="media/night2.png" width="130" height="232" /> <img src="media/night3.png" width="130" height="232" /> <img src="media/night4.png" width="130" height="232" />

### 8. Feedback Form
As we want to give users an easy avenue to provide their feedback on PayWhere, we have included a feedback form on our app. It can be accessed from the homepage by clicking the paper plane icon.

<img src="media/email1.png" width="130" height="232" /> <img src="media/email2.png" width="130" height="232" /> <img src="media/email3.png" width="130" height="232" /> <img src="media/email4.png" width="130" height="232" />

We anticipate the feedback to be about key features we should implement to make PayWhere more user-friendly and informative, and updates about our mobile payment options for mall listings.