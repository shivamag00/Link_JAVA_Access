def countletters(text):
    letters = 0
    for i in text:
        if (ord(i) >= 65 and ord(i) <= 90) or (ord(i) >= 97 and ord(i) <= 122):
            letters = letters + 1
    return letters

def countwords(text):
    words = 0
    for i in range(len(text)):
        if (i==len(text)-1 or text[i+1]==" "):
            words = words +1
    return words

def countsent(text):
    sent = 0
    for i in text:
        if (i=='.' or i=='!' or i=='?'):
            sent=sent+1
    return sent

text = input("Enter Text:")
letters=countletters(text)
words=countwords(text)
sent=countsent(text)

index=(0.0588*(letters/words)*100)-(0.296*(sent/words)*100)-15.8
if(round(index)<1):
    print("Before Grade 1")
elif (round(index)>=16):
    print("Grade 16+")
else:
    print("Grade",round(index))
