# Release Planning Meeting

## Meeting Date & Location
February 2, 2020 from 8-10 pm on Google Hangouts

## Particpants
Michelle, William, Jennifer, Coco, Harsh, Danica

---
## Project Scope

The project is an Android mobile application (app) that allows users to create, share and search for recipes created by other people. With a digitalized cookbook, users will have access to their saved recipes regardless of connectivity and the ability to modify recipes for personal use. Many people regardless of cooking abilities learn from other recipes and discover new techniques that improve their experiences. While this kind of app is common, the personal touch that allows modification of locally stored recipes more closely reflects a personal cookbook, rather than a professional one.

Each aspect of the recipe should be stored separately in the database that allows each component to be created, accessed and modified according to what the user specified. The app should be able to dynamically accept any changes and display them upon exiting edit mode. The app should also allow users to search and follow other users to be specifically updated when the user creates or shares a recipe.

---
## Release Goals

### **Sprint 1:** 

The Release Goal for Sprint 1 is for a user to be able to create a recipe with the following attributes: a recipe title, serving size, ingredients with amounts, and the steps involved. They should be able to see the recipe in their cookbook, be able to tap on the recipe and it should open up on the screen with the information they put in. This is the primary user story for this sprint since it involves a lot of set up and is the foundation for the entire app.

Since this is the first sprint with code and new technologies, two important goals for the team includes learning these technologies. All team members need to become comfortable with Android Studio since all the code for both front and back-end development needs to work with the program. Secondly, no team member has used Firebase as a database before, so the required team members working on that portion of the back-end need to learn how to use it.

### **Sprint 2:**

The Release Goals for Sprint 2 is for a user to create an account, add pictures to their recipe, scale the recipe size and conversion between common units of measurement. Their relevant personal information such as name and created recipes will be associated with their account, and stored in the database. Additionally users should be able to login and logout of their account on the app. We will allow users to add an image upon recipe creation to give other users a visual on what the dish should look like.

This sprint will also allow increased readability and personal application of recipes in terms of modifing the serving size and units used in a given recipe. By changing the serving size on a recipe, the amount and weight of ingredients needed should be modified by a scalar. If a user is more comfortable with a specific measurement system (metric or imperial) they should be able to convert amounts and weights between the two.

### **Sprint 3:**

The Release Goals for Sprint 3 is for a user to be able to access the application in an offline mode, download and modify stored recipes, share other recipes not created by themselves, subscribe to other users to get updates, and remove a recipe from public view. This sprint focuses more on the community aspect by allowing users the option to be more community involved. When a user subscribers to others, the app should inform them when the user they follow has created or shared a recipe. If a user shares a recipe, it should update their cookbook to include that recipe and inform all subscribers that they have shared the recipe. 

In the offline mode of the app, usability is restricted to creating and storing recipes. When online they should be able to download recipes to their personal cookbook. After the recipe is downloaded locally, then they should be able to modify any amounts, ingredients or steps within the recipe. Lastly, any user should be able to remove a recipe they created from public access where other users will not be able to read the recipe or see it in their cookbook.

### **Sprint 4:** 

The Release Goals for Sprint 4 revolve around searching for and rating recipes. Users should be able to filter their recipe searches based on dietary requirements, allergies or personal preference. As a result of the filters, "blacklisted" tags should prevent those recipes from popping up in a search. Filters are associated with tags that a user should be able to input into a recipe upon creation, and using these tags and potential filters, the app should be able to suggest a random recipe to a user.

Users should also be able to rate other user recipes out of 5 stars. Based on all ratings, an average rating should be displayed and users should be able to access a list of the top 5 rated recipes for a given time. Lastly, users should now get alerts and notifications from the app about other users they have subscribed to or changes to recipe status for a recipe in their cookbook that they did not create.

---
### Optional (Time-Permitting): 

These are the additional user stories that will be completed only if there is time in the later sprints and the team moves ahead of schedules. These features will not necessarily affect the functionality or the usability of the app.

- [LION-09] Meal Planner
- [LION-19] Track History of Tried Recipes
- [LION-20] Set a Timer
- [LION-08] Dictionary of Cooking Terms
