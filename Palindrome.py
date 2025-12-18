word = input()
original_word = word  # Keep original string for comparison
word = list(word)     # Convert to list for reversal

start = 0
end = len(word) - 1

while start < end:
    word[start], word[end] = word[end], word[start]
    start += 1
    end -= 1

reversed_word = ''.join(word)

if original_word == reversed_word:
    print("Word is a palindrome")
else:
    print("Word is not a palindrome")




'''Alernatively, using slicing:

word = input()
if word == word[::-1]:
    print("Word is a palindrome")
else:
    print("Word is not a palindrome")
    
'''