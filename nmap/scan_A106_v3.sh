#!/bin/bash

# Définir l'adresse de la plage d'adresses
network="172.16.0.0/24"

# Fichier de sortie
output="scan-result_3.csv"

# Ajouter l'en-tête du fichier CSV
echo "# - IP - TCP ports - UDP ports - Kernel version" > "$output"

# Lancer nmap en mode -sn pour les machines actives, puis scanner les ports TCP et UDP ouverts
nmap -T4 -p- --open -sS $network | grep -B 4 "open" | grep "Nmap scan report for" | awk '{print $5}' | while read ip; do
    # Compter les ports TCP ouverts
    tcp_ports=$(nmap -T4 -p- --open -sS $ip | grep -c "open")
    
    # Compter les ports UDP ouverts
    udp_ports=$(nmap -T4 -p- --open -sU $ip | grep -c "open")
    
    # Extraire la version du noyau Linux
    kernel_version=$(nmap -O $ip | grep "Running: Linux" | awk '{print $2,$3}' | sed 's/,$//')
    
    # Écrire les résultats dans le fichier CSV
    echo "$ip;$tcp_ports;$udp_ports;$kernel_version" >> "$output"
done

