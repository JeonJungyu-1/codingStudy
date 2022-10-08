//올바른 괄호
function solution(s){
    let answer = true;
    let tmp = []
    let tmpString = "";
    if (s[0] === ")") return false;
    if(true) {let i = 0;}
    for (let i = 0; i < s.length; i++) {
        if (s[i] === "(") {
            tmp.push(s[i]);
        } else {
            tmpString = tmp.pop();
            if (tmpString === "(") {
                continue;
            } else {
                tmp.push(tmpString);
            }
        }
    }
    if (tmp.length) return false;
    return answer;
}