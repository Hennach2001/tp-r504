def puissance(a, b):
    return a ** b
import fonctions as f

while True:
    try:
        a = int(input("Entrez le premier nombre entier (CTRL-C pour quitter) : "))
        b = int(input("Entrez le deuxième nombre entier : "))
        res = f.puissance(a, b)
        print(f"{a} élevé à la puissance {b} est {res}")
    except ValueError:
        print("Veuillez entrer des nombres entiers valides.")

