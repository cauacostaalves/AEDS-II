# Soma de dois números
def soma_dois_numeros(a, b):
    return a + b

# Soma dos elementos de um array
def soma_array(arr):
    return sum(arr)

# Exemplos de uso
numero1 = int(input("seu numero1: "))
numero2 = int(input("seu numero2: "))

array = [ ]
tam = int(input("TAM array: "))
for array in range(tam):
    num = int(input("Prox num array: ")) 
    array.append(num)

print(f"Lista total : {array}" )

soma_numeros = soma_dois_numeros(numero1, numero2)
soma_dos_elementos = soma_array(array)

print(f"Soma dos dois números: {soma_numeros}")
print(f"Soma dos elementos do array: {soma_dos_elementos}")
