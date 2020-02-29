## Sprint 2 Planning Meeting

### Meeting Date & Location
February 16, 2020 from 8-10 pm on Google Hangouts

### Particpants
Michelle, William, Jennifer, Coco, Harsh, Danica

--- 

### Sprint Goal(s)
- Completely Connect the Database
- Allow users to create an account for the app
- Allow users to temporarily alter the measurements of a recipe for customization purposes

### Team Capacity
- 252 Hours = (6 members) x (14 days/sprint) x 3 (productive hours/day)

The productive hours per day was decided to be lower since all team members have a lot of other assignments and projects due for other courses around the same time.
As a result, it was decided that 3 was an appropriate time period to allocate to learning the new technologies and writing code.
Even though Reading Week takes place during this sprint, all team members have multiple assignments and midterms to prep for, so the team capacity will not be increased.

---

### Spikes
1. **Technical Spikes:**
    - Firebase will be used as the database for storing account information since there are authentication APIs included. The exact sign in and account creation protocol have not been decided, so there needs to be time decidated to choosing the most appropriate login criteria.

2. **Functional Spikes:**
    - Users may not want or have all the information needed to create an account, so we need to decide how strict this aspect will be.
    - Since we rely on user input to create an account, there may be the potential for invalid inputs which can affect retrieval of information from the database and its authentication.
    - Similarly when creating a recipe, user input is needed for the ingredient, amount and a choice of measurement. These need to be valid inputs so they do not negatively affect future features.
   
---

### User Stories

1. **LION-24 Create an Account**
2. **LION-25 Login & Logout of Account**
3. **LION-26 Scale Recipe Size**
4. **LION-54 Add Recipe to Local Database**
5. **LION-66 View User Profile**

All the tasks for these user stories are broken down below and are separated into the approriate components (sub-tasks) for the MVP architecture.

---

### Task Breakdown

1. **LION-24 Create an Account**
    - Presenter: Create Presenter for creating user account
    - View: Create Registration Page & link to create account on login page
    - Model: Create Model for Creating User Account (use Firebase as database)
    
2. **LION-25 Login & Logout of Account**
    - Presenter: Create Presenter for login and logout
    - View: Create login page and button for logout on account page
    - Model: Create Model for Signing in and out (use Firebase as database)
    
3. **LION-26 Scale Recipe Size**
    - Presenter: Implement scaling feature logic
    - View: Add option to change serving size in Recipe view

4. **LION-54 Add Recipe to Local Database**
    - Presenter: Presenter code - connect the database to the view
    - View: Fix listview for ingredients in "Create a Recipe" 
    - Model: Connect Room Database to CreateRecipeModel
    - Model: Connect Room Databse to CookBookModel (retrieving data)

5. **LION-66 View User Profile**
    - View: Create a private profile view
    - View: Create a public profile view
