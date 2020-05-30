ToDozzz
================

## Introduction
A ToDo list manager to boost your productivity.  
The tasks are divided into 3 categories:
* **Most Important Tasks** - Tasks requiring *immediate attention*
* **Weekly List** - Goals for the *next 7 days*
* **Master List** - *Long term goals*

## About the application  
A *navigation drawer* houses the *menu* for accessing the 3 independent lists and an *about fragment*.  
All the *menu items* are attached to their specific *fragments* which in turn inflate the *layouts*.  

All the 3 lists have independent:
* Fragments
* ViewModels
* ViewModelFactories
* ListAdapters
* Layouts
* RecyclerViews
* Databases
  * Entities
  * Data Access Objects(DAO)

The **layouts** are inflated from the respective **fragments**(using **data binding**) and the **viewModels** house the data and the methods. The viewModels are instantiated using the **viewModelFactories**.  
The **roomDatabase** contains an **entity** and a **data access object** to communicate with the database.
The task data(Checkbox and Task name) is displayed using a **recyclerView** which updates the view as and when the database changes(as it works with **liveData**).  
