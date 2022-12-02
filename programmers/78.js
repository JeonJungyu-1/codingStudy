//시저 암호
function solution(s, n) {
    let answer = '';
    for (let i = 0; i < s.length; i++) {
        if (s[i] === " ") {
            answer += " ";
        } else {
            let charCode = s[i].charCodeAt() + n;
            if ((charCode > 90 && charCode - n < 91) || (charCode > 122 && charCode - n > 96)) {
                charCode -= 26;
            }
            answer += String.fromCharCode(charCode);
        }
    }
    return answer;
}