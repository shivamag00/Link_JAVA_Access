def sumofdig(n):
    sum1 =  0
    while (n!= 0):
        sum1 = sum1 + (n%10)
        n=int(n/10);
    return sum1

card = input("Enter a card no.\n")
if (len(card)!=13) and (len(card)!=15) and (len(card)!=16):
    print("INVALID\n")
    exit(1)

nos = [];
for i in card:
    i = int(i)
    nos.append(i)

mul=0
suma=0
for i in range(len(nos)-2,-1,-2):
    mul=mul+sumofdig(nos[i]*2)

for i in range(len(nos)-1,-1,-2):
    suma = suma + nos[i]

mul=mul+suma
print(mul)
if (mul%10==0):
    if (nos[0]==4):
        print("VISA\n")
    elif (nos[0]==3) and (nos[1]==4 or nos[1]==7):
        print("AMEX\n")
    elif (nos[0]==5) and (nos[1]==1 or nos[1]==2 or nos[1]==3 or nos[1]==4 or nos[1]==5 ):
        print("MASTERCARD\n")
    else:
        print("INVALID\n")
else:
    print("INVALID\n")