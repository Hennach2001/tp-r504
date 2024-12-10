from flask import Flask, render_template, request
import mysql.connector
import re

app = Flask(__name__)

# MySQL configuration
db_config = {
    'host': 'tp4-sql',
    'user': 'root',
    'password': 'foo',
    'database': 'demosql'
}

# Initialize MySQL connection
conn = mysql.connector.connect(**db_config)
cursor = conn.cursor()

# Fonction de validation de l'identifiant utilisateur
def validate_username(username):
    errors = []
    
    # Vérifier si l'identifiant a au moins 6 caractères
    if len(username) < 6:
        errors.append("L'identifiant doit contenir au moins 6 caractères.")
    
    # Vérifier s'il y a au moins 1 chiffre
    if not re.search(r'\d', username):
        errors.append("L'identifiant doit contenir au moins un chiffre.")
    
    # Vérifier s'il y a au moins 1 majuscule et 1 minuscule
    if not re.search(r'[A-Z]', username) or not re.search(r'[a-z]', username):
        errors.append("L'identifiant doit contenir au moins une majuscule et une minuscule.")
    
    # Vérifier s'il y a au moins un caractère spécial parmi #%{}@
    if not re.search(r'[%#\{\}@]', username):
        errors.append("L'identifiant doit contenir au moins un caractère spécial parmi #%{}@.")
    
    return errors

@app.route('/')
def index():
    query = "SELECT * FROM myTable"
    cursor.execute(query)
    data = cursor.fetchall()
    
    return render_template('index.html', data=data)

@app.route('/newuser/', methods=['GET', 'POST'])
def new_user():
    if request.method == 'POST':
        username = request.form['username']
        errors = validate_username(username)

        if errors:
            return render_template('index.html', errors=errors, username=username)

        return render_template('index.html', success=True, username=username)

    return render_template('index.html', errors=None)

if __name__ == '__main__':
    app.run(debug=True)

