## Sprint 4 Planning Meeting

### Meeting Date & Location
March 15, 2020 from 8:30-9:30 pm on Google Hangouts

### Particpants
Michelle, William, Jennifer, Coco, Harsh, Danica

--- 

### Sprint Goal(s)
The goals for this sprint can be broken down into to major categories: (1) User Related and (2) Recipe Related. As a result, the team will be split into two to allow achieve these goals.

1. User Related: 
    - Allow the user to log in, remain logged in and log out
    - Allow the user to view their own profile
    - Allow the user to view other user profiles
2. Recipe Related:
    - Retrieve recipes created by the user from the database
    - Delete a recipe
    - Publish and Unpublish a recipe (allowing public access to viewing)

### Team Capacity
- 252 Hours = (6 members) x (14 days/sprint) x 3 (productive hours/day)

The productive hours per day was decided to be lower since all team members have a lot of other assignments and projects due for other courses around the same time.
As a result, it was decided that 3 was an appropriate time period to allocate to learning the new technologies and writing code.
Even though Reading Week takes place during this sprint, all team members have multiple assignments and midterms to prep for, so the team capacity will not be increased.

---

### Spikes
1. **Technical Spikes:**
    -  We need to associate users and recipes together in the database and call that information into the app. Both groups need

2. **Functional Spikes:**
    - Users should be able to stay logged into the app if they don't explicitly click logout
    - Users may constantly shift between publishing and unpublishing a recipe
    
---

### User Stories

**User Related:**
1. **LION-63** View Private User Profile
2. **LION-101** Maintain User's Login State
3. **LION-102** Logout
4. **LION-106** View Public User Profile

**Recipe Related:**
1. **LION-96** Retrieve & Display a Recipe
2. **LION-95** Delete a Recipe
3. **LION-23** Remove Recipe from Pubic Access
4. **LION-89** Publish a Recipe

All the tasks for these user stories are broken down below and are separated into the approriate components (sub-tasks) for the MVP architecture.

---

### Task Breakdown

**User Related:**

1. **LION-63** View Private User Profile
    - Model: Retrieve User Information from Database
    - Presenter: Collect User Information and connect Model and View
    - Presenter: Allow navigation bar use to get to profile
    - View: Create Private Profile view
    
2. **LION-101** Maintain User's Login State
    - Presenter: Allow user to stay logged in and not have to re-authenticate for every use instance
    
3. **LION-102** Logout
    - Presenter: Logout user on button click on private profile
    - Model: Acknowledge user logout

4. **LION-106** View Public User Profile
    - Model: Retrieve limited user information from database
    - Presenter: Collect relevant user information and connect model and view
    - View: Create Public Profile (view another user profile essentially)
 
**Recipe Related:**

1. **LION-96** Retrieve & Display a Recipe
    - Model: Retrieve Recipes for Cookbook view
    - Model: Retrieve specific recipe details for recipe
    
2. **LION-95** Delete a Recipe
    - Model: Delete object from database
    - Presenter: Add delete toggle logic
    - View: Add delete button for recipe
    
3. **LION-23** Remove Recipe from Pubic Access
    - Presenter: Add code so published recipes can be made private
    - View: Create remove option in recipe view
    
4. **LION-89** Publish a Recipe
    - Model: Add a published recipe to the correct section of Firebase
    - Presenter: Add code so the user is able to select the option of publishing a recipe when they create it
    - View: Add publish option in Create a Recipe
