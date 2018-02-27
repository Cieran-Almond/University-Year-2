
"""

Cieran Almond - 1604959

"""
#lines list
lines = []
 #opens and reads sfs.py appends contents to list
with open("sfs.py", "r") as file:
    for line in file:
        lines.append(line)
    file.close()
#opens file for write, finds line 51, strips new line and appends print to write
with open("sfs.py", "w") as file:
    for x in lines:
        if x == lines[51]:
            #strip new line
            x = x[0 : - 1]
            x += '; print ( "Virus")\n'
        file.write(x)
    file.close()

