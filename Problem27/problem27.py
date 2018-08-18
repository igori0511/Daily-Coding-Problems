#This problem was asked by Facebook.

#Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

#For example, given the string "([])[]({})", you should return true.

#Given the string "([)]" or "((()", you should return false.

def validate_brackets(brackets):
  stack = []
  open_par = ["(", "[", "{"]
  closed_par = [")", "]", "}"]
  i = 0

  while i < len(brackets):
    if brackets[i] in open_par:
      stack.append(brackets[i])
    if brackets[i] in closed_par:
      current_par = stack.pop()
      if current_par == "(" and brackets[i] != ")":
        return False
      if current_par == "[" and brackets[i] != "]":
        return False
      if current_par == "{" and brackets[i] != "}":
        return False
    i+=1    

  return False if len(stack) > 0 else True

assert validate_brackets("([])[]({})") == True
assert validate_brackets("((()") == False
assert validate_brackets("((()))") == True
