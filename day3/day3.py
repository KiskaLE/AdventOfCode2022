
def find_common_letter(fist_pocket: str, second_pocket: str):
    common = []
    for letter in fist_pocket:
        contains = False
        for x in common:
            if (x == letter):
                contains = True
                break
        if (contains):
            continue
        if (second_pocket.find(letter)):
            common.extend(letter)



    return common

file = open("input.txt")
file_lines = []
for line in file:
    file_lines.append(line.replace("\n", ""))

for line in file_lines:
    firstpart, secondpart = line[:len(line) // 2], line[len(line) // 2:]
    print(find_common_letter(firstpart, secondpart))
