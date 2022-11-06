#include <iostream>
#include <list>
using namespace std;

void numberCode(){
  cout << "1 Add task" << endl;
  cout << "2 View tasks" << endl;
  cout << "3 Submit completed task" << endl;
  cout << "4 Use earned points" << endl;
  cout << "5 Exit" << endl;
}

void mainSetup(string name, int homework, int tests_projects, int chores, list<string>hw, list<string>test_proj, list<string>chore){
  int next = 0;
  int blah;
  cout << "Congrats! You have now set up " << name << "'s schedule. From this point on, everything is up to you." << endl;
  cout << "After everything you input, you have an option to enter a number to decide what happens next. Below are the numbers and what they do. Now, go out there and start scheduling!" << endl;
  while(true){
    numberCode();
    cout << "What now?(Enter a number): ";
    cin >> next;
    
    if (next == 1) {
      
    }
    else if(next == 2) {
      
    }
    else if(next == 3) {
      
    }
    else if(next == 4) {
      
    }
    else if(next == 5) {
      cout << "Alrighty, thank you for using the Virtual Schedule Maker(tm), have a good day!";
      cin >> blah;
    }
    else{
      cout << "Your input doesnt match any of the numbers, please retype the input.";
    }
  }
}

void scheduleSetup(string name, int homework, int tests_projects, int chores) {
  list<string>hw = {};
  list<string>test_proj = {};
  list<string>chore = {};
  string input;
  string category;
  string answer;
  
  cout << "Now you can add tasks to " << name << "'s schedule." << endl;
  cout << "Please enter the tasks you want to add and the category they should go under, first is the task (as one word): ";
  cin >> input;
  cout << endl;
  cout << "Now, what is the category: ";
  cin >> category;

  while((tolower(category.at(0)) != 'c') || (tolower(category.at(0)) == 't')||(tolower(category.at(0)) == 'p') || (tolower(category.at(0)) == 'h')){
    cout << "Sorry, that category is unavailable. Please reenter the category (your task is saved though): ";
    cin >> category;
  }

  if(tolower(category.at(0)) == 'c'){
    chore.push_back(input);
    cout << "You have successfully added the task to the Chore category.";
  }
  else if((tolower(category.at(0)) == 't')||(tolower(category.at(0)) == 'p')){
    test_proj.push_back(input);
    cout << "You have successfully added the task to the Tests/Projects category.";
  }
  else if(tolower(category.at(0)) == 'h'){
    hw.push_back(input);
    cout << "You have successfully added the task to the Homework category.";
  }

  cout << endl;

  mainSetup(name, homework, tests_projects, chores, hw, test_proj, chore);
}

void taskSetup(string name){
  string answer;
  int tests_projects = 0;
  int homework = 0;
  int chores = 0;
  cout << endl << "The main categories are tests/projects, homework, and chores." << endl;
  cout << "You can add items to the schedule under one of these categories. For every item " << name << " completes, they will earn a certain amount of points." << endl;
  cout << "Please, take the time to assign these categories with points now. Its just as simple and entering a number when the category appears!" << endl;

  cout << "Homework points: ";
  cin >> homework;
  cout << "Test/Project points: ";
  cin >> tests_projects;
  cout << "Chore points: ";
  cin >> chores;
  cout << endl;

  cout << "Alrighty, I have gathered the point totals and here are the results." << endl;
  cout << "Homework: " << homework << endl;
  cout << "Tests/Projects: " << tests_projects << endl;
  cout << "Chores: " << chores << endl;
  cout << "Do these values sound good? I daresay, agreeable, even?(y/n): ";
  cin >> answer;
  
    if(tolower(answer.at(0)) == 'n') {
    while(tolower(answer.at(0)) != 'y'){
      cout << endl;
      cout << "ooooooooooook then, care to re-enter the correct point totals this time." << endl;
      cout << "Homework points: ";
      cin >> homework;
      cout << "Test/Project points: ";
      cin >> tests_projects;
      cout << "Chore points: ";
      cin >> chores;
      cout << endl;
      cout << "I regathered the point totals, how do they look? " << endl;
      cout << "Homework: " << homework << endl;
      cout << "Tests/Projects: " << tests_projects << endl;
      cout << "Chores: " << chores << endl;
      cout << "Are these agreeable?(y/n): ";
      cin >> answer;
    }
    cout << endl;
    cout << "Heck yeah, now lets do some some scheduling!";
    cout << endl;
    scheduleSetup(name, homework, tests_projects, chores);
  }
  else {
    cout << endl;
    cout << "Heck yeah, now lets do some some scheduling!";
    cout << endl;
    scheduleSetup(name, homework, tests_projects, chores);
  }
  
}

int main() {
  string name = "";
  string answer;
  cout << "Welcome to the Virtual Schedule Maker(tm)" << endl;
  
  cout << "Whose schedule is being made?(enter a name): ";
  getline(cin, name);
  cout << endl;
  if((name == "Khant")||(name == "Sydney")) {
    cout << "Hey, thats the name of a developer! So is this your schedule " << name << " or are you a player committing identity theft?(y/n) ";
    cin >> answer;
  }
  else {
    cout << "Ah, so this is " << name << "'s Schedule, correct?(y/n) ";
    cin >> answer;
  }

  if(tolower(answer.at(0)) == 'n') {
    while(tolower(answer.at(0)) != 'y'){
      cout << endl;
      cout << "Bruh, whos schedule is it then?(enter a name): ";
      cin >> name;
      cout << "So this is " << name << "'s Schedule, correct?(y/n) ";
      cin >> answer;
    }
    cout << endl;
    cout << "Wonderful, lets get started by setting up some tasks!";
    cout << endl;
    taskSetup(name);
  }
  else {
    cout << "Wonderful, lets get started by setting up some tasks!";
    cout << endl;
    taskSetup(name);
  }
  
}
