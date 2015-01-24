class Solution {
public: 
    bool isMatch(const char *s, const char *p) {
        assert(s && p);
        if (*p == '\0') return *s == '\0';
        if (*(p+1) != '*') 
        {
            assert(*p != '*');
            return ((*p == *s) || (*p == '.' && *s != '\0')) && isMatch(s+1, p+1);
            
        }
        while ((*p == *s) || (*p == '.' && *s != '\0')) {
            if (isMatch(s, p+2)) return true;
            s++;
        }
        return isMatch(s, p+2);
    }
};