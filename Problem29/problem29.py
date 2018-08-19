#This problem was asked by Amazon.

#Run-length encoding is a fast and simple method of encoding strings.
#The basic idea is to represent repeated successive characters 
#as a single count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

#Implement run-length encoding and decoding. You can assume the string to be encoded have no digits a
#nd consists solely of alphabetic characters. You can assume the string to be decoded is valid.

class StringEncoder(object):

  def encode(self, s):

    if len(s) == 0: return s
    if len(s) == 1: return "1" + s

    count = 1
    encoded_s = ""
    for i in range(len(s) - 1):
      if s[i] == s[i + 1]:
        count += 1
      else:
        encoded_s += str(count) + s[i]
        count = 1
    encoded_s += str(count) + s[i + 1]    
    return encoded_s



se = StringEncoder()
assert se.encode("AAAABBBCCDAA") == "4A3B2C1D2A"
assert se.encode("S") == "1S"
assert se.encode("") == ""
assert se.encode("SBT") == "1S1B1T"
assert se.encode("SBBT") == "1S2B1T"

