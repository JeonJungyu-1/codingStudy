//짝지어 제거하기
//1 효율성 안됨
function solution(s) {
    
    for (let i = 0; i < s.length; i++) {
        if (i + 1 !== s.length && s[i] === s[i + 1]) {
            s = s.replaceAll(s[i] + s[i], "");
            i -= 2;
        }
    }
    

    return s.length ? 0 : 1;
}