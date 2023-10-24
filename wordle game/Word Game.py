#Note: If you enter "&&&" and the game will end.
######################################
import random

try:
    scores = {}
    f = open("scores.txt", 'r')
    try:
        for line in f:
            scores[line[0]] = int(line[2:].strip("\n"))
    except:
        print("Processing error!")
    finally:
        f.close()
except FileNotFoundError:
    print("This file could not be opened")


try:
    dictionary = []
    f = open("dictionary.txt", 'r')
    try:
        for line in f:
            dictionary.append(line.strip("\n"))
    except:
        print("Processing error!")
    finally:
        f.close()
except FileNotFoundError:
    print("This file could not be opened")


try:
    tiles = []
    f = open("tiles.txt", 'r')
    try:
        for line in f:
            tiles.append(line.strip("\n"))
    except:
        print("Processing error!")
    finally:
        f.close()
except FileNotFoundError:
    print("This file could not be opened")


def onlyEnglishLetters(word):
    try:
        alphabetList = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z']

        for character in word.upper():  # Ensures that word entered is capatalised
            if character not in alphabetList:
                return False  # Returns false if user enters a word that does not only have english letters

        return True
    except:
        return False


def getLetterScore(letter):
    try:
        try:
            letter = letter.upper()
            scores = {}
            f = open('scores.txt', 'r')
            for line in f:
                scores[line[0]] = line[2:].strip("\n")
            return (int(scores[letter]))

        except:
            return 0
    except FileNotFoundError:
        print("This file could not be opened")


def getWordScore(word):
    scoretotal = 0
    for letter in word:
        letterScore = getLetterScore(letter)
        if letterScore == 0:
            return 0
        scoretotal += letterScore
    return scoretotal


def canBeMade(word, myTiles):
    try:
        word = word.upper()
        list_of_letters = []
        list2 = []
        if onlyEnglishLetters(word) == True:
            for letter in word:
                list_of_letters.append(letter)

            for i in myTiles:
                if i in list_of_letters:
                    list2.append(i)

            return sorted(list_of_letters) == sorted(list2)
        else:
            return False
    except:
        return False


def isValid(word, myTiles, dictionary):
    try:
        if onlyEnglishLetters(word) == True:
            if word.upper() in dictionary and (canBeMade(word.upper(), myTiles) == True):
                return True
            return False
    except:
        return False

if len(tiles) >= 7:
    myTiles = random.choices(tiles, k =7)
    print("Tiles:", end=" ")
    for tile in myTiles:
        print(tile, end=" ")
# A for loop allows each element from list: tiles, to be printed through iteration, 7 times.
# The end= " ",allows the printing of the elements of a list on one line, as opposed to a line break (/n)

    print("\nScores:", end=" ")
    for letter in myTiles:
        letter = getWordScore(letter)
        print(letter, end=" ")
    # each letter in tiles is has a value which is returned using getWordScore function, then total a score is calculated for word inputted by user.

    while True:
        userinput = input("\nEnter a word: ")
        # If the user guesses "&&&", the while loop breaks and the game ends.
        if userinput == "&&&":
            print("Thanks for using this application, better luck next time!!!")
            break
        elif onlyEnglishLetters(userinput) == True and isValid(userinput, myTiles, dictionary) == True:
            print("Score of this word is: ", getWordScore(userinput))
            print("You got it right, this is a valid word")
            break
            # If the user guesses a valid word, the user wins and the game ends.
        elif onlyEnglishLetters(userinput) == False:
            print("Only use English letters…")
        else:
            print("There is no such word in the dictionary")