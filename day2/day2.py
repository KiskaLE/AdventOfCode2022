def win(elfMove: str):
    score : int = 6
    if (elfMove == "A"):
        score += 2
    elif (elfMove == "B"):
        score += 3
    elif (elfMove == "C"):
        score += 1
    return score

def lose(elfMove: str):
    score: int = 0
    if (elfMove == "A"):
        score += 3
    elif (elfMove == "B"):
        score += 1
    elif (elfMove == "C"):
        score += 2
    return score

def draw(elfMove: str):
    score: int = 3
    if (elfMove == "A"):
        score += 1
    elif (elfMove == "B"):
        score += 2
    elif (elfMove == "C"):
        score += 3
    return score




# převádí souborn na pole s poli her
file = open("day2/input.txt", "r")
plays = []
for line in file:
    line = line.replace("\n", "")
    play = line.split(" ")
    plays.append(play)
score = 0
for play in plays:
    opponent = play[0]
    player = play[1]
    if (player == "X"):
        score += 1
    elif (player == "Y"):
        score += 2
    elif (player == "Z"):
        score += 3
    if ((player == "X" and opponent == "C") or (player == "Y" and opponent == "A") or (
            player == "Z" and opponent == "B")):
        score += 6
    elif ((player == "X" and opponent == "A") or (player == "Y" and opponent == "B") or (
            player == "Z" and opponent == "C")):
        score += 3
print("score if I won 100% times: " +str(score))
score = 0
for play in plays:
    opponent = play[0]
    player = play[1]
    if (player == "X"):
        score += lose(opponent)
    elif (player == "Y"):
        score += draw(opponent)
    else:
        score += win(opponent)

print("score if you folow you plan: "+str(score))

