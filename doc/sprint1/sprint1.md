## Sprint 1 Planning Meeting

### Meeting Date & Location
February 2, 2020 from 8-10 pm on Google Hangouts

### Particpants
Michelle, William, Jennifer, Coco, Harsh, Danica

--- 

### Sprint Goal(s)
- Create an alpha build (1.0.0 Alpha)
    - The basic build involves being able to create a recipe and access that recipe from the cookbook
- Get comfortable with project technologies: Android Studio & Firebase Database

### Team Capacity
- 252 Hours = (6 members) x (14 days/sprint) x 3 (productive hours/day)

The productive hours per day was decided to be lower since all team members have a lot of other assignments and projects due for other courses around the same time.
As a result, it was decided that 3 was an appropriate time period to allocate to learning the new technologies and writing code.

---

### Spikes
For this sprint there are two technical spikes for the team that will affect the progress of the project. All team members have not done Android development in detail and have not used Firebase as a database.
The two technical spikes are:
- All team members are unfamiliar with Android Studio
- All team members are unfamiliar with Firebase

So for this sprint, all members need to create sub tasks to learn how to use Android Studio and all relevant members working on the Model for the project need to learn how to use Firebase.

---

### User Stories

Since we have two major technical spikes for this sprint, it has been decided that the team needs to limit the number of user stories chosen.
Two new user stories were created on JIRA related to the spikes. The user stories chosen for this sprint are:

- LION-6: Create a Recipe
- LION-39: Learn Android Studio (Spike)
- LION-42: Learn how to use Firebase (Spike)

Only one actual user story was chosen since this is a very large user story and is essentially the core of the app.
This is a cookbook app so the ability to create a recipe is vital. 
With this user story the database needs to be created and initialized, the user needs to able to input their own recipe, and the view needs to be connected with the
database in order to be able to pull up the recipe.

All the tasks for these user stories are broken down below and are separated into the approriate components for the MVP architecture.

---

### Task Breakdown

1. **LION-6 Create a Recipe**:

    - **Model (Jennifer & William)**:
        - LION-27: Set up Database
        - LION-33: Create a Blank Recipe

    - **Presenter (Michelle & Coco)**:
        - LION-28: Obtain information from View
        - LION-29: Conduct validation check for entered information
        - LION-30: Change view to CookBook view once a recipe is created
        - LION-45: Create presenter and contract for viewing cookbook
        - LION-48: Presenter: Given a list of recipe titles, display this in listView in the CookBook

    - **View (Harsh & Danica)**:
        - LION-31: Setup CookBook View
        - LION-32: Setup “Create A Recipe” View

4. **Android Studio Spike (LION-39)**: 
   - Each team member has a sub-task to learn to navigate and use Android Studio relative to the project tasks that need to be done

5. **Firebase Spike (LION-42)**:
   - At the moment, team members dealing with the model need to create a sub-task that involves learning Firebase







