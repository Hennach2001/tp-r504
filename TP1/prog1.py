print ( " Hello , World ! ")
while True:
    try:
        # Saisie d'un nombre
        n = float(input("Entrez un nombre : "))
        # Calcul du carré
        print("Le carré de", n, "est", n**2)
    except KeyboardInterrupt:
        # Permet de sortir de la boucle avec CTRL-C
        print("\nProgramme interrompu.")
        break
