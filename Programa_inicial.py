import csv

#leer archivo
datos = []
with open(r'C:\Users\HUAWEI-PC\Documents\Estrucutras_de_datos\Tarea_1\datos_redes_sociales.csv') as archivo:
    lector = csv.reader(archivo)
    for fila in lector:
        datos.append(fila)
print('---- base de datos cargada ----')

indices_meses = {
    'enero': 3, 'febrero': 4, 'marzo': 5, 
    'abril': 6, 'mayo': 7, 'junio': 8
}


#Diferencia de seguidores en Twitter de enero a junio
for fila in datos:
    if fila[0] == 'TWITTER' and fila[1] == 'SEGUIDORES (FOLLOWERS)':
        enero = int(fila[3])
        junio = int(fila[8])
        aumento = (junio - enero) 
        print(f"\nAumento de seguidores en Twitter (Enero a Junio): {aumento}")

#Comparacion visualizacion en youtube
print("\nComparacion de visualizaciones en YouTube ---")
print("Compare 2 meses de enero a junio \n")
mes1 = input("Ingresa el primer mes (ej. enero): ").lower()
mes2 = input("Ingresa el segundo mes (ej. junio): ").lower()

if mes1 in indices_meses and mes2 in indices_meses:
    col1 = indices_meses[mes1]
    col2 = indices_meses[mes2]
    
    for fila in datos:
        if fila[0] == 'YOUTUBE' and fila[1] == 'VISUALIZACIONES':
            val1 = int(fila[col1])
            val2 = int(fila[col2])
            dif_yt = abs(val1 - val2)
            print(f"La diferencia de visualizaciones entre {mes1} y {mes2} es: {dif_yt}")
else:
    print("Error: Mes no válido. Asegúrate de escribirlo bien.")


#Promedio de crecimiento facebook youtube twitter

for fila in datos :
    if 'PORCENTAJE' in fila[1] and fila[0] == 'TWITTER':
        suma = 0
        for i in range(3, 9):
            porcentaje_mes = fila[i].replace('%', '')
            suma += float(porcentaje_mes)
        
        promedio = suma / 6
        print(f"\nPromedio de crecimiento de {fila[0]}: {promedio:.2f}")

    if 'PORCENTAJE' in fila[1] and fila[0] == 'FACEBOOK':
        suma = 0
        for i in range(3, 9):
            porcentaje_mes = fila[i].replace('%', '')
            suma += float(porcentaje_mes)
        
        promedio = suma / 6
        print(f"\nPromedio de crecimiento de {fila[0]}: {promedio:.2f}")

# Promedio de 'ME GUSTA' youtube facebook twitter
print("\n---Promedio de 'Me gusta' de Enero a Junio ---")
for fila in datos:
    if 'ME GUSTA' in fila[1]:
        suma_likes = 0
        for i in range(3, 9):
            suma_likes += int(fila[i])
            
        promedio_likes = suma_likes / 6
        print(f"Promedio de 'Me gusta' en {fila[0]}: {promedio_likes:.2f}")