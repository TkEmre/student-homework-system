# 🏡 Student Homework System

This project is a web-based platform that allows students to manage and submit their homework, while teachers can create assignments, grade submissions, and track student progress.

---

## 🚀 Features

- 🧑‍🎓 Student and 🧑‍🏫 Teacher roles
- Students can:
  - View assigned homework
  - Submit homework
  - See their grades and feedback
- Teachers can:
  - Create and manage homework assignments
  - View student submissions
  - Assign grades and comments
- Authentication system (Register/Login)
- Organized dashboard for both roles

---

## 🛠️ Tech Stack

- **Backend:** Python + Django *(or Flask / specify your stack)*
- **Frontend:** HTML/CSS/JS *(or React/Vue if used)*
- **Database:** SQLite *(or PostgreSQL/MySQL)*
- **Other Tools:** Django Admin, Bootstrap *(update as needed)*

---

## ⚙️ Installation

```bash
# 1. Clone the repository
git clone https://github.com/TkEmre/student-homework-system.git
cd student-homework-system

# 2. Create and activate a virtual environment
python3 -m venv venv
source venv/bin/activate  # On Windows use: venv\Scripts\activate

# 3. Install dependencies
pip install -r requirements.txt

# 4. Run migrations
python manage.py migrate

# 5. (Optional) Load sample data
python manage.py loaddata sample_data.json

# 6. Start the server
python manage.py runserver
