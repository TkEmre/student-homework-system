# 🏫 Student Homework System

The **Student Homework System** is a web-based task management platform designed to improve collaboration between students, teachers, and parents. It allows tasks (e.g., homework, projects, assignments, wishes) to be created, managed, and completed by different roles with specific permissions.

---

## 👤 User Roles & Features

### 🧑‍🎓 Student
- View tasks assigned by teachers or parents
- Submit answers to homework
- Add personal tasks/wishes to their dashboard
- Track progress and deadlines
- View grades and feedback from teachers

### 🧑‍🏫 Teacher
- Create and assign tasks to students
- Review and grade student submissions
- Edit or remove tasks
- Collaborate with parents on student progress

### 👨‍👩‍👧 Parent
- Create tasks or reminders for their children (e.g., “Practice piano”, “Prepare for exam”)
- View their child's submitted tasks and results
- Communicate with teachers via task comments
- Help track their child’s academic development

---

## 🚀 Key Features

- Role-based access system (Student, Teacher, Parent)
- Task assignment system with due dates, statuses, and descriptions
- Homework submission portal for students
- Wish/task list system for student motivation
- Teacher grading and feedback system
- Parent-teacher-student coordination in one platform
- Authentication (Login/Register)
- Responsive UI for desktop and mobile

---

## 🛠️ Tech Stack

- **Backend:** Python + Django  
- **Frontend:** HTML, CSS, JavaScript (optionally Bootstrap)  
- **Database:** SQLite (can be switched to PostgreSQL or MySQL)  
- **Auth:** Django built-in authentication system

---

## 📦 Installation Guide

```bash
# Clone the repository
git clone https://github.com/TkEmre/student-homework-system.git
cd student-homework-system

# Create a virtual environment
python3 -m venv venv
source venv/bin/activate  # On Windows: venv\Scripts\activate

# Install dependencies
pip install -r requirements.txt

# Run migrations
python manage.py migrate

# Start the server
python manage.py runserver
