#This problem was asked by Facebook.

#Given a string of round, curly, and square open and closing brackets, return whether the brackets are balanced (well-formed).

#For example, given the string "([])[]({})", you should return true.
#Given the string "([)]" or "((()", you should return false.

class Brackets(object):
    def isValid(self, brackets):
        """
        :type s: str
        :rtype: bool
        """
        stack = []
        open_par = ["(", "[", "{"]
        closed_par = [")", "]", "}"]
        i = 0

        while i < len(brackets):
            if brackets[i] in open_par:
              stack.append(brackets[i])
            if brackets[i] in closed_par:
                if len(stack) == 0 or not self.isPair(stack[len(stack) - 1], brackets[i]):
                    return False
                else:
                    stack.pop()
            i+=1            
        return False if len(stack) > 0 else True  
    
    def isPair(self, current_par, stack_val):
        if current_par == "(" and stack_val == ")": return True
        if current_par == "[" and stack_val == "]": return True            
        if current_par == "{" and stack_val == "}": return True            
        return False        

brackets = Brackets()
assert brackets.isValid("([])[]({})") == True
assert brackets.isValid("((()") == False
assert brackets.isValid("((()))") == True
