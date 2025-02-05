#!/bin/bash

# Définir l'adresse de la plage d'adresses
network="172.16.0.0/24"

# Fichier de sortie
output="scan-result_1.csv"

# Ajouter l'en-tête du fichier CSV
echo "# - IP - TCP ports" > "$output"

# Lancer nmap en mode -sn pour les machines actives, puis scanner les ports TCP ouverts
nmap -T4 -p- --open -sS $network | grep -B 4 "open" | grep "Nmap scan report for" | awk '{print $5}' | while read ip; do
    # Compter les ports TCP ouverts
    open_ports=$(nmap -T4 -p- --open -sS $ip | grep -c "open")
    echo "$ip;$open_ports" >> "$output"
done

