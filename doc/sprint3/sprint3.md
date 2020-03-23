## Sprint 3 Planning Meeting

### Meeting Date & Location
March 1, 2020 from 8:30-9:30 pm on Google Hangouts

### Particpants
Michelle, William, Jennifer, Coco, Harsh, Danica

--- 

### Sprint Goal(s)
- Add a recipe to firebase that is associated with a user
- Allow user to be authenticated and identified
- Allow user to change measurement types when viewing a recipe
- Users should be able to change screens

### Team Capacity
- 252 Hours = (6 members) x (14 days/sprint) x 3 (productive hours/day)

The productive hours per day was decided to be lower since all team members have a lot of other assignments and projects due for other courses around the same time.
As a result, it was decided that 3 was an appropriate time period to allocate to learning the new technologies and writing code.
Even though Reading Week takes place during this sprint, all team members have multiple assignments and midterms to prep for, so the team capacity will not be increased.

---

### Spikes
1. **Technical Spikes:**
    - Authentication and adding a recipe to firebase are closely connected, so groups working on both stories need to understand what occurs in both stories.

2. **Functional Spikes:**
    - Users may want to change both measurements and serving sizes so we need to decide how the inputs will handle these values.
    - We need to keep emails and usernames unique so that queries and searches in the database are easier to implement.
    
---

### User Stories

1. **LION-69** Add a Recipe to firebase
2. **LION-75** Authentication on Login Screen
3. **LION-85** Use of navigation buttons to change screens
4. **LION-7** Conversion between units

All the tasks for these user stories are broken down below and are separated into the approriate components (sub-tasks) for the MVP architecture.

---

### Task Breakdown

1. **LION-69 Add a recipe to firebase**
    - Model: Retrieve Recipe Object
    - Model: Retrieve a list of Recipe Titles
    - Model: Delete a Recipe Object
    - Model: Update a Recipe
    - Model: Insert a Recipe Object
    - Model: Set validation rules for recipes on Firebase
    
2. **LION-75 Authentication on Login Screen**
    - Presenter: Handle User authentication
    - Model: Authenticate entered email and password on Firebase
    
3. **LION-85 Use of navigation buttons to change screens**
    - Presenter: Add code so that the navigation buttons work and take users to the correct screens
    - View: Show user which page they're on

4. **LION-7 Conversion between Units**
    - Presenter: Implement logic behind conversion & link it to UI
    - View: Add option to change unit measurements
