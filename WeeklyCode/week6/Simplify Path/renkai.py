class Solution:
    # @param path, a string
    # @return a string
    def simplifyPath(self, path):
        patharg = path.split('/')
        arglen = 0
        i = 0
        for arg in patharg:
            if arg == "..":
                if arglen > 0:
                    arglen -= 1
            elif arg != "." and arg:
                patharg[arglen] = patharg[i]
                arglen += 1
            i += 1
        if not arglen: return "/"
        return "/" + "/".join(patharg[0:arglen])