class Solution:
    # @param {string[]} words
    # @param {integer} maxWidth
    # @return {string[]}
    def fullJustify(self, words, maxWidth):
        res = []
        text = "*".join(words) + "*"
        if text == "*": return [" "*maxWidth]
        while text:
            index = text.rfind("*", 0, maxWidth+1)
            line = text[:index].split("*")
            text = text[index+1:]
            l, n = sum([len(w) for w in line]), len(line)
            if n == 1:
                res.append(line[0].ljust(maxWidth))
            else:
                every, space = divmod(maxWidth-l, n-1)
                line[:-1] = [word+" "*every for word in line[:-1]]
                line[:space] = [word+" " for word in line[:space]]
                res.append("".join(line))
        res[-1] = " ".join(res[-1].split()).ljust(maxWidth)
        return res